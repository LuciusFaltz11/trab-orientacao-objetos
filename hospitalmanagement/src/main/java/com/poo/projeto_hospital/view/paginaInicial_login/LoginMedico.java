package com.poo.projeto_hospital.view.paginaInicial_login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.poo.projeto_hospital.controller.EntrarLogin;

public class LoginMedico extends FormatacaoInicial {

    private JTextField emailField;
    private JTextField senhaField;

    public LoginMedico() {
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Hospital Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setPreferredSize(new Dimension(500, 350));
        frame.setResizable(false);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        criarTitulo(frame, "Login");
        criaPainelImagem(frame, "hospitalmanagement/src/main/resources/images/iconeRegistroMedico.png");
        criaFormularioLogin(frame, emailField, senhaField);
        redenrizaBotaoMedico(frame);

        frame.pack();
        frame.setLocationRelativeTo(null); // tela no centro
        frame.setVisible(true);

    }

    private void redenrizaBotaoMedico(JFrame frame) {
        JPanel botaoPanel = new JPanel();
        botaoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        botaoPanel.setPreferredSize(new Dimension(500, 50));

        JButton entrarButton = new JButton("Entrar");
        JButton criarContaButton = new JButton("Criar nova conta");
        JButton areaMedico = new JButton("Área do médico");

        botaoPanel.add(entrarButton);
        botaoPanel.add(criarContaButton);
        botaoPanel.add(areaMedico);

        entrarButton.addActionListener();

        final JFrame finalFrame = frame;
        criarContaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegistroPaciente registroPaciente = new RegistroPaciente();
                finalFrame.dispose();
                registroPaciente.createAndShowGUI();
            }
        });

        areaMedico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginMedico login = new LoginMedico();
                finalFrame.dispose(); // Use finalFrame instead of frame
                login.createAndShowGUI();
            }
        });

        frame.getContentPane().add(botaoPanel, BorderLayout.PAGE_END);

    }

}
