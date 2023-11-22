package com.poo.projeto_hospital;

import java.time.LocalDateTime;
import java.util.Date;

public class Consulta {
    private Paciente paciente;
    private Medico medico;
    private Date horario;

    public Consulta(Paciente paciente, Medico medico, Date horario) {
        this.paciente = paciente;
        this.medico = medico;
        this.horario = horario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public Date getHorario() {
        return horario;
    }
}
