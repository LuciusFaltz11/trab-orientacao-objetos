package com.poo.projeto_hospital.view.perfilPaciente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.*;

import com.poo.projeto_hospital.controller.RetornarAreaPaciente;
import com.poo.projeto_hospital.model.ItemComboBox;
import com.poo.projeto_hospital.model.Usuario;
import com.poo.projeto_hospital.model.UsuarioMedico;
import com.poo.projeto_hospital.persistence.ConsultaPersistence;
import com.poo.projeto_hospital.persistence.MedicoPersistence;
import com.poo.projeto_hospital.view.TelaAgenda;

public class MarcarConsulta extends PadraoPerfilPaciente {
    protected static Usuario paciente;
    private static String medicoSelecionado;
    private static String horarioSelecionado;
    private static JTextField dataNascimentoField;
    private static JTextField descricaoField;

    public MarcarConsulta(Usuario paciente) {
        this.paciente = paciente;
    }

    public static void setHorarioSelecionado(String horarioSelecionado) {
        MarcarConsulta.horarioSelecionado = horarioSelecionado;
    }


    public static void setMedicoSelecionado(String medicoSelecionado) {
        MarcarConsulta.medicoSelecionado = medicoSelecionado;
    }

    public void createAndShowGUI() {
        JFrame frame = criarFrame("Perfil do paciente");

        createToolbar(frame, paciente);
        criarTitulo(frame, "Marcar Consulta");
        createEspecialidadeComboBox(frame);
        renderBackButton(frame);
        frame.setVisible(true);
    }


    private void createEspecialidadeComboBox(final JFrame frame){
        List<String> especialidades;
        final JPanel panelMedico = new JPanel();
        final JPanel panelHorario = new JPanel();
        panelMedico.setLayout(new FlowLayout(FlowLayout.CENTER));

        final MedicoPersistence medicoPersistence = new MedicoPersistence();
        especialidades = medicoPersistence.listaEspecialidades();
        especialidades.add(0, "Selecione");

        JLabel label = new JLabel("Selecione a área desejada");
        label.setMaximumSize(new Dimension(250, 20));

        final JComboBox<String> comboBox = new JComboBox<>(especialidades.toArray(new String[0]));
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String especialidadeSelecionada = (String) comboBox.getSelectedItem();
                if(especialidadeSelecionada == null){
                    return;
                }
                List<UsuarioMedico> medicos = medicoPersistence.filterMedicoByEspecialidade(especialidadeSelecionada);
                panelMedico.removeAll();
                createMedicoComboBox(panelMedico, medicos, frame, panelHorario);
                frame.revalidate();
                frame.repaint();
            }
        });
        comboBox.setMaximumSize(new Dimension(250, 30));

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Adiciona um espaço entre a label e o comboBox
        panel.add(comboBox);

        // Adicionar o JPanel ao JFrame
        frame.add(panel);
        frame.add(panelMedico);
        frame.add(panelHorario);
    }

    private void createMedicoComboBox(final JPanel panel, List<UsuarioMedico> medicos, final JFrame framePrincipal, final JPanel panelHorario){
        final MedicoPersistence medicoPersistence = new MedicoPersistence();
        JLabel label = new JLabel("Selecione o médico desejado");
        label.setMaximumSize(new Dimension(250, 20));

        final JComboBox<ItemComboBox> comboBox = new JComboBox<>(criarModeloMedico(medicos));
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemComboBox itemSelecionado = (ItemComboBox) comboBox.getSelectedItem();
                assert itemSelecionado != null;
                if(itemSelecionado.getValue() == null){
                    return;
                }
                setMedicoSelecionado(itemSelecionado.getValue());
                UsuarioMedico medicoSelecionado = medicoPersistence.findByCpf(itemSelecionado.getValue());
                createHorarioDataAndDescriptionFields(panelHorario, medicoSelecionado, framePrincipal);
                framePrincipal.revalidate();
                framePrincipal.repaint();
            }
        });
        comboBox.setMaximumSize(new Dimension(250, 30));

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        System.out.println("Inserindo coisas no panel do medico");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Adiciona um espaço entre a label e o comboBox
        panel.add(comboBox);
    }

    private static DefaultComboBoxModel<ItemComboBox> criarModeloMedico(List<UsuarioMedico> medicos) {
        List<ItemComboBox> listaItens = new ArrayList<>();
        listaItens.add(new ItemComboBox("Selecione", null));
        for(UsuarioMedico medico : medicos){
            listaItens.add(new ItemComboBox(medico.getNome(), medico.getCpf()));
        }
        return new DefaultComboBoxModel<>(listaItens.toArray(new ItemComboBox[0]));
    }

    private void createHorarioDataAndDescriptionFields(JPanel panel, UsuarioMedico medico, final JFrame framePrincipal){
        JLabel labelHorario = new JLabel("Selecione o horário desejado");
        labelHorario.setMaximumSize(new Dimension(250, 20));
        final JComboBox<String> comboBoxHorario = new JComboBox<>(medico.getHorarios().toArray(new String[0]));
        comboBoxHorario.setMaximumSize(new Dimension(250, 30));

        JLabel labelData = new JLabel("Informe a data desejada (DD/MM/YYYY):");
        labelData.setMaximumSize(new Dimension(250, 20));
        dataNascimentoField = new JTextField();
        dataNascimentoField.setMaximumSize(new Dimension(250, 30));

        JLabel labelDescricao = new JLabel("Descreva seu problema:");
        labelDescricao.setMaximumSize(new Dimension(250, 20));
        descricaoField = new JTextField();
        descricaoField.setMaximumSize(new Dimension(250, 30));

        comboBoxHorario.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String horarioSelecionado = (String) comboBoxHorario.getSelectedItem();
               if (horarioSelecionado == null) {
                   return;
               }
               setHorarioSelecionado(horarioSelecionado);
               JButton botaoMarcarConsulta = criarBotaoMarcarConsulta(framePrincipal);
               JPanel panel = new JPanel();
               panel.setLayout(new FlowLayout(FlowLayout.CENTER));
               panel.add(botaoMarcarConsulta);
               framePrincipal.add(panel);
               framePrincipal.revalidate();
               framePrincipal.repaint();
           }
        });

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        labelData.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataNascimentoField.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelHorario.setAlignmentX(Component.CENTER_ALIGNMENT);
        comboBoxHorario.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelDescricao.setAlignmentX(Component.CENTER_ALIGNMENT);
        descricaoField.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelDescricao);
        panel.add(descricaoField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(labelData);
        panel.add(dataNascimentoField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(labelHorario);
        panel.add(comboBoxHorario);
    }

    private static JButton criarBotaoMarcarConsulta(final JFrame framePrincipal) {
        JButton botao = new JButton("Marcar Consulta");

        // Adiciona um ActionListener ao botão para tratar o evento de clique
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica a ser executada quando o botão for clicado
                marcarConsulta(framePrincipal);
            }
        });

        return botao;
    }

    public static boolean validarData(String dataString) {
        // Define o formato esperado da data
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);

        try {
            Date data = formato.parse(dataString);
            return true; // Se conseguir, a data é válida
        } catch (ParseException e) {
            return false;
        }
    }

    private static void marcarConsulta(final JFrame framePrincipal) {
        if(!validarData(dataNascimentoField.getText())){
            JOptionPane.showMessageDialog(null, "Data inválida", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        TelaAgenda tela = new TelaAgenda(medicoSelecionado);
        try{
            ConsultaPersistence consultaPersistence = new ConsultaPersistence();
            List<Integer> ids = consultaPersistence.getConsultaIds();
            int id = 0;
            if(!ids.isEmpty()){
                id = ids.get(ids.size() - 1) + 1;
            }

            tela.addConsulta(id, paciente.getCpf(), medicoSelecionado, dataNascimentoField.getText(), horarioSelecionado, "60", descricaoField.getText());
            JOptionPane.showMessageDialog(null, "Colsulta marcada com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            framePrincipal.dispose();
            new AreaPaciente(paciente).createAndShowGUI();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao marcar consulta", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao marcar consulta");
            System.out.println(e.getMessage());
        }
    }

    private void renderBackButton(final JFrame frame){
        JPanel botaoPanel = new JPanel();
        botaoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        botaoPanel.setPreferredSize(new Dimension(500, 50));
        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new RetornarAreaPaciente(paciente, frame));
        botaoPanel.add(voltarButton);
        frame.getContentPane().add(botaoPanel, BorderLayout.PAGE_END);
    }
}
