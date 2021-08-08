package com.ms.email.models;

import com.ms.email.models.enums.StatusEmail;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_EMAIL")
@Data
public class Email implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String awnerRef;

    private String emailFrom;

    private String emailTo;

    private String subject;

    @Column(columnDefinition = "TEXT")
    private String emailBody;

    private LocalDateTime sendDateEmail;

    private StatusEmail statusEmail;
}
