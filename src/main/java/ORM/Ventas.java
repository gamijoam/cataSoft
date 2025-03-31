package ORM;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "Ventas")
public class Ventas {
    @Id
    private int id_venta;
    private Date fecha_venta;
    private Time hora_venta;
    private int id_tasa_cambio;
    private double total_venta_local;
    private String metodo_pago;

    public Ventas() {
    }

    public Ventas(Date fecha_venta, Time hora_venta, int id_tasa_cambio, double total_venta_local, String metodo_pago) {
        this.fecha_venta = fecha_venta;
        this.hora_venta = hora_venta;
        this.id_tasa_cambio = id_tasa_cambio;
        this.total_venta_local = total_venta_local;
        this.metodo_pago = metodo_pago;
    }

    public int getId_venta() {
        return id_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Time getHora_venta() {
        return hora_venta;
    }

    public void setHora_venta(Time hora_venta) {
        this.hora_venta = hora_venta;
    }

    public int getId_tasa_cambio() {
        return id_tasa_cambio;
    }

    public void setId_tasa_cambio(int id_tasa_cambio) {
        this.id_tasa_cambio = id_tasa_cambio;
    }

    public double getTotal_venta_local() {
        return total_venta_local;
    }

    public void setTotal_venta_local(double total_venta_local) {
        this.total_venta_local = total_venta_local;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    @Override
    public String toString() {
        return "Ventas{" +
                "id_venta=" + id_venta +
                ", fecha_venta=" + fecha_venta +
                ", hora_venta=" + hora_venta +
                ", id_tasa_cambio=" + id_tasa_cambio +
                ", total_venta_local=" + total_venta_local +
                ", metodo_pago='" + metodo_pago + '\'' +
                '}';
    }
}
