/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.poo.grupo03.modelo;

/**
 *
 * @author cauan
 */
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
