package com.poo.projeto_hospital.exception;

import javax.swing.JOptionPane;

public class CPFException extends Exception {
    public CPFException() {
        super("error");
        JOptionPane.showMessageDialog(null, "CPF inválido!", "CPF Error", JOptionPane.ERROR_MESSAGE);
    }

}
