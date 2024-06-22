package br.unesp.poo.grupo03.modelo;

public class Paciente {
    private String nome;
    private float peso;
    private int idade;
    private float alturaMetros;
    private float IMC;
    private Objetivo objetivo;

    public Paciente() {
    }

    public Paciente(String nome, float peso, int idade, float alturaMetros, float IMC, Objetivo objetivo) {
        this.nome = nome;
        this.peso = peso;
        this.idade = idade;
        this.alturaMetros = alturaMetros;
        this.IMC = IMC;
        this.objetivo = objetivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAlturaMetros() {
        return alturaMetros;
    }

    public void setAlturaMetros(float alturaMetros) {
        this.alturaMetros = alturaMetros;
    }

    public float getIMC() {
        return IMC;
    }

    public void setIMC(float IMC) {
        this.IMC = IMC;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }
    
    
}
