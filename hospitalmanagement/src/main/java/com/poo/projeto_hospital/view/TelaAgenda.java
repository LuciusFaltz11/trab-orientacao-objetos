/*
João Augusto Pilato de Castro- 202235006
Lucius Faltz Lassarote da Silva - 202235027
Luíza Machado Costa Nascimento - 202235021
*/
package com.poo.projeto_hospital.view;

import javax.swing.*;

import com.poo.projeto_hospital.controller.AdicionarConsulta;
import com.poo.projeto_hospital.controller.EditarConsulta;
import com.poo.projeto_hospital.controller.GerenciarConsultas;
import com.poo.projeto_hospital.controller.RemoverConsulta;
import com.poo.projeto_hospital.controller.SelecionarConsulta;
import com.poo.projeto_hospital.exception.DataException;
import com.poo.projeto_hospital.exception.HorarioException;
import com.poo.projeto_hospital.model.Consulta;
import com.poo.projeto_hospital.model.Data;
import com.poo.projeto_hospital.model.Horario;
import com.poo.projeto_hospital.persistence.ConsultaPersistence;
import com.poo.projeto_hospital.persistence.Persistence;
import com.poo.projeto_hospital.view.paginaInicial_login.Login;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAgenda {
    private final int WIDTH = 1000;
    private final int HEIGHT = 500;
    private final int V_GAP = 10;
    private final int H_GAP = 5;

    private String cpfMedico;
    private JFrame tela;

    private JTextField tfNome;
    private JTextField tfCpf;
    private JTextField tfDatadeNascimento;
    private JTextField tfCidade;
    private JTextField tfEstado;
    private JTextField tfSexo;
    private JTextField tfData;
    private JTextField tfHorario;
    private JTextField tfDescricao;

    private JList<Consulta> listConsultas;

    public TelaAgenda(String cpfMedico) {
        this.cpfMedico = cpfMedico;
        DefaultListModel<Consulta> model = new DefaultListModel<>();
        listConsultas = new JList<>(model);

    }

    public void desenha() {

        tela = new JFrame("Agenda");
        tela.addWindowListener(new GerenciarConsultas(this));
        tela.setSize(WIDTH, HEIGHT);
        tela.setLocationRelativeTo(null);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());

        desenhaLista();
        desenhaFormulario();

        tela.pack();
    }

    private void desenhaLista() {

        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder("Consultas"));
        painel.setPreferredSize(new Dimension((2 * WIDTH) / 3, HEIGHT));
        painel.setLayout(new BorderLayout());

        listConsultas.addListSelectionListener(new SelecionarConsulta(this));

        painel.add(new JScrollPane(listConsultas), BorderLayout.CENTER);

        tela.getContentPane().add(painel, BorderLayout.WEST);
    }

    private void desenhaFormulario() {

        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder("Formulário"));

        JPanel formulario = new JPanel();
        JPanel painelLabel = new JPanel();
        painelLabel.setLayout(new GridLayout(0, 1, H_GAP, 15));
        painelLabel.add(new JLabel("Nome"));
        painelLabel.add(new JLabel("CPF"));
        painelLabel.add(new JLabel("Data de Nascimento"));
        painelLabel.add(new JLabel("Cidade"));
        painelLabel.add(new JLabel("Estado"));
        painelLabel.add(new JLabel("Sexo"));
        painelLabel.add(new JLabel("Data"));
        painelLabel.add(new JLabel("Horario"));
        painelLabel.add(new JLabel("Laudo"));

        JPanel painelField = new JPanel();
        painelField.setLayout(new GridLayout(0, 1, H_GAP, 11));
        tfNome = new JTextField(20);
        tfNome.setEditable(false);
        tfCpf = new JTextField(20);
        tfCpf.setEditable(false);
        tfDatadeNascimento = new JTextField(20);
        tfDatadeNascimento.setEditable(false);
        tfCidade = new JTextField(20);
        tfCidade.setEditable(false);

        // ...

        tfEstado = new JTextField(20);
        tfEstado.setEditable(false);
        tfSexo = new JTextField(20);
        tfSexo.setEditable(false);
        tfData = new JTextField(20);
        tfHorario = new JTextField(20);

        tfDescricao = new JTextField(20);

        painelField.add(tfNome);
        painelField.add(tfCpf);
        painelField.add(tfDatadeNascimento);
        painelField.add(tfCidade);
        painelField.add(tfEstado);
        painelField.add(tfSexo);
        painelField.add(tfData);
        painelField.add(tfHorario);
        painelField.add(tfDescricao);

        formulario.add(painelLabel);
        formulario.add(painelField);

        painel.setLayout(new BorderLayout());
        painel.add(formulario, BorderLayout.CENTER);

        JButton btnLaudo = new JButton("Salvar Laudo");
        btnLaudo.addActionListener(new EditarConsulta(this));

        JButton btnRemover = new JButton("Desmarcar");
        btnRemover.addActionListener(new RemoverConsulta(this));

        JButton btnEditar = new JButton("Remarcar");
        btnEditar.addActionListener(new EditarConsulta(this));

        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela.dispose();
                Login login = new Login();
                login.createAndShowGUI();
            }
        });
        JPanel botoes = new JPanel();
        // botoes.add(btnLaudo);
        botoes.add(btnRemover);
        botoes.add(btnEditar);
        botoes.add(btnLaudo);
        botoes.add(btnSair);

        painel.add(botoes, BorderLayout.SOUTH);

        tela.getContentPane().add(painel, BorderLayout.CENTER);

    }

    public void carregaConsultas(List<Consulta> consultas) {

        DefaultListModel<Consulta> model = (DefaultListModel<Consulta>) listConsultas.getModel();

        for (Consulta c : consultas) {
            model.addElement(c);
        }

    }

    public List<Consulta> listaConsultas() {
        DefaultListModel<Consulta> model = (DefaultListModel<Consulta>) listConsultas.getModel();
        List<Consulta> consultas = new ArrayList<>();

        for (int i = 0; i < model.size(); i++) {
            consultas.add(model.get(i));
        }

        return consultas;
    }

    public void atualizarFormulario() {
        int selectedIndex = listConsultas.getSelectedIndex();

        if (selectedIndex != -1) {

            DefaultListModel<Consulta> model = (DefaultListModel<Consulta>) listConsultas.getModel();
            Consulta consulta = model.get(selectedIndex);
            tfNome.setText(consulta.getPacienteNome());
            tfCpf.setText(consulta.getCpfPaciente());
            tfDatadeNascimento.setText(consulta.getPacienteDataNascimento());
            tfCidade.setText(consulta.getPacienteCidade());
            tfEstado.setText(consulta.getPacienteEstado());
            tfSexo.setText(consulta.getPacienteSexo());
            tfData.setText(consulta.getData().toString());
            tfHorario.setText(consulta.getHorario().toString());
            tfDescricao.setText(consulta.getDescricao());

        }

    }

    public void addConsulta(int id, String cpfP, String cpfM, String data, String horario, String descricao)
            throws DataException {

        DefaultListModel<Consulta> model = (DefaultListModel<Consulta>) listConsultas.getModel();
        Consulta novaConsulta = null;

        try {
            novaConsulta = new Consulta(id, cpfP, cpfM, Data.isValidData(data), Horario.isValidHorario(horario),
                    60, descricao);
        } catch (DataException e) {
            throw new DataException();
        } catch (HorarioException e) {
            throw new HorarioException();
        }

        Persistence<Consulta> consultaPersistence = new ConsultaPersistence();
        List<Consulta> consultas = consultaPersistence.findAll();

        for (Consulta c : consultas) {
            if (Data.compara(c.getData(), novaConsulta.getData()) == 0
                    && c.getCpfMedico().equals(novaConsulta.getCpfMedico())) {
                if (Horario.compara(c.getHorario(), novaConsulta.getHorario()) == 0) {
                    JOptionPane.showMessageDialog(null, "Horario indisponivel");
                    return;
                } else if (Horario.compara(novaConsulta.getHorario(), c.getHorario()) >= 0 && Horario
                        .compara(novaConsulta.getHorario(), Horario.soma(c.getHorario(), c.getDuracaoMinutos())) < 0) {
                    JOptionPane.showMessageDialog(null, "Horario indisponivel");
                    return;
                }
            }
        }

        consultas.add(novaConsulta);

        consultaPersistence.save(consultas);

    }

    public void removerConsulta() {

        int selectedIndex = listConsultas.getSelectedIndex();

        if (selectedIndex != -1) {

            DefaultListModel<Consulta> model = (DefaultListModel<Consulta>) listConsultas.getModel();
            model.remove(selectedIndex);
        }
    }

    public void editarConsulta() {

        int selectedIndex = listConsultas.getSelectedIndex();

        if (selectedIndex != -1) {

            DefaultListModel<Consulta> model = (DefaultListModel<Consulta>) listConsultas.getModel();

            Consulta consulta = model.get(selectedIndex);

            model.remove(selectedIndex);

            consulta.setCPFmedico(cpfMedico);
            consulta.setCPFpaciente(tfCpf.getText());
            consulta.setData(tfData.getText());
            consulta.setHorario(tfHorario.getText());
            consulta.setDuracaoMinutos(60);
            consulta.setDescricao(tfDescricao.getText());

            ArrayList<Consulta> lista = Collections.list(model.elements());

            int index = 0;
            try {

                for (Consulta i : lista) {
                    if (Data.compara(i.getData(), consulta.getData()) > 0) {
                        break;
                    }
                    if (Data.compara(i.getData(), consulta.getData()) == 0) {
                        if (Horario.compara(i.getHorario(), consulta.getHorario()) > 0) {
                            break;
                        }
                    }
                    index++;
                }
            } catch (HorarioException e) {
                return;
            }

            lista.add(index, consulta);

            DefaultListModel<Consulta> novoModelo = new DefaultListModel<>();
            for (Consulta i : lista) {
                novoModelo.addElement(i);
            }

            // Definindo o novo modelo como o modelo da lista
            listConsultas.setModel(novoModelo);

            ConsultaPersistence consultaPersistence = new ConsultaPersistence();
            List<Consulta> consultas = consultaPersistence.findAll();

            consultaPersistence.removeById(consulta.getId());
            consultaPersistence.save(consulta);

            // consultaPersistence.save(consultas);

        }

        tela.pack();

    }

    public String getCpfMedico() {
        return cpfMedico;
    }

}
