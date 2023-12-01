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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.poo.projeto_hospital.exception.LoginException;
import com.poo.projeto_hospital.model.Email;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.poo.projeto_hospital.exception.LoginException;
import com.poo.projeto_hospital.model.Email;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author luiza
 */
public class Login extends FormatacaoInicial {
    private static JTextField emailField;
    private static JPasswordField senhaField;

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

    private static void renderizaBotao(JFrame frame) {
        JPanel botaoPanel = new JPanel();
        botaoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        botaoPanel.setPreferredSize(new Dimension(500, 50));

        JButton entrarButton = new JButton("Entrar");
        JButton criarContaButton = new JButton("Criar nova conta");

        botaoPanel.add(entrarButton);
        botaoPanel.add(criarContaButton);
        final JFrame finalFrame = frame;

        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String senha = new String(senhaField.getPassword());
                try {
                    validarLogin(email, senha);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        criarContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // redirecionar para o login
                RegistroPaciente.main(null);
                finalFrame.dispose(); // fechar tela de login
            }
        });

        frame.getContentPane().add(botaoPanel, BorderLayout.PAGE_END);
    }

    private static void validarLogin(String email, String senha) throws Exception {
        try {
            email = Email.isValidEmail(email); // Corrigir aqui
            if (isEmailRegistered(email)) {
                System.out.println("entrou no email registrado");
                if (isPasswordCorrect(email, senha)) {
                    JOptionPane.showMessageDialog(null, "Login realizado com sucesso!", "Login",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    throw new LoginException("Senha incorreta!");
                }
            } else {
                throw new LoginException("Email não registrado!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    private static boolean isEmailRegistered(String email) {
        HashMap<String, String> registeredEmails = getEmailAndPasswords();
        printEmailAndPasswords(registeredEmails);
        return registeredEmails.containsKey(email);
    }

    private static HashMap<String, String> getEmailAndPasswords() {
        HashMap<String, String> emailAndPasswords = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader("hospitalmanagement/src/main/java/com/poo/projeto_hospital/infoFile/usuarios.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String email = parts[0].trim();
                    String password = parts[1].trim();
                    emailAndPasswords.put(email, password);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        printEmailAndPasswords(emailAndPasswords);
        return emailAndPasswords;
    }

    private static void printEmailAndPasswords(HashMap<String, String> emailAndPasswords) {
        for (Map.Entry<String, String> entry : emailAndPasswords.entrySet()) {
            String email = entry.getKey();
            String password = entry.getValue();
            System.out.println("Email: " + email + ", Password: " + password);
        }
    }

    private static boolean isPasswordCorrect(final String email, final String senha) throws LoginException {
        HashMap<String, String> emailAndPasswords = getEmailAndPasswords();
        String storedPassword = emailAndPasswords.get(email);

        if (storedPassword != null && storedPassword.equals(senha)) {
            return true;
        } else {
            throw new LoginException("Senha incorreta!");
        }
    }

}
