package br.unesp.poo.grupo03.projeto.utilitario;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.Paragraph;
import java.io.FileNotFoundException;




public class GeneratePDF {

    public static void geradorPDF() throws FileNotFoundException {
        String path = "Dieta.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        Document document = new Document(pdfDocument);

        /*float height = 285f;
        float width = 600f;
        float tableSize[] = {width, height};
        Table table = new Table(tableSize);*/
        
        Paragraph title = new Paragraph("DIETA").setFontSize(50);
        document.add(title);
        
        Paragraph nomeNutri = new Paragraph("Nutricionista - Nome da nutri aqui").setFontSize(14);
        document.add(nomeNutri);

        Paragraph nomeCliente = new Paragraph("Cliente - Nome do cliente aqui").setFontSize(14);
        document.add(nomeCliente);
        
        Div line; // define a largura da linha como 100% da largura da página
        line = new Div().setBorder(new SolidBorder(1)); // define a borda sólida com espessura 1
        document.add(line);
        
        Paragraph cafeDaManha = new Paragraph("Café da manhã").setFontSize(18);
        document.add(cafeDaManha);
        Paragraph opcoesCafeDaManha = new Paragraph("Pão com ovo").setFontSize(12);
        document.add(opcoesCafeDaManha);
        
        document.add(line);
        
        Paragraph almoco = new Paragraph("Almoço").setFontSize(18);
        document.add(almoco);
        Paragraph opcoesAlmoco = new Paragraph("Arroz, feijão e frango").setFontSize(12);
        document.add(opcoesAlmoco);
        
        document.add(line);
        
        Paragraph lancheDaTarde = new Paragraph("Lanche da Tarde").setFontSize(18);
        document.add(lancheDaTarde);
        Paragraph opcoesLancheDaTarde = new Paragraph("1 maçã ou 1 banana").setFontSize(12);
        document.add(opcoesLancheDaTarde);
        
        document.add(line);
        
        Paragraph janta = new Paragraph("Janta").setFontSize(18);
        document.add(janta);
        Paragraph opcoesJanta = new Paragraph("Sopa de Ervilha").setFontSize(12);
        document.add(opcoesJanta);
        
        
        document.close();
    }
}
