/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.io.*;


/**
 *
 * @author akzelini
 */
public class Usuarios {
    private ArrayList<Usuario> lista;

    public Usuarios() {
          lista = new ArrayList<>();
    cargarDesdeArchivo(); 

    if (lista.isEmpty()) {
        lista.add(new Usuario(1, "Akzelini", "654321", "admin"));
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
        lista.add(usuario);
    }

    
    public ArrayList<Usuario> getListaUsuarios() {
        return lista;
    }
        
    public void cargarDesdeArchivo() {
    try {
        BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"));
        String linea;

        lista.clear();

        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");

            int id = Integer.parseInt(datos[0]);
            String usuario = datos[1];
            String pass = datos[2];
            String rol = datos[3];

            lista.add(new Usuario(id, usuario, pass, rol));
        }

        br.close();
    } catch (IOException e) {
       
    }
    
}
    public void guardarEnArchivo() {
    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios.txt"));

        for (Usuario u : lista) {
            bw.write(u.getId() + "," + u.getUsuario() + "," + u.getContrasena() + "," + u.getRol());
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
            lista.remove(u);
            break;
        }
    }
    guardarEnArchivo(); 
}
    
}
