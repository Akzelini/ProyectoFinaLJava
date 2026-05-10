package modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.io.*;

public class Usuarios {

    private ArrayList<Usuario> lista;

    private HashSet<String> usuariosUnicos;

    public Usuarios() {

        lista = new ArrayList<>();

        usuariosUnicos = new HashSet<>();

        cargarDesdeArchivo();

        if (lista.isEmpty()) {

            Usuario admin =
                    new Usuario(
                            1,
                            "Akzelini",
                            "654321",
                            "admin"
                    );

            Usuario astrid =
                    new Usuario(
                            2,
                            "Astrid",
                            "1234",
                            "empleado"
                    );

            Usuario reyDavid =
                    new Usuario(
                            3,
                            "ReyDavid",
                            "1234",
                            "empleado"
                    );

            lista.add(admin);
            lista.add(astrid);
            lista.add(reyDavid);

            usuariosUnicos.add(admin.getUsuario());
            usuariosUnicos.add(astrid.getUsuario());
            usuariosUnicos.add(reyDavid.getUsuario());

            guardarEnArchivo();
        }
    }

    public Usuario validarLogin(String u, String c) {

        for (Usuario user : lista) {

            if (user.validar(u, c)) {

                return user;
            }
        }

        return null;
    }

    public void agregarUsuario(Usuario usuario) {

        if (usuariosUnicos.contains(
                usuario.getUsuario()
        )) {

            System.out.println(
                    "Usuario repetido"
            );

            return;
        }

        usuariosUnicos.add(
                usuario.getUsuario()
        );

        lista.add(usuario);

        guardarEnArchivo();
    }

    public ArrayList<Usuario> getListaUsuarios() {

        return lista;
    }

    public void cargarDesdeArchivo() {

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(
                                    "usuarios.txt"
                            )
                    );

            String linea;

            lista.clear();

            usuariosUnicos.clear();

            while ((linea = br.readLine()) != null) {

                String[] datos =
                        linea.split(",");

                int id =
                        Integer.parseInt(
                                datos[0]
                        );

                String usuario =
                        datos[1];

                String pass =
                        datos[2];

                String rol =
                        datos[3];

                Usuario u =
                        new Usuario(
                                id,
                                usuario,
                                pass,
                                rol
                        );

                lista.add(u);

                usuariosUnicos.add(
                        usuario
                );
            }

            br.close();

        } catch (IOException e) {

            System.out.println(
                    "No existe archivo"
            );
        }
    }

    public void guardarEnArchivo() {

        try {

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter(
                                    "usuarios.txt"
                            )
                    );

            for (Usuario u : lista) {

                bw.write(
                        u.getId() + "," +
                        u.getUsuario() + "," +
                        u.getContrasena() + "," +
                        u.getRol()
                );

                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void eliminarUsuario(int id) {

        for (Usuario u : lista) {

            if (u.getId() == id) {

                usuariosUnicos.remove(
                        u.getUsuario()
                );

                lista.remove(u);

                break;
            }
        }

        guardarEnArchivo();
    }
}