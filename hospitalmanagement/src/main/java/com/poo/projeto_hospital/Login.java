/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo.projeto_hospital;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

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
public class Login {
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
        frame.setSize(768, 768);
        frame.setResizable(false);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        criaTitulo(frame);
        criaPainelImagem(frame);
        criaFormularioLogin(frame);
        renderizaBotao(frame);

        frame.pack();
        frame.setVisible(true);
    }

    private static void criaPainelImagem(JFrame frame) {

        JPanel iconePanel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        iconePanel.setLayout(layout);
        iconePanel.setPreferredSize(new Dimension(768, 100));

        ImageIcon imageIcon = new ImageIcon("hospitalmanagement/src/main/resources/images/iconeCerto.png");
        JLabel jLabel = new JLabel(imageIcon);
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setVerticalAlignment(JLabel.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weighty = 1;

        iconePanel.add(jLabel, gbc);
        frame.getContentPane().add(iconePanel, BorderLayout.CENTER);
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

        frame.getContentPane().add(formularioPanel, BorderLayout.SOUTH);
    }

    private static void renderizaBotao(JFrame frame) {
        JPanel botaoPanel = new JPanel();
        botaoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton entrarButton = new JButton("Entrar");
        JButton criarContaButton = new JButton("Criar nova conta");

        botaoPanel.add(entrarButton);
        botaoPanel.add(criarContaButton);
        botaoPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));

        frame.getContentPane().add(botaoPanel, BorderLayout.PAGE_END);
    }

    private static void criaTitulo(JFrame frame) {
        JPanel tituloPanel = new JPanel();
        tituloPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        tituloPanel.setPreferredSize(new Dimension(768, 50));

        JLabel tituloLabel = new JLabel("Login");
        tituloLabel.setFont(tituloLabel.getFont().deriveFont(20.0f));
        tituloPanel.add(tituloLabel);

        frame.getContentPane().add(tituloPanel, BorderLayout.NORTH);
    }

}
