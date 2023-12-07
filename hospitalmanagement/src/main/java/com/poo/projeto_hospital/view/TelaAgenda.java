package com.poo.projeto_hospital.view;

import javax.swing.*;

import com.poo.projeto_hospital.Consulta;
import com.poo.projeto_hospital.model.Medico;
import com.poo.projeto_hospital.controller.AdicionarConsulta;
import com.poo.projeto_hospital.controller.EditarConsulta;
import com.poo.projeto_hospital.controller.GerenciarConsultas;
import com.poo.projeto_hospital.controller.RemoverConsulta;
import com.poo.projeto_hospital.controller.SelecionarConsulta;
import com.poo.projeto_hospital.exception.CPFException;
import com.poo.projeto_hospital.exception.DataException;
import com.poo.projeto_hospital.exception.EmailException;
import com.poo.projeto_hospital.model.CPF;
import com.poo.projeto_hospital.model.Data;
import com.poo.projeto_hospital.model.Email;
import com.poo.projeto_hospital.model.Horario;
import com.poo.projeto_hospital.model.Paciente;
import com.poo.projeto_hospital.model.UsuarioMedico;

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

    private UsuarioMedico medico;
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
    private JRadioButton opcao1;
    private JRadioButton opcao2;
    private JRadioButton opcao3;
    private String tfDuracao;

    private JList<Consulta> listConsultas;

    public TelaAgenda(UsuarioMedico medico) {
        this.medico = medico;
    }

    public void desenha() {

        tela = new JFrame(medico.getNome() + " - Agenda");
        tela.addWindowListener(new GerenciarConsultas(this));
        tela.setSize(WIDTH, HEIGHT);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        DefaultListModel<Consulta> model = new DefaultListModel<>();

        listConsultas = new JList<>(model);
        listConsultas.addListSelectionListener(new SelecionarConsulta(this));

        painel.add(new JScrollPane(listConsultas), BorderLayout.CENTER);

        tela.getContentPane().add(painel, BorderLayout.WEST);
    }

    private void desenhaFormulario() {

        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder("Formulário"));

        JPanel formulario = new JPanel();
        JPanel painelLabel = new JPanel();
        painelLabel.setLayout(new GridLayout(0, 1, H_GAP, 25));
        painelLabel.add(new JLabel("Nome"));
        painelLabel.add(new JLabel("CPF"));
        painelLabel.add(new JLabel("Data de Nascimento"));
        painelLabel.add(new JLabel("Cidade"));
        painelLabel.add(new JLabel("Estado"));
        painelLabel.add(new JLabel("Sexo"));
        painelLabel.add(new JLabel("Data"));
        painelLabel.add(new JLabel("Horario"));
        painelLabel.add(new JLabel("Descricao"));
        painelLabel.add(new JLabel("Duracao"));

        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel painelField = new JPanel();
        painelField.setLayout(new GridLayout(0, 1, H_GAP, 6));
        tfNome = new JTextField(20);
        tfCpf = new JTextField(20);
        tfDatadeNascimento = new JTextField(20);
        tfCidade = new JTextField(20);

        // ...

        tfEstado = new JTextField(20);
        tfSexo = new JTextField(20);
        tfData = new JTextField(20);
        tfHorario = new JTextField(20);
        opcao1 = new JRadioButton("30 minutos");
        opcao1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tfDuracao = "30";
            }
        });
        opcao2 = new JRadioButton("60 minutos");
        opcao2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tfDuracao = "60";
            }
        });
        opcao3 = new JRadioButton("120 minutos");
        opcao3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tfDuracao = "120";
            }
        });
        tfDescricao = new JTextField(20);

        ButtonGroup group = new ButtonGroup();
        group.add(opcao1);
        group.add(opcao2);
        group.add(opcao3);

        radioPanel.add(opcao1);
        radioPanel.add(opcao2);
        radioPanel.add(opcao3);

        painelField.add(tfNome);
        painelField.add(tfCpf);
        painelField.add(tfDatadeNascimento);
        painelField.add(tfCidade);
        painelField.add(tfEstado);
        painelField.add(tfSexo);
        painelField.add(tfData);
        painelField.add(tfHorario);
        painelField.add(tfDescricao);
        painelField.add(radioPanel);

        formulario.add(painelLabel);
        formulario.add(painelField);

        painel.setLayout(new BorderLayout());
        painel.add(formulario, BorderLayout.CENTER);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(new AdicionarConsulta(this));

        JButton btnRemover = new JButton("Remover");
        btnRemover.addActionListener(new RemoverConsulta(this));

        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(new EditarConsulta(this));

        JPanel botoes = new JPanel();
        botoes.add(btnAdicionar);
        botoes.add(btnRemover);
        botoes.add(btnEditar);

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
            tfNome.setText(consulta.getPaciente().getNome());
            tfCpf.setText(consulta.getPaciente().getCpf());
            tfDatadeNascimento.setText(consulta.getPaciente().getDataNascimento());
            tfCidade.setText(consulta.getPaciente().getCidade());
            tfEstado.setText(consulta.getPaciente().getEstado());
            tfSexo.setText(consulta.getPaciente().getSexo());
            tfData.setText(consulta.getData().toString());
            tfHorario.setText(consulta.getHorario().toString());
            tfDescricao.setText(consulta.getDescricao());

            String duracao = String.valueOf(consulta.getDuracaoMinutos());
            duracao += " minutos";
            if (opcao1.getText().equals(duracao)) {
                opcao1.setSelected(true);
            } else if (opcao2.getText().equals(duracao)) {
                opcao2.setSelected(true);
            } else if (opcao3.getText().equals(duracao)) {
                opcao3.setSelected(true);
            }

        }

    }

    public void addConsulta() {

        DefaultListModel<Consulta> model = (DefaultListModel<Consulta>) listConsultas.getModel();
        Consulta novaConsulta = null;
        try {
            novaConsulta = new Consulta(
                    new Paciente(tfNome.getText(), CPF.parser(tfCpf.getText()),
                            Data.isValidData(tfDatadeNascimento.getText()),
                            tfCidade.getText(), tfEstado.getText(), tfSexo.getText()),
                    Data.isValidData(tfData.getText()), tfHorario.getText(),
                    Integer.parseInt(tfDuracao),medico, tfDescricao.getText());
        } catch (CPFException e) {
            // Handle the CPFException here
        } catch (DataException e) {

        }

        // Convertendo para ArrayList para poder inserir em um índice específico
        ArrayList<Consulta> lista = Collections.list(model.elements());

        // Encontrando o índice correto para a nova Consulta
        int index = 0;
        for (Consulta consulta : lista) {
            if (Data.compara(consulta.getData(), novaConsulta.getData()) > 0) {
                break;
            }
            if (Data.compara(consulta.getData(), novaConsulta.getData()) == 0) {
                if (Horario.compara(consulta.getHorario(), novaConsulta.getHorario()) > 0) {
                    break;
                }
            }
            index++;
        }

        // Inserindo a nova Consulta no índice correto
        lista.add(index, novaConsulta);

        // Criando um novo modelo e adicionando os elementos
        DefaultListModel<Consulta> novoModelo = new DefaultListModel<>();
        for (Consulta consulta : lista) {
            novoModelo.addElement(consulta);
        }

        // Definindo o novo modelo como o modelo da lista
        listConsultas.setModel(novoModelo);

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

            consulta.getPaciente().setNome(tfNome.getText());
            consulta.getPaciente().setCpf(tfCpf.getText());
            consulta.getPaciente().setDataNascimento(tfDatadeNascimento.getText());
            consulta.getPaciente().setCidade(tfCidade.getText());
            consulta.getPaciente().setEstado(tfEstado.getText());
            consulta.getPaciente().setSexo(tfSexo.getText());
            consulta.setData(tfData.getText());
            consulta.setHorario(tfHorario.getText());
            consulta.setDuracaoMinutos(Integer.parseInt(tfDuracao));
            consulta.setDescricao(tfDescricao.getText());

            ArrayList<Consulta> lista = Collections.list(model.elements());

            int index = 0;
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

            lista.add(index, consulta);

            DefaultListModel<Consulta> novoModelo = new DefaultListModel<>();
            for (Consulta i : lista) {
                novoModelo.addElement(i);
            }

            // Definindo o novo modelo como o modelo da lista
            listConsultas.setModel(novoModelo);

        }

        tela.pack();

    }

}
