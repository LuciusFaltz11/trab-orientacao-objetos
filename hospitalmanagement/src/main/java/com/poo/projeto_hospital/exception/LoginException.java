package com.poo.projeto_hospital.exception;

import javax.swing.JOptionPane;

public class LoginException extends Exception {
    public LoginException(String messagem) {
        super("erro login");
        JOptionPane.showMessageDialog(null, messagem, "Login Error", JOptionPane.ERROR_MESSAGE);
    }
}
