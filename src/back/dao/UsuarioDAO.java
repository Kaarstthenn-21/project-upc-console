package back.dao;

import back.entidades.Usuario;
import back.util.ArchivoTexto;
import back.util.RutaArchivo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public static void registrar(Usuario usuario) {
        try {
            BufferedWriter bufferedWrite = ArchivoTexto.escribir(RutaArchivo.RUTA_ARCHIVO_USUARIO);
            bufferedWrite.newLine();
            bufferedWrite.write(usuario.codigo + "|" + usuario.nombres + "|" + usuario.apellidos + "|" + usuario.usuario + "|" + usuario.contraseña + "|" + usuario.cargo);
            bufferedWrite.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Usuario> listar() {

        List<Usuario> listaUsuario = new ArrayList<>();
        try {

            BufferedReader bufferedReader = ArchivoTexto.leer(RutaArchivo.RUTA_ARCHIVO_USUARIO);
            Usuario usuario = null;
            String fila;
            String[] texto;
            while ((fila = bufferedReader.readLine()) != null) {
                texto = fila.split("\\|");
                usuario = new Usuario();
                usuario.codigo = texto[0];
                usuario.nombres = texto[1];
                usuario.apellidos = texto[2];
                usuario.usuario = texto[3];
                usuario.contraseña = texto[4];
                usuario.cargo = texto[5];

                listaUsuario.add(usuario);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaUsuario;

    }

    public static Usuario buscar(String login, String contraseña) throws IOException {

        Usuario usuario = null;
        try {

            BufferedReader bufferedReader = ArchivoTexto.leer(RutaArchivo.RUTA_ARCHIVO_USUARIO);

            String fila;
            String[] texto;
            while ((fila = bufferedReader.readLine()) != null) {
                texto = fila.split("\\|");
                usuario = new Usuario();
                usuario.codigo = texto[0];
                usuario.nombres = texto[1];
                usuario.apellidos = texto[2];
                usuario.usuario = texto[3];
                usuario.contraseña = texto[4];
                usuario.cargo = texto[5];

                if (usuario.usuario.contains(login) && (usuario.contraseña.contains(contraseña))) {
                    return usuario;
                } else {
                    usuario = null;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;

    }

    public static boolean exist(String referencia) throws IOException {
        List<Usuario> listaUsuario = listar();
        Usuario usuario;
        String Nombre, Codigo;
        for (int i = 0; i < listaUsuario.size(); i++) {
            usuario = listaUsuario.get(i);
            Nombre = usuario.nombres;
            Codigo = usuario.codigo;
            if (Nombre.contains(referencia.toUpperCase()) || Codigo.equals(referencia.toUpperCase())) {
                return true;
            }
        }
        return false;

    }

    public static List<Usuario> BuscarNombre(String Nombre) {

        Usuario usuario = null;
        List<Usuario> listaUsuario = listar();
        List<Usuario> listaDeBusqueda = new ArrayList();
        for (int i = 0; i < listaUsuario.size(); i++) {
            usuario = listaUsuario.get(i);
            if (usuario.nombres.contains(Nombre.toUpperCase())) {
                listaDeBusqueda.add(usuario);
            }
        }
        if (!(listaDeBusqueda.get(0).nombres).contains(Nombre.toUpperCase())) {
            usuario.codigo = "neel";
            listaDeBusqueda.add(usuario);
        }

        return listaDeBusqueda;
    }

    public static void escribiras(List<Usuario> listaUsuario) throws IOException {
        FileWriter file = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;
        try {
            file = new FileWriter(RutaArchivo.RUTA_ARCHIVO_USUARIO);
            bufferedWriter = new BufferedWriter(file);
            printWriter = new PrintWriter(bufferedWriter);
            Usuario usuario;

            for (int j = 0; j < listaUsuario.size(); j++) {

                usuario = listaUsuario.get(j);
                printWriter.write(usuario.codigo + "|" + usuario.nombres + "|"
                        + usuario.apellidos + "|" + usuario.usuario + "|" + usuario.contraseña + "|" + usuario.cargo);
                printWriter.write("\r\n");
            }
        } catch (Exception e) {

        }
        printWriter.close();
        bufferedWriter.close();
        file.close();

    }

}
