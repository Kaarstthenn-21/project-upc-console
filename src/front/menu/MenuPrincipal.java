package front.menu;

public class MenuPrincipal {
    public static boolean  esAdministrador = true;

    public static void mostrarMenuPrincipal(){
        if(MenuPrincipal.esAdministrador){
            MenuLogin.mostrarMenuAdmin();
        }else {
            MenuLogin.mostrarMenuUsuario();
        }
    }
}
