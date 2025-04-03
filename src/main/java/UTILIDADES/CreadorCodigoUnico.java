package UTILIDADES;

import ORM.Productos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Random;

public class CreadorCodigoUnico {
    public static void main(String[] args) {
        CreadorCodigoUnico creadorCodigoUnico = new CreadorCodigoUnico();
        String m = creadorCodigoUnico.crearCodigo("BOLIGRAFO UNIVIVERSAL DE PROPI");
        boolean i = creadorCodigoUnico.verificarExistenciaDato(m);
    }

    public boolean verificarExistenciaDato(String dato){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Productos.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "SELECT COUNT(*) FROM Productos WHERE codigo_unico = :valor";
        Query<Long> query = session.createQuery(hql, Long.class);
        query.setParameter("valor", dato);
        Long count = query.uniqueResult();
        session.close();
        sessionFactory.close();
        return count > 0;
    }

     public String crearCodigo(String cadena){
        Random random = new Random(System.currentTimeMillis());
        int numero = random.nextInt(100);
        String cadena2;
        String cadena3;
        String cadena4;
        cadena2 = cadena.substring(0,4);
        System.out.println(cadena2);
        int vacio = cadena.indexOf(" ");
        cadena3 = cadena.substring(vacio+1,vacio+5);
        System.out.println(cadena3);
        cadena4 = cadena2 + "-" + cadena3 + "-" + numero;
        return cadena4;
    }
}
