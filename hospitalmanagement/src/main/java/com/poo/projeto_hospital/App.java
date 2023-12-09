package com.poo.projeto_hospital;

import com.poo.projeto_hospital.exception.DataException;
import com.poo.projeto_hospital.view.paginaInicial_login.Login;

public class App {
    public static void main(String[] args) throws DataException {
        Login login = new Login();
        login.createAndShowGUI();
    }
}
