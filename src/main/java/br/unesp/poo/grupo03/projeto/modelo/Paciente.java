package br.unesp.poo.grupo03.projeto.modelo;

public class Paciente extends Pessoa {
    private float peso;
    private int idade;
    private float alturaMetros;
    private float imc; // indice de massa corporal
    private float tmb; // taxa metabolismo basal
    private String cpf;
    private Objetivo objetivo;
    private Nutricionista nutricionista;

    public Paciente() {
    }

    public Paciente(float peso, int idade, float alturaMetros, float imc, float tmb, String cpf, Objetivo objetivo, Nutricionista nutricionista, String nome, String email) {
        super(nome, email);
        this.peso = peso;
        this.idade = idade;
        this.alturaMetros = alturaMetros;
        this.imc = imc;
        this.tmb = tmb;
        this.cpf = cpf;
        this.objetivo = objetivo;
        this.nutricionista = nutricionista;
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

    public Nutricionista getNutricionista() {
        return nutricionista;
    }

    public void setNutricionista(Nutricionista nutricionista) {
        this.nutricionista = nutricionista;
    }

    public float getTmb() {
        return tmb;
    }

    public void setTmb(float tmb) {
        this.tmb = tmb;
    }
    
    
}
