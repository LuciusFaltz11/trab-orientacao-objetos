package com.poo.projeto_hospital.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.poo.projeto_hospital.Consulta;
import com.poo.projeto_hospital.model.Data;
import com.poo.projeto_hospital.model.Horario;
import com.poo.projeto_hospital.persistence.ConsultaPersistence;
import com.poo.projeto_hospital.persistence.Persistence;
import com.poo.projeto_hospital.view.TelaAgenda;

public class GerenciarConsultas implements WindowListener {
    private final TelaAgenda tela;

    public GerenciarConsultas(TelaAgenda tela) {
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {

        Persistence<Consulta> consultaPersistence = new ConsultaPersistence();
        List<Consulta> all = consultaPersistence.findAll();
        Collections.sort(all, new Comparator<Consulta>() {
            @Override
            public int compare(Consulta o1, Consulta o2) {
                int i = Data.compara(o1.getData(), o2.getData());
                if (i == 0) {
                    return Horario.compara(o1.getHorario(), o2.getHorario());
                }

                return i;
            }
        });
        tela.carregaConsultas(all);

    }

    @Override
    public void windowClosing(WindowEvent e) {
        Persistence<Consulta> ConsultaPersistence = new ConsultaPersistence();
        ConsultaPersistence.save(tela.listaConsultas());
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
