package ir.mostafa.semnani.rostambackend.common.security.controller;

import ir.mostafa.semnani.rostambackend.common.security.jwt.AuthenticationRequest;
import ir.mostafa.semnani.rostambackend.common.security.jwt.AuthenticationResponse;
import ir.mostafa.semnani.rostambackend.common.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class JwtAuthenticationRestController {

  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private JwtUtil jwtUtil;

  @PostMapping("/authenticate")
  public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws AuthenticationException {
    final Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()
            )
    );

    SecurityContextHolder.getContext().setAuthentication(authentication);
    final String token = jwtUtil.generateToken(authentication);
    return ResponseEntity.ok(new AuthenticationResponse(token));
  }

}

