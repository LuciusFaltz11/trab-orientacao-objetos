package com.poo.projeto_hospital.view.perfilPaciente;

import javax.swing.JFrame;

import com.poo.projeto_hospital.model.Usuario;

public class CancelarConsulta extends PadraoPerfilPaciente {
    JFrame frame;
    Usuario paciente;

    public CancelarConsulta(Usuario paciente) {
        this.paciente = paciente;
    }

    void createAndShowGUI() {

        createToolbar(frame, paciente);
        criarTitulo(frame, "Cancelar Consulta");

        frame.setVisible(true);
    }

}
