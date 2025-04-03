package CONTROLADORES;

import ORM.Inventario;
import ORM.Productos;
import ORM.VariacionesProducto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.util.List;

public class VentanaAggColores {
    @FXML
    private ListView listaProductos;
    @FXML
    private Spinner selectorStock;
    @FXML
    private TextField campoColor;
    private String productoSeleccionado;

    @FXML
    private void realizarVenta(){
//        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Productos.class).buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        VariacionesProducto variacionesProducto = new VariacionesProducto();
//        variacionesProducto.setProducto(obtenerIdProducto());
//        variacionesProducto.setColor(campoColor.getText());
//        variacionesProducto.setCodigoUnicoVariacion("ggggg");
//        session.save(variacionesProducto);
//        session.getTransaction().commit();
//        session.close();
//        sessionFactory.close();
        int stock = (Integer) cantidadStockSpinner.getValue();
    }

    public Productos obtenerIdProducto(){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Productos.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "SELECT id_producto FROM Productos WHERE nombre = :valor";
        Query<Integer> numero = session.createQuery(hql, Integer.class);
        numero.setParameter("valor",productoSeleccionado);
        int count = numero.uniqueResult();
        Productos productos = session.get(Productos.class,count);
        session.close();
        sessionFactory.close();
        return productos;
    }


    @FXML
    void listarProductos(){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Productos.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "SELECT nombre FROM Productos";
        Query <String>  query = session.createQuery(hql,String.class);
        List<String> nombres = query.list();
        ObservableList<String> observablesProductos = FXCollections.observableArrayList(nombres);
        listaProductos.setItems(observablesProductos);
        listaProductos.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2) {
                productoSeleccionado = (String) listaProductos.getSelectionModel().getSelectedItem();
                System.out.println("Producto seleccionado (doble clic): " + productoSeleccionado);
                // Aquí puedes realizar acciones con el producto seleccionado
            }
        });
        session.close();
        sessionFactory.close();
    }
    @FXML
    void initialize(){
        listarProductos();
        selectorStock.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5000,1));
    }
}
