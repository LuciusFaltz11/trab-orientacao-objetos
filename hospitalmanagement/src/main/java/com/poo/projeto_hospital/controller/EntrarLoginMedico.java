/*
João Augusto Pilato de Castro- 202235006
Lucius Faltz Lassarote da Silva - 202235027
Luíza Machado Costa Nascimento - 202235021
*/
package com.poo.projeto_hospital.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

import com.poo.projeto_hospital.model.UsuarioMedico;
import com.poo.projeto_hospital.persistence.MedicoPersistence;
import com.poo.projeto_hospital.persistence.Persistence;
import com.poo.projeto_hospital.view.TelaAgenda;
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

        Persistence<UsuarioMedico> medicoPersistence = new MedicoPersistence();
        List<UsuarioMedico> medicos = medicoPersistence.findAll();
        for (UsuarioMedico medico : medicos) {
            if (medico.getEmail().equals(email) && Arrays.equals(medico.getSenha(), senha)) {
                // JOptionPane.showMessageDialog(null, "Login realizado com sucesso!", "Login",
                // JOptionPane.INFORMATION_MESSAGE);
                loginMedico.getFrame().dispose();
                String CPF = medico.getCpf();
                TelaAgenda telaAgenda = new TelaAgenda(CPF);
                telaAgenda.desenha();
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
