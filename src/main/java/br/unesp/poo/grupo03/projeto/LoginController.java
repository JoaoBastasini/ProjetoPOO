package br.unesp.poo.grupo03.projeto;

import br.unesp.poo.grupo03.projeto.repositorio.NutricionistaRepositorio;
import br.unesp.poo.grupo03.projeto.utilitario.CarregadorDados;
import static br.unesp.poo.grupo03.projeto.utilitario.GeneratePDF.geradorPDF;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController {

    //@FXML
    //private ResourceBundle resources;
//
    //@FXML
    //private URL location;
    @FXML
    private Button btnEntrar;

    @FXML
    private TextField txtRegistro;

    @FXML
    private PasswordField txtSenha;

    @FXML
    void onClickBtnEntrar(ActionEvent event) throws IOException {
        String registro = txtRegistro.getText();
        String senha = txtSenha.getText();
        login(registro, senha);
    }

    void login(String registro, String senha) throws IOException {
        NutricionistaRepositorio nr = new NutricionistaRepositorio();
        if (nr.existe(registro) && senha.equals(nr.buscar(registro).getSenha())) {
            System.setProperty("login", registro);
            System.setProperty("password", senha);

            Parent root = FXMLLoader.load(getClass().getResource("telaInicial.fxml"));
            Stage inicialStage = new Stage();
            inicialStage.initStyle(StageStyle.DECORATED);
            inicialStage.setScene(new Scene(root));

            Stage stage = (Stage) btnEntrar.getScene().getWindow();
            stage.close();

            inicialStage.show();
        } else {
            Alert alert = new Alert(AlertType.NONE, "Senha incorreta, tente novamente!", ButtonType.OK);
            alert.show();
            txtRegistro.setText("");
            txtSenha.setText("");
        }
    }

    @FXML
    void initialize() throws FileNotFoundException {
        if (!CarregadorDados.init) {
            CarregadorDados.carregar();
            CarregadorDados.init = true;
            geradorPDF();
        }
    }
}
