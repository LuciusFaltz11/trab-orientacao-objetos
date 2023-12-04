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
import java.util.List;

public class TelaAgenda {
    private final int WIDTH = 1000;
    private final int HEIGHT = 500;
    private final int V_GAP = 10;
    private final int H_GAP = 5;

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

    private JList<Consulta> listConsultas;

    public void desenha() {

        tela = new JFrame("Agenda");
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

        JPanel painelField = new JPanel();
        painelField.setLayout(new GridLayout(0, 1, H_GAP, V_GAP));
        tfNome = new JTextField(20);
        tfCpf = new JTextField(20);
        tfDatadeNascimento = new JTextField(20);
        tfCidade = new JTextField(20);
        tfEstado = new JTextField(20);
        tfSexo = new JTextField(20);
        tfData = new JTextField(20);
        tfHorario = new JTextField(20);
        tfDuracao = new JTextField(20);

        painelField.add(tfNome);
        painelField.add(tfCpf);
        painelField.add(tfDatadeNascimento);
        painelField.add(tfCidade);
        painelField.add(tfEstado);
        painelField.add(tfSexo);
        painelField.add(tfData);
        painelField.add(tfHorario);
        painelField.add(tfDuracao);

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

        }

    }

    public void addContato() {

        DefaultListModel<Consulta> model = (DefaultListModel<Consulta>) listConsultas.getModel();
       
            model.addElement(new Consulta(new Paciente(tfNome.getText(), tfCpf.getText(), tfDatadeNascimento.getText(),
                    tfCidade.getText(), tfEstado.getText(), tfSexo.getText()), tfData.getText(), tfHorario.getText(),
                    Integer.parseInt(tfDuracao.getText())));
        
}

    public void removerConsulta(){

        int selectedIndex = listConsultas.getSelectedIndex();

        if(selectedIndex != -1){

            DefaultListModel<Consulta> model = (DefaultListModel<Consulta>)listConsultas.getModel();
            model.remove(selectedIndex);
        }
    }

    public void editarConsulta(){

        int selectedIndex = listConsultas.getSelectedIndex();

        if(selectedIndex != -1){

            DefaultListModel<Consulta> model = (DefaultListModel<Consulta>)listConsultas.getModel();

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
                
                model.add(selectedIndex, consulta);
            
        }


        tela.pack();

    }

}
