package front.menu;

import front.formularios.FormularioUsuario;
import front.util.Pantalla;

import java.io.IOException;

public class MenuUsuario {

    public static void mostrarMenuListarUsuarios() throws IOException{
        Pantalla.limpiarPantalla();
        Pantalla.crearMenu("Listar usuarios");
        FormularioUsuario.mostrarFormularioListar();
    }
    public static void mostrarMenuBuscarUsuarios () throws IOException{
        Pantalla.limpiarPantalla();
        Pantalla.crearMenu("Buscar Usuarios");
        FormularioUsuario.mostrarFormularioBuscar();
    }

    public static void mostrarMenuAgregarUsuarios() throws IOException {
        Pantalla.limpiarPantalla();
        Pantalla.crearMenu("Agregar Usuarios");
        FormularioUsuario.mostrarFormularioAgregar();
    }
}
