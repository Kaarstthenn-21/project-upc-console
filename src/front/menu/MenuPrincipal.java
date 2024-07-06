package front.menu;

import java.io.IOException;

public class MenuPrincipal {
    public static boolean esAdministrador = true;

    public static void mostrarMenuPrincipal() throws IOException {
        if (MenuPrincipal.esAdministrador) {
            MenuLogin.mostrarMenuAdmin();
        } else {
            MenuLogin.mostrarMenuUsuario();
        }
    }
}
