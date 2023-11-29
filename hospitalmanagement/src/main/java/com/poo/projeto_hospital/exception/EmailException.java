package com.poo.projeto_hospital.exception;

import javax.swing.JOptionPane;

public class EmailException extends Exception {
    public EmailException() {
        super();
        JOptionPane.showMessageDialog(null, "Invalid email!", "Email Error", JOptionPane.ERROR_MESSAGE);
    }
}
