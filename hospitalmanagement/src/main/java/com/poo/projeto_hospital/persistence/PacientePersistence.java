package com.poo.projeto_hospital.persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.poo.projeto_hospital.model.Usuario;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PacientePersistence implements Persistence<Usuario> {
    private static final String PATH = DIRECTORY + File.separator + "pacientes.json";

    @Override
    public void save(List<Usuario> itens) {
        Gson gson = new Gson();
        String json = gson.toJson(itens);

        File diretorio = new File(DIRECTORY);
        if (!diretorio.exists())
            diretorio.mkdirs();

        Arquivo.salva(PATH, json);

    }

    @Override
    public List<Usuario> findAll() {
        Gson gson = new Gson();

        String json = Arquivo.le(PATH);

        List<Usuario> pacientes = new ArrayList<>();
        if (!json.trim().equals("")) {

            Type tipoLista = new TypeToken<List<Usuario>>() {
            }.getType();
            pacientes = gson.fromJson(json, tipoLista);

            if (pacientes == null)
                pacientes = new ArrayList<>();
        }

        return pacientes;
    }

    public Usuario findByCpf(String cpf) {
        List<Usuario> pacientes = findAll();
        Usuario paciente = null;

        for (Usuario p : pacientes) {
            if (p.getCpf().equals(cpf)) {
                paciente = p;
                break;
            }
        }
        return paciente;
    }

}
