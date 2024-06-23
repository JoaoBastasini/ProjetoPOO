package br.unesp.poo.grupo03.projeto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    private TextField txtSenha;

    @FXML
    void onClickEntrar(ActionEvent event) {
        String registro = txtRegistro.getText();
        String senha = txtSenha.getText();
        login(registro, senha);
    }
    
    void login(String registro, String senha){
        if (registro.equals("123") && senha.equals("123")){
            btnEntrar.setText("ablublubluble");
        }
    }

    //@Override
    //public void initialize(URL url, ResourceBundle rb) {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}

}
