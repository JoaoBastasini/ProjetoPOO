/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.unesp.poo.grupo03.projeto;

import br.unesp.poo.grupo03.projeto.modelo.Paciente;
import br.unesp.poo.grupo03.projeto.modelo.Prato;
import br.unesp.poo.grupo03.projeto.modelo.Refeicao;
import br.unesp.poo.grupo03.projeto.repositorio.DietaRepositorio;
import br.unesp.poo.grupo03.projeto.repositorio.PacienteRepositorio;
import br.unesp.poo.grupo03.projeto.repositorio.PratoRepositorio;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author cauan
 */
public class TelaMontarRefeicaoController implements Initializable {

    private final PacienteRepositorio pr = new PacienteRepositorio();
    private final DietaRepositorio dr = new DietaRepositorio();
    private final PratoRepositorio ptr = new PratoRepositorio();

    @FXML
    private Label lblNomeDoPaciente;

    @FXML
    private Label lblNomeRefeicao;

    @FXML
    private Button btnInserirPrato;

    @FXML
    private Button btnRemoverPrato;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVoltar;

    @FXML
    private ListView<String> lstPratosRefeicao;

    @FXML
    private ListView<String> lstTodosPratos;

    @FXML
    void onClickBtnSalvar(ActionEvent event) throws IOException {

        Paciente paciente = pr.buscar(System.getProperty("cpfPacienteSelecionado"));
        List<Refeicao> refeicoes = dr.buscarPorPaciente(paciente.getCpf()).getRefeicoesDiarias();
        List<Prato> nvPratos = new ArrayList<>();

        String refeicaoSelecionada = System.getProperty("refeicaoSelecionada");
        //
        if (!refeicaoSelecionada.equals("adicionar.refeicao")) {
            for (Refeicao r : refeicoes) {
                if (r.getNome() == System.getProperty("refeicaoSelecionada")) {
                    ObservableList<String> observableListPratosRefeicao = FXCollections.observableArrayList();

                    List<Prato> pratos = r.getOpcoesDePrato();
                    for (String pratoNome : lstPratosRefeicao.getItems()) {
                        nvPratos.add(ptr.buscarPrato(pratoNome));
                    }
                    r.setOpcoesDePrato(nvPratos);
                }
            }
        } else {
            // Abrir um alert perguntando o nome
            ObservableList<String> observableListPratosRefeicao = FXCollections.observableArrayList();
            List<Prato> novosPratos = new ArrayList<>();
            for (String pratoNome : lstPratosRefeicao.getItems()) {
                novosPratos.add(ptr.buscarPrato(pratoNome));
            }
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Nova Refeição");
            dialog.setHeaderText("Adicionando Nova Refeição");
            dialog.setContentText("Por favor, digite o nome da refeição");

            // Mostrando o diálogo e esperando a resposta do usuário
            Optional<String> nomeRefeicao = dialog.showAndWait();
            nomeRefeicao.ifPresent(nome -> {
                boolean nomeValido = true;
                for (Refeicao r : refeicoes) {
                    if ((r.getNome().equals(nome)) || nome.isEmpty()) {
                        nomeValido = false;
                    }
                }
                if (nomeValido) {
                    Refeicao novaRefeicao = new Refeicao(nome, novosPratos);
                    dr.buscarPorPaciente(System.getProperty("cpfPacienteSelecionado")).getRefeicoesDiarias().add(novaRefeicao);
                }
            });

        }

        chamarTela("telaMontarDieta.fxml", (Stage) btnSalvar.getScene().getWindow());
    }

    @FXML
    void onClickBtnInserirPrato(ActionEvent event) {
        String selectedItem = lstTodosPratos.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            lstTodosPratos.getItems().remove(selectedItem);
            lstPratosRefeicao.getItems().add(selectedItem);

            lstTodosPratos.getSelectionModel().clearSelection();
            lstPratosRefeicao.getSelectionModel().clearSelection();
        }
    }

    @FXML
    void onClickBtnRemoverrPrato(ActionEvent event) {
        String selectedItem = lstPratosRefeicao.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            lstPratosRefeicao.getItems().remove(selectedItem);
            lstTodosPratos.getItems().add(selectedItem);

            lstTodosPratos.getSelectionModel().clearSelection();
            lstPratosRefeicao.getSelectionModel().clearSelection();
        }
    }

    @FXML
    void onClickBtnVoltar(ActionEvent event) throws IOException {
        chamarTela("telaModeloRefeicao.fxml", (Stage) btnVoltar.getScene().getWindow());

    }

    void chamarTela(String nome, Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(nome));
        Stage inicialStage = new Stage();
        inicialStage.initStyle(StageStyle.DECORATED);
        inicialStage.setScene(new Scene(root));

        stage.close();

        inicialStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Paciente paciente = pr.buscar(System.getProperty("cpfPacienteSelecionado"));
        List<Refeicao> refeicoes = dr.buscarPorPaciente(paciente.getCpf()).getRefeicoesDiarias();
        List<Prato> todosPratos = new ArrayList<>(ptr.getPratos());
        String refeicaoSelecionada = System.getProperty("refeicaoSelecionada");

        lblNomeDoPaciente.setText("Dieta de " + paciente.getNome());
        if (refeicaoSelecionada.equals("adicionar.refeicao")) {
            lblNomeRefeicao.setText("Nova Refeição");
        } else {
            lblNomeRefeicao.setText(refeicaoSelecionada);
            for (Refeicao r : refeicoes) {
                if (r.getNome().equals(refeicaoSelecionada)) {
                    ObservableList<String> observableListPratosRefeicao = FXCollections.observableArrayList();
                    List<Prato> pratos = r.getOpcoesDePrato();
                    for (Prato p : pratos) {
                        observableListPratosRefeicao.add(p.getNomePrato());
                        todosPratos.remove(p);
                    }
                    lstPratosRefeicao.setItems(observableListPratosRefeicao);
                }
            }
        }
        ObservableList<String> observableListTodosPratos = FXCollections.observableArrayList();
        for (Prato p : todosPratos) {
            observableListTodosPratos.add(p.getNomePrato());
        }
        lstTodosPratos.setItems(observableListTodosPratos);

    }

}
