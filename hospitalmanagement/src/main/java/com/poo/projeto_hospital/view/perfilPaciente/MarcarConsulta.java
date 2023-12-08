package com.poo.projeto_hospital.view.perfilPaciente;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import com.poo.projeto_hospital.model.Usuario;

public class MarcarConsulta extends PadraoPerfilPaciente {
    protected Usuario paciente;

    public MarcarConsulta(Usuario paciente) {
        this.paciente = paciente;
    }

    public void createAndShowGUI() {
        JFrame frame = criarFrame("Perfil do paciente");

        createToolbar(frame);
        criarTitulo(frame, "Marcar Consulta");

        frame.setVisible(true);
    }

}
