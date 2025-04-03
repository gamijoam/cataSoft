package ORM;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private Integer idInventario;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_variacion", nullable = false, unique = true)
    private VariacionesProducto variacionProducto;

    @Column(name = "cantidad_stock", nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer cantidadStock;

    @Column(name = "ultima_actualizacion", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp ultimaActualizacion;

    // Constructor vacío
    public Inventario() {
    }

    // Getters y setters

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public VariacionesProducto getVariacionProducto() {
        return variacionProducto;
    }

    public void setVariacionProducto(VariacionesProducto variacionProducto) {
        this.variacionProducto = variacionProducto;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Timestamp getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(Timestamp ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }
}