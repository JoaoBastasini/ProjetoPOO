package br.unesp.poo.grupo03.projeto.repositorio;

import br.unesp.poo.grupo03.projeto.modelo.Dieta;
import java.util.ArrayList;
import java.util.List;

public class DietaRepositorio {

    private static List<Dieta> dietas = new ArrayList<>();

    public DietaRepositorio() {
        
    }

    public static List<Dieta> getDietas() {
        return dietas;
    }

    public static void setDietas(List<Dieta> dietas) {
        DietaRepositorio.dietas = dietas;
    }

    public boolean adicionar(Dieta dieta) {
        return dietas.add(dieta);
    }

    public void remover(Dieta dieta) {
        dietas.remove(dieta);
    }

    public Dieta buscarPorPaciente(String cpfPaciente) {
        for (Dieta dieta : dietas) {
            if (dieta.getPaciente().getCpf().equals(cpfPaciente)) {
                return dieta;
            }
        }
        return null;
    }

}