package com.poo.projeto_hospital;

import com.poo.projeto_hospital.exception.DataException;
import com.poo.projeto_hospital.model.Usuario;
import com.poo.projeto_hospital.persistence.PacientePersistence;
import com.poo.projeto_hospital.view.perfilPaciente.AreaPaciente;
import com.poo.projeto_hospital.view.perfilPaciente.EditarPerfil;
import com.poo.projeto_hospital.view.perfilPaciente.MarcarConsulta;

public class App {
    public static void main(String[] args) throws DataException {
        // Login login = new Login();
        // login.createAndShowGUI();

        /*
         * TelaAgenda telaAgenda = new TelaAgenda("999.888.777-66s");
         * try {
         * // nao faz sentido lancar excecao para os CPF, eles ja seriam validados, ja
         * estao no arquivo de pacientes
         * telaAgenda.addConsulta("13593634678", "14072295671", "07/12/2023", "23:30",
         * "60", "Consulta de rotina");
         * }
         * catch (DataException e){
         * System.out.println(e.getMessage());
         * }
         * catch(HorarioException e){
         * System.out.println(e.getMessage());
         * }
         * telaAgenda.desenha();
         * 
         */

        PacientePersistence encontrar = new PacientePersistence();
        Usuario paciente = encontrar.findByCpf("13593634678");

        // AreaPaciente area = new AreaPaciente(paciente);
        // area.createAndShowGUI();

        // MarcarConsulta marcarConsulta = new MarcarConsulta(paciente);
        // marcarConsulta.createAndShowGUI();

        EditarPerfil editarPerfil = new EditarPerfil(paciente);
        editarPerfil.createAndShowGUI();

    }
}
