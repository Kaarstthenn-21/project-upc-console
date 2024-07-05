package front.util;

/**
 *
 * @author Kaarstthenn-21
 */
public class Pantalla {

    static int largoMenu = 100;

    public static void crearMenu(String titulo) {
        String letra = "*";
        //El largo de menu debe ser par

        int largoTitulo = titulo.length();
        if (largoTitulo % 2 != 0) {
            largoMenu = largoMenu + 1;
        }//fin del if
        int espaciosBlanco = (largoMenu - largoTitulo) - 2;
        System.out.println("\n");
        System.out.println("\t" + repetir(letra, largoMenu));
        System.out.println("\t" + repetir(letra, 1) + repetir(" ", espaciosBlanco / 2) + titulo + repetir(" ", espaciosBlanco / 2) + repetir(letra, 1));
        System.out.println("\t" + repetir(letra, largoMenu));
    }

    public static void crearOpcionMenu(String opcion, String titulo) {
        System.out.println("\t" + opcion + " = " + titulo);
    }

    public static void crearLineaOpcionMenu() {
        System.out.println("\t" + repetir("-", largoMenu));
    }

    private static String repetir(String letra, int cantidad) {
        String retorno = "";
        for (int i = 0; i < cantidad; i++) {
            retorno = retorno + letra;
        }
        return retorno;
    }

    public static void crearCabeceraTabla(String[] titulos, Integer[] anchos) {
        String letra = "-";

        System.out.println("\t" + repetir(letra, largoMenu));

        String titulo;
        String cabecera = "|";
        Integer ancho;
        for (int i = 0; i < titulos.length; i++) {
            titulo = titulos[i];
            ancho = anchos[i];
            cabecera = cabecera + titulo + repetir(" ", ancho - titulo.length() - 1) + "|";
        }
        System.out.println("\t" + cabecera);
        System.out.println("\t" + repetir(letra, largoMenu));
    }

    public static void crearContenidoTabla(String[] data, Integer[] anchos) {
        String celda ;
        Integer ancho;
        String fila = "|";
        for (int i = 0; i < data.length; i++) {
            celda = data[i];            
            ancho = anchos[i];
            fila =fila+ celda + repetir(" ", ancho - celda.length() - 1) + "|";
        }
        System.out.println("\t" + fila);
    }

    public static void limpiarPantalla() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception ex) {
        }
    }

}
