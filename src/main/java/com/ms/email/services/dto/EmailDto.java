package com.ms.email.services.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailDto {

    @NotBlank
    private String awnerRef;

    @NotBlank
    @Email
    private String emailFrom;

    @NotBlank
    @Email
    private String emailTo;

    @NotBlank
    private String subject;

    @NotBlank
    private String emailBody;
}
