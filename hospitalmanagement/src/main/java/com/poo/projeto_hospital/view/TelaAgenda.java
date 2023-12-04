package com.poo.projeto_hospital.view;

import javax.swing.*;

import com.poo.projeto_hospital.Consulta;
import com.poo.projeto_hospital.Medico;
import com.poo.projeto_hospital.controller.AdicionarConsulta;
import com.poo.projeto_hospital.controller.EditarConsulta;
import com.poo.projeto_hospital.controller.GerenciarConsultas;
import com.poo.projeto_hospital.controller.RemoverConsulta;
import com.poo.projeto_hospital.controller.SelecionarConsulta;
import com.poo.projeto_hospital.exception.CPFException;
import com.poo.projeto_hospital.exception.DataException;
import com.poo.projeto_hospital.exception.EmailException;
import com.poo.projeto_hospital.model.Email;
import com.poo.projeto_hospital.model.Paciente;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TelaAgenda {
    private final int WIDTH = 1000;
    private final int HEIGHT = 500;
    private final int V_GAP = 10;
    private final int H_GAP = 5;

    private Medico medico;
    private JFrame tela;

    private JTextField tfNome;
    private JTextField tfCpf;
    private JTextField tfDatadeNascimento;
    private JTextField tfCidade;
    private JTextField tfEstado;
    private JTextField tfSexo;
    private JTextField tfData;
    private JTextField tfHorario;
    private JTextField tfDuracao;
    private JTextField tfDescricao;

    private JList<Consulta> listConsultas;

    public TelaAgenda(Medico medico) {
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
        painelLabel.setLayout(new GridLayout(0, 1, H_GAP, V_GAP));
        painelLabel.add(new JLabel("Nome"));
        painelLabel.add(new JLabel("CPF"));
        painelLabel.add(new JLabel("Data de Nascimento"));
        painelLabel.add(new JLabel("Cidade"));
        painelLabel.add(new JLabel("Estado"));
        painelLabel.add(new JLabel("Sexo"));
        painelLabel.add(new JLabel("Data"));
        painelLabel.add(new JLabel("Horario"));
        painelLabel.add(new JLabel("Duracao"));
        painelLabel.add(new JLabel("Descricao"));

        JPanel painelField = new JPanel();
        painelField.setLayout(new GridLayout(0, 1, H_GAP, 6));
        tfNome = new JTextField(20);
        tfCpf = new JTextField(20);
        tfDatadeNascimento = new JTextField(20);
        tfCidade = new JTextField(20);
        tfEstado = new JTextField(20);
        tfSexo = new JTextField(20);
        tfData = new JTextField(20);
        tfHorario = new JTextField(20);
        tfDuracao = new JTextField(20);
        tfDescricao = new JTextField(20);

        painelField.add(tfNome);
        painelField.add(tfCpf);
        painelField.add(tfDatadeNascimento);
        painelField.add(tfCidade);
        painelField.add(tfEstado);
        painelField.add(tfSexo);
        painelField.add(tfData);
        painelField.add(tfHorario);
        painelField.add(tfDuracao);
        painelField.add(tfDescricao);

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
            tfDuracao.setText(String.valueOf(consulta.getDuracaoMinutos()));
            tfDescricao.setText(consulta.getDescricao());

        }

    }

    public void addConsulta() {

        DefaultListModel<Consulta> model = (DefaultListModel<Consulta>) listConsultas.getModel();
        Consulta novaConsulta = new Consulta(
                new Paciente(tfNome.getText(), tfCpf.getText(), tfDatadeNascimento.getText(),
                        tfCidade.getText(), tfEstado.getText(), tfSexo.getText()),
                tfData.getText(), tfHorario.getText(),
                Integer.parseInt(tfDuracao.getText()), tfDescricao.getText());

        // Convertendo para ArrayList para poder inserir em um índice específico
        ArrayList<Consulta> lista = Collections.list(model.elements());

        int dd = Integer.parseInt(novaConsulta.getData().substring(0, 2));
        int mm = Integer.parseInt(novaConsulta.getData().substring(3, 5));
        int aa = Integer.parseInt(novaConsulta.getData().substring(6));
        int hh = Integer.parseInt(novaConsulta.getHorario().replaceAll("[\\D]", ""));

        // Encontrando o índice correto para a nova Consulta
        int index = 0;
        for (Consulta consulta : lista) {
            int dia = Integer.parseInt(consulta.getData().substring(0, 2));
            int mes = Integer.parseInt(consulta.getData().substring(3, 5));
            int ano = Integer.parseInt(consulta.getData().substring(6));
            int horario = Integer.parseInt(consulta.getHorario().replaceAll("[\\D]", ""));
            if (aa < ano) {
                break;
            } else if (aa == ano) {
                if (mm < mes) {
                    break;
                } else if (mm == mes) {
                    if (dd < dia) {
                        break;
                    } else if (dd == dia) {
                        if (hh < horario) {
                            break;
                        }
                    }
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
            consulta.setDuracaoMinutos(Integer.parseInt(tfDuracao.getText()));
            consulta.setDescricao(tfDescricao.getText());

            ArrayList<Consulta> lista = Collections.list(model.elements());

            int dd = Integer.parseInt(consulta.getData().substring(0, 2));
            int mm = Integer.parseInt(consulta.getData().substring(3, 5));
            int aa = Integer.parseInt(consulta.getData().substring(6));
            int hh = Integer.parseInt(consulta.getHorario().replaceAll("[\\D]", ""));

            int index = 0;
            for (Consulta i : lista) {
                int dia = Integer.parseInt(i.getData().substring(0, 2));
                int mes = Integer.parseInt(i.getData().substring(3, 5));
                int ano = Integer.parseInt(i.getData().substring(6));
                int horario = Integer.parseInt(i.getHorario().replaceAll("[\\D]", ""));
                if (aa < ano) {
                    break;
                } else if (aa == ano) {
                    if (mm < mes) {
                        break;
                    } else if (mm == mes) {
                        if (dd < dia) {
                            break;
                        } else if (dd == dia) {
                            if (hh < horario) {
                                break;
                            }
                        }
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
