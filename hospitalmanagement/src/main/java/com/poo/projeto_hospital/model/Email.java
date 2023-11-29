package com.poo.projeto_hospital.model;

import com.poo.projeto_hospital.exception.EmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static boolean isValidEmail(String email) throws EmailException {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);

        if (matcher.find()) {
            return true;
        } else
            throw new EmailException();
    }

}
