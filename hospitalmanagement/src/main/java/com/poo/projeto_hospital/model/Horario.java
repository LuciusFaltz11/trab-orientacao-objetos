package com.poo.projeto_hospital.model;

import com.poo.projeto_hospital.exception.HorarioException;

public class Horario {
    private static final String HORARIO_PATTERN = "^([0-1][0-9]|2[0-3]):[0-5][0-9]$";

    public static String isValidHorario(String horario) throws HorarioException {
        horario = horario.replaceAll(" ", "");
        if (horario.matches(HORARIO_PATTERN)) {
            return horario;
        } else {
            throw new HorarioException();
        }
    }

    public static int compara(String horario1, String horario2) throws HorarioException {

        horario1 = isValidHorario(horario1);
        horario2 = isValidHorario(horario2);

        int hora1 = Integer.parseInt(horario1.substring(0, 2));
        int minuto1 = Integer.parseInt(horario1.substring(3));

        int hora2 = Integer.parseInt(horario2.substring(0, 2));
        int minuto2 = Integer.parseInt(horario2.substring(3));

        if (hora1 > hora2)
            return 1;
        else if (hora1 < hora2)
            return -1;
        else {
            if (minuto1 > minuto2)
                return 1;
            else if (minuto1 < minuto2)
                return -1;
            else
                return 0;
        }
    }

    public static String soma(String horario, int minutos) throws HorarioException {
        horario = isValidHorario(horario);

        int hora = Integer.parseInt(horario.substring(0, 2));
        int minuto = Integer.parseInt(horario.substring(3));

        minuto += minutos;

        while (minuto >= 60) {
            hora++;
            minuto -= 60;
        }

        if (hora >= 24)
            hora -= 24;

        String horaString = String.valueOf(hora);
        String minutoString = String.valueOf(minuto);

        if (horaString.length() == 1)
            horaString = "0" + horaString;

        if (minutoString.length() == 1)
            minutoString = "0" + minutoString;

        return horaString + ":" + minutoString;
    }


}
