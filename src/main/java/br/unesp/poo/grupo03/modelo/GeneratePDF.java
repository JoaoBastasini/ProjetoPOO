package br.unesp.poo.grupo03.modelo;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import static java.awt.SystemColor.text;
import java.io.FileNotFoundException;


public class GeneratePDF {
     public static void main(String[] args) throws FileNotFoundException{
         String path = "Dieta.pdf";
         PdfWriter pdfWriter = new PdfWriter(path);
         PdfDocument pdfDocument = new PdfDocument(pdfWriter);
         pdfDocument.setDefaultPageSize(PageSize.A4);
         Document document = new Document(pdfDocument);
         
         document.close();
     }
}
