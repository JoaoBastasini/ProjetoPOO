module br.unesp.poo.grupo03.projeto {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires org.apache.commons.collections4;

    opens br.unesp.poo.grupo03.projeto to javafx.fxml;
    exports br.unesp.poo.grupo03.projeto;
}