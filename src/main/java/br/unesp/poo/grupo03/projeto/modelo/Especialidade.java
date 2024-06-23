
package br.unesp.poo.grupo03.projeto.modelo;


public class Especialidade {
    boolean nutricaoClinica;
    boolean nutricaoPediatrica;
    boolean nutricaoEsportiva;

    public Especialidade() {
    }

    public Especialidade(boolean nutricaoClinica, boolean nutricaoPediatrica, boolean nutricaoEsportiva) {
        this.nutricaoClinica = nutricaoClinica;
        this.nutricaoPediatrica = nutricaoPediatrica;
        this.nutricaoEsportiva = nutricaoEsportiva;
    }

    public boolean isNutricaoClinica() {
        return nutricaoClinica;
    }

    public void setNutricaoClinica(boolean nutricaoClinica) {
        this.nutricaoClinica = nutricaoClinica;
    }

    public boolean isNutricaoPediatrica() {
        return nutricaoPediatrica;
    }

    public void setNutricaoPediatrica(boolean nutricaoPediatrica) {
        this.nutricaoPediatrica = nutricaoPediatrica;
    }

    public boolean isNutricaoEsportiva() {
        return nutricaoEsportiva;
    }

    public void setNutricaoEsportiva(boolean nutricaoEsportiva) {
        this.nutricaoEsportiva = nutricaoEsportiva;
    }
    
}
