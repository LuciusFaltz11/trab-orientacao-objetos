package com.poo.projeto_hospital;

import com.poo.projeto_hospital.model.Medico;
import com.poo.projeto_hospital.model.Paciente;
import com.poo.projeto_hospital.model.Usuario;
import com.poo.projeto_hospital.model.UsuarioMedico;
import com.poo.projeto_hospital.view.TelaAgenda;
import com.poo.projeto_hospital.view.paginaInicial_login.Login;
import com.poo.projeto_hospital.view.perfilPaciente.AreaPaciente;

public class App {
    public static void main(String[] args) {
        // Login login = new Login();
        // login.createAndShowGUI();

        // Medico medico = new Medico("Dr. Marcelo", "2020202020","20/02/2020",
        // "Cardiologista", "08:00", "18:00");
        // medico.getAgenda();

        Paciente paciente = new Paciente("Luiza", "18785173762", "20/02/2020", "São Paulo", "SP", "Feminino");
        AreaPaciente areaPaciente = new AreaPaciente(paciente);
        areaPaciente.createAndShowGUI();

    }
}
