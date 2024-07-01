package br.unesp.poo.grupo03.projeto.utilitario;

import br.unesp.poo.grupo03.projeto.modelo.Prato;
import br.unesp.poo.grupo03.projeto.modelo.Refeicao;
import br.unesp.poo.grupo03.projeto.repositorio.DietaRepositorio;
import br.unesp.poo.grupo03.projeto.repositorio.NutricionistaRepositorio;
import br.unesp.poo.grupo03.projeto.repositorio.PacienteRepositorio;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.Paragraph;
import java.io.FileNotFoundException;
import java.util.List;




public class GerarPDF {

    public void geradorPDF() throws FileNotFoundException {
        String path = "Dieta.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        Document document = new Document(pdfDocument);
        
        // Instanciando os repositorios para poder acessar as listas estaticas (ja iniciada com dados)
        DietaRepositorio dietaRepositorio = new DietaRepositorio();
        NutricionistaRepositorio nutricionistaRepositorio = new NutricionistaRepositorio();
        PacienteRepositorio pacienteRepositorio = new PacienteRepositorio();


        // Armazenando a lista de refeicoes especificas do paciente de cpf 123...
        // Isso eh importante pois iremos percorrer as refeicoes somente deste paciente e nao todas refeicoes cadastrados no programa
        List<Refeicao> listaRefeicoes = dietaRepositorio.buscarPorPaciente(System.getProperty("cpfPacienteSelecionado")).getRefeicoesDiarias();
        
        // Pega o nome do paciente
        String nutri = nutricionistaRepositorio.buscar(System.getProperty("login")).getNome();
        
        // Pega o nome do paciente
        String paciente = pacienteRepositorio.buscar(System.getProperty("cpfPacienteSelecionado")).getNome();
        
        
        Paragraph title = new Paragraph("DIETA").setFontSize(50);
        document.add(title);
        
        Paragraph nomeNutri = new Paragraph("Nutricionista - " + nutri).setFontSize(14);
        document.add(nomeNutri);

        Paragraph nomeCliente = new Paragraph("Cliente - " + paciente).setFontSize(14);
        document.add(nomeCliente); 
        
        Div line; // define a largura da linha como 100% da largura da página (exlcuindo margem)
        line = new Div().setBorder(new SolidBorder(1)); // define a borda sólida com espessura 1
        
        // For otimizado para percorrer a lista de refeicoes do paciente
        for(Refeicao r: listaRefeicoes){          
            // captura o nome da refeicao 
            document.add(line);
            Paragraph refeicao = new Paragraph("Opções de " + r.getNome()).setFontSize(18);
            document.add(refeicao);
            
            for(Prato p : r.getOpcoesDePrato()){// r.getOpcoesDePrato armazena os pratos cadastrados dentro da refeicao que esta sendo lida
                Paragraph pratos = new Paragraph("- " + p.getNomePrato()).setFontSize(12);
                document.add(pratos);
        }
            }
       
        document.close();
    }
}