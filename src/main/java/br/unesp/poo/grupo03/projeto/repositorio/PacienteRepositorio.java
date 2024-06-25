package br.unesp.poo.grupo03.projeto.repositorio;

import br.unesp.poo.grupo03.projeto.modelo.Paciente;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PacienteRepositorio {

    private static List<Paciente> pacientes = new ArrayList<>();

    public PacienteRepositorio() {
    }

    public static List<Paciente> getPacientes() {
        return pacientes;
    }

    public static void setPacientes(List<Paciente> pacientes) {
        PacienteRepositorio.pacientes = pacientes;
    }

    public boolean adicionar(Paciente paciente) {
        return pacientes.add(paciente);
    }

    public void remover(String cpf) {
        Iterator<Paciente> iterator = pacientes.iterator();
        while (iterator.hasNext()) {
            Paciente paciente = iterator.next();
            if (paciente.getCpf().equals(cpf)) {
                iterator.remove();
                return;
            }
        }
    }

    public Paciente buscar(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
    }
}
