/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.unesp.poo.grupo03.projeto;

import br.unesp.poo.grupo03.projeto.modelo.Prato;
import br.unesp.poo.grupo03.projeto.modelo.Refeicao;
import br.unesp.poo.grupo03.projeto.repositorio.DietaRepositorio;
import br.unesp.poo.grupo03.projeto.repositorio.PratoRepositorio;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author cauan
 */
public class TelaMontarDietaController {

    private final DietaRepositorio dr = new DietaRepositorio();

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnVoltar;

    @FXML
    private ListView<String> lstPratos;

    @FXML
    private ListView<String> lstRefeicoes;

    @FXML
    void onClickBtnAdicionar(ActionEvent event) {

    }

    @FXML
    void onClickBtnEditar(ActionEvent event) throws IOException {

        int numLinha = lstRefeicoes.getSelectionModel().getSelectedIndex();
        if (numLinha != -1) {
            System.setProperty("refeicaoSelecionada", lstRefeicoes.getItems().get(numLinha));
            chamarTela("telaMontarRefeicao.fxml", (Stage) btnVoltar.getScene().getWindow());
        }
    }

    @FXML
    void onClickBtnExcluir(ActionEvent event) {

    }

    @FXML
    void onClickBtnVoltar(ActionEvent event) throws IOException {
        chamarTela("telaInicial.fxml", (Stage) btnVoltar.getScene().getWindow());

    }

    @FXML
    void onMouseClickLstRefeicoes(MouseEvent event) {
        DietaRepositorio dr = new DietaRepositorio();
        if (dr.buscarPorPaciente(System.getProperty("cpfPacienteSelecionado")) != null) {
            List<Refeicao> refeicoes = dr.buscarPorPaciente(System.getProperty("cpfPacienteSelecionado")).getRefeicoesDiarias();

            String itemSelecionado = lstRefeicoes.getSelectionModel().getSelectedItem();
            if (itemSelecionado != null) {
                for (Refeicao r : refeicoes) {
                    if (r.getNome().equals(itemSelecionado)) {
                        exibirPratos(r);
                        break;
                    }
                }
            }
        }

    }

    void chamarTela(String nome, Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(nome));
        Stage inicialStage = new Stage();
        inicialStage.initStyle(StageStyle.DECORATED);
        inicialStage.setScene(new Scene(root));

        stage.close();

        inicialStage.show();
    }

    void exibirPratos(Refeicao refeicao) {
        if (refeicao.getOpcoesDePrato() != null) {
            ObservableList<String> observableListPratos = FXCollections.observableArrayList();
            List<Prato> pratos = refeicao.getOpcoesDePrato();
            for (Prato p : pratos) {
                observableListPratos.add(p.getNomePrato());
            }
            lstPratos.setItems(observableListPratos);
        }
    }

    @FXML
    void initialize() {
        // Obter a lista de pacientes do repositório
        List<Refeicao> refeicoes = dr.buscarPorPaciente(System.getProperty("cpfPacienteSelecionado")).getRefeicoesDiarias();

        ObservableList<String> observableListRefeicoes = FXCollections.observableArrayList();

        for (Refeicao r : refeicoes) {
            observableListRefeicoes.add(r.getNome());
        }

        lstRefeicoes.setItems(observableListRefeicoes);
    }
}
