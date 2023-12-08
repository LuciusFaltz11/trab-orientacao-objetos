package com.poo.projeto_hospital.view.perfilPaciente;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.poo.projeto_hospital.Consulta;
import com.poo.projeto_hospital.model.Paciente;
import com.poo.projeto_hospital.model.Usuario;
import com.poo.projeto_hospital.model.UsuarioMedico;
import com.poo.projeto_hospital.persistence.MedicoPersistence;

import java.awt.Dimension;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JScrollPane;

public class AreaPaciente {
    protected Usuario paciente;

    public AreaPaciente(Usuario paciente) {
        this.paciente = paciente;
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Perfil do paciente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setPreferredSize(new Dimension(500, 350));
        frame.setResizable(false);
        // acoesPaciente(frame);
        createToolbar(frame);
        criarMensagem(frame);
        consultasPaciente(frame);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.pack();
        frame.setLocationRelativeTo(null); // tela no centro
        frame.setVisible(true);
    }

    void acoesPaciente(JFrame frame) {
        JPanel botaoPanel = new JPanel();
        botaoPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center align the buttons
        botaoPanel.setPreferredSize(new Dimension(100, 50));

        JButton voltarButton = new JButton("Sair");
        JButton marcarConsultaButton = new JButton("Marcar consulta");
        JButton editarPerfilButton = new JButton("Editar perfil");
        JButton cancelarConsultaButton = new JButton("Cancelar consulta");

        botaoPanel.add(marcarConsultaButton);
        botaoPanel.add(editarPerfilButton);
        botaoPanel.add(cancelarConsultaButton);
        botaoPanel.add(voltarButton);
        frame.add(botaoPanel);
    }

    void createToolbar(JFrame frame) {
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);

        JButton marcarConsultaButton = new JButton("Marcar consulta");
        JButton editarPerfilButton = new JButton("Editar perfil");
        JButton cancelarConsultaButton = new JButton("Cancelar consulta");
        JButton sairButton = new JButton("Sair");

        toolbar.add(marcarConsultaButton);
        toolbar.add(editarPerfilButton);
        toolbar.add(cancelarConsultaButton);
        toolbar.add(sairButton);

        frame.add(toolbar);
    }

    void consultasPaciente(JFrame frame) {
        JPanel consultasPanel = new JPanel();
        consultasPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        consultasPanel.setPreferredSize(new Dimension(500, 300));

        // Create a border for the panel
        Border border = BorderFactory.createEtchedBorder();
        consultasPanel.setBorder(border);

        JLabel tituloLabel = new JLabel("Consultas");
        tituloLabel.setFont(new Font(null, Font.BOLD, 20));
        consultasPanel.add(tituloLabel);

        List<Consulta> consultas = paciente.getConsultas();

        if (consultas == null || consultas.isEmpty()) {
            JLabel semConsultasLabel = new JLabel("Você não tem consultas agendadas.");
            consultasPanel.add(semConsultasLabel);
        } else {
            JTextArea consultasTextArea = new JTextArea();
            consultasTextArea.setEditable(false);
            consultasTextArea.setPreferredSize(new Dimension(400, 200));

            StringBuilder consultasText = new StringBuilder();
            for (Consulta consulta : consultas) {
                consultasText.append(consulta.toString(true)).append("\n");
            }
            consultasTextArea.setText(consultasText.toString());

            JScrollPane scrollPane = new JScrollPane(consultasTextArea);
            scrollPane.setPreferredSize(new Dimension(450, 150));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Remove horizontal scroll
                                                                                             // bar

            consultasPanel.add(scrollPane);
        }

        frame.add(consultasPanel);
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
