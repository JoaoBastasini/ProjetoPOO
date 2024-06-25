module br.unesp.poo.grupo03.projeto {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires org.apache.commons.collections4;
    requires kernel;
    requires layout;
    requires io;
    requires java.base;
    requires javafx.base;
    requires javafx.graphics;
    
    opens br.unesp.poo.grupo03.projeto to javafx.fxml;
    exports br.unesp.poo.grupo03.projeto;
}
