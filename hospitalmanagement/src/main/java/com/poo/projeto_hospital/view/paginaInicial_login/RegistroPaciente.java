package com.poo.projeto_hospital.view.paginaInicial_login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.poo.projeto_hospital.controller.CriarContaLogin;

public class RegistroPaciente extends FormatacaoInicial {

    protected static JFrame frame;
    private static JTextField nomeField;
    private static JTextField cpfField;
    private static JTextField dataNascimentoField;
    private static JTextField cidadeField;
    private static JTextField estadoField;
    private static JTextField sexoField;
    private static JTextField emailField;
    private static JPasswordField passwordField;

    public void createAndShowGUI() {
        frame = new JFrame("Hospital Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(768, 768);
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setResizable(false);

        frame.pack();

        criarTitulo(frame, "Registro de Paciente");
        formulariosInfoPaciente(frame);
        criaBotao(frame);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * @param frame
     */

    private void formulariosInfoPaciente(JFrame frame) {
        JPanel formularioPanel = new JPanel();
        formularioPanel.setPreferredSize(new Dimension(768, 500));
        formularioPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel tituloLabel = new JLabel("Informações do Paciente");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        // Nome
        JLabel nomeLabel = new JLabel("Nome");
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nomeField = new JTextField(20);
        nomeField.setFont(new Font("Arial", Font.PLAIN, 16));

        // CPF
        JLabel cpfLabel = new JLabel("CPF");
        cpfLabel.setFont(new Font("Arial", Font.BOLD, 16));
        cpfField = new JTextField(20);
        cpfField.setFont(new Font("Arial", Font.PLAIN, 16));

        // Data de Nascimento
        JLabel dataNascimentoLabel = new JLabel("Data de Nascimento(dd/mm/aaaa)");
        dataNascimentoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        dataNascimentoField = new JTextField(20);
        dataNascimentoField.setFont(new Font("Arial", Font.PLAIN, 16));

        // cidade
        JLabel cidadeLabel = new JLabel("Cidade");
        cidadeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        cidadeField = new JTextField(20);
        cidadeField.setFont(new Font("Arial", Font.PLAIN, 16));

        // estado
        JLabel estadoLabel = new JLabel("Estado(sigla)");
        estadoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        estadoField = new JTextField(20);
        estadoField.setFont(new Font("Arial", Font.PLAIN, 16));

        // Sexo
        JLabel sexoLabel = new JLabel("Sexo(F/M)");
        sexoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        sexoField = new JTextField(20);
        sexoField.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel tituloLabel2 = new JLabel("Informações de Login");
        tituloLabel2.setFont(new Font("Arial", Font.BOLD, 20));

        // Email
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 16));
        emailField = new JTextField(20);
        emailField.setFont(new Font("Arial", Font.PLAIN, 16));

        // Senha
        JLabel senhaLabel = new JLabel("Senha(mínimo 8 caracteres)");
        senhaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));

        formularioPanel.add(tituloLabel, gbc);
        formularioPanel.add(nomeLabel, gbc);
        formularioPanel.add(nomeField, gbc);
        formularioPanel.add(cpfLabel, gbc);
        formularioPanel.add(cpfField, gbc);
        formularioPanel.add(dataNascimentoLabel, gbc);
        formularioPanel.add(dataNascimentoField, gbc);
        formularioPanel.add(cidadeLabel, gbc);
        formularioPanel.add(cidadeField, gbc);
        formularioPanel.add(estadoLabel, gbc);
        formularioPanel.add(estadoField, gbc);
        formularioPanel.add(sexoLabel, gbc);
        formularioPanel.add(sexoField, gbc);
        formularioPanel.add(tituloLabel2, gbc);
        formularioPanel.add(emailLabel, gbc);
        formularioPanel.add(emailField, gbc);
        formularioPanel.add(senhaLabel, gbc);
        formularioPanel.add(passwordField, gbc);
        frame.getContentPane().add(formularioPanel, BorderLayout.CENTER);
    }

    private void criaBotao(JFrame frame) {
        JPanel botaoPanel = new JPanel();
        botaoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton criarContaButton = new JButton("Criar nova conta");
        JButton voltarButton = new JButton("Voltar");

        botaoPanel.add(voltarButton);
        botaoPanel.add(criarContaButton);
        botaoPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        final JFrame finalFrame = frame;
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login().createAndShowGUI();
                finalFrame.dispose();
            }
        });

        criarContaButton.addActionListener(new CriarContaLogin(this));
        frame.add(botaoPanel, BorderLayout.PAGE_END);

        frame.add(botaoPanel, BorderLayout.PAGE_END);

    }

    public JTextField getCidadeField() {
        return cidadeField;
    }

    public JTextField getCpfField() {
        return cpfField;
    }

    public JTextField getDataNascimentoField() {
        return dataNascimentoField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getEstadoField() {
        return estadoField;
    }

    public JTextField getNomeField() {
        return nomeField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JTextField getSexoField() {
        return sexoField;
    }

}
