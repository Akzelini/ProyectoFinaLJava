/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;

/**
 *
 * @author akzelini
 */
public class Usuarios {
    private ArrayList<Usuario> lista;

    public Usuarios() {
        lista = new ArrayList<>();
        lista.add(new Usuario(1, "Akzelini", "654321", "admin"));
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
    
    
}
