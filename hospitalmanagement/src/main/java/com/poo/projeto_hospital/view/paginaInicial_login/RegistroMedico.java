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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.poo.projeto_hospital.controller.CriarContaLogin;
import com.poo.projeto_hospital.controller.CriarContaMedico;

public class RegistroMedico extends FormatacaoInicial {

    protected static JFrame frame;
    private static JTextField nomeField;
    private static JTextField cpfField;
    private static JTextField dataNascimentoField;
    private static JTextField cidadeField;
    private static JTextField estadoField;
    private static JTextField sexoField;
    private static JTextField emailField;
    private static JPasswordField passwordField;
    private static JTextField inicioExpedienteField;
    private static JTextField fimExpedienteField;
    private static JTextField especialidadeField;

    public void createAndShowGUI() {
        frame = new JFrame("Hospital Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(768, 768);
        frame.setPreferredSize(new java.awt.Dimension(600, 600));
        frame.setResizable(false);

        frame.pack();

        criarTitulo(frame, "Registro de Médico");
        formulariosInfoMedico(frame);
        criaBotao(frame);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void formulariosInfoMedico(JFrame frame) {
        JPanel formularioPanel = new JPanel();
        formularioPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font fieldFont = new Font("Arial", Font.PLAIN, 16);

        JLabel nomeLabel = new JLabel("Nome: ");
        nomeLabel.setFont(labelFont);
        formularioPanel.add(nomeLabel, gbc);

        nomeField = new JTextField(20);
        nomeField.setFont(fieldFont);
        formularioPanel.add(nomeField, gbc);

        JLabel cpfLabel = new JLabel("CPF: ");
        cpfLabel.setFont(labelFont);
        formularioPanel.add(cpfLabel, gbc);

        cpfField = new JTextField(20);
        cpfField.setFont(fieldFont);
        formularioPanel.add(cpfField, gbc);

        JLabel especialidadeLabel = new JLabel("Especialidade: ");
        especialidadeLabel.setFont(labelFont);
        formularioPanel.add(especialidadeLabel, gbc);

        especialidadeField = new JTextField(20);
        especialidadeField.setFont(fieldFont);
        formularioPanel.add(especialidadeField, gbc);

        JLabel inicioExpedienteLabel = new JLabel("Início/fim do expediente(hh:mm): ");
        inicioExpedienteLabel.setFont(labelFont);
        formularioPanel.add(inicioExpedienteLabel, gbc);

        inicioExpedienteField = new JTextField("Inicio");
        inicioExpedienteField.setFont(fieldFont);
        formularioPanel.add(inicioExpedienteField, gbc);

        fimExpedienteField = new JTextField("Fim");
        fimExpedienteField.setFont(fieldFont);
        formularioPanel.add(fimExpedienteField, gbc);

        JLabel dataNascimentoLabel = new JLabel("Data de Nascimento(dd/mm/aaaa)");
        dataNascimentoLabel.setFont(labelFont);
        formularioPanel.add(dataNascimentoLabel, gbc);

        dataNascimentoField = new JTextField(20);
        dataNascimentoField.setFont(fieldFont);
        formularioPanel.add(dataNascimentoField, gbc);

        JLabel cidadeLabel = new JLabel("Cidade: ");
        cidadeLabel.setFont(labelFont);
        formularioPanel.add(cidadeLabel, gbc);

        cidadeField = new JTextField(20);
        cidadeField.setFont(fieldFont);
        formularioPanel.add(cidadeField, gbc);

        JLabel estadoLabel = new JLabel("Estado(sigla): ");
        estadoLabel.setFont(labelFont);
        formularioPanel.add(estadoLabel, gbc);

        estadoField = new JTextField(20);
        estadoField.setFont(fieldFont);
        formularioPanel.add(estadoField, gbc);

        JLabel sexoLabel = new JLabel("Sexo(F/M): ");
        sexoLabel.setFont(labelFont);
        formularioPanel.add(sexoLabel, gbc);

        sexoField = new JTextField(20);
        sexoField.setFont(fieldFont);
        formularioPanel.add(sexoField, gbc);

        JLabel tituloLabel2 = new JLabel("Informações de Login");
        tituloLabel2.setFont(labelFont);

        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setFont(labelFont);
        formularioPanel.add(emailLabel, gbc);

        emailField = new JTextField(20);
        emailField.setFont(fieldFont);
        formularioPanel.add(emailField, gbc);

        JLabel senhaLabel = new JLabel("Senha(mínimo 8 caracteres): ");
        senhaLabel.setFont(labelFont);
        formularioPanel.add(senhaLabel, gbc);

        passwordField = new JPasswordField(20);
        passwordField.setFont(fieldFont);
        formularioPanel.add(passwordField, gbc);

        formularioPanel.add(nomeLabel, gbc);
        formularioPanel.add(nomeField, gbc);
        formularioPanel.add(cpfLabel, gbc);
        formularioPanel.add(cpfField, gbc);
        formularioPanel.add(especialidadeLabel, gbc);
        formularioPanel.add(especialidadeField, gbc);
        formularioPanel.add(inicioExpedienteLabel, gbc);
        formularioPanel.add(inicioExpedienteField, gbc);
        formularioPanel.add(fimExpedienteField, gbc);
        formularioPanel.add(dataNascimentoLabel, gbc);
        formularioPanel.add(dataNascimentoField, gbc);
        formularioPanel.add(sexoLabel, gbc);
        formularioPanel.add(sexoField, gbc);
        formularioPanel.add(cidadeLabel, gbc);
        formularioPanel.add(cidadeField, gbc);
        formularioPanel.add(estadoLabel, gbc);
        formularioPanel.add(estadoField, gbc);
        formularioPanel.add(tituloLabel2, gbc);
        formularioPanel.add(emailLabel, gbc);
        formularioPanel.add(emailField, gbc);
        formularioPanel.add(senhaLabel, gbc);
        formularioPanel.add(passwordField, gbc);

        JScrollPane scrollPane = new JScrollPane(formularioPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        formularioPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
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

        criarContaButton.addActionListener(new CriarContaMedico(this));

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

    public JTextField getEspecialidadeField() {
        return especialidadeField;
    }

    public JTextField getEstadoField() {
        return estadoField;
    }

    public JTextField getFimExpedienteField() {
        return fimExpedienteField;
    }

    public JTextField getInicioExpedienteField() {
        return inicioExpedienteField;
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

    public JFrame getFrame() {
        return frame;
    }

}
