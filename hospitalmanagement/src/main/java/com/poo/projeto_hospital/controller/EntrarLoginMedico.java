package com.poo.projeto_hospital.controller;

import com.poo.projeto_hospital.model.Senha;
import com.poo.projeto_hospital.model.Usuario;
import com.poo.projeto_hospital.persistence.MedicoPersistence;
import com.poo.projeto_hospital.persistence.PacientePersistence;
import com.poo.projeto_hospital.persistence.Persistence;
import com.poo.projeto_hospital.view.paginaInicial_login.Login;
import com.poo.projeto_hospital.view.paginaInicial_login.LoginMedico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;
import java.util.Arrays;

import javax.swing.*;

public class EntrarLoginMedico implements ActionListener {
    private LoginMedico loginMedico;

    public EntrarLoginMedico(LoginMedico login) {
        this.loginMedico = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String email = loginMedico.getEmailField().getText();
        JPasswordField senhaField = (JPasswordField) loginMedico.getSenhaField();

        if (email.isEmpty() || senhaField.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Campos vazios",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Persistence<Usuario> medicoPersistence = new MedicoPersistence();
        List<Usuario> medicos = medicoPersistence.findAll();
        for (Usuario medico : medicos) {
            if (medico.getEmail().equals(email) && Arrays.equals(medico.getSenha(), senhaField.getPassword())) {
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!", "Login",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Usuário não encontrado ou senha incorreta", "Erro de Login",
                JOptionPane.ERROR_MESSAGE);
    }

}
