package com.ms.email.services.impl;

import com.ms.email.models.Email;
import com.ms.email.models.enums.StatusEmail;
import com.ms.email.repositories.EmailRepository;
import com.ms.email.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    private JavaMailSender mailSender;

    public Email sendEmail(Email email){

        email.setSendDateEmail(LocalDateTime.now());

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getEmailBody());
            mailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            email.setStatusEmail(StatusEmail.ERROR);
            System.out.println(e);
        } finally {
            return emailRepository.save(email);
        }
    }
}
