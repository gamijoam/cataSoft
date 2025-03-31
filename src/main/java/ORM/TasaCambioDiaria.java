package ORM;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TasaCambioDiaria")
public class TasaCambioDiaria {
    @Id
    private int id_tasa_cambio;
    private Date fecha_tasa;
    private double tasa_cambio_usd;

    public TasaCambioDiaria() {
    }

    public TasaCambioDiaria(Date fecha_tasa, double tasa_cambio_usd) {
        this.fecha_tasa = fecha_tasa;
        this.tasa_cambio_usd = tasa_cambio_usd;
    }

    public int getId_tasa_cambio() {
        return id_tasa_cambio;
    }

    public Date getFecha_tasa() {
        return fecha_tasa;
    }

    public void setFecha_tasa(Date fecha_tasa) {
        this.fecha_tasa = fecha_tasa;
    }

    public double getTasa_cambio_usd() {
        return tasa_cambio_usd;
    }

    public void setTasa_cambio_usd(double tasa_cambio_usd) {
        this.tasa_cambio_usd = tasa_cambio_usd;
    }

    @Override
    public String toString() {
        return "TasaCambioDiaria{" +
                "id_tasa_cambio=" + id_tasa_cambio +
                ", fecha_tasa=" + fecha_tasa +
                ", tasa_cambio_usd=" + tasa_cambio_usd +
                '}';
    }
}
