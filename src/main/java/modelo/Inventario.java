package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;
import java.io.*;

public class Inventario {

    private ArrayList<Animal> animales;

    private HashMap<Integer, Animal> mapaAnimales;

    public Inventario() {

        animales = new ArrayList<>();

        mapaAnimales = new HashMap<>();

        cargarDesdeArchivo();
    }

    public void agregarAnimal(Animal a) {

        animales.add(a);

        mapaAnimales.put(a.getId(), a);

        guardarEnArchivo();
    }

    public void mostrarAnimales() {

        for (Animal a : animales) {

            System.out.println(a.getId() + " - " + a.getNombre());
        }
    }

    public void eliminarAnimal(int id) {

        animales.removeIf(a -> a.getId() == id);

        mapaAnimales.remove(id);

        guardarEnArchivo();
    }

    public void modificarAnimal(
            int id,
            String nombre,
            int edad,
            double peso,
            double precio
    ) {

        Animal a = mapaAnimales.get(id);

        if (a != null) {

            a.setNombre(nombre);

            a.setEdad(edad);

            a.setPeso(peso);

            a.setPrecio(precio);

            guardarEnArchivo();
        }
    }

    public Animal buscarAnimal(int id) {

        for (Animal a : animales) {

            if (a.getId() == id) {

                return a;
            }
        }

        return null;
    }

    public Animal buscarAnimalMapa(int id) {

        return mapaAnimales.get(id);
    }

    public void ordenarPorPrecio() {

        Collections.sort(animales, new Comparator<Animal>() {

            @Override
            public int compare(Animal a1, Animal a2) {

                return Double.compare(
                        a1.getPrecio(),
                        a2.getPrecio()
                );
            }
        });
    }

    public ArrayList<Animal> getAnimales() {

        return animales;
    }

    public void guardarEnArchivo() {

        try {

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("animales.txt")
            );

            for (Animal a : animales) {

                bw.write(
                        a.getId() + "," +
                        a.getNombre() + "," +
                        a.getEdad() + "," +
                        a.getPeso() + "," +
                        a.getPrecio()
                );

                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {

            System.out.println("Error al guardar");
        }
    }

    public void cargarDesdeArchivo() {

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("animales.txt")
            );

            String linea;

            animales.clear();

            mapaAnimales.clear();

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                int id = Integer.parseInt(datos[0]);

                String nombre = datos[1];

                int edad = Integer.parseInt(datos[2]);

                double peso = Double.parseDouble(datos[3]);

                double precio = Double.parseDouble(datos[4]);

                Animal a = new Animal(
                        id,
                        nombre,
                        edad,
                        peso,
                        precio
                );

                animales.add(a);

                mapaAnimales.put(id, a);
            }

            br.close();

        } catch (IOException e) {

            System.out.println("No existe archivo");
        }
    }
}