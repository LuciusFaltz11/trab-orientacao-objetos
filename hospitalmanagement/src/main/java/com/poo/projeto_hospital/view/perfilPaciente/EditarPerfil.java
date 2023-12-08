package com.poo.projeto_hospital.view.perfilPaciente;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.poo.projeto_hospital.controller.EditarPerfilVerifica;
import com.poo.projeto_hospital.model.Usuario;

public class EditarPerfil extends PadraoPerfilPaciente {
    Usuario paciente;
    JTextField genderTextField;
    JTextField cidadeTextField;
    JTextField estadoTextField;
    JTextField emailTextField;
    JPasswordField senhaTextField;
    JFrame frame;

    public EditarPerfil(Usuario paciente) {
        this.paciente = paciente;
    }

    public void createAndShowGUI() {
        frame = criarFrame("Dados pessoais");

        createToolbar(frame);
        criarTitulo(frame, "Editar Perfil");
        alterarDados(frame);
        criarBotoes(frame);

        frame.setVisible(true);
    }

    private void alterarDados(JFrame frame) {
        JPanel dadosPanel = new JPanel();

        // Create a JLabel and JTextField for each user data
        JLabel nameLabel = new JLabel("Nome:");
        JTextField nameTextField = new JTextField(paciente.getNome());
        nameTextField.setPreferredSize(new Dimension(50, 20)); // Decrease the size of the text field
        nameTextField.setEditable(false); // Set the text field as non-editable
        dadosPanel.add(nameLabel);
        dadosPanel.add(nameTextField);

        JLabel ageLabel = new JLabel("Data de Nascimento:");
        JTextField ageTextField = new JTextField(paciente.getDataNascimento());
        ageTextField.setPreferredSize(new Dimension(150, 20)); // Decrease the size of the text field
        ageTextField.setEditable(false); // Set the text field as non-editable
        dadosPanel.add(ageLabel);
        dadosPanel.add(ageTextField);

        JLabel genderLabel = new JLabel("Sexo(F/M):");
        genderTextField = new JTextField(paciente.getSexo());
        genderTextField.setPreferredSize(new Dimension(100, 20)); // Decrease the size of the text field
        dadosPanel.add(genderLabel);
        dadosPanel.add(genderTextField);

        JLabel cpfLabel = new JLabel("CPF:");
        JTextField cpfTextField = new JTextField(paciente.getCpf());
        cpfTextField.setEditable(false); // Set the text field as non-editable
        dadosPanel.add(cpfLabel);
        dadosPanel.add(cpfTextField);

        JLabel cidadeLabel = new JLabel("Cidade:");
        cidadeTextField = new JTextField(paciente.getCidade());
        dadosPanel.add(cidadeLabel);
        dadosPanel.add(cidadeTextField);

        JLabel estadoLabel = new JLabel("Estado:");
        estadoTextField = new JTextField(paciente.getEstado());
        dadosPanel.add(estadoLabel);
        dadosPanel.add(estadoTextField);

        // Add more JLabels and JTextFields for additional user data as needed

        JLabel conta = new JLabel("Dados de login");
        dadosPanel.add(conta);

        JLabel emailLabel = new JLabel("Email:");
        emailTextField = new JTextField(paciente.getEmail());
        dadosPanel.add(emailLabel);
        dadosPanel.add(emailTextField);

        JLabel senhaLabel = new JLabel("Senha(mínimo 8 caracteres):");
        senhaTextField = new JPasswordField();
        dadosPanel.add(senhaLabel);
        dadosPanel.add(senhaTextField);

        // Set the layout manager to arrange components vertically
        dadosPanel.setLayout(new BoxLayout(dadosPanel, BoxLayout.Y_AXIS));
        dadosPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        // Add the panel to the frame
        frame.add(dadosPanel);
        JScrollPane scrollPane = new JScrollPane(dadosPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the scroll pane to the frame
        frame.add(scrollPane);

        // Rest of the method code...
    }

    void criarBotoes(JFrame frame) {
        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        botoesPanel.setPreferredSize(new Dimension(500, 50));

        JButton salvarButton = new JButton("Salvar");
        JButton cancelarButton = new JButton("Cancelar");

        botoesPanel.add(salvarButton);
        botoesPanel.add(cancelarButton);

        final JFrame finalFrame = frame;

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new AreaPaciente(paciente).createAndShowGUI();
                finalFrame.dispose();
            }
        });

        salvarButton.addActionListener(new EditarPerfilVerifica(this));
        frame.add(botoesPanel);
    }

    public JTextField getCidadeTextField() {
        return cidadeTextField;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public JTextField getEstadoTextField() {
        return estadoTextField;
    }

    public JTextField getGenderTextField() {
        return genderTextField;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public JPasswordField getSenhaTextField() {
        return senhaTextField;
    }

    public JFrame getFrame() {
        return frame;
    }
}
