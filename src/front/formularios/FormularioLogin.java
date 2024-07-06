package front.formularios;

import back.dao.UsuarioDAO;
import back.entidades.Usuario;
import front.menu.MenuLogin;
import front.menu.MenuPrincipal;
import front.util.Pantalla;
import front.util.Teclado;

import java.io.IOException;

public class FormularioLogin {
    public static void mostrarFormularioLogin() throws IOException {
        Pantalla.limpiarPantalla();
        Teclado teclado = new Teclado();
        Pantalla.crearMenu("login");

        System.out.println("");

        String tab = "\t\t\t\t";

        String login = teclado.getStringLogin("Ingrese su Usuario :", tab);
        String clave = teclado.getStringLogin("Ingrese su Contraseña :", tab);
        System.out.println("");

        Usuario user = UsuarioDAO.buscar(login.toUpperCase(), clave);
        if (user == null) {
            System.out.println("\t\t\t\t\t" + "usuario o contraseña invalido");
            Pantalla.limpiarPantalla();
            mostrarFormularioLogin();
        } else {
            if (user.cargo.contains("ADMINISTRADOR")) {
                MenuPrincipal.esAdministrador = true;
                MenuLogin.mostrarMenuAdmin();
            } else {
                MenuPrincipal.esAdministrador = false;
                MenuLogin.mostrarMenuUsuario();
            }

        }
    }
}
