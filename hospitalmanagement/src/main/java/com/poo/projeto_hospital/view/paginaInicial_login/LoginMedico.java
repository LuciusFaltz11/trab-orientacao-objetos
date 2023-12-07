package com.poo.projeto_hospital.view.paginaInicial_login;

import com.poo.projeto_hospital.controller.EntrarLoginMedico;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.poo.projeto_hospital.controller.EntrarLoginMedico;

public class LoginMedico extends FormatacaoInicial {

    public JTextField emailField;
    public JPasswordField senhaField;

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

        criaFormularioLogin(frame);
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
        entrarButton.addActionListener(new EntrarLoginMedico(this));

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

    private void criaFormularioLogin(JFrame frame) {
        JPanel formularioPanel = new JPanel();
        formularioPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel emaiLabel = new JLabel("Email");
        emailField = new JTextField(20);
        JLabel senhaLabel = new JLabel("Senha");
        senhaField = new JPasswordField(20);

        formularioPanel.add(emaiLabel, gbc);
        formularioPanel.add(emailField, gbc);
        formularioPanel.add(senhaLabel, gbc);
        formularioPanel.add(senhaField, gbc);

        formularioPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.getContentPane().add(formularioPanel, BorderLayout.SOUTH);

    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JPasswordField getSenhaField() {
        return senhaField;
    }

}
