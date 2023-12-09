package com.poo.projeto_hospital;

import com.poo.projeto_hospital.exception.DataException;
import com.poo.projeto_hospital.model.Usuario;
import com.poo.projeto_hospital.persistence.PacientePersistence;
import com.poo.projeto_hospital.view.paginaInicial_login.Login;
import com.poo.projeto_hospital.view.paginaInicial_login.RegistroMedico;
import com.poo.projeto_hospital.view.perfilPaciente.AreaPaciente;
import com.poo.projeto_hospital.view.perfilPaciente.EditarPerfil;
import com.poo.projeto_hospital.view.perfilPaciente.MarcarConsulta;

public class App {
    public static void main(String[] args) throws DataException {
        /*
         * 
         * Login login = new Login();
         * login.createAndShowGUI();
         */

        RegistroMedico registroMedico = new RegistroMedico();
        registroMedico.createAndShowGUI();
    }
}
