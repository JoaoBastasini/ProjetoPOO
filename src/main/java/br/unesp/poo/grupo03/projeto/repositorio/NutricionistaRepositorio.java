package br.unesp.poo.grupo03.projeto.repositorio;

import br.unesp.poo.grupo03.projeto.modelo.Nutricionista;
import br.unesp.poo.grupo03.projeto.modelo.Paciente;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NutricionistaRepositorio {

    private static List<Nutricionista> nutricionistas = new ArrayList<>();

    public NutricionistaRepositorio() {
    }

    public static List<Nutricionista> getNutricionistas() {
        return nutricionistas;
    }

    public static void setNutricionistas(List<Nutricionista> nutricionistas) {
        NutricionistaRepositorio.nutricionistas = nutricionistas;
    }

    public boolean adicionar(Nutricionista nutricionista) {
        return nutricionistas.add(nutricionista);
    }

    public void remover(String registro) {
        Iterator<Nutricionista> iterator = nutricionistas.iterator();
        while (iterator.hasNext()) {
            Nutricionista nutricionista = iterator.next();
            if (nutricionista.getRegistroProfissional().equals(registro)) {
                iterator.remove();
                return;
            }
        }
    }

    public Nutricionista buscar(String registro) {
        for (Nutricionista nutricionista : nutricionistas) {
            if (nutricionista.getRegistroProfissional().equals(registro)) {
                return nutricionista;
            }
        }
        return null;
    }

    public boolean existe(String registro) {
        for (Nutricionista nutricionista : nutricionistas) {
            if (nutricionista.getRegistroProfissional().equals(registro)) {
                return true;
            }
        }
        return false;
    }
}
