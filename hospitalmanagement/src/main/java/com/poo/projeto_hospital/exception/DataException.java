package com.poo.projeto_hospital.exception;

import javax.swing.JOptionPane;

public class DataException extends Exception {
    public DataException() {
        super();
        JOptionPane.showMessageDialog(null, "Data inválida!", "Data Error", JOptionPane.ERROR_MESSAGE);
    }

}
