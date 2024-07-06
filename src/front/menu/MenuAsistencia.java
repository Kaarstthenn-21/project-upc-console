package front.menu;

import front.util.Pantalla;
import front.formularios.FormularioAsistencia;
import front.util.Teclado;

import java.io.IOException;

public class MenuAsistencia {
    public static void mostrarMenuListarAsistencias() throws IOException {
        Pantalla.limpiarPantalla();
        Pantalla.crearMenu("Listar Asistencias");
        FormularioAsistencia.mostrarFormularioListar();
    }

    public static void mostrarMenuBuscarAsistencias() throws IOException {
        Pantalla.limpiarPantalla();
        Pantalla.crearMenu("Buscar Asistencias");
        FormularioAsistencia.mostrarFormularioBuscar();
    }

    public static void mostrarMenuAgregarAsistencias() throws IOException {
        Pantalla.limpiarPantalla();
        Pantalla.crearMenu("Agregar Asistencias");
        FormularioAsistencia.mostrarFormularioAgregar();
    }

    public static void mostrarMenuTotalAsistencias() throws IOException {
        Pantalla.limpiarPantalla();
        Pantalla.crearMenu("Total de Asistencias");
        FormularioAsistencia.mostrarFormularioTotalAsistencias();
        volverMenuPrincipal();
    }

    public static void mostrarMenuAsistenciasPorUsuario() throws IOException {
        Pantalla.limpiarPantalla();
        Pantalla.crearMenu("Asistencias por Usuario");
        FormularioAsistencia.mostrarFormularioAsistenciasPorUsuario();
        volverMenuPrincipal();
    }

    public static void mostrarMenuUsuariosSinAsistencia() throws IOException {
        Pantalla.limpiarPantalla();
        Pantalla.crearMenu("Usuarios sin Asistencia");
        FormularioAsistencia.mostrarFormularioUsuariosSinAsistencia();
        volverMenuPrincipal();
    }

    public static void mostrarMenuAsistenciasPorTipo() throws IOException {
        Pantalla.limpiarPantalla();
        Pantalla.crearMenu("Asistencias por Tipo");
        FormularioAsistencia.mostrarFormularioAsistenciasPorTipo();
        volverMenuPrincipal();
    }

    public static void mostrarMenuPrimerUltimoRegistro() throws IOException {
        Pantalla.limpiarPantalla();
        Pantalla.crearMenu("Primer y Último Registro");
        FormularioAsistencia.mostrarFormularioPrimerUltimoRegistro();
        volverMenuPrincipal();
    }

    private static void volverMenuPrincipal() throws IOException {
        Pantalla.crearOpcionMenu("0", "Volver al Menú Principal");
        Teclado teclado = new Teclado();
        int opcion = teclado.getIntHasta("Ingrese una opción del menú", 0);

        switch (opcion) {
            case 0:
                MenuPrincipal.mostrarMenuPrincipal();
                break;
            default:
        }
    }
}
