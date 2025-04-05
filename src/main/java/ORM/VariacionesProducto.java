package ORM;

import javax.persistence.*;

@Entity
@Table(name = "VariacionesProducto")
public class VariacionesProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_variacion")
    private Integer idVariacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false)
    private Productos producto;

    @Column(name = "color", nullable = false, length = 50)
    private String color;

    @Column(name = "codigo_unico_variacion", unique = true, nullable = false, length = 50)
    private String codigoUnicoVariacion;

    @OneToOne(mappedBy = "variacionProducto", cascade = CascadeType.ALL, orphanRemoval = true)
    private Inventario inventario;

    // Constructor vacío
    public VariacionesProducto() {
    }

    // Getters y setters

    public Integer getIdVariacion() {
        return idVariacion;
    }

    public void setIdVariacion(Integer idVariacion) {
        this.idVariacion = idVariacion;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCodigoUnicoVariacion() {
        return codigoUnicoVariacion;
    }

    public void setCodigoUnicoVariacion(String codigoUnicoVariacion) {
        this.codigoUnicoVariacion = codigoUnicoVariacion;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
}