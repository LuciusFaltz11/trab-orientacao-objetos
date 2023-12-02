package com.poo.projeto_hospital.persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.poo.projeto_hospital.model.Paciente;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PacientePersistence implements Persistence<Paciente> {
    private static final String PATH = DIRECTORY+ File.separator +"pacientes.json";

    @Override
    public void save(List<Paciente> itens) {
        Gson gson = new Gson();
        String json = gson.toJson(itens);

        File diretorio = new File(DIRECTORY);
        if(!diretorio.exists())
            diretorio.mkdirs();

        Arquivo.salva(PATH, json);


    }

    @Override
    public List<Paciente> findAll() {
        Gson gson = new Gson();

        String json = Arquivo.le(PATH);

        List<Paciente> pacientes = new ArrayList<>();
        if(!json.trim().equals("")) {

            Type tipoLista = new TypeToken<List<Paciente>>() {
            }.getType();
            pacientes = gson.fromJson(json, tipoLista);

            if (pacientes == null)
                pacientes = new ArrayList<>();
        }

        return pacientes;
    }
}
