package com.poo.projeto_hospital.exception;

import javax.swing.JOptionPane;

public class CPFException extends Exception {
    public CPFException() {
        super();
        JOptionPane.showMessageDialog(null, "Invalid CPF!", "CPF Error", JOptionPane.ERROR_MESSAGE);
    }

}
