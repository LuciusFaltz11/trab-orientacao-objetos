package com.poo.projeto_hospital.model;

import com.poo.projeto_hospital.exception.SenhaException;

public class Senha {
    public static void isValidSenha(char[] senha) throws SenhaException {
        if (senha.length < 8) {
            throw new SenhaException();
        }
    }

}
