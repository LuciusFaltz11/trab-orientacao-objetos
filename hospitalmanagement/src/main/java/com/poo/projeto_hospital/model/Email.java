package com.poo.projeto_hospital.model;

import com.poo.projeto_hospital.exception.EmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//tirar espaços em branco
public class Email {
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static String isValidEmail(String email) throws EmailException {
        email = email.replaceAll("\\s+", "");

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);

        email = email.replaceAll("\\s+", "");

        if (!matcher.find()) {
            throw new EmailException();
        }
        return email;
    }

}
