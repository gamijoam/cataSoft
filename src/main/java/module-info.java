module cat.soft.com.catasoft {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    requires java.desktop;           // Necesario para JDBC

    opens ORM to org.hibernate.orm.core;
    opens cat.soft.com.catasoft to javafx.fxml;
    opens CONTROLADORES to javafx.fxml; // Agregado para permitir acceso de javafx.fxml
    exports cat.soft.com.catasoft;
    exports CONTROLADORES; // Agregado para exportar el paquete CONTROLADORES
}