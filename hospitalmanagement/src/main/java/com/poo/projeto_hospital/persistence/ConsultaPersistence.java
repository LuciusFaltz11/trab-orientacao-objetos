package com.poo.projeto_hospital.persistence;

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
        cpf = cpf.replaceAll("[^0-9]", "");
        for (Consulta consulta : consultas) {
            String cpfPaciente = consulta.getCpfPaciente().replaceAll("[^0-9]", "");
            if (cpfPaciente.equals(cpf)) {
                consultasPaciente.add(consulta);
            }
        }

        return consultasPaciente;
    }

    public List<Consulta> findByMedico(String cpf) {
        List<Consulta> consultas = findAll();
        List<Consulta> consultasMedico = new ArrayList<>();
        cpf = cpf.replaceAll("[^0-9]", "");
        for (Consulta consulta : consultas) {
            String cpfMedico = consulta.getCpfMedico().replaceAll("[^0-9]", "");
            if (cpfMedico.equals(cpf)) {
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

    public List<Integer> getConsultaIds() {
        List<Consulta> consultas = findAll();
        List<Integer> consultaIds = new ArrayList<>();

        for (Consulta consulta : consultas) {
            // Adicione o ID da consulta à lista (assumindo que o ID é uma propriedade chamada "id" na classe Consulta)
            consultaIds.add(consulta.getId());  // Substitua "getId()" pelo método que retorna o ID da sua consulta
        }

        return consultaIds;
    }

    public boolean removeById(int id) {
        List<Consulta> consultas = findAll();
        for (Consulta consulta : consultas) {
            if (consulta.getId() == id) {
                consultas.remove(consulta);
                save(consultas);
                return true;
            }
        }
        return false;
    }

}
