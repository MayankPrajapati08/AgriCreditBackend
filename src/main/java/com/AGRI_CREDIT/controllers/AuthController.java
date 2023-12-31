package com.AGRI_CREDIT.controllers;

import com.AGRI_CREDIT.models.ERole;
import com.AGRI_CREDIT.models.Role;
import com.AGRI_CREDIT.models.User;
import com.AGRI_CREDIT.payload.request.LoginRequest;
import com.AGRI_CREDIT.payload.request.SignupRequest;
import com.AGRI_CREDIT.payload.response.JwtResponse;
import com.AGRI_CREDIT.payload.response.MessageResponse;
import com.AGRI_CREDIT.repository.RoleRepository;
import com.AGRI_CREDIT.repository.UserRepository;
import com.AGRI_CREDIT.security.jwt.JwtUtils;
import com.AGRI_CREDIT.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();


			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "warehouse":
					Role warehouseRole = roleRepository.findByName(ERole.ROLE_WAREHOUSE)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(warehouseRole);

					break;
					case "bank":
						Role bankRole = roleRepository.findByName(ERole.ROLE_BANK)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(bankRole);

						break;

					case "farmer":
						Role farmerRole = roleRepository.findByName(ERole.ROLE_FARMER)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(farmerRole);

						break;

					case "BCagent":
						Role agentRole = roleRepository.findByName(ERole.ROLE_BC_AGENT)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(agentRole);

						break;
				}
			});


		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
