package com.poo.projeto_hospital.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

import com.poo.projeto_hospital.model.Medico;
import com.poo.projeto_hospital.persistence.MedicoPersistence;
import com.poo.projeto_hospital.persistence.Persistence;
import com.poo.projeto_hospital.view.paginaInicial_login.LoginMedico;

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

        Persistence<Medico> medicoPersistence = new MedicoPersistence();
        List<Medico> medicos = medicoPersistence.findAll();
        for (Medico medico : medicos) {
            if (medico.getEmail().equals(email) && Arrays.equals(medico.getSenha(), senha)) {
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!", "Login",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            } else if (medico.getEmail().equals(email) && !Arrays.equals(medico.getSenha(), senha)) {
                JOptionPane.showMessageDialog(null, "Senha incorreta.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Médico não cadastrado.", "Erro",
                JOptionPane.ERROR_MESSAGE);
    }

}
