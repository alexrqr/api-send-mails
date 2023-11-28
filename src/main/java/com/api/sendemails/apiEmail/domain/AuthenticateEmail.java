package com.api.sendemails.apiEmail.domain;


import com.api.sendemails.apiEmail.manager.MailManager;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateEmail {

    MailManager mailManager;
    //constructor
    public AuthenticateEmail(MailManager mailManager) {
        this.mailManager = mailManager;
    }

    public void sendMessageUser(String email, String message){
        mailManager.sendMailMessage(email, message);
    }

}
