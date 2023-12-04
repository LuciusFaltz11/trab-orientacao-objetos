package com.poo.projeto_hospital.persistence;

import com.poo.projeto_hospital.model.Usuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Arquivo {

    private static final String NOME_ARQUIVO = "hospitalmanagement/src/main/java/com/poo/projeto_hospital/infoFile/usuarios.txt";

    public static boolean emailJaRegistrado(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length > 0 && partes[0].equals(email)) {
                    // O email já está registrado
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao verificar o email: " + e.getMessage());
        }
        // O email não está registrado
        return false;
    }

    public static void salvarUsuario(Usuario usuario) {
        if (emailJaRegistrado(usuario.getEmail())) {
            JOptionPane.showMessageDialog(null, "Email já cadastrado!", "Cadastro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(NOME_ARQUIVO, false))) {
            // Adiciona as informações do usuário ao arquivo
            writer.println(usuario.toFileString());
            JOptionPane.showMessageDialog(null, "Usuário cadastrado!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o usuário: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error", "Cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String le(String filePath) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }

        return content.toString();
    }

    public static void salva(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
