public class Propietario extends Persona {
    private static int contadorIds = 1;
    private String id_Propietario;

    public Propietario(int documento, String nombres, String apellidos, int edad) {
        super(documento, nombres, apellidos, edad);
        this.id_Propietario = generarIdUnico();
    }
    private String generarIdUnico() {
        String formato = "PID%02d";
        String id = String.format(formato, contadorIds);
        contadorIds++;
        return id;
    }
    public String getId_Propietario() {
        return id_Propietario;
    }

}