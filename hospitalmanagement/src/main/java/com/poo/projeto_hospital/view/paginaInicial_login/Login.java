/*
João Augusto Pilato de Castro- 202235006
Lucius Faltz Lassarote da Silva - 202235027
Luíza Machado Costa Nascimento - 202235021
*/
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.poo.projeto_hospital.controller.EntrarLogin;

/**
 *
 * @author luiza
 */
public class Login extends FormatacaoInicial {
    private JTextField emailField;
    private JPasswordField senhaField;
    JFrame frame;

    public Login() {

    }

    public void createAndShowGUI() {
        emailField = new JTextField(20);
        senhaField = new JPasswordField(20);
        frame = new JFrame("Hospital Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setPreferredSize(new Dimension(500, 350));
        frame.setResizable(false);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        criarTitulo(frame, "Login");
        criaPainelImagem(frame, "hospitalmanagement/src/main/resources/images/iconeLogin.png");
        criaFormularioLogin(frame, emailField, senhaField);
        renderizaBotao(frame);

        frame.pack();
        frame.setLocationRelativeTo(null); // tela no centro
        frame.setVisible(true);
    }

    private void renderizaBotao(JFrame frame) {
        JPanel botaoPanel = new JPanel();
        botaoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        botaoPanel.setPreferredSize(new Dimension(500, 50));

        JButton entrarButton = new JButton("Entrar");
        JButton criarContaButton = new JButton("Criar nova conta");
        JButton areaMedico = new JButton("Área do médico");

        botaoPanel.add(entrarButton);
        botaoPanel.add(criarContaButton);
        botaoPanel.add(areaMedico);

        entrarButton.addActionListener(new EntrarLogin(this));

        final JFrame finalFrame = frame;
        areaMedico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginMedico loginMedico = new LoginMedico();
                finalFrame.dispose();
                loginMedico.createAndShowGUI();
                finalFrame.dispose();
            }
        });
        criarContaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegistroPaciente registroPaciente = new RegistroPaciente();
                finalFrame.dispose(); // Use finalFrame instead of frame
                registroPaciente.createAndShowGUI();
                finalFrame.dispose();
            }
        });

        frame.getContentPane().add(botaoPanel, BorderLayout.PAGE_END);
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JPasswordField getSenhaField() {
        return senhaField;
    }

    public JFrame getFrame() {
        return frame;
    }

}
