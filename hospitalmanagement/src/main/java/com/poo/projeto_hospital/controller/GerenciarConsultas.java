package com.poo.projeto_hospital.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import com.poo.projeto_hospital.Consulta;
import com.poo.projeto_hospital.persistence.ConsultaPersistence;
import com.poo.projeto_hospital.persistence.Persistence;
import com.poo.projeto_hospital.view.TelaAgenda;

public class GerenciarConsultas implements WindowListener{
    private final TelaAgenda tela;

    public GerenciarConsultas(TelaAgenda tela) {
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
         
        Persistence<Consulta> contatoPersistence = new ConsultaPersistence();
        List<Consulta> all = contatoPersistence.findAll();
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
