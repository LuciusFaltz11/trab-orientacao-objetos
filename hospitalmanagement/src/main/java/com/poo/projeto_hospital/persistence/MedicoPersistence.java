package com.poo.projeto_hospital.persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.poo.projeto_hospital.model.Medico;
import com.poo.projeto_hospital.model.Usuario;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MedicoPersistence implements Persistence<Medico> {
    private static final String PATH = DIRECTORY + File.separator + "medicos.json";

    @Override
    public void save(List<Medico> itens) {
        Gson gson = new Gson();
        String json = gson.toJson(itens);

        File diretorio = new File(DIRECTORY);
        if (!diretorio.exists())
            diretorio.mkdirs();

        Arquivo.salva(PATH, json);

    }

    @Override
    public List<Medico> findAll() {
        Gson gson = new Gson();

        String json = Arquivo.le(PATH);

        List<Medico> medicos = new ArrayList<>();
        if (!json.trim().equals("")) {

            Type tipoLista = new TypeToken<List<Medico>>() {
            }.getType();
            medicos = gson.fromJson(json, tipoLista);

            if (medicos == null) {
                medicos = new ArrayList<>();
            }
        } else
            System.out.println("nao foi possivel ler o arquivo");

        return medicos;
    }
}