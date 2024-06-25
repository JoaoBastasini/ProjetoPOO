package br.unesp.poo.grupo03.projeto.modelo;

import java.util.List;

public class Dieta {
    private Paciente paciente;
    private List<Refeicao> refeicoesDiarias;

    public Dieta() {
    }

    public Dieta(Paciente paciente, List<Refeicao> refeicoesDiarias) {
        this.paciente = paciente;
        this.refeicoesDiarias = refeicoesDiarias;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Refeicao> getRefeicoesDiarias() {
        return refeicoesDiarias;
    }

    public void setRefeicoesDiarias(List<Refeicao> refeicoesDiarias) {
        this.refeicoesDiarias = refeicoesDiarias;
    }
    
}
