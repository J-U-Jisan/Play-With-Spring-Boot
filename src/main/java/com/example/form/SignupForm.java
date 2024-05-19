package com.example.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SignupForm {
    private String userId;
    private String password;
    private String userName;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthday;
    private Integer age;
    private Integer gender;
}
