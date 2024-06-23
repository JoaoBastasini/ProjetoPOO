package br.unesp.poo.grupo03.modelo;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import java.io.FileNotFoundException;

public class GeneratePDF {

    public static void geradorPDF() throws FileNotFoundException {
        String fileName = "Dieta.pdf"; // Nome do arquivo
        String projectDirectory = System.getProperty("user.dir"); // Diretório do projeto
        String path = projectDirectory+ "//" + fileName;
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        Document document = new Document(pdfDocument);

        document.close();
    }
}