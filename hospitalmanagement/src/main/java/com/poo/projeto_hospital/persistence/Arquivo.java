package com.poo.projeto_hospital.persistence;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {
    public static void salvarDados(String dados) {
        try {
            File file = new File("dados.txt");
            FileWriter writer = new FileWriter(file);
            writer.write(dados);
            writer.close();
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }
}
