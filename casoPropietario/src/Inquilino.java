public class Inquilino extends Persona {
    private String id_Inquilino;
    private String numeroContrato;
    private String telefono;
    private String correo;

    public Inquilino(int documento, String nombres, String apellidos, int edad, String id_Inquilino, String numeroContrato, String telefono, String correo) {
        super(documento, nombres, apellidos, edad);
        this.id_Inquilino = id_Inquilino;
        this.numeroContrato = numeroContrato;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getInformacion() {
        return "ID Inquilino: " + id_Inquilino + "\nNúmero de Contrato: " + numeroContrato +
                "\nTeléfono: " + telefono + "\nCorreo: " + correo;
    }
}