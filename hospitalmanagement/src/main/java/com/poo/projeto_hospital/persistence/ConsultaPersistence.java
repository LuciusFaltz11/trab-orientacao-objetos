package com.poo.projeto_hospital.persistence;

import java.awt.Window.Type;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.poo.projeto_hospital.Consulta;
import com.google.gson.reflect.TypeToken;

public class ConsultaPersistence implements Persistence<Consulta> {
    private static final String PATH = DIRECTORY + File.separator + "consultas.json";

    @Override
    public void save(List<Consulta> itens) {
        Gson gson = new Gson();
        String json = gson.toJson(itens);

        File diretorio = new File(DIRECTORY);
        if (!diretorio.exists())
            diretorio.mkdirs();

        Arquivo.salva(PATH, json);
    }

    @Override

    public List<Consulta> findAll() {
        Gson gson = new Gson();

        String json = Arquivo.le(PATH);

        List<Consulta> consultas = new ArrayList<>();
        if (!json.trim().equals("")) {
            java.lang.reflect.Type tipoLista = new TypeToken<List<Consulta>>() {
            }.getType();
            consultas = gson.fromJson(json, tipoLista);

            if (consultas == null)
                consultas = new ArrayList<>();
        }

        return consultas;
    }

    public List<Consulta> findByPaciente(String cpf) {
        List<Consulta> consultas = findAll();
        List<Consulta> consultasPaciente = new ArrayList<>();

        for (Consulta consulta : consultas) {
            if (consulta.getPaciente().getCpf().equals(cpf)) {
                consultasPaciente.add(consulta);
            }
        }

        return consultasPaciente;
    }

    public List<Consulta> findByMedico(String cpf) {
        List<Consulta> consultas = findAll();
        List<Consulta> consultasMedico = new ArrayList<>();

        for (Consulta consulta : consultas) {
            if (consulta.getMedico().getCpf().equals(cpf)) {
                consultasMedico.add(consulta);
            }
        }

        return consultasMedico;
    }

    // funcao para salvar a consulta
    public void save(Consulta consulta) {
        List<Consulta> consultas = findAll();
        consultas.add(consulta);
        save(consultas);
    }
}
