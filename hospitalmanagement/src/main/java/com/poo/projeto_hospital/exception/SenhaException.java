package com.poo.projeto_hospital.exception;

import javax.swing.JOptionPane;

public class SenhaException extends Exception {
    public SenhaException() {
        super();
        JOptionPane.showMessageDialog(null, "A senha deve ter no mínimo 8 caracteres.", "Senha Inválida",
                JOptionPane.WARNING_MESSAGE);
    }
}
