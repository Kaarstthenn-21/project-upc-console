package front.menu;


import front.formularios.FormularioLogin;
import front.util.ColorLetra;
import front.util.Pantalla;
import front.util.Teclado;

public class MenuLogin {

    public static void mostrarMenuAdmin() {

        //Limpiar pantalla
        Pantalla.limpiarPantalla();

        //Change color screen
        Pantalla.crearMenu("Menu de asistencia ADMINISTRADOR");

        Pantalla.crearOpcionMenu("1", "Listar usuarios");
        Pantalla.crearOpcionMenu("2", "Buscar usuario");
        Pantalla.crearOpcionMenu("3", "Agregar usuario");
        Pantalla.crearOpcionMenu("4", "Eliminar usuario");


        Pantalla.crearOpcionMenu("0", "Salir");

        System.out.println("\t" + "\n");

        Teclado teclado = new Teclado();
        int opcion = teclado.getInt("Selecciona una opción del menú", 1);
        System.out.print(ColorLetra.RESET);

        try {
            switch (opcion) {
                case 1:
                    MenuUsuario.mostrarMenuListarUsuarios();
                    break;
                case 2:
                    MenuUsuario.mostrarMenuBuscarUsuarios();
                    break;

                case 3:
                    MenuUsuario.mostrarMenuAgregarUsuarios();
                    break;
                case 4:
//
                    break;
                case 0:
                    FormularioLogin.mostrarFormularioLogin();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mostrarMenuUsuario() {
        //primero se limpia la pantalla
        Pantalla.limpiarPantalla();
        //camiamos de color a la letra
        Pantalla.crearMenu(" MENU DEL CONSUMIDOR");

        Pantalla.crearOpcionMenu("1", "Listar Asistencias");
        Pantalla.crearOpcionMenu("3", "Registrar falta");
        Pantalla.crearOpcionMenu("0", "Salir");

        System.out.println("\t" + "\n");


        Teclado teclado = new Teclado();
        int opcion = teclado.getInt("Selecciona una opción del menú", 1);
        System.out.print(ColorLetra.RESET);

        try {
            switch (opcion) {
                case 1:
//                    MenuPelicula.mostrarMenuListarPeliculas();
                    break;
                case 0:
//                    FormularioLogin.mostrarFormularioLogin();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void loginUsuario(String cargo){


    }


}
