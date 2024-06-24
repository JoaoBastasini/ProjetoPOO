package br.unesp.poo.grupo03.projeto.modelo;

public class Prato {
    private String nomePrato;
    private int caloriasRefeicao;
    private int pesoGramas;


    public Prato(String nomePrato, int caloriasRefeicao, int pesoGramas){
        this.nomePrato = nomePrato;
        this.caloriasRefeicao = caloriasRefeicao;
        this.pesoGramas = pesoGramas;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public int getCaloriasRefeicao() {
        return caloriasRefeicao;
    }

    public void setCaloriasRefeicao(int caloriasRefeicao) {
        this.caloriasRefeicao = caloriasRefeicao;
    }

    public int getPesoGramas() {
        return pesoGramas;
    }

    public void setPesoGramas(int pesoGramas) {
        this.pesoGramas = pesoGramas;
    }

    @Override
    public String toString() {
        return "Prato{" +
                "nomePrato='" + nomePrato + '\'' +
                ", caloriasRefeicao=" + caloriasRefeicao +
                ", pesoGramas=" + pesoGramas +
                '}';
    }
}
