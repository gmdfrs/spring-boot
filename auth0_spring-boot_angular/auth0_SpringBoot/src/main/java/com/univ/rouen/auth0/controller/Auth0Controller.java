package com.univ.rouen.auth0.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.univ.rouen.auth0.dto.Auth0Request;

/**
 * Controller pour JwtAuthenticationController 
 * @author GROUPE JEE
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="auth0", produces = MediaType.APPLICATION_JSON_VALUE)
public class Auth0Controller {

	// @Autowired
	//private AuthenticationManager authenticationManager;
//	@Autowired
//	private Auth0Service auth0service;
	
	@GetMapping(value = "/public")
    public ResponseEntity<?> publicEndpoint() {
        return new ResponseEntity<>("All good. You DO NOT need to be authenticated to call /api/public.", HttpStatus.OK);
    }

    @GetMapping(value = "/private")
    public ResponseEntity<?> privateEndpoint() {
        return new ResponseEntity<>("All good. You can see this because you are Authenticated.", HttpStatus.OK);
    }

    @GetMapping(value = "/private-scoped")
    public ResponseEntity<?> privateScopedEndpoint() {
        return new ResponseEntity<>("All good. You can see this because you are Authenticated with a Token granted the 'read:messages' scope", HttpStatus.OK);
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody Auth0Request authenticationRequest)
			throws Exception {
		
		// authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		
		return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}
	

//	// authentficate avec auth0
//	private void authenticate(String email, String password) throws Exception {
//		
//		Objects.requireNonNull(email);
//		Objects.requireNonNull(password);
//
//		try {
//
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
//
//		} catch (DisabledException e) {
//			throw new Exception("USER_DISABLED", e);
//		} catch (BadCredentialsException e) {
//			throw new Exception("INVALID_CREDENTIALS", e);		
//
//		}
//	}
	
}