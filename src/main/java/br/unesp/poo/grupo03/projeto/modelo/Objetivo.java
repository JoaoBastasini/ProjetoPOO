package br.unesp.poo.grupo03.projeto.modelo;

public class Objetivo {

    private boolean ganharPeso;
    private boolean perderPeso;
    private boolean manutencaoPeso;

    public Objetivo() {
    }

    public Objetivo(boolean ganharPeso, boolean perderPeso, boolean manutencaoPeso) {
        this.ganharPeso = ganharPeso;
        this.perderPeso = perderPeso;
        this.manutencaoPeso = manutencaoPeso;
    }

    public boolean isGanharPeso() {
        return ganharPeso;
    }

    public void setGanharPeso(boolean ganharPeso) {
        this.ganharPeso = ganharPeso;
    }

    public boolean isPerderPeso() {
        return perderPeso;
    }

    public void setPerderPeso(boolean perderPeso) {
        this.perderPeso = perderPeso;
    }

    public boolean isManutencaoPeso() {
        return manutencaoPeso;
    }

    public void setManutencaoPeso(boolean manutencaoPeso) {
        this.manutencaoPeso = manutencaoPeso;
    }

}
