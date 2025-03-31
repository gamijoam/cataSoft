package ORM;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "Productos")
public class Productos {
    @Id
    private int id_producto;
    private String nombre;
    private String descripcion;
    private String codigo_unico;
    private double precio_venta;
    private double precio_costo;
    private String categoria;
    private String marca;
    private String proveedor;

    public Productos() {
    }

    public Productos(String nombre, String descripcion, String codigo_unico, double precio_venta, double precio_costo, String categoria, String marca, String proveedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo_unico = codigo_unico;
        this.precio_venta = precio_venta;
        this.precio_costo = precio_costo;
        this.categoria = categoria;
        this.marca = marca;
        this.proveedor = proveedor;
    }

    public int getId_producto() {
        return id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo_unico() {
        return codigo_unico;
    }

    public void setCodigo_unico(String codigo_unico) {
        this.codigo_unico = codigo_unico;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public double getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(double precio_costo) {
        this.precio_costo = precio_costo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "id_producto=" + id_producto +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", codigo_unico='" + codigo_unico + '\'' +
                ", precio_venta=" + precio_venta +
                ", precio_costo=" + precio_costo +
                ", categoria='" + categoria + '\'' +
                ", marca='" + marca + '\'' +
                ", proveedor='" + proveedor + '\'' +
                '}';
    }
}
