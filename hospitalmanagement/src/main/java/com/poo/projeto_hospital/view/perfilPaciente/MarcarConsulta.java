package com.poo.projeto_hospital.view.perfilPaciente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import com.poo.projeto_hospital.model.ItemComboBox;
import com.poo.projeto_hospital.model.Usuario;
import com.poo.projeto_hospital.model.UsuarioMedico;
import com.poo.projeto_hospital.persistence.MedicoPersistence;

public class MarcarConsulta extends PadraoPerfilPaciente {
    protected Usuario paciente;

    public MarcarConsulta(Usuario paciente) {
        this.paciente = paciente;
    }

    public void createAndShowGUI() {
        JFrame frame = criarFrame("Perfil do paciente");

        createToolbar(frame);
        criarTitulo(frame, "Marcar Consulta");
        createEspecialidadeComboBox(frame);

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
                if(itemSelecionado.getValue() == null){
                    return;
                }
                UsuarioMedico medicoSelecionado = medicoPersistence.findByCpf(itemSelecionado.getValue());
                createHoraioComboBox(panelHorario, medicoSelecionado, framePrincipal);
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

    private void createHoraioComboBox(JPanel panel, UsuarioMedico medico, final JFrame framePrincipal){
        JLabel label = new JLabel("Selecione o horário desejado");
        label.setMaximumSize(new Dimension(250, 20));

        final JComboBox<String> comboBox = new JComboBox<>(medico.getHorarios().toArray(new String[0]));

        comboBox.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String horarioSelecionado = (String) comboBox.getSelectedItem();
               if (horarioSelecionado == null) {
                   return;
               }
               System.out.println("Horario selecionado: " + horarioSelecionado);
               JButton botaoMarcarConsulta = criarBotaoMarcarConsulta();
               JPanel panel = new JPanel();
               panel.setLayout(new FlowLayout(FlowLayout.CENTER));
               panel.add(botaoMarcarConsulta);
               framePrincipal.add(panel);
               framePrincipal.revalidate();
               framePrincipal.repaint();
           }
        });

        comboBox.setMaximumSize(new Dimension(250, 30));

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        System.out.println("Inserindo coisas no panel do horario");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(comboBox);
    }

    private static JButton criarBotaoMarcarConsulta() {
        JButton botao = new JButton("Marcar Consulta");

        // Adiciona um ActionListener ao botão para tratar o evento de clique
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica a ser executada quando o botão for clicado
                System.out.println("Botão 'Marcar Consulta' clicado!");
            }
        });

        return botao;
    }

}
