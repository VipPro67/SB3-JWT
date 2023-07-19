package com.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.dto.AuthenticationRequest;
import com.security.dto.RegisterRequest;
import com.security.service.AuthenticationService;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @PostMapping("/register")
  public ResponseEntity<Object> register(@RequestBody RegisterRequest request) {
    try {
      return ResponseEntity.ok(authenticationService.register(request));
    } catch (Exception e) {
      return ResponseEntity
          .badRequest()
          .header("error", e.getMessage())
          .body(e.getMessage());
    }
  }

  @PostMapping("/authenticate")
  public ResponseEntity<Object> authenticate(@RequestBody AuthenticationRequest request) {
    try {
      return ResponseEntity.ok(authenticationService.authenticate(request));
    } catch (Exception e) {
      return ResponseEntity
          .badRequest()
          .header("error", e.getMessage())
          .body(e.getMessage());
    }
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response) throws IOException {
    authenticationService.refreshToken(request, response);
  }

}
