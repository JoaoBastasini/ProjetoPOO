package br.unesp.poo.grupo03.projeto;

import br.unesp.poo.grupo03.projeto.modelo.Paciente;
import br.unesp.poo.grupo03.projeto.repositorio.DietaRepositorio;
import br.unesp.poo.grupo03.projeto.repositorio.NutricionistaRepositorio;
import br.unesp.poo.grupo03.projeto.repositorio.PacienteRepositorio;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaInicialController {
    
    private final DietaRepositorio dr = new DietaRepositorio();
    private final NutricionistaRepositorio nr = new NutricionistaRepositorio();
    private final PacienteRepositorio pr = new PacienteRepositorio();

    @FXML
    private Button btnEditarDieta;

    @FXML
    private Button btnEditarPaciente;

    @FXML
    private Button btnImprimirDieta;

    @FXML
    private Button btnNovoPaciente;

    @FXML
    private Button btnRemoverPaciente;

    @FXML
    private Button btnSair;

    @FXML
    private Label lblEspecialidade;

    @FXML
    private Label lblNutricionista;

    @FXML
    private TableColumn<Paciente, String> tblClCpf;

    @FXML
    private TableColumn<Paciente, String> tblClNome;

    @FXML
    private TableView<Paciente> tblPacientes;

    @FXML
    void OnClickBtnNovoPaciente(ActionEvent event) {

    }

    @FXML
    void OnClickBtnRemoverPaciente(ActionEvent event) {

    }

    @FXML
    void onClickBtnEditarPaciente(ActionEvent event) {

    }

    @FXML
    void onClickBtnImprimirDieta(ActionEvent event) {

    }

    @FXML
    void OnClickBtnSair(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage loginStage = new Stage();
        loginStage.initStyle(StageStyle.DECORATED);
        loginStage.setScene(new Scene(root));

        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
        System.clearProperty("login");
        System.clearProperty("password");
        loginStage.show();
    }

    @FXML
    void onClickBtnEditarDieta(ActionEvent event) throws IOException {
        int numLinha = tblPacientes.getSelectionModel().getSelectedIndex();
        if (numLinha != -1) {
            System.setProperty("cpfPacienteSelecionado", tblPacientes.getItems().get(numLinha).getCpf());
            if (dr.buscarPorPaciente(System.getProperty("cpfPacienteSelecionado")) != null) {
                Parent root = FXMLLoader.load(getClass().getResource("telaMontarDieta.fxml"));
                Stage inicialStage = new Stage();
                inicialStage.initStyle(StageStyle.DECORATED);
                inicialStage.setScene(new Scene(root));

                Stage stage = (Stage) btnEditarDieta.getScene().getWindow();
                stage.close();

                inicialStage.show();
            } else {
                //montar dieta;
            }
        }

    }

    void preencherTabela() {

        List<Paciente> pacientes = pr.getPacientes();

        tblClNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        tblClCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        ObservableList<Paciente> dadosPacientes = FXCollections.observableArrayList();

        for (Paciente p : pacientes) {
            if (p.getNutricionista() == nr.buscar(System.getProperty("login"))) {
                dadosPacientes.add(p);
            }
        }

        tblPacientes.setItems(dadosPacientes);
    }

    @FXML
    void initialize() {
        preencherTabela();

        String registro = System.getProperty("login");

        if (nr.existe(registro)) {
            lblNutricionista.setText(nr.buscar(registro).getNome());

            String especialidade = "Nutricao ";
            if (nr.buscar(registro).getEspecialidade().isNutricaoClinica() == true) {
                especialidade += "Clinica ";
            }
            if (nr.buscar(registro).getEspecialidade().isNutricaoEsportiva() == true) {
                especialidade += "Esportiva ";
            }
            if (nr.buscar(registro).getEspecialidade().isNutricaoPediatrica() == true) {
                especialidade += "Pediatrica ";
            }

            lblEspecialidade.setText(especialidade);
        }

    }

}
