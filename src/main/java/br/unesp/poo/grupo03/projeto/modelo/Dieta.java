package br.unesp.poo.grupo03.projeto.modelo;

import java.util.Date;
import java.util.List;

public class Dieta {
    private Paciente paciente;
    private Date dtInicio;
    private List<Refeicao> refeicoesDiarias;

    public Dieta() {
    }

    public Dieta(Paciente paciente, Nutricionista nutricionista, Date dtInicio, List<Refeicao> refeicoesDiarias) {
        this.paciente = paciente;
        this.dtInicio = dtInicio;
        this.refeicoesDiarias = refeicoesDiarias;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public List<Refeicao> getRefeicoesDiarias() {
        return refeicoesDiarias;
    }

    public void setRefeicoesDiarias(List<Refeicao> refeicoesDiarias) {
        this.refeicoesDiarias = refeicoesDiarias;
    }
    
}
