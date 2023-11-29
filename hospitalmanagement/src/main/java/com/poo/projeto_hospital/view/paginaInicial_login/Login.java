/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo.projeto_hospital.view.paginaInicial_login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author luiza
 */
public class Login extends FormatacaoInicial {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Hospital Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setPreferredSize(new Dimension(500, 350));
        frame.setResizable(false);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        criarTitulo(frame, "Login");
        criaPainelImagem(frame, "hospitalmanagement/src/main/resources/images/iconeLogin.png");
        criaFormularioLogin(frame);
        renderizaBotao(frame);

        frame.pack();
        frame.setLocationRelativeTo(null); // tela no centro
        frame.setVisible(true);
    }

    private static void criaFormularioLogin(JFrame frame) {
        JPanel formularioPanel = new JPanel();
        formularioPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel emaiLabel = new JLabel("Email");
        JTextField emailField = new JTextField(20);
        JLabel senhaLabel = new JLabel("Senha");
        JPasswordField passwordField = new JPasswordField(20);

        formularioPanel.add(emaiLabel, gbc);
        formularioPanel.add(emailField, gbc);
        formularioPanel.add(senhaLabel, gbc);
        formularioPanel.add(passwordField, gbc);

        formularioPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        frame.getContentPane().add(formularioPanel, BorderLayout.SOUTH);

    }

    private static void renderizaBotao(JFrame frame) {
        JPanel botaoPanel = new JPanel();
        botaoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        botaoPanel.setPreferredSize(new Dimension(500, 50));

        JButton entrarButton = new JButton("Entrar");
        JButton criarContaButton = new JButton("Criar nova conta");

        botaoPanel.add(entrarButton);
        botaoPanel.add(criarContaButton);
        final JFrame finalFrame = frame;
        criarContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Redirecionar para a tela de registro de paciente
                RegistroPaciente registroPaciente = new RegistroPaciente();
                registroPaciente.main(null);
                finalFrame.dispose(); // Close the current frame
            }
        });

        frame.getContentPane().add(botaoPanel, BorderLayout.PAGE_END);
    }

}
