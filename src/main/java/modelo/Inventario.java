/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.io.*;
import modelo.Animal;   


/**
 *
 * @author akzelini
 */
public class Inventario {
    private ArrayList<Animal> animales;

    public Inventario() {
        animales = new ArrayList<>();
          cargarDesdeArchivo();
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
    public void guardarEnArchivo() {
    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter("animales.txt"));

        for (Animal a : animales) {
            bw.write(a.getId() + "," + a.getNombre() + "," + a.getEdad() + "," + a.getPeso() + "," + a.getPrecio());
            bw.newLine();
        }

        bw.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    public void cargarDesdeArchivo() {
    try {
        BufferedReader br = new BufferedReader(new FileReader("animales.txt"));
        String linea;

        animales.clear();

        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");

            int id = Integer.parseInt(datos[0]);
            String nombre = datos[1];
            int edad = Integer.parseInt(datos[2]);
            double peso = Double.parseDouble(datos[3]);
            double precio = Double.parseDouble(datos[4]);

            animales.add(new Animal(id, nombre, edad, peso, precio));
        }

        br.close();
    } catch (IOException e) {
        
    }
}
    
}
