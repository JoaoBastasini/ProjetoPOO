package br.unesp.poo.grupo03.projeto.utilitario;

import br.unesp.poo.grupo03.projeto.modelo.Prato;
import br.unesp.poo.grupo03.projeto.repositorio.PratoRepositorio;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GerenciaPlanilha {

        private final String filePath = "Alimentacao.xlsx";
        private final PratoRepositorio pratoRepositorio;

        public GerenciaPlanilha(PratoRepositorio pratoRepositorio) {
            this.pratoRepositorio = pratoRepositorio;
        }

        public void ler() throws IOException {
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("Erro: Arquivo não encontrado. Verifique o caminho do arquivo: " + filePath);
                return;
            }

            try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

                Sheet sheet = workbook.getSheetAt(0);

                for (Row row : sheet) {
                    Iterator<Cell> cellIterator = row.cellIterator();

                    String nome = cellIterator.next().getStringCellValue();
                    int calorias = (int) cellIterator.next().getNumericCellValue();
                    int peso = (int) cellIterator.next().getNumericCellValue();

                    Prato prato = new Prato(nome, calorias, peso);
                    pratoRepositorio.adicionar(prato);
                }

                System.out.println("Dados lidos com sucesso da planilha.");

            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo. Verifique se o arquivo está acessível e no formato correto: " + e.getMessage());
            }
        }

        
        public void adicionarNovoPrato(String nome, int calorias, int peso) throws IOException {
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("Erro: Arquivo não encontrado. Verifique o caminho do arquivo: " + filePath);
                return;
            }

            try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

                Sheet sheet = workbook.getSheetAt(0);
                int rowCount = sheet.getLastRowNum();
                Row row = sheet.createRow(++rowCount);

                Cell cell = row.createCell(0);
                cell.setCellValue(nome);

                cell = row.createCell(1);
                cell.setCellValue(calorias);

                cell = row.createCell(2);
                cell.setCellValue(peso);

                try (FileOutputStream outFile = new FileOutputStream(filePath)) {
                    workbook.write(outFile);
                    System.out.println("Dados adicionados com sucesso na planilha.");
                }

            } catch (IOException e) {
                System.out.println("Erro ao escrever no arquivo. Verifique se o arquivo está acessível e no formato correto: " + e.getMessage());
            }
        }
    }