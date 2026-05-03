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
public class Cultivos {
    private ArrayList<Cultivo> lista;

    public Cultivos() {
        lista = new ArrayList<>();
    }

    public void agregarCultivo(Cultivo c) {
        lista.add(c);
    }

    public ArrayList<Cultivo> getLista() {
        return lista;
    }

    public void eliminarCultivo(int id) {
        for (Cultivo c : lista) {
            if (c.getId() == id) {
                lista.remove(c);
                break;
            }
        }
    }
    
}
