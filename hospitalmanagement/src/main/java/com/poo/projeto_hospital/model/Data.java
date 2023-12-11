/*
João Augusto Pilato de Castro- 202235006
Lucius Faltz Lassarote da Silva - 202235027
Luíza Machado Costa Nascimento - 202235021
*/
package com.poo.projeto_hospital.model;

import com.poo.projeto_hospital.exception.DataException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Data {
    // validar dia e mes correto
    private static final String DATA_PATTERN = "^([0-9]{2})/([0-9]{2})/([0-9]{4})$";

    public static String isValidData(String data) throws DataException {
        data = data.replaceAll(" ", "");
        Pattern pattern = Pattern.compile(DATA_PATTERN);
        Matcher matcher = pattern.matcher(data);

        if (matcher.find()) {
            int dia = Integer.parseInt(matcher.group(1));
            int mes = Integer.parseInt(matcher.group(2));
            int ano = Integer.parseInt(matcher.group(3));

            boolean isLeapYear = (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
            int maxDays;

            if (mes >= 1 && mes <= 12) {
                if (mes % 2 == 0) {
                    maxDays = (mes == 2) ? (isLeapYear ? 29 : 28) : 30;
                } else {
                    maxDays = (mes <= 7) ? 31 : 30;
                }

                if (dia >= 1 && dia <= maxDays) {
                    return data;
                } else {
                    throw new DataException();
                }
            } else {
                throw new DataException();
            }

        } else
            throw new DataException();
    }

    public static int compara(String Data1, String Data2) {

        int dia1 = Integer.parseInt(Data1.substring(0, 2));
        int mes1 = Integer.parseInt(Data1.substring(3, 5));
        int ano1 = Integer.parseInt(Data1.substring(6));

        int dia2 = Integer.parseInt(Data2.substring(0, 2));
        int mes2 = Integer.parseInt(Data2.substring(3, 5));
        int ano2 = Integer.parseInt(Data2.substring(6));

        if (ano1 > ano2)
            return 1;
        else if (ano1 < ano2)
            return -1;
        else if (mes1 > mes2)
            return 1;
        else if (mes1 < mes2)
            return -1;
        else if (dia1 > dia2)
            return 1;
        else if (dia1 < dia2)
            return -1;
        else

            return 0;

    }
}
