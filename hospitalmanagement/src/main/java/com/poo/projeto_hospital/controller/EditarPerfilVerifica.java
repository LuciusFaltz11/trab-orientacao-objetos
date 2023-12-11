/*
João Augusto Pilato de Castro- 202235006
Lucius Faltz Lassarote da Silva - 202235027
Luíza Machado Costa Nascimento - 202235021
*/
package com.poo.projeto_hospital.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.poo.projeto_hospital.exception.EmailException;
import com.poo.projeto_hospital.exception.SenhaException;
import com.poo.projeto_hospital.model.Email;
import com.poo.projeto_hospital.model.Senha;
import com.poo.projeto_hospital.model.Usuario;
import com.poo.projeto_hospital.persistence.PacientePersistence;
import com.poo.projeto_hospital.view.perfilPaciente.AreaPaciente;
import com.poo.projeto_hospital.view.perfilPaciente.EditarPerfil;

public class EditarPerfilVerifica implements ActionListener {
    private EditarPerfil alteraPerfil;

    public EditarPerfilVerifica(EditarPerfil editarPerfil) {
        this.alteraPerfil = editarPerfil;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cidade = alteraPerfil.getCidadeTextField().getText();
        String estado = alteraPerfil.getEstadoTextField().getText();
        String sexo = alteraPerfil.getGenderTextField().getText();
        String email = alteraPerfil.getEmailTextField().getText();
        char[] senha = alteraPerfil.getSenhaTextField().getPassword();

        try {
            email = Email.isValidEmail(email);
            Senha.isValidSenha(senha);
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

        // trocar as informações do paciente e salvar no paciente

        PacientePersistence pacientePersistence = new PacientePersistence();
        Usuario paciente = pacientePersistence.findByCpf(alteraPerfil.getPaciente().getCpf());
        paciente.setCidade(cidade);
        paciente.setEmail(email);
        paciente.setSenha(senha);
        paciente.setSexo(sexo);

        pacientePersistence.alterarDados(paciente);

        JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Alteração de dados",
                JOptionPane.INFORMATION_MESSAGE);
        alteraPerfil.getFrame().dispose();
        new AreaPaciente(alteraPerfil.getPaciente()).createAndShowGUI();

    }

}
