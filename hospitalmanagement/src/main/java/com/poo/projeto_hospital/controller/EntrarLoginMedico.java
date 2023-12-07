package com.poo.projeto_hospital.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.poo.projeto_hospital.model.Medico;
import com.poo.projeto_hospital.persistence.MedicoPersistence;
import com.poo.projeto_hospital.persistence.Persistence;
import com.poo.projeto_hospital.view.listaMedicos.MedicosPanel;
import com.poo.projeto_hospital.view.paginaInicial_login.LoginMedico;
import java.lang.reflect.Field;

public class EntrarLoginMedico implements ActionListener {
    private LoginMedico loginMedico;

    public EntrarLoginMedico(LoginMedico loginMedico) {
        this.loginMedico = loginMedico;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String email = loginMedico.getEmailField().getText();
        char[] senha = loginMedico.getSenhaField().getPassword();

        if (email.isEmpty() || senha.length == 0) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Campos vazios",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // decidir entre usurioMedico e medico
        Persistence<Medico> medicoPersistence = new MedicoPersistence();
        List<Medico> medicos = medicoPersistence.findAll();
        for (Medico usuarioMedico : medicos) {
            if (usuarioMedico.getEmail().equals(email) && Arrays.equals(usuarioMedico.getSenha(), senha)) {
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!", "Login",
                        JOptionPane.INFORMATION_MESSAGE);
                // Medico novo = usuarioMedico;
                // novo.getAgenda();
                return;
            } else if (usuarioMedico.getEmail().equals(email) && !Arrays.equals(usuarioMedico.getSenha(), senha)) {
                JOptionPane.showMessageDialog(null, "Senha incorreta.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Médico não cadastrado.", "Erro",
                JOptionPane.ERROR_MESSAGE);
    }

}
