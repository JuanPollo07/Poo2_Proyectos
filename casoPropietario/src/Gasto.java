import java.util.Date;

public class Gasto {
    private int id_gasto;
    private Date fecha;
    private float valor;
    private String descripcion;

    public Gasto(int id_gasto, Date fecha, float valor, String descripcion) {
        this.id_gasto = id_gasto;
        this.fecha = fecha;
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public String getInformacion() {
        return "ID Gasto: " + id_gasto + "\nFecha: " + fecha.toString() +
                "\nValor: " + valor + "\nDescripción: " + descripcion;
    }
}