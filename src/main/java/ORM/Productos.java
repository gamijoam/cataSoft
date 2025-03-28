package ORM;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "productos")
public class Productos {
    @Id
    private int id_producto;
    private String codigo;
    private String nombre;
    private double precio_unidad;
    private double precio_caja;
    private int stock;
    private int id_categoria;
    private String ruta_imagen;
    private LocalDateTime fecha_registro;

    public Productos() {
    }

    public Productos(String codigo, String nombre, double precio_unidad, double precio_caja, int stock, int id_categoria, String ruta_imagen, LocalDateTime fecha_registro) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio_unidad = precio_unidad;
        this.precio_caja = precio_caja;
        this.stock = stock;
        this.id_categoria = id_categoria;
        this.ruta_imagen = ruta_imagen;
        this.fecha_registro = fecha_registro;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio_unidad() {
        return precio_unidad;
    }

    public void setPrecio_unidad(double precio_unidad) {
        this.precio_unidad = precio_unidad;
    }

    public double getPrecio_caja() {
        return precio_caja;
    }

    public void setPrecio_caja(double precio_caja) {
        this.precio_caja = precio_caja;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getRuta_imagen() {
        return ruta_imagen;
    }

    public void setRuta_imagen(String ruta_imagen) {
        this.ruta_imagen = ruta_imagen;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "id_producto=" + id_producto +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio_unidad=" + precio_unidad +
                ", precio_caja=" + precio_caja +
                ", stock=" + stock +
                ", id_categoria=" + id_categoria +
                ", ruta_imagen='" + ruta_imagen + '\'' +
                ", fecha_registro=" + fecha_registro +
                '}';
    }
}
