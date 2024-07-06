package front.menu;


import front.formularios.FormularioLogin;
import front.util.ColorLetra;
import front.util.Pantalla;
import front.util.Teclado;

import java.io.IOException;
import java.sql.SQLOutput;

public class MenuLogin {

    public static void mostrarMenuAdmin() throws IOException {
        Pantalla.limpiarPantalla();
        Pantalla.crearMenu("Menu de asistencia ADMINISTRADOR");
        Pantalla.crearOpcionMenu("1", "Listar usuarios");
        Pantalla.crearOpcionMenu("2", "Buscar usuario");
        Pantalla.crearOpcionMenu("3", "Agregar usuario");
        Pantalla.crearOpcionMenu("4", "Eliminar usuario");
        Pantalla.crearOpcionMenu("5", "Listar asistencias");
        Pantalla.crearOpcionMenu("6", "Buscar asistencia");
        Pantalla.crearOpcionMenu("7", "Agregar asistencia");
        Pantalla.crearOpcionMenu("8", "Total de asistencias");
        Pantalla.crearOpcionMenu("9", "Asistencias por usuario");
        Pantalla.crearOpcionMenu("10", "Usuarios sin asistencia");
        Pantalla.crearOpcionMenu("11", "Asistencias por tipo");
        Pantalla.crearOpcionMenu("12", "Primer y último registro de asistencia");
        Pantalla.crearOpcionMenu("0", "Salir");

        System.out.println("\n");

        Teclado teclado = new Teclado();
        int opcion = teclado.getInt("Selecciona una opción del menú", 1);

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
                    // Agregar lógica para eliminar usuario si es necesario
                    break;
                case 5:
                    MenuAsistencia.mostrarMenuListarAsistencias();
                    break;
                case 6:
                    MenuAsistencia.mostrarMenuBuscarAsistencias();
                    break;
                case 7:
                    MenuAsistencia.mostrarMenuAgregarAsistencias();
                    break;
                case 8:
                    MenuAsistencia.mostrarMenuTotalAsistencias();
                    break;
                case 9:
                    MenuAsistencia.mostrarMenuAsistenciasPorUsuario();
                    break;
                case 10:
                    MenuAsistencia.mostrarMenuUsuariosSinAsistencia();
                    break;
                case 11:
                    MenuAsistencia.mostrarMenuAsistenciasPorTipo();
                    break;
                case 12:
                    MenuAsistencia.mostrarMenuPrimerUltimoRegistro();
                    break;
                case 0:
                    FormularioLogin.mostrarFormularioLogin();
                    break;
                default:
                    System.out.println("Opción no válida, por favor seleccione una opción del menú.");
                    mostrarMenuAdmin();
            }
        } catch (IOException e) {
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


    public static void loginUsuario(String cargo) {


    }


}
