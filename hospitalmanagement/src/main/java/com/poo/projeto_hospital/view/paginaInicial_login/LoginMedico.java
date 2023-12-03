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
import com.poo.projeto_hospital.controller.EntrarLoginMedico;

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
        botaoPanel.setPreferredSize(new Dimension(400, 42));

        JButton entrarButton = new JButton("Entrar");
        JButton voltarButton = new JButton("Voltar");

        botaoPanel.add(entrarButton);
        botaoPanel.add(voltarButton);
        // entrarButton.addActionListener(new EntrarLogin(this));

        final JFrame finalFrame = frame;
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                finalFrame.dispose();
                login.createAndShowGUI();
            }
        });

        entrarButton.addActionListener(new EntrarLoginMedico(this));

        frame.getContentPane().add(botaoPanel, BorderLayout.PAGE_END);

    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getSenhaField() {
        return senhaField;
    }

}
