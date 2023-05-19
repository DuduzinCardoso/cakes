package com.cake.controller;

import com.cake.dto.auth.AuthenticationRequestDto;
import com.cake.dto.auth.AuthenticationResponseDto;
import com.cake.dto.auth.RegisterRequestDto;
import com.cake.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDto> register(@RequestBody RegisterRequestDto registerRquest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authenticationService.register(registerRquest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDto> authenticate(
            @RequestBody AuthenticationRequestDto authenticationRequestDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authenticationService.authenticate(authenticationRequestDto));
    }
}
