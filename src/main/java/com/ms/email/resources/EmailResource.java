package com.ms.email.resources;

import com.ms.email.models.Email;
import com.ms.email.services.EmailService;
import com.ms.email.services.dto.EmailDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class EmailResource {

    @Autowired
    EmailService emailService;

    @PostMapping("/send-email")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDto emailDto) {
        Email email = new Email();

        BeanUtils.copyProperties(emailDto, email);
        emailService.sendEmail(email);

        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }

}
