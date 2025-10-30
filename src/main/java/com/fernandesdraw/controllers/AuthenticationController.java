package com.fernandesdraw.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandesdraw.dtos.LoginRequest;
import com.fernandesdraw.entities.Employee;
import com.fernandesdraw.exceptions.InvalidCredentialsException;
import com.fernandesdraw.services.AuthenticationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @PostMapping("/login")
  public Employee loginEmployee(@RequestBody LoginRequest body, HttpServletRequest request,
      HttpServletResponse response) {
    return authenticationService.loginEmployee(body.email(), body.password(), request, response);
  }

  @ExceptionHandler({ InvalidCredentialsException.class })
  public ResponseEntity<String> handleInvalidCredentialsException() {
    return ResponseEntity.status(404).body("Invalid email or password");
  }

}
