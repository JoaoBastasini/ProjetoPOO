package br.unesp.poo.grupo03.projeto;

import br.unesp.poo.grupo03.projeto.modelo.Prato;
import br.unesp.poo.grupo03.projeto.modelo.Refeicao;
import br.unesp.poo.grupo03.projeto.repositorio.DietaRepositorio;
import br.unesp.poo.grupo03.projeto.repositorio.PacienteRepositorio;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaMontarDietaController {

    private final DietaRepositorio dr = new DietaRepositorio();
    private final PacienteRepositorio pr = new PacienteRepositorio();

    @FXML
    private Label lblNomeDoPaciente;

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
    void onClickBtnAdicionar(ActionEvent event) throws IOException {
        System.setProperty("refeicaoSelecionada", "adicionar.refeicao");
        chamarTela("telaMontarRefeicao.fxml", (Stage) btnAdicionar.getScene().getWindow());
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
        String cpfPaciente = System.getProperty("cpfPacienteSelecionado");
        List<Refeicao> refeicoes = dr.buscarPorPaciente(cpfPaciente).getRefeicoesDiarias();
        String itemSelecionado = lstRefeicoes.getSelectionModel().getSelectedItem();

        Iterator<Refeicao> iterator = refeicoes.iterator();
        while (iterator.hasNext()) {
            Refeicao r = iterator.next();
            if (r.getNome().equals(itemSelecionado)) {
                iterator.remove();
            }
        }
        exibirRefeicoes();
    }

    @FXML
    void onClickBtnVoltar(ActionEvent event) throws IOException {
        chamarTela("telaInicial.fxml", (Stage) btnVoltar.getScene().getWindow());

    }

    @FXML
    void onMouseClickLstRefeicoes(MouseEvent event) {
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

    void exibirRefeicoes() {
        String cpfPaciente = System.getProperty("cpfPacienteSelecionado");
        // Obter a lista de pacientes do repositório
        List<Refeicao> refeicoes = dr.buscarPorPaciente(cpfPaciente).getRefeicoesDiarias();
        lblNomeDoPaciente.setText("Dieta de " + pr.buscar(cpfPaciente).getNome());
        ObservableList<String> observableListRefeicoes = FXCollections.observableArrayList();

        for (Refeicao r : refeicoes) {
            observableListRefeicoes.add(r.getNome());
        }

        lstRefeicoes.setItems(observableListRefeicoes);
    }

    @FXML
    void initialize() {
        exibirRefeicoes();
    }
}
