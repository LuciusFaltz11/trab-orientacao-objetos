package com.poo.projeto_hospital;

import com.poo.projeto_hospital.model.Medico;
import com.poo.projeto_hospital.model.Paciente;
import com.poo.projeto_hospital.model.Usuario;
import com.poo.projeto_hospital.model.UsuarioMedico;
import com.poo.projeto_hospital.persistence.ConsultaPersistence;
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

        UsuarioMedico usuarioMedico = new UsuarioMedico("gabriel@gmail.com", "123456".toCharArray(), "Dr. Gabriel",
                "16676994747", "20/02/2020", "São Paulo", "SP", "Masculino", "Cardiologista", "08:00", "18:00");
        Paciente paciente = new Paciente("Luiza", "18785173762", "20/02/2020", "São Paulo", "SP", "Feminino");
        AreaPaciente areaPaciente = new AreaPaciente(paciente);
        // Consulta consulta = new Consulta(paciente, "20/02/2020", "08:00", 30,
        // usuarioMedico, "Consulta de rotina");
        ConsultaPersistence consultaPersistence = new ConsultaPersistence();
        areaPaciente.createAndShowGUI();

    }
}
