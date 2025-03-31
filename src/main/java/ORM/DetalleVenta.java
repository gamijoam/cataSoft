package ORM;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DetalleVenta")
public class DetalleVenta {
    @Id
    private int id_detalle;
    private int id_venta;
    private int id_variacion;
    private int cantidad;
    private double precio_unitario_venta;
    private double subtotal;

    public DetalleVenta() {
    }

    public DetalleVenta(int id_venta, int id_variacion, int cantidad, double precio_unitario_venta, double subtotal) {
        this.id_venta = id_venta;
        this.id_variacion = id_variacion;
        this.cantidad = cantidad;
        this.precio_unitario_venta = precio_unitario_venta;
        this.subtotal = subtotal;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_variacion() {
        return id_variacion;
    }

    public void setId_variacion(int id_variacion) {
        this.id_variacion = id_variacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario_venta() {
        return precio_unitario_venta;
    }

    public void setPrecio_unitario_venta(double precio_unitario_venta) {
        this.precio_unitario_venta = precio_unitario_venta;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" +
                "id_detalle=" + id_detalle +
                ", id_venta=" + id_venta +
                ", id_variacion=" + id_variacion +
                ", cantidad=" + cantidad +
                ", precio_unitario_venta=" + precio_unitario_venta +
                ", subtotal=" + subtotal +
                '}';
    }

}
