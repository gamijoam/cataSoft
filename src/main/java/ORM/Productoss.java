package ORM;

import javax.persistence.*;

@Entity
@Table(name="Productos")
public class Productoss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int producto;
    private String nombre;
    private String descripcion;
    private String codigo_unico;
    private double precio_venta;
    private double precio_costo;
    private String categoria;
    private String marca;
    private String proveedor;


    public Productoss() {
    }

    public Productoss(String nombre, String descripcion, String codigo_unico, double precio_venta, double precio_costo, String categoria, String marca, String proveedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo_unico = codigo_unico;
        this.precio_venta = precio_venta;
        this.precio_costo = precio_costo;
        this.categoria = categoria;
        this.marca = marca;
        this.proveedor = proveedor;
    }

    public int getProducto() {
        return producto;
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
}
