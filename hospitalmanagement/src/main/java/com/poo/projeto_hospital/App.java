/*
João Augusto Pilato de Castro- 202235006
Lucius Faltz Lassarote da Silva - 202235027
Luíza Machado Costa Nascimento - 202235021
*/
package com.poo.projeto_hospital;

import com.poo.projeto_hospital.exception.DataException;
import com.poo.projeto_hospital.view.paginaInicial_login.Login;

public class App {
    public static void main(String[] args) throws DataException {
        Login login = new Login();
        login.createAndShowGUI();
    }
}
