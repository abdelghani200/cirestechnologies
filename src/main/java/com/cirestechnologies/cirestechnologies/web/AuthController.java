package com.cirestechnologies.cirestechnologies.web;

import com.cirestechnologies.cirestechnologies.dtos.req.AuthReq;
import com.cirestechnologies.cirestechnologies.dtos.resp.AuthRes;
import com.cirestechnologies.cirestechnologies.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public ResponseEntity<AuthRes> login(@RequestBody AuthReq authReq){
        return ResponseEntity.ok(authService.login(authReq));
    }
}
