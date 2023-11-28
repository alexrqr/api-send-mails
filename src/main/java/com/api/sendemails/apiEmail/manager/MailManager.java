package com.api.sendemails.apiEmail.manager;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailManager {

    //Componente de MailSender
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    //Metodo para enviar los mails
    public MailManager(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendMailMessage(String email, String messageEmail){
        //crea el mensaje o correo
        MimeMessage message = javaMailSender.createMimeMessage();

        try{
            message.setSubject("Correo de prueba");
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setText(messageEmail);
            mimeMessageHelper.setFrom(sender);
            javaMailSender.send(message);


        }catch (MessagingException ex){
            throw  new RuntimeException(ex);
        }







    }

}
