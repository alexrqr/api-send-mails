package com.api.sendemails.apiEmail.app.controller;

import com.api.sendemails.apiEmail.app.model.LoginRequest;
import com.api.sendemails.apiEmail.domain.AuthenticateEmail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthEmailController {

    AuthenticateEmail authenticateEmail;
    //constructor
    public AuthEmailController(AuthenticateEmail authenticateEmail) {
        this.authenticateEmail = authenticateEmail;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Object>autehnticateSendEmail(@RequestBody LoginRequest loginRequest){

        //
        authenticateEmail.sendMessageUser(loginRequest.getEmailUser(), loginRequest.getMessage());

        return ResponseEntity.ok()
                .body("El envío ha sido satisfactorio");
    }



}
