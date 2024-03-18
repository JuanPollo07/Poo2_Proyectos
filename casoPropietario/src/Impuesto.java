import java.util.Date;

public class Impuesto extends Gasto {
    private String id_impuesto;
    private String nombre;
    private String estado;

    public Impuesto(int id_gasto, Date fecha, float valor, String descripcion, String id_impuesto, String nombre, String estado) {
        super(id_gasto, fecha, valor, descripcion);
        this.id_impuesto = id_impuesto;
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getInformacion() {
        return super.getInformacion() + "\nID Impuesto: " + id_impuesto +
                "\nNombre: " + nombre + "\nEstado: " + estado;
    }
}