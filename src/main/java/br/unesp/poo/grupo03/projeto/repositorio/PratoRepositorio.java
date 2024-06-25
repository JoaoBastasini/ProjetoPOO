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

    public static boolean adicionarPrato(Prato prato) {
        return pratos.add(prato);
    }

}
