package back.dao;

import back.entidades.Asistencia;
import back.entidades.Usuario;
import back.util.ArchivoTexto;
import back.util.RutaArchivo;

import java.io.*;
import java.util.*;

public class AsistenciaDAO {
    public static void registrar(Asistencia asistencia) {
        try {
            BufferedWriter bufferedWrite = ArchivoTexto.escribir(RutaArchivo.RUTA_ARCHIVO_ASISTENCIA);
            bufferedWrite.newLine();
            bufferedWrite.write(asistencia.codigoUsuario + "|" + asistencia.fechaAsistencia + "|" + asistencia.horaIngreso + "|" + asistencia.horaSalida + "|" + asistencia.tipoAsistencia);
            bufferedWrite.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Asistencia> listar() {
        List<Asistencia> listaAsistencia = new ArrayList<>();
        try {
            BufferedReader bufferedReader = ArchivoTexto.leer(RutaArchivo.RUTA_ARCHIVO_ASISTENCIA);
            Asistencia asistencia = null;
            String fila;
            String[] texto;
            while ((fila = bufferedReader.readLine()) != null) {
                texto = fila.split("\\|");
                asistencia = new Asistencia();
                asistencia.codigoUsuario = texto[0];
                asistencia.fechaAsistencia = texto[1];
                asistencia.horaIngreso = texto[2];
                asistencia.horaSalida = texto[3];
                asistencia.tipoAsistencia = texto[4];

                listaAsistencia.add(asistencia);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaAsistencia;
    }

    public static Asistencia buscar(String codigoUsuario, String fechaAsistencia) throws IOException {
        Asistencia asistencia = null;
        try {
            BufferedReader bufferedReader = ArchivoTexto.leer(RutaArchivo.RUTA_ARCHIVO_ASISTENCIA);

            String fila;
            String[] texto;
            while ((fila = bufferedReader.readLine()) != null) {
                texto = fila.split("\\|");
                asistencia = new Asistencia();
                asistencia.codigoUsuario = texto[0];
                asistencia.fechaAsistencia = texto[1];
                asistencia.horaIngreso = texto[2];
                asistencia.horaSalida = texto[3];
                asistencia.tipoAsistencia = texto[4];

                if (asistencia.codigoUsuario.equals(codigoUsuario) && asistencia.fechaAsistencia.equals(fechaAsistencia)) {
                    return asistencia;
                } else {
                    asistencia = null;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return asistencia;
    }

    public static boolean exist(String codigoUsuario, String fechaAsistencia) throws IOException {
        List<Asistencia> listaAsistencia = listar();
        for (Asistencia asistencia : listaAsistencia) {
            if (asistencia.codigoUsuario.equals(codigoUsuario) && asistencia.fechaAsistencia.equals(fechaAsistencia)) {
                return true;
            }
        }
        return false;
    }

    public static void escribir(List<Asistencia> listaAsistencia) throws IOException {
        FileWriter file = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;
        try {
            file = new FileWriter(RutaArchivo.RUTA_ARCHIVO_ASISTENCIA);
            bufferedWriter = new BufferedWriter(file);
            printWriter = new PrintWriter(bufferedWriter);

            for (Asistencia asistencia : listaAsistencia) {
                printWriter.write(asistencia.codigoUsuario + "|" + asistencia.fechaAsistencia + "|" + asistencia.horaIngreso + "|" + asistencia.horaSalida + "|" + asistencia.tipoAsistencia);
                printWriter.write("\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (file != null) {
                file.close();
            }
        }
    }

    public static int obtenerTotalAsistencias(String fechaInicio, String fechaFin) {
        List<Asistencia> listaAsistencia = listar();
        int totalAsistencias = 0;
        for (Asistencia asistencia : listaAsistencia) {
            if (asistencia.fechaAsistencia.compareTo(fechaInicio) >= 0 && asistencia.fechaAsistencia.compareTo(fechaFin) <= 0) {
                totalAsistencias++;
            }
        }
        return totalAsistencias;
    }

    // Método para obtener las asistencias de un usuario específico en un periodo de tiempo
    public static List<Asistencia> obtenerAsistenciasPorUsuario(String codigoUsuario, String fechaInicio, String fechaFin) {
        List<Asistencia> listaAsistencia = listar();
        List<Asistencia> asistenciasUsuario = new ArrayList<>();
        for (Asistencia asistencia : listaAsistencia) {
            if (asistencia.codigoUsuario.equals(codigoUsuario) && asistencia.fechaAsistencia.compareTo(fechaInicio) >= 0 && asistencia.fechaAsistencia.compareTo(fechaFin) <= 0) {
                asistenciasUsuario.add(asistencia);
            }
        }
        return asistenciasUsuario;
    }

    // Método para obtener los usuarios que no han asistido en un periodo de tiempo
    public static List<String> obtenerUsuariosSinAsistencia(String fechaInicio, String fechaFin) {
        List<Asistencia> listaAsistencia = listar();
        Set<String> usuariosConAsistencia = new HashSet<>();
        for (Asistencia asistencia : listaAsistencia) {
            if (asistencia.fechaAsistencia.compareTo(fechaInicio) >= 0 && asistencia.fechaAsistencia.compareTo(fechaFin) <= 0) {
                usuariosConAsistencia.add(asistencia.codigoUsuario);
            }
        }
        List<Usuario> todosLosUsuarios = UsuarioDAO.listar();
        List<String> usuariosSinAsistencia = new ArrayList<>();
        for (Usuario usuario : todosLosUsuarios) {
            if (!usuariosConAsistencia.contains(usuario.codigo)) {
                usuariosSinAsistencia.add(usuario.codigo);
            }
        }
        return usuariosSinAsistencia;
    }

    // Método para obtener las asistencias por tipo
    public static List<Asistencia> obtenerAsistenciasPorTipo(String tipoAsistencia, String fechaInicio, String fechaFin) {
        List<Asistencia> listaAsistencia = listar();
        List<Asistencia> asistenciasTipo = new ArrayList<>();
        for (Asistencia asistencia : listaAsistencia) {
            if (asistencia.tipoAsistencia.equals(tipoAsistencia) && asistencia.fechaAsistencia.compareTo(fechaInicio) >= 0 && asistencia.fechaAsistencia.compareTo(fechaFin) <= 0) {
                asistenciasTipo.add(asistencia);
            }
        }
        return asistenciasTipo;
    }

    // Método para obtener el primer y último registro de asistencia de cada usuario en un periodo de tiempo
    public static Map<String, Asistencia[]> obtenerPrimerUltimoRegistro(String fechaInicio, String fechaFin) {
        List<Asistencia> listaAsistencia = listar();
        Map<String, Asistencia[]> registros = new HashMap<>();
        for (Asistencia asistencia : listaAsistencia) {
            if (asistencia.fechaAsistencia.compareTo(fechaInicio) >= 0 && asistencia.fechaAsistencia.compareTo(fechaFin) <= 0) {
                Asistencia[] registrosUsuario = registros.getOrDefault(asistencia.codigoUsuario, new Asistencia[2]);
                if (registrosUsuario[0] == null || asistencia.horaIngreso.compareTo(registrosUsuario[0].horaIngreso) < 0) {
                    registrosUsuario[0] = asistencia;
                }
                if (registrosUsuario[1] == null || asistencia.horaSalida.compareTo(registrosUsuario[1].horaSalida) > 0) {
                    registrosUsuario[1] = asistencia;
                }
                registros.put(asistencia.codigoUsuario, registrosUsuario);
            }
        }
        return registros;
    }
}
