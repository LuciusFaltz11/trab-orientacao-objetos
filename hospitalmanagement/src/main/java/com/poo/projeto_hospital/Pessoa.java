package com.poo.projeto_hospital;

import java.time.LocalDate;

public class Pessoa {
    private final String nome;
    private final String cpf;
    private final LocalDate dataNascimento;

    public Pessoa(String nome, String cpf, LocalDate dataNascimento) {
        if(verificaCpf(cpf)){
            System.out.println("Insira um CPF valido!");
        }
        if(validaDataDeNascimento(dataNascimento)){
            System.out.println("Insira um CPF valido!");
        }
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    private boolean verificaCpf(String cpf){
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verificar se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verificar se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcular o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int resto = soma % 11;
        int digitoVerificador1 = (resto < 2) ? 0 : (11 - resto);

        // Verificar o primeiro dígito verificador
        if (digitoVerificador1 != Character.getNumericValue(cpf.charAt(9))) {
            return false;
        }

        // Calcular o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        resto = soma % 11;
        int digitoVerificador2 = (resto < 2) ? 0 : (11 - resto);

        // Verificar o segundo dígito verificador
        return (digitoVerificador2 == Character.getNumericValue(cpf.charAt(10)));
    }


    private boolean validaDataDeNascimento(LocalDate dataNascimento){
        LocalDate dataAtual = LocalDate.now();
        return dataNascimento.isBefore(dataAtual);
    }
}