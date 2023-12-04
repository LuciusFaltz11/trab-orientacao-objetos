package com.poo.projeto_hospital;

import com.poo.projeto_hospital.view.TelaAgenda;
import com.poo.projeto_hospital.view.paginaInicial_login.Login;

public class App {
    public static void main(String[] args) {
        //Login login = new Login();
        //login.createAndShowGUI();

        TelaAgenda tela = new TelaAgenda();
        tela.desenha();
    }
}
