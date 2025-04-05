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
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.query.Query;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.List;

public class VentanaAggColores {
    @FXML
    private ListView listaProductos;
    @FXML
    private Spinner selectorStock;
    @FXML
    private TextField campoColor;
    private String productoSeleccionado;

    private static SessionFactory sessionFactory; // Mantener una única instancia de SessionFactory

    // Inicializar SessionFactory al cargar la clase (o en algún punto inicial de la aplicación)
    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Productos.class)
                    .addAnnotatedClass(VariacionesProducto.class)
                    .addAnnotatedClass(Inventario.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Método para obtener una sesión (asegúrate de cerrarla después de usarla)
    public Session getSession() {
        return sessionFactory.openSession();
    }
    public String generarCodigoUnicoDeVariacion(Session session){
        Productos productos = obtenerProductoPorNombre(session,productoSeleccionado);
        String codigo = productos.getCodigo_unico();
        String nuevo_codigo = codigo + "-"+campoColor.getText();
        return nuevo_codigo;
    }
    @FXML
    private void realizarVenta(){
//        Session session = getSession();
//        generarCodigoUnicoDeVariacion(session);
        int stock = (Integer) selectorStock.getValue();
        Session session = getSession(); // Obtener la sesión
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Productos producto = obtenerProductoPorNombre(session, productoSeleccionado);
            if (producto != null) {
                Instant now = Instant.now();
                Timestamp st = Timestamp.from(now); // Conversión directa desde Instant
                VariacionesProducto nuevaVariacion = new VariacionesProducto();
                nuevaVariacion.setProducto(producto);
                nuevaVariacion.setColor(campoColor.getText());
                nuevaVariacion.setCodigoUnicoVariacion(generarCodigoUnicoDeVariacion(session)); // Deberías generar un código único más robusto

                session.save(nuevaVariacion);

                Inventario nuevoInventario = new Inventario();
                nuevoInventario.setVariacionProducto(nuevaVariacion);
                nuevoInventario.setCantidadStock(stock);
                nuevoInventario.setUltimaActualizacion(st);
                session.save(nuevoInventario);

                transaction.commit();
                System.out.println("Producto, variación y stock agregados correctamente.");
                campoColor.setText("");
       //         System.out.println(time);
            } else {
                System.out.println("No se encontró el producto seleccionado.");
                transaction.rollback(); // Hacer rollback si no se encontró el producto
            }

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close(); // Cerrar la sesión en el bloque finally
            }
        }
    }

    public Productos obtenerProductoPorNombre(Session session, String nombreProducto) {
        String hql = "FROM Productos p WHERE p.nombre = :valor";
        Query<Productos> query = session.createQuery(hql, Productos.class);
        query.setParameter("valor", nombreProducto);
        return query.uniqueResult();
    }


    @FXML
    void listarProductos(){
        Session session = getSession();
        try {
            String hql = "SELECT nombre FROM Productos";
            Query<String> query = session.createQuery(hql, String.class);
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
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @FXML
    void initialize(){
        listarProductos();
        selectorStock.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,5000,1));
    }
}