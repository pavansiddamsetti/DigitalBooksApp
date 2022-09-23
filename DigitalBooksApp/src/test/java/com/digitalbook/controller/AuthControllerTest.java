package com.digitalbook.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.digitalbook.controllers.AuthController;
import com.digitalbook.models.ERole;
import com.digitalbook.models.Role;
import com.digitalbook.payload.request.LoginRequest;
import com.digitalbook.payload.request.SignupRequest;
import com.digitalbook.repository.RoleRepository;
import com.digitalbook.repository.UserRepository;
import com.digitalbook.security.jwt.JwtUtils;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

	@Mock
	private UserRepository uRepo;

	@Mock
	private RoleRepository rRepo;

	@InjectMocks
	private AuthController aController;
	
	@Mock
	private PasswordEncoder encoder;
	
	@Mock
	private AuthenticationManager authenticationManger;
	
	@Mock
	private JwtUtils jUtils;
	
	//@Mock
	//private Authentication authentication;

	@Test
	public void testRegisterUser() {
		SignupRequest signReq = new SignupRequest();
		signReq.setUsername("pavan");
		when(uRepo.existsByAuthorname("pavan")).thenReturn(true);
		ResponseEntity<?> registerUser = aController.registerUser(signReq);
		assertEquals(400, registerUser.getStatusCode().value());
	}

	@Test
	public void testRegisterUser1() {
		SignupRequest signReq = new SignupRequest();
		signReq.setEmail("pavan@gmail.com");
		when(uRepo.existsByEmail("pavan@gmail.com")).thenReturn(true);
		ResponseEntity<?> registerUser = aController.registerUser(signReq);
		assertEquals(400, registerUser.getStatusCode().value());
	}
	@Test
	public void testregisterUser2() {
		Set<String> roles=new HashSet<>();
		roles.add("ROLE_AUTHOR");
		SignupRequest signReq = new SignupRequest();
		signReq.setRole(roles);
		signReq.setPassword("pavan12");
		Role r=new Role();
		Optional<Role> optRole=Optional.ofNullable(r);
		when(rRepo.findByName(ERole.ROLE_AUTHOR)).thenReturn(optRole);
		ResponseEntity<?> registerUser = aController.registerUser(signReq);
		assertEquals(200, registerUser.getStatusCodeValue());
	}
	
	@Test
	public void testregisterUser3() {
		Set<String> roles=new HashSet<>();
		roles.add("ROLE_READER");
		SignupRequest signReq = new SignupRequest();
		signReq.setRole(roles);
		signReq.setPassword("pavan12");
		Role r=new Role();
		Optional<Role> optRole=Optional.ofNullable(r);
		when(rRepo.findByName(ERole.ROLE_READER)).thenReturn(optRole);
		ResponseEntity<?> registerUser = aController.registerUser(signReq);
		assertEquals(200, registerUser.getStatusCodeValue());
	}
	
	@Test
	public void testregisterUser4() {
		Set<String> roles=new HashSet<>();
		//roles.add("ROLE_READER");
		SignupRequest signReq = new SignupRequest();
		signReq.setRole(null);
		signReq.setPassword("pavan12");
		Role r=new Role();
		Optional<Role> optRole=Optional.ofNullable(r);
		when(rRepo.findByName(ERole.ROLE_READER)).thenReturn(optRole);
		ResponseEntity<?> registerUser = aController.registerUser(signReq);
		assertEquals(200, registerUser.getStatusCodeValue());
	}
	
	@Test
	public void testregisterUser5() {
		Set<String> roles=new HashSet<>();
		roles.add("ROLE_MODERATOR");
		SignupRequest signReq = new SignupRequest();
		signReq.setRole(roles);
		signReq.setPassword("pavan12");
		Role r=new Role();
		Optional<Role> optRole=Optional.ofNullable(r);
		when(rRepo.findByName(ERole.ROLE_MODERATOR)).thenReturn(optRole);
		ResponseEntity<?> registerUser = aController.registerUser(signReq);
		assertEquals(200, registerUser.getStatusCodeValue());
	}
//	@Test
//	public void testAuthenticateUser() {
//		LoginRequest lrequest=new LoginRequest();
//		lrequest.setUsername("pavan");
//		lrequest.setPassword("pavanK@12");
//		//User
//		//when(authenticationManger.authenticate(new UsernamePasswordAuthenticationToken("pavan","pavanK@12"))).thenReturn(new Authentication());
//		ResponseEntity<?> authenticateUser = aController.authenticateUser(lrequest);
//	
//		assertEquals(200, authenticateUser.getStatusCodeValue());
//	}
	
}
