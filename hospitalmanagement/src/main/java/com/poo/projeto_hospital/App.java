package com.poo.projeto_hospital;

import com.poo.projeto_hospital.exception.DataException;
import com.poo.projeto_hospital.exception.HorarioException;
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

         TelaAgenda telaAgenda = new TelaAgenda("999.888.777-66s");
         try {
            // nao faz sentido lancar excecao para os CPF, eles ja seriam validados, ja estao no arquivo de pacientes
         telaAgenda.addConsulta("13593634678", "14072295671", "07/12/2023", "22:00", "60", "Consulta de rotina");
         }
         catch (DataException e){
            System.out.println(e.getMessage());
         }
         catch(HorarioException e){
            System.out.println(e.getMessage());
         }
         telaAgenda.desenha();

        //UsuarioMedico usuarioMedico = new UsuarioMedico("gabriel@gmail.com", "123456".toCharArray(), "Dr. Gabriel",
               // "16676994747", "20/02/2020", "São Paulo", "SP", "Masculino", "Cardiologista", "08:00", "18:00");
       // Paciente paciente = new Paciente("Luiza", "18785173762", "20/02/2020", "São Paulo", "SP", "Feminino");
       // AreaPaciente areaPaciente = new AreaPaciente(paciente);
        // Consulta consulta = new Consulta(paciente, "20/02/2020", "08:00", 30,
        // usuarioMedico, "Consulta de rotina");
        //ConsultaPersistence consultaPersistence = new ConsultaPersistence();
        //areaPaciente.createAndShowGUI();

    }
}
