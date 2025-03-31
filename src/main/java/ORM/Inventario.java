package ORM;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "Inventario")
public class Inventario {
    @Id
    private int id_inventario;
    private int id_variacion;
    private  int cantidad_stock;
    private Timestamp ultima_actualizacion;

    public Inventario() {
    }

    public Inventario(int id_variacion, int cantidad_stock, Timestamp ultima_actualizacion) {
        this.id_variacion = id_variacion;
        this.cantidad_stock = cantidad_stock;
        this.ultima_actualizacion = ultima_actualizacion;
    }

    public int getId_inventario() {
        return id_inventario;
    }

    public int getId_variacion() {
        return id_variacion;
    }

    public void setId_variacion(int id_variacion) {
        this.id_variacion = id_variacion;
    }

    public int getCantidad_stock() {
        return cantidad_stock;
    }

    public void setCantidad_stock(int cantidad_stock) {
        this.cantidad_stock = cantidad_stock;
    }

    public Timestamp getUltima_actualizacion() {
        return ultima_actualizacion;
    }

    public void setUltima_actualizacion(Timestamp ultima_actualizacion) {
        this.ultima_actualizacion = ultima_actualizacion;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "id_inventario=" + id_inventario +
                ", id_variacion=" + id_variacion +
                ", cantidad_stock=" + cantidad_stock +
                ", ultima_actualizacion=" + ultima_actualizacion +
                '}';
    }
}
