package br.unesp.poo.grupo03.projeto;

import br.unesp.poo.grupo03.projeto.modelo.Paciente;
import br.unesp.poo.grupo03.projeto.repositorio.NutricionistaRepositorio;
import br.unesp.poo.grupo03.projeto.repositorio.PacienteRepositorio;
import br.unesp.poo.grupo03.projeto.utilitario.CarregadorDados;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaInicialController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private ListView<String> lstFuncionarios;

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
        PacienteRepositorio pr = new PacienteRepositorio();
        NutricionistaRepositorio nr = new NutricionistaRepositorio();
        // Obter a lista de pacientes do repositório
        List<Paciente> pacientes = pr.getPacientes();
        
        ObservableList<String> observableListPacientes =  FXCollections.observableArrayList();
        
        for (Paciente p: pacientes){
            if(p.getNutricionista() == nr.buscar(System.getProperty("login"))){
                observableListPacientes.add(p.getNome());
            }
        }

        // Definir o ObservableList no ListView
        lstFuncionarios.setItems(observableListPacientes);
    }

    @FXML
    void initialize() {
        assert btnEditar != null : "fx:id=\"btnEditar\" was not injected: check your FXML file 'telaInicial.fxml'.";
        assert btnImprimir != null : "fx:id=\"btnImprimir\" was not injected: check your FXML file 'telaInicial.fxml'.";
        assert btnMontarDieta != null : "fx:id=\"btnMontarDieta\" was not injected: check your FXML file 'telaInicial.fxml'.";
        assert btnNovoPaciente != null : "fx:id=\"btnNovoPaciente\" was not injected: check your FXML file 'telaInicial.fxml'.";
        assert btnRemover != null : "fx:id=\"btnRemover\" was not injected: check your FXML file 'telaInicial.fxml'.";
        assert btnSair != null : "fx:id=\"btnSair\" was not injected: check your FXML file 'telaInicial.fxml'.";
        assert lblEspecialidade != null : "fx:id=\"lblEspecialidade\" was not injected: check your FXML file 'telaInicial.fxml'.";
        assert lblNutricionista != null : "fx:id=\"lblNutricionista\" was not injected: check your FXML file 'telaInicial.fxml'.";
        assert lstFuncionarios != null : "fx:id=\"lstFuncionarios\" was not injected: check your FXML file 'telaInicial.fxml'.";

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
