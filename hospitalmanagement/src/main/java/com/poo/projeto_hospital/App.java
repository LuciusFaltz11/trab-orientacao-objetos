package com.poo.projeto_hospital;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        LocalDateTime nascimento = new LocalDateTime.of(1980, Calendar.OCTOBER, 22);
        Medico medico = new Medico("Genésio", "211.116.237.08", nascimento, "Ortopedista" , "8:00", "15:00");
    }
}
