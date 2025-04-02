package CONTROLADORES;

import ORM.Productos;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;

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
    void agregarNuevoColor(){
        System.out.println("Hola");
    }

    @FXML
    void guardarProducto(){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Productos.class).buildSessionFactory();
        String nombre = nombreProductoField.getText();
        double precioVenta = Double.parseDouble(precioVentaField.getText());
        double precioCosto = Double.parseDouble(precioCostoField.getText());
        String descripcion = descripcionProductoArea.getText();
        String categoria = categoriaProductoField.getText();
        String marca = marcaProductoField.getText();
        String proveedor = proveedorProductoField.getText();
        int stock = (Integer) cantidadStockSpinner.getValue();

//        System.out.println(nombre + " " +  " " +  " " + precioVenta + " "  + " " + precioCosto + " "+ descripcion
//                + " " + categoria + " " + marca + " " + proveedor + " " +  stock);

        //Abrir la sesion
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            LocalDateTime hora = LocalDateTime.now();
            Productos producto = new Productos(nombre,descripcion,"juju-002",precioVenta,precioCosto,categoria,marca,proveedor);
            session.save(producto);
            session.getTransaction().commit();
        }catch (Exception e ){
            System.out.println(e);
            session.getTransaction().rollback();
        }finally {
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
