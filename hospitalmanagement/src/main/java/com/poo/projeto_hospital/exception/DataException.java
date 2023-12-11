/*
João Augusto Pilato de Castro- 202235006
Lucius Faltz Lassarote da Silva - 202235027
Luíza Machado Costa Nascimento - 202235021
*/
package com.poo.projeto_hospital.exception;

import javax.swing.JOptionPane;

public class DataException extends Exception {
    public DataException() {
        super("error");
        JOptionPane.showMessageDialog(null, "Data inválida!", "Data Error", JOptionPane.ERROR_MESSAGE);
    }

}
