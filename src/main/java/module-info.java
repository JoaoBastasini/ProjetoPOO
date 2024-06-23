module br.unesp.poo.grupo03.projeto {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.unesp.poo.grupo03.projeto to javafx.fxml;
    exports br.unesp.poo.grupo03.projeto;
}
