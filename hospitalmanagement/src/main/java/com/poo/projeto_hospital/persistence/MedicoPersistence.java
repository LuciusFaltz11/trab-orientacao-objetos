package com.poo.projeto_hospital.persistence;

import com.google.gson.Gson;
import com.poo.projeto_hospital.model.UsuarioMedico;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedicoPersistence implements Persistence<UsuarioMedico> {
    private static final String PATH = DIRECTORY + File.separator + "medicos.json";

    @Override
    public void save(List<UsuarioMedico> itens) {
        Gson gson = new Gson();
        String json = gson.toJson(itens);

        File diretorio = new File(DIRECTORY);
        if (!diretorio.exists())
            diretorio.mkdirs();

        Arquivo.salva(PATH, json);
    }

    @Override
    public List<UsuarioMedico> findAll() {
        // Cria uma instância do Gson
        Gson gson = new Gson();

        List<UsuarioMedico> medicos = new ArrayList<>();
        try {
            // Lê o arquivo JSON como uma string
            String json = new String(Files.readAllBytes(Paths.get(PATH)));

            // Converte a string JSON em uma lista de UsuarioMedico
            UsuarioMedico[] medicoArray = gson.fromJson(json, UsuarioMedico[].class);
            medicos = Arrays.asList(medicoArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return medicos;
    }
}
