package com.poo.projeto_hospital.exception;

import javax.swing.JOptionPane;

public class HorarioException extends RuntimeException{
    public HorarioException() {
        super("error");
        JOptionPane.showMessageDialog(null, "Horário inválido!", "Horário Error", JOptionPane.ERROR_MESSAGE);
    }
}
