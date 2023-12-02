package com.poo.projeto_hospital.controller;
import com.poo.projeto_hospital.model.Usuario;
import com.poo.projeto_hospital.persistence.PacientePersistence;
import com.poo.projeto_hospital.persistence.Persistence;
import com.poo.projeto_hospital.view.paginaInicial_login.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;
import java.util.Arrays;

import javax.swing.*;

public class EntrarLogin implements ActionListener {
    private Login login;

    public EntrarLogin(Login login) {
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String email = login.getEmailField().getText();
        char[] senha = login.getSenhaField().getPassword();

        if (email.isEmpty() || senha.length == 0) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Campos vazios",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Persistence<Usuario> pacientePersistence = new PacientePersistence();
        List<Usuario> pacientes = pacientePersistence.findAll();
        for (Usuario paciente : pacientes) {
            if (paciente.getEmail().equals(email) && Arrays.equals(paciente.getSenha(), senha)) {
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!", "Login",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Usuário não encontrado ou senha incorreta", "Erro de Login",
                JOptionPane.ERROR_MESSAGE);
    }

}
