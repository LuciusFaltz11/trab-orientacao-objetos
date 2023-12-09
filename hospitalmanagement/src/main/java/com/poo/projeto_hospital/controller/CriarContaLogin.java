package com.poo.projeto_hospital.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.poo.projeto_hospital.exception.CPFException;
import com.poo.projeto_hospital.exception.DataException;
import com.poo.projeto_hospital.exception.EmailException;
import com.poo.projeto_hospital.exception.SenhaException;
import com.poo.projeto_hospital.model.*;
import com.poo.projeto_hospital.persistence.PacientePersistence;
import com.poo.projeto_hospital.persistence.Persistence;
import com.poo.projeto_hospital.view.paginaInicial_login.Login;
import com.poo.projeto_hospital.view.paginaInicial_login.RegistroPaciente;

public class CriarContaLogin implements ActionListener {
    private RegistroPaciente registroPaciente;

    public CriarContaLogin(RegistroPaciente registroPaciente) {
        this.registroPaciente = registroPaciente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = registroPaciente.getNomeField().getText();
        String cpf = registroPaciente.getCpfField().getText();
        String dataNascimento = registroPaciente.getDataNascimentoField().getText();
        String cidade = registroPaciente.getCidadeField().getText();
        String estado = registroPaciente.getEstadoField().getText();
        String sexo = registroPaciente.getSexoField().getText();
        String email = registroPaciente.getEmailField().getText();
        char[] senha = registroPaciente.getPasswordField().getPassword();

        if (nome.isEmpty() || cpf.isEmpty() || dataNascimento.isEmpty() || cidade.isEmpty()
                || estado.isEmpty() || sexo.isEmpty() || email.isEmpty() || senha.length == 0) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Campos vazios",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Validar o CPF
            cpf = CPF.parser(cpf);
            // Validar a data de nascimento
            dataNascimento = Data.isValidData(dataNascimento);
            // Validar o email
            email = Email.isValidEmail(email);
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

        Usuario usuario = new Usuario(email, senha, nome, cpf, dataNascimento, cidade, estado, sexo);

        try {
            armazenarUsuario(usuario);
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(null, "Paciente já cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // armazenarUsuario(usuario);
        JOptionPane.showMessageDialog(null, "Conta criada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        registroPaciente.getFrame().dispose();
        new Login().createAndShowGUI();
    }

    private void armazenarUsuario(Usuario novo) {
        PacientePersistence pacientePersistence = new PacientePersistence();
        List<Usuario> pacientes = pacientePersistence.findAll();

        if (pacientePersistence.findByCpf(novo.getCpf()) != null)
            throw new RuntimeException("CPF já cadastrado!");

        pacientes.add(novo);
        pacientePersistence.save(pacientes);
    }
}
