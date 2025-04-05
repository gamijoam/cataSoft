package CONTROLADORES;

import ORM.Inventario;
import ORM.Productos;
import ORM.Productoss;
import ORM.VariacionesProducto;
import UTILIDADES.CreadorCodigoUnico;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

public class VentanaVentas {
    @FXML
    private TextField nombreProductoField; //
    @FXML
    private TextField codigoUnicoField; // Crear
    @FXML
    private TextField precioVentaField; //
    @FXML
    private TextField precioCostoField; //
    @FXML
    private TextArea descripcionProductoArea; //
    @FXML
    private TextField categoriaProductoField; //
    @FXML
    private TextField marcaProductoField; //
    @FXML
    private TextField proveedorProductoField; //
    @FXML
    private ComboBox colorProductoCombo; // Este no
    @FXML
    private TextField codigoUnicoVariacionField; // Es no
    @FXML
    private Spinner cantidadStockSpinner; //

    @FXML
    void agregarNuevoColor() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(cat.soft.com.catasoft.VentanaPrincipal.class.getResource("/VENTANAS/ventanaAggColores.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600 , 400);
        scene.getStylesheets().add(getClass().getResource("/css/ventanaAggColores.css").toExternalForm());
        Stage stage = new Stage();
        stage.setTitle("Aplicacion");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void guardarProducto(){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Productoss.class).buildSessionFactory();
        String nombre = nombreProductoField.getText();
        double precioVenta = Double.parseDouble(precioVentaField.getText());
        double precioCosto = Double.parseDouble(precioCostoField.getText());
        String descripcion = descripcionProductoArea.getText();
        String categoria = categoriaProductoField.getText();
        String marca = marcaProductoField.getText();
        String proveedor = proveedorProductoField.getText();
//        int stock = (Integer) cantidadStockSpinner.getValue();
        CreadorCodigoUnico creadorCodigoUnico = new CreadorCodigoUnico();
        String codigo_unicoo = creadorCodigoUnico.crearCodigo(nombre);
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            Productoss producto = new Productoss(nombre,descripcion,codigo_unicoo,precioVenta,precioCosto,categoria,marca,proveedor);
            session.save(producto);
            session.getTransaction().commit();
        }catch (Exception e ){
            System.out.println(e);
            session.getTransaction().rollback();
        }finally {
            nombreProductoField.setText("");
            precioVentaField.setText("");
            precioCostoField.setText("");
            descripcionProductoArea.setText("");
            categoriaProductoField.setText("");
            proveedorProductoField.setText("");
            marcaProductoField.setText("");
            session.close();
            sessionFactory.close();
        }

    }
    @FXML
    void cancelar(){
        System.out.println("Hola");
    }

    @FXML
    void initialize(){
        cantidadStockSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5000,1));
    }
}
