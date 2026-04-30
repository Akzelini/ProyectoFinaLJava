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
public class Inventario {
    private ArrayList<Animal> animales;

    public Inventario() {
        animales = new ArrayList<>();
    }

    
    public void agregarAnimal(Animal a) {
        animales.add(a);
    }

    
    
    public void mostrarAnimales() {
        for (Animal a : animales) {
            System.out.println(a.getId() + " - " + a.getNombre());
        }
    }
    public void eliminarAnimal(int id) {
    animales.removeIf(a -> a.getId() == id);
                            }
    public Animal buscarAnimal(int id) {
        for (Animal a : animales) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }
    public ArrayList<Animal> getAnimales() {
    return animales;
}
    
}
