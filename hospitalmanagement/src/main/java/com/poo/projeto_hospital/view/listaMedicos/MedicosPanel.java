package com.poo.projeto_hospital.view.listaMedicos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.poo.projeto_hospital.model.Medico;
import com.poo.projeto_hospital.persistence.Arquivo;

import javax.swing.*;
import java.awt.*;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.poo.projeto_hospital.persistence.Persistence.DIRECTORY;

public class MedicosPanel extends JPanel {
    private JList<Medico> medicosList;

    public JScrollPane ListaMedicosPanel() {
        // Configuração do layout e da JList
        setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(medicosList);
        add(scrollPane, BorderLayout.CENTER);
        medicosList = new JList<>();

        // Atualiza a lista de médicos
        atualizarListaMedicos();
        scrollPane.setViewportView(medicosList);
        return scrollPane;
    }

    private void atualizarListaMedicos() {
        List<Medico> medicos = obterListaMedicos();
        System.out.println(medicos.size());
        medicosList.setListData(medicos.toArray(new Medico[0]));
    }

    private List<Medico> obterListaMedicos() {
        final String PATH = DIRECTORY + File.separator + "medicos.json";
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
        }
        return medicos;
    }

    private List<Medico> filtrarMedicosPorEspecialidade(List<Medico> medicos, String especialidade) {
        List<Medico> medicosFiltrados = new ArrayList<>();
        for (Medico medico : medicos) {
            if (medico != null) {
                if (medico.getEspecialidade().equalsIgnoreCase(especialidade)) {
                    medicosFiltrados.add(medico);
                }
            }
        }
        return medicosFiltrados;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lista de Médicos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        MedicosPanel panel = new MedicosPanel();
        frame.add(panel.ListaMedicosPanel());

        frame.setVisible(true);

    }
}
