package com.poo.projeto_hospital;

import java.util.List;

import com.poo.projeto_hospital.exception.DataException;
import com.poo.projeto_hospital.exception.HorarioException;
import com.poo.projeto_hospital.model.Usuario;
import com.poo.projeto_hospital.persistence.ConsultaPersistence;
import com.poo.projeto_hospital.persistence.PacientePersistence;
import com.poo.projeto_hospital.persistence.Persistence;
import com.poo.projeto_hospital.view.TelaAgenda;
import com.poo.projeto_hospital.view.paginaInicial_login.Login;
import com.poo.projeto_hospital.view.perfilPaciente.AreaPaciente;
import com.poo.projeto_hospital.view.perfilPaciente.EditarPerfil;
import com.poo.projeto_hospital.view.perfilPaciente.MarcarConsulta;

public class App {
    public static void main(String[] args) throws DataException {
        //Login login = new Login();
        //login.createAndShowGUI();

        ConsultaPersistence consultaPersistence = new ConsultaPersistence();
         List<Integer> ids = consultaPersistence.getConsultaIds();
            int id = 0;
            if (!ids.isEmpty()) {
                id = ids.get(ids.size() - 1) + 1;
            }

         TelaAgenda telaAgenda = new TelaAgenda("99988877766");
         try {
            // nao faz sentido lancar excecao para os CPF, eles ja seriam validados, ja estao no arquivo de pacientes
         telaAgenda.addConsulta(id,"13593634678", "00072295672", "07/12/2023", "09:00", "Diarreia");
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
