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
public class Cultivo {

    private int id;
    private String nombre;
    private int cantidad;
    private String estado;
    private double precio;

    public Cultivo(int id, String nombre, int cantidad, String estado, double precio) {

        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.estado = estado;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}