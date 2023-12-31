/*
João Augusto Pilato de Castro- 202235006
Lucius Faltz Lassarote da Silva - 202235027
Luíza Machado Costa Nascimento - 202235021
*/
package com.poo.projeto_hospital.controller;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import com.poo.projeto_hospital.exception.CPFException;
import com.poo.projeto_hospital.exception.DataException;
import com.poo.projeto_hospital.exception.EmailException;
import com.poo.projeto_hospital.exception.HorarioException;
import com.poo.projeto_hospital.exception.SenhaException;
import com.poo.projeto_hospital.model.CPF;
import com.poo.projeto_hospital.model.Data;
import com.poo.projeto_hospital.model.Email;
import com.poo.projeto_hospital.model.Horario;
import com.poo.projeto_hospital.model.Senha;
import com.poo.projeto_hospital.model.UsuarioMedico;
import com.poo.projeto_hospital.persistence.MedicoPersistence;
import com.poo.projeto_hospital.view.paginaInicial_login.LoginMedico;
import com.poo.projeto_hospital.view.paginaInicial_login.RegistroMedico;

public class CriarContaMedico implements ActionListener {
    private RegistroMedico registroMedico;

    public CriarContaMedico(RegistroMedico registroMedico) {
        this.registroMedico = registroMedico;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        String nome = registroMedico.getNomeField().getText();
        String cpf = registroMedico.getCpfField().getText();
        String dataNascimento = registroMedico.getDataNascimentoField().getText();
        String cidade = registroMedico.getCidadeField().getText();
        String estado = registroMedico.getEstadoField().getText();
        String sexo = registroMedico.getSexoField().getText();
        String email = registroMedico.getEmailField().getText();
        char[] senha = registroMedico.getPasswordField().getPassword();
        String inicioExpediente = registroMedico.getInicioExpedienteField().getText();
        String fimExpediente = registroMedico.getFimExpedienteField().getText();
        String especialidade = registroMedico.getEspecialidadeField().getText();

        if (nome.isEmpty() || cpf.isEmpty() || dataNascimento.isEmpty() || cidade.isEmpty()
                || estado.isEmpty() || sexo.isEmpty() || email.isEmpty() || senha.length == 0
                || inicioExpediente.isEmpty() || fimExpediente.isEmpty() || especialidade.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Campos vazios",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
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
            inicioExpediente = Horario.isValidHorario(inicioExpediente);
            fimExpediente = Horario.isValidHorario(fimExpediente);
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
        } catch (HorarioException ex) {
            ex.getMessage();
            return;
        }

        if (!sexo.equals("f") && !sexo.equals("F") && !sexo.equals("m") && !sexo.equals("M")) {
            JOptionPane.showMessageDialog(null, "Sexo inválido!", "Sexo Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        UsuarioMedico medico = new UsuarioMedico(email, senha, nome, cpf, dataNascimento, cidade, estado, sexo,
                especialidade, inicioExpediente, fimExpediente);

        try {
            armazenarMedico(medico);
        } catch (RuntimeException ex) {
            ex.getMessage();
            JOptionPane.showMessageDialog(null, "Médico já cadastrado!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null, "Conta criada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        registroMedico.getFrame().dispose();
        new LoginMedico().createAndShowGUI();
    }

    private void armazenarMedico(UsuarioMedico novo) {
        MedicoPersistence medicoPersistence = new MedicoPersistence();
        List<UsuarioMedico> medicos = medicoPersistence.modificaLista();

        if (medicoPersistence.findByCpf(novo.getCpf()) != null) {
            throw new RuntimeException("CPF já cadastrado!");
        }

        medicos.add(novo);
        medicoPersistence.save(medicos);
    }

}
