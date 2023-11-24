package com.poo.projeto_hospital;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Medico medico = new Medico("Dr. João", "21111623708", LocalDate.of(1980, 1, 1), "Cardiologia", "8:00", "18:00");

        // Criar um paciente
        Paciente paciente = new Paciente("Maria", "21111623708", LocalDate.of(1990, 5, 15), "Paciente com dor de barriga");

        // Criar duas consultas para o paciente com o médico
        LocalDate dataConsulta1 = LocalDate.of(2023, 1, 15);
        LocalDate dataConsulta2 = LocalDate.of(2023, 2, 1);

        Consulta consulta1 = new Consulta(paciente, medico, dataConsulta1, "13:00", 30);
        Consulta consulta2 = new Consulta(paciente, medico, dataConsulta2, "15:30", 15);

        // Adicionar as consultas à agenda do médico e ao histórico do paciente
        medico.getAgenda().adicionarConsulta(consulta1);
        medico.getAgenda().adicionarConsulta(consulta2);
        paciente.adicionarConsulta(consulta1);
        paciente.adicionarConsulta(consulta2);

        // Listar as consultas do médico
        System.out.println("Consultas do Médico " + medico.getNome() + ":");
        Secretaria.listarConsultasMedico(medico);

        // Listar as consultas do paciente
        System.out.println("\nConsultas do Paciente " + paciente.getNome() + ":");
        Secretaria.listarConsultasPaciente(paciente);
    }
}
