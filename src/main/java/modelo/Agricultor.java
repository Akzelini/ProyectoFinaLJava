/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author JC
 */
public class Agricultor extends Empleado {

    public Agricultor(int id, String nombre) {
        super(id, nombre);
    }

    @Override
    public String getTrabajo() {
        return "Cuida cultivos";
    }
}