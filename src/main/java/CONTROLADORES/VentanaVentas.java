package CONTROLADORES;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
        String nombre = nombreProductoField.getText();
        double precioVenta = Double.parseDouble(precioVentaField.getText());
        double precioCosto = Double.parseDouble(precioCostoField.getText());
        String descripcion = descripcionProductoArea.getText();
        String categoria = categoriaProductoField.getText();
        String marca = marcaProductoField.getText();
        String proveedor = proveedorProductoField.getText();
        //int stock = (int) cantidadStockSpinner.getValue();

        System.out.println(nombre + " " +  " " +  " " + precioVenta + " "  + " " + precioCosto + " "+ descripcion
                + " " + categoria + " " + marca + " " + proveedor + " " );

    }
    @FXML
    void cancelar(){
        System.out.println("Hola");
    }
}
