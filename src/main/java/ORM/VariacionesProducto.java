package ORM;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VariacionesProducto")
public class VariacionesProducto {
    @Id
    private int id_variacion;
    private int id_producto;
    private String color;
    private String codigo_unico_variacion;

    public VariacionesProducto() {
    }

    public VariacionesProducto(int id_producto, String color, String codigo_unico_variacion) {
        this.id_producto = id_producto;
        this.color = color;
        this.codigo_unico_variacion = codigo_unico_variacion;
    }

    public int getId_variacion() {
        return id_variacion;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCodigo_unico_variacion() {
        return codigo_unico_variacion;
    }

    public void setCodigo_unico_variacion(String codigo_unico_variacion) {
        this.codigo_unico_variacion = codigo_unico_variacion;
    }

    @Override
    public String toString() {
        return "VariacionesProducto{" +
                "id_variacion=" + id_variacion +
                ", id_producto=" + id_producto +
                ", color='" + color + '\'' +
                ", codigo_unico='" + codigo_unico_variacion + '\'' +
                '}';
    }
}
