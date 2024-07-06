package front.formularios;

import back.dao.UsuarioDAO;
import back.entidades.Usuario;
import front.menu.MenuPrincipal;
import front.util.Pantalla;
import front.util.Teclado;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FormularioUsuario {
    public static void mostrarFormularioListar() throws IOException {

        String[] titulos = {"CODIGO", "NOMBRES", "APELLIDOS", "USUARIO", "CLAVE", "CARGO"};
        Integer[] anchos = {10, 25, 25, 25, 25, 15};

        Pantalla.crearCabeceraTabla(titulos, anchos);
        List<Usuario> listaUsuario = UsuarioDAO.listar();

        Usuario usuario;
        for (int i = 0; i < listaUsuario.size(); i++) {
            usuario = listaUsuario.get(i);

            String data[] = {usuario.codigo, usuario.nombres, usuario.apellidos, usuario.usuario, usuario.contraseña, usuario.cargo};

            Pantalla.crearContenidoTabla(data, anchos);
        }

        System.out.println("");
        Pantalla.crearOpcionMenu("0", "Retornas al Menu Principal");
        Teclado teclado = new Teclado();
        int opcion = teclado.getIntHasta("Ingrese una opcion del menu", 0);

        switch (opcion) {
            case 0:
                MenuPrincipal.mostrarMenuPrincipal();
                break;
            default:

        }

    }

    public static void mostrarFormularioBuscar() throws IOException {
        Teclado teclado = new Teclado();
        String Nombre = teclado.getString("Ingrese el nombre del Usuario a buscar");
        List<Usuario> listaBuscada;
        Usuario usuario = new Usuario();

        if (UsuarioDAO.exist(Nombre)) {
            listaBuscada = UsuarioDAO.BuscarNombre(Nombre);
            String[] titulos = {"CODIGO", "NOMBRES", "APELLIDOS", "USUARIO", "CLAVE", "CARGO"};
            Integer[] anchos = {10, 20, 20, 20, 20, 10};
            Pantalla.crearCabeceraTabla(titulos, anchos);

            for (int i = 0; i < listaBuscada.size(); i++) {
                usuario = listaBuscada.get(i);
                String[] data = {usuario.codigo, usuario.nombres, usuario.apellidos, usuario.usuario, usuario.contraseña, usuario.cargo};
                Pantalla.crearContenidoTabla(data, anchos);
            }

        } else {
            System.out.println("\tEl nombre del usuario ingresado no exite en la base de datos");

        }
        System.out.println("");
        Pantalla.crearOpcionMenu("1", "Volver a realizar la acción");
        Pantalla.crearOpcionMenu("0", "Regresar al Menu Principal");
        int opcion = teclado.getIntHasta("Ingrese una opcion del Menu", 1);

        switch (opcion) {
            case 1:
                FormularioUsuario.mostrarFormularioBuscar();
                break;
            case 0:
                MenuPrincipal.mostrarMenuPrincipal();
                break;
        }

    }

    public static void mostrarFormularioAgregar() throws IOException {
        Teclado teclado = new Teclado();
        Usuario usuario = new Usuario();
        List<Usuario> listaUsuario = UsuarioDAO.listar();
        String codigo = teclado.getCodigoU("CODIGO: ");

        if (!UsuarioDAO.exist(codigo)) {

            String nombre = teclado.getEspecial("NOMBRE: ");
            String apellidos = teclado.get("APELLIDOS: ");
            String usuarios = teclado.get("USUARIO: ");
            String contraseñas = teclado.get("CONTRASEÑA: ");
            String cargos = teclado.getCargo("CARGO (ADMINISTRADOR | CONSUMIDOR): ");
            usuario.codigo = codigo.toUpperCase();
            usuario.nombres = nombre.toUpperCase();
            usuario.apellidos = apellidos.toUpperCase();
            usuario.usuario = usuarios.toUpperCase();
            usuario.contraseña = contraseñas.toUpperCase();
            usuario.cargo = cargos.toUpperCase();
            listaUsuario.add(usuario);
            UsuarioDAO.escribiras(listaUsuario);
            System.out.println("\tProceso Exitoso");

        } else {
            System.out.println("\tEl codigo ingresado ya existe");
            mostrarFormularioAgregar();
        }
        Pantalla.crearOpcionMenu("1", "Volver a realizar la acción");
        Pantalla.crearOpcionMenu("0", "Regresar al Menu Principal");
        int opcion = teclado.getIntHasta("Ingrese una opcion del Menu", 1);

        switch (opcion) {
            case 1:
                FormularioUsuario.mostrarFormularioAgregar();
                break;
            case 0:
                MenuPrincipal.mostrarMenuPrincipal();
                break;
        }
    }

    public static void loginUsuario(String cargo) throws IOException {

    }
}
