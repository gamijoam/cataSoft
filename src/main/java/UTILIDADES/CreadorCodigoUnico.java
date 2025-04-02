package UTILIDADES;

import ORM.Productos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreadorCodigoUnico {
    public static void main(String[] args) {
        String cadena = "BOLIGRAFO UNIVERSAL";
        String cadena2;
        String cadena3;
        String cadena4;


        cadena2 = cadena.substring(0,4);
        System.out.println(cadena2);
        int vacio = cadena.indexOf(" ");
        cadena3 = cadena.substring(vacio+1,vacio+5);
        System.out.println(cadena3);
        cadena4 = cadena2 + "-" + cadena3;
        System.out.println(cadena4);
    }

    void verificarCodigo(){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Productos.class).buildSessionFactory();

        Session session = sessionFactory.openSession();

        try{
            session.beginTransaction();

        }
    }
}
