package br.unesp.poo.grupo03.projeto.utilitario;

import br.unesp.poo.grupo03.projeto.modelo.Dieta;
import br.unesp.poo.grupo03.projeto.modelo.Especialidade;
import br.unesp.poo.grupo03.projeto.modelo.Nutricionista;
import br.unesp.poo.grupo03.projeto.modelo.Objetivo;
import br.unesp.poo.grupo03.projeto.modelo.Paciente;
import br.unesp.poo.grupo03.projeto.modelo.Prato;
import br.unesp.poo.grupo03.projeto.modelo.Refeicao;
import br.unesp.poo.grupo03.projeto.repositorio.NutricionistaRepositorio;
import br.unesp.poo.grupo03.projeto.repositorio.PacienteRepositorio;
import br.unesp.poo.grupo03.projeto.repositorio.PratoRepositorio;
import java.util.ArrayList;
import java.util.List;

public class CarregadorDados {

    public static void carregar() {
        // Criando e Carregando Pratos

        PratoRepositorio pratosRep = new PratoRepositorio();
        List<Prato> pratos = new ArrayList<>();

        pratos.add(new Prato("Macarrão", 500, 250));
        pratos.add(new Prato("Salmão grelhado", 450, 200));
        pratos.add(new Prato("Salada de frutas", 300, 150));
        pratos.add(new Prato("Hambúrguer", 700, 300));
        pratos.add(new Prato("Sopa de legumes", 250, 200));
        pratos.add(new Prato("Pizza", 800, 350));
        pratos.add(new Prato("Frango assado", 400, 180));
        pratos.add(new Prato("Arroz integral", 350, 180));
        pratos.add(new Prato("Peixe ao molho de alcaparras", 600, 250));
        pratos.add(new Prato("Purê de batatas", 200, 150));
        pratos.add(new Prato("Ceviche", 350, 200));
        pratos.add(new Prato("Lasanha vegetariana", 550, 300));
        pratos.add(new Prato("Torta de frango", 400, 250));
        pratos.add(new Prato("Feijoada", 900, 400));
        pratos.add(new Prato("Mousse de chocolate", 400, 180));
        pratos.add(new Prato("Sanduíche natural", 300, 200));
        pratos.add(new Prato("Risoto de cogumelos", 600, 300));
        pratos.add(new Prato("Picanha grelhada", 800, 350));
        pratos.add(new Prato("Espaguete à carbonara", 700, 400));
        pratos.add(new Prato("Cuscuz marroquino", 400, 250));

        for (Prato p : pratos) {
            PratoRepositorio.adicionarPrato(p);
        }

        // Criando e Carregando Refeicoes
        List<Prato> opcoesCafe = new ArrayList<>();
        opcoesCafe.add(pratos.get(2)); // Salada de frutas
        opcoesCafe.add(pratos.get(9)); // Purê de batatas
        opcoesCafe.add(pratos.get(15)); // Sanduíche natural

        List<Prato> opcoesAlmoco = new ArrayList<>();
        opcoesAlmoco.add(pratos.get(0));
        opcoesAlmoco.add(pratos.get(1));
        opcoesAlmoco.add(pratos.get(3));
        opcoesAlmoco.add(pratos.get(6));
        opcoesAlmoco.add(pratos.get(13));
        opcoesAlmoco.add(pratos.get(18));

        List<Prato> opcoesJantar = new ArrayList<>();
        opcoesJantar.add(pratos.get(4));
        opcoesJantar.add(pratos.get(5));
        opcoesJantar.add(pratos.get(7));
        opcoesJantar.add(pratos.get(8));
        opcoesJantar.add(pratos.get(11));
        opcoesJantar.add(pratos.get(16));
        opcoesJantar.add(pratos.get(17));
        opcoesJantar.add(pratos.get(19));

        List<Prato> opcoesLanche = new ArrayList<>();
        opcoesLanche.add(pratos.get(14));
        opcoesLanche.add(pratos.get(15));
        opcoesLanche.add(pratos.get(2));

        List<Prato> opcoesBrunch = new ArrayList<>();
        opcoesBrunch.add(pratos.get(1));
        opcoesBrunch.add(pratos.get(7));
        opcoesBrunch.add(pratos.get(10));
        opcoesBrunch.add(pratos.get(12));

        List<Prato> opcoesJantarTardio = new ArrayList<>();
        opcoesJantarTardio.add(pratos.get(5));
        opcoesJantarTardio.add(pratos.get(8));
        opcoesJantarTardio.add(pratos.get(11));
        opcoesJantarTardio.add(pratos.get(17));

        // Criação das instâncias de Refeicao
        Refeicao cafe = new Refeicao("Café da Manhã", opcoesCafe);
        Refeicao almoco = new Refeicao("Almoço", opcoesAlmoco);
        Refeicao jantar = new Refeicao("Jantar", opcoesJantar);
        Refeicao lanche = new Refeicao("Lanche", opcoesLanche);
        Refeicao brunch = new Refeicao("Brunch", opcoesBrunch);
        Refeicao jantarTardio = new Refeicao("Jantar Tardio", opcoesJantarTardio);

        // Instanciando especialidades
        Especialidade especialidade1 = new Especialidade(true, false, false); // Nutrição Clínica
        Especialidade especialidade2 = new Especialidade(false, false, true); // Nutrição Esportiva
        Especialidade especialidade3 = new Especialidade(true, false, true);  // Nutrição Clínica e Esportiva

        // Instanciando nutricionistas
        NutricionistaRepositorio nr = new NutricionistaRepositorio();
        nr.adicionar(new Nutricionista("12345", "senha123", especialidade1, "Dr. João", "joao@example.com"));
        nr.adicionar(new Nutricionista("67890", "senha456", especialidade2, "Dra. Maria", "maria@example.com"));
        nr.adicionar(new Nutricionista("11223", "senha789", especialidade3, "Dr. Pedro", "pedro@example.com"));

        // Instanciando objetivos
        Objetivo objetivo1 = new Objetivo(false, true, false); // Perder Peso
        Objetivo objetivo2 = new Objetivo(true, false, false); // Ganhar Peso
        Objetivo objetivo3 = new Objetivo(false, false, true); // Manutenção 

        // Instanciando pacientes
        PacienteRepositorio pr = new PacienteRepositorio();
        pr.adicionar(new Paciente(70.5f, 25, 1.75f, "12345678901", objetivo1, nr.buscar("12345"), "Ana", "ana@example.com", false));
        pr.adicionar(new Paciente(80.0f, 30, 1.80f, "23456789012", objetivo2, nr.buscar("67890"), "Bruno", "bruno@example.com", true));
        pr.adicionar(new Paciente(65.0f, 22, 1.65f, "34567890123", objetivo3, nr.buscar("11223"), "Carlos", "carlos@example.com", true));
        pr.adicionar(new Paciente(55.0f, 28, 1.60f, "45678901234", objetivo1, nr.buscar("12345"), "Diana", "diana@example.com", false));
        pr.adicionar(new Paciente(75.0f, 35, 1.70f, "56789012345", objetivo2, nr.buscar("12345"), "Eduardo", "eduardo@example.com", true));
        pr.adicionar(new Paciente(90.0f, 40, 1.85f, "67890123456", objetivo3, nr.buscar("67890"), "Fernanda", "fernanda@example.com", false));
        pr.adicionar(new Paciente(60.0f, 20, 1.68f, "78901234567", objetivo1, nr.buscar("12345"), "Gustavo", "gustavo@example.com", true));
        pr.adicionar(new Paciente(85.0f, 45, 1.82f, "89012345678", objetivo2, nr.buscar("67890"), "Helena", "helena@example.com", false));
        pr.adicionar(new Paciente(50.0f, 27, 1.55f, "90123456789", objetivo3, nr.buscar("67890"), "Igor", "igor@example.com", true));
        pr.adicionar(new Paciente(68.0f, 33, 1.72f, "01234567890", objetivo1, nr.buscar("11223"), "Julia", "julia@example.com", false));
        pr.adicionar(new Paciente(78.0f, 29, 1.77f, "09876543210", objetivo2, nr.buscar("12345"), "Lucas", "lucas@example.com", true));

        // Montando dietas para os pacientes
        // Paciente 1 - Nutricionista 1
        List<Refeicao> dietaPaciente1 = new ArrayList<>();
        dietaPaciente1.add(cafe);
        dietaPaciente1.add(almoco);
        dietaPaciente1.add(jantar);

        Dieta d1 = new Dieta(pr.buscar("12345678901"), dietaPaciente1);

        // Paciente 2 - Nutricionista 2
        List<Refeicao> dietaPaciente2 = new ArrayList<>();
        dietaPaciente2.add(lanche);
        dietaPaciente2.add(brunch);
        dietaPaciente2.add(jantarTardio);
        Dieta d2 = new Dieta(pr.buscar("23456789012"), dietaPaciente2);

        // Paciente 3 - Nutricionista 3
        List<Refeicao> dietaPaciente3 = new ArrayList<>();
        dietaPaciente3.add(cafe);
        dietaPaciente3.add(lanche);
        dietaPaciente3.add(jantar);
        dietaPaciente3.add(jantarTardio);
        Dieta d3 = new Dieta(pr.buscar("34567890123"), dietaPaciente3);

        // Paciente 4 - Nutricionista 1
        List<Refeicao> dietaPaciente4 = new ArrayList<>();
        dietaPaciente4.add(lanche);
        dietaPaciente4.add(brunch);
        dietaPaciente4.add(jantarTardio);

        Dieta d4 = new Dieta(pr.buscar("45678901234"), dietaPaciente4);

    }
}
