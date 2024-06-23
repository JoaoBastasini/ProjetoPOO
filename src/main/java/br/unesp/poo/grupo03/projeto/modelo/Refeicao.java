package br.unesp.poo.grupo03.projeto.modelo;

import java.util.List;


public class Refeicao {
    private String nome; // (Cafe, Almoco, Lanche, etc...
    private List<Prato> opcoesDePrato;

    public Refeicao() {
    }
    
    public Refeicao(String nome, List<Prato> opcoesDePrato) {
        this.nome = nome;
        this.opcoesDePrato = opcoesDePrato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Prato> getOpcoesDePrato() {
        return opcoesDePrato;
    }

    public void setOpcoesDePrato(List<Prato> opcoesDePrato) {
        this.opcoesDePrato = opcoesDePrato;
    }
    
    
}
