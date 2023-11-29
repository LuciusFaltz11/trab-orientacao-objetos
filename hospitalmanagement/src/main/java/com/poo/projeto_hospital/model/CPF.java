package com.poo.projeto_hospital.model;

import com.poo.projeto_hospital.exception.CPFException;

public class CPF {
    private String cpf;

    public static boolean parser(String cpf) throws Exception {

        // Verificar se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            throw new CPFException();
        }

        // Verificar se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            throw new CPFException();
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
            throw new CPFException();
        }

        // Calcular o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        resto = soma % 11;
        int digitoVerificador2 = (resto < 2) ? 0 : (11 - resto);

        if (digitoVerificador2 != Character.getNumericValue(cpf.charAt(10))) {
            throw new CPFException();
        }

        return true;
    }

}
