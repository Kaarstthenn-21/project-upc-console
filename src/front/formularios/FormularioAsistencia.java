package front.formularios;

import back.dao.AsistenciaDAO;
import back.entidades.Asistencia;
import front.menu.MenuPrincipal;
import front.util.Pantalla;
import front.util.Teclado;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FormularioAsistencia {
    public static void mostrarFormularioListar() throws IOException {
        String[] titulos = {"CODIGO USUARIO", "FECHA", "HORA INGRESO", "HORA SALIDA", "TIPO ASISTENCIA"};
        Integer[] anchos = {15, 15, 15, 15, 20};

        Pantalla.crearCabeceraTabla(titulos, anchos);
        List<Asistencia> listaAsistencia = AsistenciaDAO.listar();

        Asistencia asistencia;
        for (int i = 0; i < listaAsistencia.size(); i++) {
            asistencia = listaAsistencia.get(i);

            String data[] = {asistencia.codigoUsuario, asistencia.fechaAsistencia, asistencia.horaIngreso, asistencia.horaSalida, asistencia.tipoAsistencia};

            Pantalla.crearContenidoTabla(data, anchos);
        }

        System.out.println("");
        Pantalla.crearOpcionMenu("0", "Retornar al Menu Principal");
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
        String codigoUsuario = teclado.getString("Ingrese el codigo del Usuario a buscar");
        String fechaAsistencia = teclado.getString("Ingrese la fecha de la asistencia a buscar (YYYY-MM-DD)");

        if (AsistenciaDAO.exist(codigoUsuario, fechaAsistencia)) {
            Asistencia asistencia = AsistenciaDAO.buscar(codigoUsuario, fechaAsistencia);
            String[] titulos = {"CODIGO USUARIO", "FECHA", "HORA INGRESO", "HORA SALIDA", "TIPO ASISTENCIA"};
            Integer[] anchos = {15, 15, 15, 15, 20};
            Pantalla.crearCabeceraTabla(titulos, anchos);

            if (asistencia != null) {
                String[] data = {asistencia.codigoUsuario, asistencia.fechaAsistencia, asistencia.horaIngreso, asistencia.horaSalida, asistencia.tipoAsistencia};
                Pantalla.crearContenidoTabla(data, anchos);
            }
        } else {
            System.out.println("\tEl registro de asistencia no existe en la base de datos");
        }

        System.out.println("");
        Pantalla.crearOpcionMenu("1", "Volver a realizar la acción");
        Pantalla.crearOpcionMenu("0", "Regresar al Menu Principal");
        int opcion = teclado.getIntHasta("Ingrese una opcion del Menu", 1);

        switch (opcion) {
            case 1:
                FormularioAsistencia.mostrarFormularioBuscar();
                break;
            case 0:
                MenuPrincipal.mostrarMenuPrincipal();
                break;
        }
    }

    public static void mostrarFormularioAgregar() throws IOException {
        Teclado teclado = new Teclado();
        Asistencia asistencia = new Asistencia();

        try {
            List<Asistencia> listaAsistencia = AsistenciaDAO.listar();
            String codigoUsuario = teclado.getCodigoU("CODIGO: ");
            String fechaAsistencia = teclado.getString2("FECHA (YYYY-MM-DD): ");

            if (!AsistenciaDAO.exist(codigoUsuario, fechaAsistencia)) {
                String horaIngreso = teclado.getHora("HORA INGRESO (HH:MM): ");
                String horaSalida = teclado.getHora("HORA SALIDA (HH:MM): ");
                String tipoAsistencia = teclado.getTipoAsistencia("TIPO DE ASISTENCIA: ");

                asistencia.codigoUsuario = codigoUsuario;
                asistencia.fechaAsistencia = fechaAsistencia;
                asistencia.horaIngreso = horaIngreso;
                asistencia.horaSalida = horaSalida;
                asistencia.tipoAsistencia = tipoAsistencia;

                listaAsistencia.add(asistencia);
                AsistenciaDAO.escribir(listaAsistencia);
                System.out.println("\tProceso Exitoso");
            } else {
                System.out.println("\tEl registro de asistencia ya existe");
                mostrarFormularioAgregar();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        Pantalla.crearOpcionMenu("1", "Volver a realizar la acción");
        Pantalla.crearOpcionMenu("0", "Regresar al Menu Principal");
        int opcion = teclado.getIntHasta("Ingrese una opcion del Menu", 1);

        switch (opcion) {
            case 1:
                FormularioAsistencia.mostrarFormularioAgregar();
                break;
            case 0:
                MenuPrincipal.mostrarMenuPrincipal();
                break;
        }
    }

    public static void mostrarFormularioTotalAsistencias() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la fecha de inicio (yyyy-MM-dd): ");
        String fechaInicio = scanner.nextLine();
        System.out.print("Ingrese la fecha de fin (yyyy-MM-dd): ");
        String fechaFin = scanner.nextLine();

        int totalAsistencias = AsistenciaDAO.obtenerTotalAsistencias(fechaInicio, fechaFin);
        System.out.println("Total de asistencias desde " + fechaInicio + " hasta " + fechaFin + ": " + totalAsistencias);
    }

    public static void mostrarFormularioAsistenciasPorUsuario() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el código del usuario: ");
        String codigoUsuario = scanner.nextLine();
        System.out.print("Ingrese la fecha de inicio (yyyy-MM-dd): ");
        String fechaInicio = scanner.nextLine();
        System.out.print("Ingrese la fecha de fin (yyyy-MM-dd): ");
        String fechaFin = scanner.nextLine();

        List<Asistencia> asistencias = AsistenciaDAO.obtenerAsistenciasPorUsuario(codigoUsuario, fechaInicio, fechaFin);
        System.out.println("Asistencias del usuario " + codigoUsuario + " desde " + fechaInicio + " hasta " + fechaFin + ":");
        for (Asistencia asistencia : asistencias) {
            System.out.println(asistencia.fechaAsistencia + " | " + asistencia.horaIngreso + " | " + asistencia.horaSalida + " | " + asistencia.tipoAsistencia);
        }
    }

    public static void mostrarFormularioUsuariosSinAsistencia() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la fecha de inicio (yyyy-MM-dd): ");
        String fechaInicio = scanner.nextLine();
        System.out.print("Ingrese la fecha de fin (yyyy-MM-dd): ");
        String fechaFin = scanner.nextLine();

        List<String> usuariosSinAsistencia = AsistenciaDAO.obtenerUsuariosSinAsistencia(fechaInicio, fechaFin);
        System.out.println("Usuarios sin asistencia desde " + fechaInicio + " hasta " + fechaFin + ":");
        for (String codigoUsuario : usuariosSinAsistencia) {
            System.out.println(codigoUsuario);
        }
    }

    public static void mostrarFormularioAsistenciasPorTipo() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tipo de asistencia (presencial/remoto): ");
        String tipoAsistencia = scanner.nextLine();
        System.out.print("Ingrese la fecha de inicio (yyyy-MM-dd): ");
        String fechaInicio = scanner.nextLine();
        System.out.print("Ingrese la fecha de fin (yyyy-MM-dd): ");
        String fechaFin = scanner.nextLine();

        List<Asistencia> asistencias = AsistenciaDAO.obtenerAsistenciasPorTipo(tipoAsistencia, fechaInicio, fechaFin);
        System.out.println("Asistencias de tipo " + tipoAsistencia + " desde " + fechaInicio + " hasta " + fechaFin + ":");
        for (Asistencia asistencia : asistencias) {
            System.out.println(asistencia.fechaAsistencia + " | " + asistencia.horaIngreso + " | " + asistencia.horaSalida + " | " + asistencia.tipoAsistencia);
        }
    }

    public static void mostrarFormularioPrimerUltimoRegistro() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la fecha de inicio (yyyy-MM-dd): ");
        String fechaInicio = scanner.nextLine();
        System.out.print("Ingrese la fecha de fin (yyyy-MM-dd): ");
        String fechaFin = scanner.nextLine();

        Map<String, Asistencia[]> registros = AsistenciaDAO.obtenerPrimerUltimoRegistro(fechaInicio, fechaFin);
        System.out.println("Primer y último registro de asistencia desde " + fechaInicio + " hasta " + fechaFin + ":");
        for (Map.Entry<String, Asistencia[]> entry : registros.entrySet()) {
            String codigoUsuario = entry.getKey();
            Asistencia[] asistencias = entry.getValue();
            Asistencia primera = asistencias[0];
            Asistencia ultima = asistencias[1];
            System.out.println("Usuario: " + codigoUsuario);
            if (primera != null) {
                System.out.println("  Primer ingreso: " + primera.fechaAsistencia + " | " + primera.horaIngreso);
            }
            if (ultima != null) {
                System.out.println("  Última salida: " + ultima.fechaAsistencia + " | " + ultima.horaSalida);
            }
        }
    }
}
