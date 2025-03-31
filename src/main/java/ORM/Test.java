package ORM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        Timestamp timestamp = Timestamp.from(Instant.now());
        test.ingresarInventario(800);

    }
    public void consultar(){
        // Crear la fábrica de sesiones
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Productos.class)
                .buildSessionFactory();

        // Abrir una sesión
        Session session = factory.openSession();

        try {
            // Iniciar transacción
            session.beginTransaction();

            // Recuperar el producto con ID 1
            Productos productoRecuperado = session.get(Productos.class, 1);
            if (productoRecuperado != null) {
                System.out.println("Este es el producto: " + productoRecuperado);
            } else {
                System.out.println("No se encontró un producto con ID 1");
            }

            // Confirmar transacción
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
            factory.close();
        }
    }

    public void ingresar(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Productos.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        try{
            session.beginTransaction();
            LocalDateTime hora = LocalDateTime.now();
            Productos productos = new Productos("Boligrafo","PUNTA FINA","BOLI-FINA-001",1.2,5,"LAPIZ","SHARP","");
            System.out.println("Producto ingresado exitosamente" + productos);
            session.save(productos);
            session.getTransaction().commit();
        }
        catch (Exception e ){
            System.out.println("Ingreso un dato repetido");
            session.getTransaction().rollback();
        }
        finally {
            session.close();
            factory.close();
        }
    }

//    public void actualizar(){
//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Productos.class)
//                .buildSessionFactory();
//
//        Session session = factory.openSession();
//
//        try{
//            session.beginTransaction();
//            Productos productos = session.get(Productos.class,1);
//            productos.setNombre("Televisor HD 25 PULGADAS");
//            productos.setStock(100);
//            session.getTransaction().commit();
//            System.out.println("Item actualizado");
//        }catch (Exception e ){
//            System.out.println("Problemas");
//            session.getTransaction().rollback();
//        }finally {
//            session.close();
//            factory.close();
//        }
//    }
    public void eliminar(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Productos.class)
                .buildSessionFactory();
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            Productos productos = session.get(Productos.class,1);
            session.delete(productos);
            session.getTransaction().commit();
            System.out.println("Item Eliminado");
        }catch (Exception e ){
            System.out.println("Problemas");
            session.getTransaction().rollback();
        }finally {
            session.close();
            factory.close();
        }
    }
    public void consultarVariacion(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(VariacionesProducto.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try{
            session.beginTransaction();
            VariacionesProducto variacionesProducto = session.get(VariacionesProducto.class,1);
            if (variacionesProducto != null){
                System.out.println("Este es la variacion : " + variacionesProducto);
            }else {
                System.out.println("NO se encuentra");
            }
        }catch (Exception e){
            System.out.println("Una excepcion" );
            session.getTransaction().rollback();
        }finally {
            session.close();
            factory.close();
        }
    }

    public void ingresarInventario(int numero){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Inventario.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();
            Inventario inventario = session.get(Inventario.class,1);
            inventario.setCantidad_stock(numero);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
            session.getTransaction().rollback();
        }finally {
            session.close();
            factory.close();
        }
    }
}