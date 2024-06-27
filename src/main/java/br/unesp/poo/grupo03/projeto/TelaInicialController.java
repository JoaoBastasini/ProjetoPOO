package br.unesp.poo.grupo03.projeto;

import br.unesp.poo.grupo03.projeto.modelo.Paciente;
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

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnImprimir;

    @FXML
    private Button btnMontarDieta;

    @FXML
    private Button btnNovoPaciente;

    @FXML
    private Button btnRemover;

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
    void onClickBtnImprimir(ActionEvent event) {

    }

    void preencherTabela() {

        PacienteRepositorio pr = new PacienteRepositorio();
        NutricionistaRepositorio nr = new NutricionistaRepositorio();

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

        NutricionistaRepositorio np = new NutricionistaRepositorio();

        String registro = System.getProperty("login");

        if (np.existe(registro)) {
            lblNutricionista.setText(np.buscar(registro).getNome());

            String especialidade = "Nutricao ";
            if (np.buscar(registro).getEspecialidade().isNutricaoClinica() == true) {
                especialidade += "Clinica ";
            }
            if (np.buscar(registro).getEspecialidade().isNutricaoEsportiva() == true) {
                especialidade += "Esportiva ";
            }
            if (np.buscar(registro).getEspecialidade().isNutricaoPediatrica() == true) {
                especialidade += "Pediatrica ";
            }

            lblEspecialidade.setText(especialidade);
        }

    }

}
