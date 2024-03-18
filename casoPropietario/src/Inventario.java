import java.util.Date;

public class Inventario {
    private int id_inventario;
    private Date fecha;

    public Inventario(int id_inventario, Date fecha) {
        this.id_inventario = id_inventario;
        this.fecha = fecha;
    }

    public String getReporte() {
        return "ID Inventario: " + id_inventario + "\nFecha: " + fecha.toString();
    }
}