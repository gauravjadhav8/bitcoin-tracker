package com.crypto.btctracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

        @Autowired private JavaMailSender mailSender;

        @Value("${spring.mail.username}") String username;

        public void sendEmail(String toEmail, String body, String subject) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(username);
            message.setTo(toEmail);
            message.setText(body);
            message.setSubject(subject);
            mailSender.send(message);
            System.out.println("Mail Send...");
        }
}
