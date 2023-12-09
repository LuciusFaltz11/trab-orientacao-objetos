package com.poo.projeto_hospital.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.poo.projeto_hospital.Consulta;
import com.poo.projeto_hospital.controller.GerenciarConsultas;


public class Laudo extends JFrame {


    private Consulta consulta;
    private JFrame frame;
    private JTextArea textArea;
    
    public Laudo(Consulta consulta) {
        this.consulta = consulta;
        Tela();
    }

    public void Tela () {
         // 1. Create JFrame
        frame = new JFrame("Laudo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 2. Set JFrame layout
        frame.setLayout(new BorderLayout());

        // 3. Create JPanel
        JPanel panel = new JPanel();

        // 4. Set JPanel layout
        panel.setLayout(new GridLayout(0, 1, 0, 2));
        // 5. Create JLabel
        JLabel title = new JLabel("Laudo da consulta");
        title.setFont(new Font("Arial", Font.ITALIC, 24));
        panel.add(title);
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBackground(Color.cyan);

        JButton btnSave = new JButton("Salvar");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // consulta.setLaudo(getText());
            }
        });

        panel.add(btnSave);

        JPanel panel2 = new JPanel();

        // 6. Create JTextArea
        textArea = new JTextArea(20, 40);

        textArea.setBorder(BorderFactory.createLoweredSoftBevelBorder());

        // 7. Create JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);

        // 8. Add JScrollPane to JPanel
        panel2.add(scrollPane);

        // 9. Add JPanel to JFrame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.SOUTH);

        // 10. Set JFrame size
        frame.setSize(500, 500);

        // 11. Make JFrame visible
        frame.setVisible(true);

    }

    public void setText(String text) {
        textArea.setText(text);
    }

    public String getText() {
        return textArea.getText();
    }

    public static void main(String[] args) {
        Laudo laudo = new Laudo(null);
        
    }


}
