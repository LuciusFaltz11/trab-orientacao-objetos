package com.poo.projeto_hospital.model;

import com.poo.projeto_hospital.exception.DataException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Data {

    private static final String DATA_PATTERN = "^([0-9]{2})/([0-9]{2})/([0-9]{4})$";

    public static boolean isValidData(String data) throws DataException, ParseException {
        Pattern pattern = Pattern.compile(DATA_PATTERN);
        Matcher matcher = pattern.matcher(data);

        if (matcher.find()) {
            int dia = Integer.parseInt(matcher.group(1));
            int mes = Integer.parseInt(matcher.group(2));
            int ano = Integer.parseInt(matcher.group(3));

            return true;
        } else {
            throw new DataException();
        }
    }
}
