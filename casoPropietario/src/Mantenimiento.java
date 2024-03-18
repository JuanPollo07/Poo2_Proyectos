import java.util.Date;

public class Mantenimiento extends Gasto {
    private String id_mantenimiento;
    private String responsable;

    public Mantenimiento(int id_gasto, Date fecha, float valor, String descripcion, String id_mantenimiento, String responsable) {
        super(id_gasto, fecha, valor, descripcion);
        this.id_mantenimiento = id_mantenimiento;
        this.responsable = responsable;
    }

    public String getInformacion() {
        return super.getInformacion() + "\nID Mantenimiento: " + id_mantenimiento +
                "\nResponsable: " + responsable;
    }
}