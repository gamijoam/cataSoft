package cat.soft.com.catasoft;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaPrincipal extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VentanaPrincipal.class.getResource("/VENTANAS/ventanaPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 310);
        scene.getStylesheets().add(getClass().getResource("/css/ventanaPrincipal.css").toExternalForm());
        stage.setTitle("Aplicacion");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}