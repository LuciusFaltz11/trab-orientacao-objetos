/*
João Augusto Pilato de Castro- 202235006
Lucius Faltz Lassarote da Silva - 202235027
Luíza Machado Costa Nascimento - 202235021
*/
package com.poo.projeto_hospital.exception;

import javax.swing.JOptionPane;

public class SenhaException extends Exception {
    public SenhaException() {
        super("erro senha");
        JOptionPane.showMessageDialog(null, "A senha deve ter no mínimo 8 caracteres.", "Senha Inválida",
                JOptionPane.WARNING_MESSAGE);
    }
}
