package CONTROLADORES;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaPrincipal {
    @FXML
    void agregarProducto(){
        System.out.println("Hola");
    }
    @FXML
    void eliminarProducto(){
        System.out.println("h");
    }
    @FXML
    void modificarProducto(){
        System.out.println("Hola");
    }
    @FXML
    void venta() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(cat.soft.com.catasoft.VentanaPrincipal.class.getResource("/VENTANAS/ventanaVentas.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800 , 600);
        scene.getStylesheets().add(getClass().getResource("/css/ventanaVentas.css").toExternalForm());
        Stage stage = new Stage();
        stage.setTitle("Aplicacion");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void inventario(){
        System.out.println("Venta");
    }
}
