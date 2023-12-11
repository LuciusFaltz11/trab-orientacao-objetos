/*
João Augusto Pilato de Castro- 202235006
Lucius Faltz Lassarote da Silva - 202235027
Luíza Machado Costa Nascimento - 202235021
*/
package com.poo.projeto_hospital.exception;

import javax.swing.JOptionPane;

public class LoginException extends Exception {
    public LoginException(String messagem) {
        super("erro login");
        JOptionPane.showMessageDialog(null, messagem, "Login Error", JOptionPane.ERROR_MESSAGE);
    }
}
