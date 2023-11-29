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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.poo.projeto_hospital.exception.CPFException;
import com.poo.projeto_hospital.exception.DataException;
import com.poo.projeto_hospital.exception.EmailException;
import com.poo.projeto_hospital.exception.SenhaException;
import com.poo.projeto_hospital.model.CPF;
import com.poo.projeto_hospital.model.Data;
import com.poo.projeto_hospital.model.Email;
import com.poo.projeto_hospital.model.Senha;
import com.poo.projeto_hospital.model.Usuario;
import com.poo.projeto_hospital.persistence.Arquivo;

public class RegistroPaciente extends FormatacaoInicial {

    private static JTextField nomeField;
    private static JTextField cpfField;
    private static JTextField dataNascimentoField;
    private static JTextField cidadeField;
    private static JTextField estadoField;
    private static JTextField sexoField;
    private static JTextField emailField;
    private static JPasswordField passwordField;

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
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setResizable(false);

        frame.pack();

        criarTitulo(frame, "Registro de Paciente");
        formuláriosInfoPaciente(frame);
        criaBotao(frame);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * @param frame
     */

    private static void formuláriosInfoPaciente(JFrame frame) {
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

    private static void criaBotao(JFrame frame) {
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
                Login login = new Login();
                login.main(null);
                finalFrame.dispose();
            }
        });

        criarContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String cpf = cpfField.getText();
                String dataNascimento = dataNascimentoField.getText();
                String cidade = cidadeField.getText();
                String estado = estadoField.getText();
                String sexo = sexoField.getText();
                String email = emailField.getText();
                char[] senha = passwordField.getPassword();

                if (nome.isEmpty() || cpf.isEmpty() || dataNascimento.isEmpty() || cidade.isEmpty()
                        || estado.isEmpty() || sexo.isEmpty() || email.isEmpty() || senha.length == 0) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Campos vazios",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    // Validar o CPF
                    CPF.parser(cpf);
                    // Validar a data de nascimento
                    Data.isValidData(dataNascimento);
                    // Validar o email
                    Email.isValidEmail(email);
                    // Validar a senha
                    Senha.isValidSenha(senha);
                } catch (CPFException ex) {
                    ex.getMessage();
                    return;
                } catch (DataException ex) {
                    ex.getMessage();
                    return;
                } catch (EmailException ex) {
                    ex.getMessage();
                    return;
                } catch (SenhaException ex) {
                    ex.getMessage();
                    return;
                }

                if (!sexo.equals("f") && !sexo.equals("F") && !sexo.equals("m") && !sexo.equals("M")) {
                    JOptionPane.showMessageDialog(null, "Sexo inválido!", "Sexo Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        });

        frame.add(botaoPanel, BorderLayout.PAGE_END);

        frame.add(botaoPanel, BorderLayout.PAGE_END);

    }
}
