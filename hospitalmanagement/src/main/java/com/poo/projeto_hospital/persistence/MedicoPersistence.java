package com.poo.projeto_hospital.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.poo.projeto_hospital.model.Medico;

import java.lang.reflect.Type;

public class MedicoPersistence implements Persistence<Medico> {
    private static final String PATH = DIRECTORY + File.separator + "medicos.json";

    @Override
    public List<Medico> findAll() {
        List<Medico> medicos = new ArrayList<>();

        try {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader(PATH));

            Type typeOfT = new TypeToken<ArrayList<Medico>>() {
            }.getType();
            medicos = gson.fromJson(br, typeOfT);
        } catch (IOException e) {
            System.out.println("Erro ao ler os médicos: " + e.getMessage());
        }

        return medicos;
    }

    @Override
    public void save(List<Medico> itens) {
    }

}
