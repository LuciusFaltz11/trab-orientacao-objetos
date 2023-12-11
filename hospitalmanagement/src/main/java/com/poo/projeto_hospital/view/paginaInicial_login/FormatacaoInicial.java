/*
João Augusto Pilato de Castro- 202235006
Lucius Faltz Lassarote da Silva - 202235027
Luíza Machado Costa Nascimento - 202235021
*/
package com.poo.projeto_hospital.view.paginaInicial_login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FormatacaoInicial {
    protected static void criarTitulo(JFrame frame, String titulo) {
        JPanel tituloPanel = new JPanel();
        tituloPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        tituloPanel.setPreferredSize(new Dimension(768, 50));

        JLabel tituloLabel = new JLabel(titulo);
        tituloLabel.setFont(tituloLabel.getFont().deriveFont(20.0f));
        tituloPanel.add(tituloLabel);

        frame.getContentPane().add(tituloPanel, BorderLayout.PAGE_START);
    }

    protected static void criaPainelImagem(JFrame frame, String caminhoImagem) {

        JPanel iconePanel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        iconePanel.setLayout(layout);
        iconePanel.setPreferredSize(new Dimension(768, 110));

        ImageIcon imageIcon = new ImageIcon(caminhoImagem);
        JLabel jLabel = new JLabel(imageIcon);
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setVerticalAlignment(JLabel.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weighty = 1;

        iconePanel.add(jLabel, gbc);
        frame.getContentPane().add(iconePanel, BorderLayout.NORTH);
    }

    protected void criaFormularioLogin(JFrame frame, JTextField emailField, JPasswordField senhaField) {
        JPanel formularioPanel = new JPanel();
        formularioPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel emaiLabel = new JLabel("Email");
        JLabel senhaLabel = new JLabel("Senha");

        adicionarLabel(formularioPanel, emaiLabel, gbc);
        adicionarInput(formularioPanel, emailField, gbc);
        adicionarLabel(formularioPanel, senhaLabel, gbc);
        adicionarSenha(formularioPanel, senhaField, gbc);

        formularioPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.getContentPane().add(formularioPanel, BorderLayout.SOUTH);

    }

    private void adicionarLabel(JPanel panel, JLabel label, GridBagConstraints gbc) {
        panel.add(label, gbc);
    }

    private void adicionarInput(JPanel panel, JTextField input, GridBagConstraints gbc) {
        panel.add(input, gbc);
    }

    private void adicionarSenha(JPanel panel, JPasswordField senha, GridBagConstraints gbc) {
        panel.add(senha, gbc);
    }
}
