package br.unesp.poo.grupo03.projeto.modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class GerenciaPlanilha {

    public List<Prato> criar() throws IOException {
        String filePath = "Alimentacao.xlsx";
        List<Prato> pratos = new ArrayList<>();
        System.out.println("oi");

        //recuperando o arquivo
        try (FileInputStream file = new FileInputStream(filePath)) {
            Workbook workbook = new XSSFWorkbook(file);
            System.out.println("arquivo");

            //setando a aba
            Sheet sheet = (Sheet) workbook.getSheetAt(0);
            System.out.println("aba");
            //sentando as linhas
            for (Row row : sheet) {
                Iterator<Cell> cellIterator = row.cellIterator();

                // usando o builder para criar objetos Prato
                String nome = cellIterator.next().getStringCellValue();
                int calorias = (int) cellIterator.next().getNumericCellValue();
                int peso = (int) cellIterator.next().getNumericCellValue();

                Prato prato = new Prato(nome, calorias, peso);
                pratos.add(prato);
            }

            // adicionando novos pratos (exemplo)
            adicionarNovoPrato(sheet, "Novo Prato 1", 700, 250);
            adicionarNovoPrato(sheet, "Novo Prato 2", 600, 300);

            // salvando as alterações na planilha
            try (FileOutputStream outFile = new FileOutputStream(filePath)) {
                workbook.write(outFile);
                System.out.println("Dados adicionados com sucesso na planilha.");
            } catch (IOException e) {
                System.out.println("Erro ao salvar alterações na planilha.");
                //e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo não encontrado. Verifique o caminho do arquivo: " + filePath);
            //e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Erro: Problema ao ler/escrever o arquivo. Verifique se o arquivo está acessível e no formato correto.");
            //e.printStackTrace();
        }

        return pratos;
    }

    public List<?> toList(Iterator<?> iterator) {
        return IteratorUtils.toList(iterator);
    }

    private void adicionarNovoPrato(Sheet sheet, String nome, int calorias, int peso) {
        int rowCount = sheet.getLastRowNum();
        Row row = sheet.createRow(++rowCount);

        Cell cell = row.createCell(0);
        cell.setCellValue(nome);

        cell = row.createCell(1);
        cell.setCellValue(calorias);

        cell = row.createCell(2);
        cell.setCellValue(peso);
    }

    private static class IteratorUtils {

        private static List<?> toList(Iterator<?> iterator) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public IteratorUtils() {
        }
    }
}

