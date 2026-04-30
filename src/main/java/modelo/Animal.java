/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author akzelini
 */
public class Animal {
    
      private int id;
    private String nombre;
    private int edad;
    private double precio;
    private double peso;

    public Animal(int id, String nombre, int edad, double peso, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
          this.peso = peso;
        this.precio = precio;
      
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
   public int getEdad() {
    return edad;
}
   public double getPeso() {
    return peso;
}
    

public double getPrecio() {
    return precio;
}


}
