package br.unesp.poo.grupo03.projeto;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    
    void login(String registro, String senha) throws IOException{
        if (registro.equals("123") && senha.equals("123")){
            Parent root = FXMLLoader.load(getClass().getResource("telaInicial.fxml"));
            Stage inicialStage = new Stage();
            inicialStage.initStyle(StageStyle.DECORATED);
            inicialStage.setScene(new Scene(root));
            
            Stage stage = (Stage) btnEntrar.getScene().getWindow();
            stage.close();
            
            inicialStage.show();
        }
    }

    //@Override
    //public void initialize(URL url, ResourceBundle rb) {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}

}
