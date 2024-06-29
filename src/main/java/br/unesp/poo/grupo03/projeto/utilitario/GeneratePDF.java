package br.unesp.poo.grupo03.projeto.utilitario;

import br.unesp.poo.grupo03.projeto.modelo.Prato;
import br.unesp.poo.grupo03.projeto.modelo.Refeicao;
import br.unesp.poo.grupo03.projeto.repositorio.DietaRepositorio;
import br.unesp.poo.grupo03.projeto.repositorio.PratoRepositorio;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.Paragraph;
import java.io.FileNotFoundException;
import java.util.List;




public class GeneratePDF {

    public static void geradorPDF() throws FileNotFoundException {
        String path = "Dieta.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        Document document = new Document(pdfDocument);
        
        // Instanciando os repositorios para poder acessar as listas estaticas (ja iniciada com dados)
        DietaRepositorio dr = new DietaRepositorio();
        PratoRepositorio pr = new PratoRepositorio();

        // Armazenando a lista de refeicoes especificas do paciente de cpf 123...
        // Isso eh importante pois iremos percorrer as refeicoes somente deste paciente e nao todas refeicoes cadastrados no programa
        List<Refeicao> listaRefeicoes = dr.buscarPorPaciente("123.456.789-01").getRefeicoesDiarias();

        Div line; // define a largura da linha como 100% da largura da página
        line = new Div().setBorder(new SolidBorder(1)); // define a borda sólida com espessura 1
        

        
         
        Paragraph title = new Paragraph("DIETA").setFontSize(50);
        document.add(title);
        
        Paragraph nomeNutri = new Paragraph("Nutricionista - Nome da nutri aqui").setFontSize(14);
        document.add(nomeNutri);

        Paragraph nomeCliente = new Paragraph("Cliente - Nome do cliente aqui").setFontSize(14);
        document.add(nomeCliente);
        
        
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
