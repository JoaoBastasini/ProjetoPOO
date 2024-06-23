package br.unesp.poo.grupo03.projeto.modelo;

public class Objetivo {
    private boolean ganharPeso;
    private boolean perderPeso;

    public Objetivo() {
    }
    
    public Objetivo(boolean ganharPeso, boolean perderPeso) {
        this.ganharPeso = ganharPeso;
        this.perderPeso = perderPeso;
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
}
