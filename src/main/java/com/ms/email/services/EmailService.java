package com.ms.email.services;

import com.ms.email.models.Email;

public interface EmailService {

    Email sendEmail(Email email);
}
