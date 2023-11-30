package com.poo.projeto_hospital.model;

import com.poo.projeto_hospital.exception.DataException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Data {
    // validar dia e mes correto
    private static final String DATA_PATTERN = "^([0-9]{2})/([0-9]{2})/([0-9]{4})$";

    public static void isValidData(String data) throws DataException {
        Pattern pattern = Pattern.compile(DATA_PATTERN);
        Matcher matcher = pattern.matcher(data);

        if (matcher.find()) {
            int dia = Integer.parseInt(matcher.group(1));
            int mes = Integer.parseInt(matcher.group(2));
            int ano = Integer.parseInt(matcher.group(3));

            boolean isLeapYear = (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
            int maxDays = 31;

            if (mes % 2 == 0) {
                maxDays = (mes == 2) ? (isLeapYear ? 29 : 28) : 30;
            } else {
                maxDays = (mes <= 7) ? 31 : 30;
            }

            if (dia > maxDays || dia < 1 || mes > 12 || mes < 1 || ano < 2021) {
                throw new DataException();
            }
        }
    }
}
