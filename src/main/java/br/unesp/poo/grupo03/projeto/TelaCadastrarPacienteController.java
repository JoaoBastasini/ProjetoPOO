package br.unesp.poo.grupo03.projeto;

import br.unesp.poo.grupo03.projeto.modelo.Nutricionista;
import br.unesp.poo.grupo03.projeto.modelo.Objetivo;
import br.unesp.poo.grupo03.projeto.modelo.Paciente;
import br.unesp.poo.grupo03.projeto.repositorio.NutricionistaRepositorio;
import br.unesp.poo.grupo03.projeto.repositorio.PacienteRepositorio;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.NumberStringConverter;

public class TelaCadastrarPacienteController {

    private final NutricionistaRepositorio nr = new NutricionistaRepositorio();
    private final PacienteRepositorio pr = new PacienteRepositorio();

    @FXML
    private ComboBox<String> ComboBoxObjetivo;

    @FXML
    private ComboBox<String> ComboBoxSexo;

    @FXML
    private Button btnSalvar;

    @FXML
    private Label lblTitulo;

    @FXML
    private TextField txtAlturaPaciente;

    @FXML
    private TextField txtCpfPaciente;

    @FXML
    private TextField txtEmailPaciente;

    @FXML
    private TextField txtIdadePaciente;

    @FXML
    private TextField txtNomePaciente;

    @FXML
    private TextField txtPesoPaciente;

    @FXML
    void onClickBtnSalvar(ActionEvent event) throws IOException {
        if (!System.getProperty("cpfPacienteSelecionado").equals("novo.paciente")) {
            pr.remover(System.getProperty("cpfPacienteSelecionado"));
        }
        String nome = txtNomePaciente.getText();
        String email = txtEmailPaciente.getText();
        String cpf = txtCpfPaciente.getText();
        int idade = Integer.parseInt(txtIdadePaciente.getText());
        float altura = Float.parseFloat(txtAlturaPaciente.getText());
        float peso = Float.parseFloat(txtPesoPaciente.getText());
        String sexo = ComboBoxSexo.getSelectionModel().getSelectedItem();
        String objetivo = ComboBoxObjetivo.getSelectionModel().getSelectedItem();
        boolean masculino = false;
        Nutricionista nutricionista = nr.buscar(System.getProperty("login"));
        masculino = (sexo.equals("Masculino")) ? true : false;
        Objetivo ob = new Objetivo();
        switch (objetivo) {
            case "Ganhar Peso":
                ob.setGanharPeso(true);
                break;
            case "Perder Peso":
                ob.setPerderPeso(true);
                break;
            case "Manter Peso":
                ob.setManutencaoPeso(true);
                break;
        }
        Paciente novoPaciente = new Paciente(peso, idade, altura, cpf, ob, nutricionista, nome, email, masculino);
        pr.adicionar(novoPaciente);

        chamarTela("telaInicial.fxml", (Stage) btnSalvar.getScene().getWindow());
    }

    void chamarTela(String nome, Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(nome));
        Stage inicialStage = new Stage();
        inicialStage.initStyle(StageStyle.DECORATED);
        inicialStage.setScene(new Scene(root));

        stage.close();

        inicialStage.show();
    }

    @FXML
    void initialize() {
        txtIdadePaciente.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        txtPesoPaciente.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        txtAlturaPaciente.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        String cpfPaciente = System.getProperty("cpfPacienteSelecionado");

        ComboBoxObjetivo.getItems().addAll("Ganhar Peso", "Perder Peso", "Manter Peso");
        ComboBoxSexo.getItems().addAll("Masculino", "Feminíno");

        if (cpfPaciente.equals("novo.paciente")) {
            btnSalvar.setText("Cadastrar");
        } else {
            Paciente p = pr.buscar(cpfPaciente);
            txtNomePaciente.setText(p.getNome());
            txtEmailPaciente.setText(p.getEmail());
            txtCpfPaciente.setText(p.getCpfSemFormatacao());
            txtIdadePaciente.setText(String.valueOf(p.getIdade()));
            txtPesoPaciente.setText(String.valueOf(p.getPeso() / 10));
            txtAlturaPaciente.setText(String.valueOf(p.getAlturaMetros() / 100));
            if (p.getObjetivo().isGanharPeso()) {
                ComboBoxObjetivo.setValue("Ganhar Peso");
            } else if (p.getObjetivo().isPerderPeso()) {
                ComboBoxObjetivo.setValue("Perder Peso");

            } else if (p.getObjetivo().isManutencaoPeso()) {
                ComboBoxObjetivo.setValue("Manter Peso");
            }

            if (p.isSexoMasculino()) {
                ComboBoxSexo.setValue("Masculino");
            } else {
                ComboBoxSexo.setValue("Feminíno");
            }
            btnSalvar.setText("Alterar");

        }
    }

}
