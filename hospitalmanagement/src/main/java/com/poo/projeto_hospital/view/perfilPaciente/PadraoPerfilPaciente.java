package com.poo.projeto_hospital.view.perfilPaciente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.poo.projeto_hospital.model.Usuario;
import com.poo.projeto_hospital.model.UsuarioMedico;
import com.poo.projeto_hospital.view.paginaInicial_login.Login;

public abstract class PadraoPerfilPaciente {

    protected static void createToolbar(JFrame frame, Usuario paciente) {
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);

        JButton marcarConsultaButton = new JButton("Marcar consulta");
        JButton editarPerfilButton = new JButton("Editar perfil");
        JButton cancelarConsultaButton = new JButton("Cancelar consulta");
        JButton sairButton = new JButton("Sair");

        final Usuario finalPaciente = paciente;
        final JFrame finalFrame = frame;
        marcarConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new MarcarConsulta(finalPaciente).createAndShowGUI();
                finalFrame.dispose();
            }
        });

        editarPerfilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new EditarPerfil(finalPaciente).createAndShowGUI();
                finalFrame.dispose();
            }
        });

        cancelarConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new CancelarConsulta(finalPaciente).createAndShowGUI();
                finalFrame.dispose();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new Login().createAndShowGUI();
                finalFrame.dispose();
            }
        });

        toolbar.add(marcarConsultaButton);
        toolbar.add(editarPerfilButton);
        toolbar.add(cancelarConsultaButton);
        toolbar.add(sairButton);

        frame.add(toolbar);
    }

    protected static void criarTitulo(JFrame frame, String titulo) {
        JPanel tituloPanel = new JPanel();
        tituloPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        tituloPanel.setPreferredSize(new Dimension(768, 50));

        JLabel tituloLabel = new JLabel(titulo);
        tituloLabel.setFont(tituloLabel.getFont().deriveFont(20.0f));
        tituloPanel.add(tituloLabel);

        frame.getContentPane().add(tituloPanel, BorderLayout.PAGE_START);
    }

    protected static JFrame criarFrame(String titulo) { // colocar setVisibleTrue na propria classe que chama
        JFrame frame = new JFrame(titulo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setPreferredSize(new Dimension(500, 400));
        frame.setResizable(false);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.pack();
        frame.setLocationRelativeTo(null); // tela no centro
        return frame;
    }
}