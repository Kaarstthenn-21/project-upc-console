package back.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author saisa
 */
public class ArchivoTexto {

    public static BufferedReader leer(String rutaArchivo) {
        BufferedReader bufferedReader = null;
        try {
            FileReader reader = new FileReader(rutaArchivo);
            bufferedReader = new BufferedReader(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }

    public static BufferedWriter escribir(String rutaArchivo) {
        BufferedWriter bufferedReader = null;
        try {
            //se pone true para agregar contenido al archivo que existe
            FileWriter reader = new FileWriter(rutaArchivo, true);
            bufferedReader = new BufferedWriter(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }

}
