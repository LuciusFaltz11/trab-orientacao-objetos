package com.poo.projeto_hospital;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Secretaria {
    public static void agendarConsulta(Paciente paciente, Medico medico, Date horario) {
        // Verificar a disponibilidade do médico antes de agendar
        if (verificarDisponibilidade(medico, horario)) {
            Consulta consulta = new Consulta(paciente, medico, horario);
            medico.getAgenda().adicionarConsulta(consulta);
            paciente.adicionarConsulta(consulta);
            System.out.println("Consulta agendada com sucesso!");
        } else {
            System.out.println("Médico não disponível neste horário. Escolha outro horário ou médico.");
        }
    }

    public static void listarConsultasMedico(Medico medico) {
        List<Consulta> consultas = medico.getAgenda().getConsultas();
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada para este médico.");
        } else {
            System.out.println("Consultas agendadas para o médico " + medico.getNome() + ":");
            for (Consulta consulta : consultas) {
                System.out.println("Paciente: " + consulta.getPaciente().getNome() +
                        " | Data e Hora: " + consulta.getHorario());
            }
        }
    }

    private static boolean verificarDisponibilidade(Medico medico, Date horario) {
        List<Consulta> consultas = medico.getAgenda().getConsultas();
        for (Consulta consulta : consultas) {
            // Verificar se o horário está ocupado
            if (consulta.getHorario().equals(horario)) {
                return false; // Horário ocupado
            }
        }
        return true; // Horário disponível
    }
}
