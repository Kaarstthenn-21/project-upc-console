package back.entidades;

public class Asistencia {
    public String codigoUsuario;
    public String fechaAsistencia;
    public String horaIngreso;
    public String horaSalida;
    public String tipoAsistencia;

    // Constructor
    public Asistencia(String codigoUsuario, String fechaAsistencia, String horaIngreso, String horaSalida, String tipoAsistencia) {
        this.codigoUsuario = codigoUsuario;
        this.fechaAsistencia = fechaAsistencia;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
        this.tipoAsistencia = tipoAsistencia;
    }

    // Constructor vacío
    public Asistencia() {
    }
}
