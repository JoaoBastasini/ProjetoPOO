package br.unesp.poo.grupo03.projeto.repositorio;

import br.unesp.poo.grupo03.projeto.modelo.Prato;
import java.util.ArrayList;
import java.util.List;

public class PratoRepositorio {

    private static List<Prato> pratos = new ArrayList<>();

    public PratoRepositorio() {
    }

    public static List<Prato> getPratos() {
        return pratos;
    }

    public static void setPratos(List<Prato> pratos) {
        PratoRepositorio.pratos = pratos;
    }

    public boolean adicionar(Prato prato) {
        return pratos.add(prato);
    }
    
    public Prato buscarPrato(String nomePrato){
        for (Prato p: pratos){
            if(p.getNomePrato().equals(nomePrato)){
                return p;
            }
        }
        return null;
    }
    
    public boolean remover(Prato prato){
        return pratos.remove(prato);
    }
    
    public void imprimir() {
        for (Prato p : pratos) {
            System.out.println(p.getNomePrato());
        }
    }

}
