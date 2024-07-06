package front.util;

import java.util.Scanner;

/**
 * Clase desarrollada para obtener datos desde el teclado, con validaciones y
 * eliminando la inconsistencia del flujo de datos.
 *
 *
 */
public class Teclado {

    /**
     * Objeto usado para obtener el lector de texto
     */
    private Scanner sc;

    public Teclado() {
        sc = new Scanner(System.in);
    }

    /**
     * Obtiene una cadena de caracteres desde el telcado, unicamente de la [A a
     * la Z] teniendo en cuenta mayusculas y minusculas de acuerdo a lo que se
     * pida en el titulo (parametro de este metodo).
     *
     * @param titulo Titulo a mostrar en consola, como referencia a lo que se
     * desea obtener
     * @return String Cadena de caracteres con lo capturado en consola
     */
    
     public String getStringLogin(String titulo,String tab) {
        String s1 = "";
        while (s1.equals("")) {
            System.out.println("\t"+tab+titulo);
                        System.out.print("\t"+tab);

            s1 = sc.nextLine(); // "Hola"
            
        }
        return s1;
    }
    
    public String getString(String titulo) {
        String s1 = "";
        while (s1.equals("")) {
            System.out.println("\t"+titulo);
                        System.out.print("\t");

            s1 = sc.nextLine(); // "Hola"
            if (!s1.matches("^[A-Za-z]*$")) {
                s1 = "";
            }
        }
        return s1;
    }
    public String getString2(String titulo) {
        String input = "";
        while (input.isEmpty()) {
            System.out.println("\t" + titulo);
            System.out.print("\t");

            input = sc.nextLine().trim(); // Leer la entrada y eliminar espacios en blanco al inicio y al final

            if (input.isEmpty()) {
                System.out.println("El campo no puede estar vacío. Inténtelo de nuevo.");
            }
        }
        return input;
    }

    /**
     * Obtiene un entero desde el telcado a traves de la consola, unicamente
     * este numero debe ser entero [0-9], Ademas se valida si el usuario captura
     * numeros o letras evitando la insonsistencia de informacion.
     *
     * @param titulo Referencia a mostrar en consola para obtener datos
     * @param caracteres Que numero de caracteres deseamos obtener
     * @return Int Numero capturado por el usuario
     */
    public int getInt(String titulo, int caracteres) {
        String s1 = "";
        while (s1.equals("")) {
            System.out.println("\t" + titulo);
            System.out.print("\t");
            s1 = sc.nextLine(); // "Hola"
            if (!s1.matches("[0-9]{" + caracteres + "}")) { // 455
                s1 = "";
            }
        }
        return Integer.parseInt(s1);
    }

    /**
     * Obtiene un entero desde el telcado a traves de la consola, unicamente
     * este numero debe ser entero [0-9], Ademas se valida si el usuario captura
     * numeros o letras evitando la insonsistencia de informacion.
     *
     * @param titulo Referencia a mostrar en consola para obtener datos
     * @return Int Numero capturado por el usuario
     */
    public int getInt(String titulo) {
        String s1 = "";
        while (s1.equals("")) {
            System.out.println("\t"+titulo);
            System.out.print("\t");
            s1 = sc.nextLine(); // "Hola"
            if (!s1.matches("[0-9]*$")) { // 455
                s1 = "";
            }
        }
        return Integer.parseInt(s1);
    }
    
     public int getIntHasta(String titulo,Integer hasta) {
        String s1 = "";
        while (s1.equals("")) {
            System.out.println("\t"+titulo);
            System.out.print("\t");
            s1 = sc.nextLine(); // "Hola"
            if (!s1.matches("[0-"+hasta +"]*$")) { // 455
                s1 = "";
            }
        }
        return Integer.parseInt(s1);
    }
    
    public String get(String titulo) {
        String s1 = "";
        while (s1.equals("")) {
            System.out.print("\t"+titulo);
            s1 = sc.nextLine(); // "Hola"
            if (!s1.matches("[0-9a-zA-Z]*$")) { // 455
                s1 = "";
            }
        }
        return (s1);
    }
    public String getEspecial(String titulo){
        String sl;
        System.out.print("\t"+titulo);
        sl = sc.nextLine();
        return sl;
    
    }
    
    public String getFecha(String titulo) {
        String s1 = "";
        while (s1.equals("")) {
            System.out.print("\t"+titulo);
            s1 = sc.nextLine(); // "Hola"
            if (!s1.matches("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")) { // 455
                s1 = "";
            }
        }
        return (s1);
    }
    
    public String getCodigoP(String titulo) {
        String s1 = "";
        while (s1.equals("")) {
            System.out.print("\t"+titulo);
            
            s1 = sc.nextLine(); // "Hola"
            if (!s1.matches("^((P|p)([0-9]{3}))$")) { // 455
                System.out.println("El codigo va en el formato (P###)");
                s1 = "";
            }
        }
        return s1;
    }
    
    public String getCodigoU(String titulo) {
        String s1 = "";
        while (s1.equals("")) {
            System.out.print("\t"+titulo);
            
            s1 = sc.nextLine(); // "Hola"
            if (!s1.matches("^((U|u)([0-9]{3}))$")) { // 455
                System.out.println("\tEl codigo va en el formato (U###)");
                s1 = "";
            }
        }
        return s1;
    }
    
    public String getCargo (String titulo){
         String s1 = "";
        while (s1.equals("")) {
            System.out.print("\t"+titulo);         
            s1 = sc.nextLine().toUpperCase(); // "Hola"
            if (!s1.matches("^((TRABAJADOR|ADMINISTRADOR))$")) { // 455
                System.out.println("\tSolo se permite Administrador o TRABAJADOR");
                s1 = "";
            }
        }
        return s1;
        
    }

    public String getHora(String titulo) {
        String hora = "";
        while (hora.equals("")) {
            System.out.print("\t" + titulo);
            hora = sc.nextLine().trim();

            // Validar el formato HH:MM
            if (!hora.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$")) {
                System.out.println("\tFormato de hora incorrecto. Debe ser HH:MM");
                hora = "";
            }
        }
        return hora;
    }

    public String getTipoAsistencia(String titulo) {
        String tipoAsistencia = "";
        while (tipoAsistencia.equals("")) {
            System.out.print("\t" + titulo);
            tipoAsistencia = sc.nextLine().trim();

            // Validar que sea "Presencial" o "Remoto", indistintamente de mayúsculas o minúsculas
            if (!tipoAsistencia.equalsIgnoreCase("Presencial") && !tipoAsistencia.equalsIgnoreCase("Remoto")) {
                System.out.println("\tTipo de asistencia incorrecto. Debe ser 'Presencial' o 'Remoto'.");
                tipoAsistencia = "";
            }
        }
        return tipoAsistencia;
    }
}