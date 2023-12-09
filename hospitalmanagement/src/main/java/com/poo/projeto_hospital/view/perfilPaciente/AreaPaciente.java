package com.poo.projeto_hospital.view.perfilPaciente;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.poo.projeto_hospital.model.Consulta;
import com.poo.projeto_hospital.model.Usuario;

import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JScrollPane;

public class AreaPaciente extends PadraoPerfilPaciente {
    protected Usuario paciente;

    public AreaPaciente(Usuario paciente) {
        this.paciente = paciente;
    }

    public void createAndShowGUI() {
        JFrame frame = criarFrame("Perfil do paciente");
        createToolbar(frame, paciente);
        criarMensagem(frame);
        consultasPaciente(frame);

        frame.setVisible(true);

    }

    void consultasPaciente(JFrame frame) {
        JPanel consultasPanel = new JPanel();
        consultasPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        consultasPanel.setPreferredSize(new Dimension(500, 250));

        // Create a border for the panel
        Border border = BorderFactory.createEtchedBorder();
        consultasPanel.setBorder(border);

        JLabel tituloLabel = new JLabel("Consultas");
        tituloLabel.setFont(new Font(null, Font.BOLD, 20));
        consultasPanel.add(tituloLabel);

        List<Consulta> consultas = paciente.getConsultas();

        if (consultas == null || consultas.isEmpty()) {
            JLabel semConsultasLabel = new JLabel("Você não tem consultas agendadas.");
            semConsultasLabel.setFont(semConsultasLabel.getFont().deriveFont(Font.BOLD));
            consultasPanel.add(semConsultasLabel);
        } else {
            JTextArea consultasTextArea = new JTextArea();
            consultasTextArea.setEditable(false);
            consultasTextArea.setLineWrap(true);
            consultasTextArea.setWrapStyleWord(true);
            consultasTextArea.setFont(new Font(null, Font.PLAIN, 15));

            StringBuilder consultasText = new StringBuilder();
            for (Consulta consulta : consultas) {
                consultasText.append(consulta.getDetalhesConsulta()).append("\n");
            }
            consultasTextArea.setText(consultasText.toString());

            JScrollPane scrollPane = new JScrollPane(consultasTextArea);
            scrollPane.setPreferredSize(new Dimension(450, 200));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            consultasPanel.add(scrollPane);
        }

        frame.getContentPane().add(consultasPanel);
    }

    void criarMensagem(JFrame frame) {
        JPanel mensagemPanel = new JPanel();
        mensagemPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mensagemPanel.setPreferredSize(new Dimension(50, 50));

        mensagemPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel mensagemLabel = new JLabel(
                "Bem vindo(a) " + this.paciente.getNome() + "! Você está na central do paciente.");
        mensagemPanel.add(mensagemLabel);
        mensagemLabel.setFont(new Font(null, Font.BOLD, 17));
        frame.add(mensagemPanel);
    }
}
