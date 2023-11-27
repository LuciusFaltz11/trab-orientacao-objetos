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
import javax.swing.JButton;
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
        frame.setPreferredSize(new Dimension(768, 768));
        frame.setResizable(false);

        frame.pack();

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
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(768, 400));

        JLabel informacoesPessoaisLabel = new JLabel("Informações Pessoais");
        informacoesPessoaisLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(informacoesPessoaisLabel, gbc);

        JLabel nomeLabel = new JLabel("Nome");
        nomeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        nomeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField nomeField = new JTextField(20);
        nomeField.setFont(new Font("Arial", Font.PLAIN, 15));
        nomeField.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(nomeLabel, gbc);
        panel.add(nomeField, gbc);

        JLabel cpfLabel = new JLabel("CPF");
        cpfLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        cpfLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField cpfField = new JTextField(20);
        cpfField.setFont(new Font("Arial", Font.PLAIN, 15));
        cpfField.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(cpfLabel, gbc);
        panel.add(cpfField, gbc);

        JLabel dataNascimentoLabel = new JLabel("Data de Nascimento (dd/mm/aaaa)");
        dataNascimentoLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        dataNascimentoLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField dataNascimentoField = new JTextField(20);
        dataNascimentoField.setFont(new Font("Arial", Font.PLAIN, 15));
        dataNascimentoField.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(dataNascimentoLabel, gbc);
        panel.add(dataNascimentoField, gbc);

        JLabel sexoLabel = new JLabel("Sexo (F/M)");
        sexoLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        sexoLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField sexoField = new JTextField(20);
        sexoField.setFont(new Font("Arial", Font.PLAIN, 15));
        sexoField.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(sexoLabel, gbc);
        panel.add(sexoField, gbc);

        JLabel informacoesLoginLabel = new JLabel("Informações de Login");
        informacoesLoginLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(informacoesLoginLabel, gbc);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        emailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField emailField = new JTextField(20);
        emailField.setFont(new Font("Arial", Font.PLAIN, 15));
        emailField.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(emailLabel, gbc);
        panel.add(emailField, gbc);

        JLabel senhaLabel = new JLabel("Senha (minímo 8 caracteres)");
        senhaLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        senhaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(senhaLabel, gbc);
        panel.add(passwordField, gbc);

        frame.getContentPane().add(panel, BorderLayout.SOUTH);

        JPanel botaPanel = new JPanel();
        botaPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        criaBotao(panel);
        panel.add(botaPanel);

        panel.setBorder(BorderFactory.createEmptyBorder(0, 60, 10, 60));
    }

    private static void criaBotao(JPanel panel) {
        JPanel botaoPanel = new JPanel();
        botaoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton criarContaButton = new JButton("Criar nova conta");
        JButton voltarButton = new JButton("Voltar");

        botaoPanel.add(voltarButton);
        botaoPanel.add(criarContaButton);
        botaoPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        panel.add(botaoPanel);
    }
}
