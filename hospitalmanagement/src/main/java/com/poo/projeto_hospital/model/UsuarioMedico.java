/*
João Augusto Pilato de Castro- 202235006
Lucius Faltz Lassarote da Silva - 202235027
Luíza Machado Costa Nascimento - 202235021
*/
package com.poo.projeto_hospital.model;

public class UsuarioMedico extends Medico {
    private String email;
    private char[] senha;

    public UsuarioMedico(String email, char[] senha, String nome, String cpf, String dataNascimento,
            String cidade, String estado, String sexo, String especialidade, String inicioExpediente,
            String finalExpediente) {
        super(nome, cpf, dataNascimento, cidade, estado, sexo, especialidade, inicioExpediente, finalExpediente);
        this.email = email;
        this.senha = senha;
    }

    public String toFileString() {
        // Retorna uma string formatada para armazenar no arquivo
        return String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s", email, new String(senha), getNome(), getCpf(),
                getDataNascimento(), getEspecialidade(), getInicioExpediente(), getFinalExpediente());
    }

    public String getEmail() {
        return email;
    }

    public char[] getSenha() {
        return senha;
    }

    /*
     * public Agenda getAgenda() {
     * return agenda;
     * }
     */

    @Override
    public String toString() {
        return String.format(
                "Nome: %s\nCPF: %s\nData de Nascimento: %s\nCidade: %s\nEstado: %s\nSexo: %s\nEspecialidade: %s\nInicio do Expediente: %s\nFinal do Expediente: %s\n",
                getNome(), getCpf(), getDataNascimento(), getCidade(), getEstado(), getSexo(), getEspecialidade(),
                getInicioExpediente(), getFinalExpediente());
    }
}