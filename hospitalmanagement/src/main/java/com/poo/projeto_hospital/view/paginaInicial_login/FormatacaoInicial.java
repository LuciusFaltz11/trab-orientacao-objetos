package com.poo.projeto_hospital.view.paginaInicial_login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

}
