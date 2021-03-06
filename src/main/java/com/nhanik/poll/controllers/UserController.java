package com.nhanik.poll.controllers;

import com.nhanik.poll.payload.AuthenticationRequest;
import com.nhanik.poll.payload.AuthenticationResponse;
import com.nhanik.poll.payload.RegistrationRequest;
import com.nhanik.poll.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity<?> createUser(@Valid @RequestBody RegistrationRequest request) {
        userService.createNewUser(request);
        return ResponseEntity.ok("User created");
    }

    @PostMapping("login")
    public ResponseEntity<?> authenticate(@Valid @RequestBody AuthenticationRequest request) {
        AuthenticationResponse response = userService.authenticateUser(request);
        return ResponseEntity.ok(response);
    }
}
