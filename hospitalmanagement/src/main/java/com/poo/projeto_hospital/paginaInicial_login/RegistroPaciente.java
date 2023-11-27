package com.poo.projeto_hospital.paginaInicial_login;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class RegistroPaciente extends FormatacaoInicial {

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

        criarTitulo(frame, "Registro de Paciente");
        criaPainelImagem(frame, "hospitalmanagement/src/main/resources/images/iconeRegistro.png");
        formuláriosInfoPaciente(frame);

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * @param frame
     */
    private static void formuláriosInfoPaciente(JFrame frame) {
        JPanel panel = new JPanel(new GridLayout(1, 1));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel informacoesPessoaisLabel = new JLabel("Informações Pessoais");
        informacoesPessoaisLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(informacoesPessoaisLabel);

        JLabel nomeLabel = new JLabel("Nome");
        nomeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JTextField nomeField = new JTextField(20);
        nomeField.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(nomeLabel);
        panel.add(nomeField);

        JLabel cpfLabel = new JLabel("CPF");
        cpfLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JTextField cpfField = new JTextField(20);
        cpfField.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(cpfLabel);
        panel.add(cpfField);

        JLabel dataNascimentoLabel = new JLabel("Data de Nascimento (dd/mm/aaaa)");
        dataNascimentoLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JTextField dataNascimentoField = new JTextField(20);
        dataNascimentoField.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(dataNascimentoLabel);
        panel.add(dataNascimentoField);

        JLabel sexoLabel = new JLabel("Sexo (F/M)");
        sexoLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JTextField sexoField = new JTextField(20);
        sexoField.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(sexoLabel);
        panel.add(sexoField);

        JLabel informacoesLoginLabel = new JLabel("Informações de Login");
        informacoesLoginLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(informacoesLoginLabel);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JTextField emailField = new JTextField(20);
        emailField.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(emailLabel);
        panel.add(emailField);

        JLabel senhaLabel = new JLabel("Senha (minímo 8 caracteres)");
        senhaLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(senhaLabel);
        panel.add(passwordField);

        frame.getContentPane().add(panel, BorderLayout.SOUTH);

        // Adiciona espaço entre a borda da direita e da esquerda
        panel.setBorder(BorderFactory.createEmptyBorder(0, 30, 10, 30));
    }
}
