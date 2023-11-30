package com.poo.projeto_hospital.model;

import com.poo.projeto_hospital.exception.EmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//tirar espaços em branco
public class Email {
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static void isValidEmail(String email) throws EmailException {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.find()) {
            throw new EmailException();
        }
    }

}
