package com.poo.projeto_hospital.model;

import com.poo.projeto_hospital.exception.DataException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Data {

    private static final String DATA_PATTERN = "^([0-9]{2})/([0-9]{2})/([0-9]{4})$";

    public static void isValidData(String data) throws DataException {
        Pattern pattern = Pattern.compile(DATA_PATTERN);
        Matcher matcher = pattern.matcher(data);

        if (!matcher.find()) {
            throw new DataException();
        }
    }
}
