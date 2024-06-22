package br.unesp.poo.grupo03.modelo;

public class Nutricionista extends Pessoa{
    private String CNPJ;
    private String senha;

    public Nutricionista(String CNPJ, String senha, String nome, String email) {
        super(nome, email);
        this.CNPJ = CNPJ;
        this.senha = senha;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
   
}
