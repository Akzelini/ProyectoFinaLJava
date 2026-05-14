package modelo;

import java.util.ArrayList;
import java.io.*;

public class Cultivos {
    private ArrayList<Cultivo> lista;
    
    
    private final String ARCHIVO = System.getProperty("user.dir") + File.separator + "cultivos.txt";

    public Cultivos() {
        lista = new ArrayList<>();
        cargarDesdeArchivo();
    }

    public void agregarCultivo(Cultivo c) {
        lista.add(c);
        guardarEnArchivo(); 
    }

    public ArrayList<Cultivo> getLista() {
        return lista;
    }

    
    public void eliminarCultivoPorIndice(int index) {
        if (index >= 0 && index < lista.size()) {
            lista.remove(index);
            guardarEnArchivo(); 
        }
    }

    public void guardarEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Cultivo c : lista) {
                bw.write(c.getId() + "," + c.getNombre() + "," + c.getCantidad() + "," + c.getEstado() + "," + c.getPrecio());
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            System.err.println("Error al guardar cultivos: " + e.getMessage());
        }
    }

    public void cargarDesdeArchivo() {
        File file = new File(ARCHIVO);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            lista.clear();
            while ((linea = br.readLine()) != null) {
                try {
                    String[] datos = linea.split(",");
                    if (datos.length < 5) continue;

                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    int cantidad = Integer.parseInt(datos[2]);
                    String estado = datos[3];
                    double precio = Double.parseDouble(datos[4]);

                    lista.add(new Cultivo(id, nombre, cantidad, estado, precio));
                } catch (Exception e) {
                    System.err.println("Saltando línea corrupta: " + linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer cultivos: " + e.getMessage());
        }
    }
}