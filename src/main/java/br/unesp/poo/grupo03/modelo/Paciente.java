package br.unesp.poo.grupo03.modelo;

public class Paciente extends Pessoa {
    private float peso;
    private int idade;
    private float alturaMetros;
    private float imc;
    private String cpf;
    private Objetivo objetivo;

    public Paciente() {
    }

    public Paciente(float peso, int idade, float alturaMetros, float imc, String cpf, Objetivo objetivo, String nome, String email) {
        super(nome, email);
        this.peso = peso;
        this.idade = idade;
        this.alturaMetros = alturaMetros;
        this.imc = imc;
        this.cpf = cpf;
        this.objetivo = objetivo;
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

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    
}
