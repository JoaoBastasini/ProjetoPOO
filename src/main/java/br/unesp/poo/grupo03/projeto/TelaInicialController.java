package br.unesp.poo.grupo03.projeto;

import br.unesp.poo.grupo03.projeto.repositorio.PratoRepositorio;
import static br.unesp.poo.grupo03.projeto.utilitario.CarregadorDados.carregar;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
    private ListView<?> lstFuncionarios;

    @FXML
    void OnClickBtnSair(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage loginStage = new Stage();
            loginStage.initStyle(StageStyle.DECORATED);
            loginStage.setScene(new Scene(root));
            
            Stage stage = (Stage) btnSair.getScene().getWindow();
            stage.close();
            
            loginStage.show();
    }

    @FXML
    void onClickBtnImprimir(ActionEvent event){
        carregar();
        PratoRepositorio pr = new PratoRepositorio();
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

    }

}
