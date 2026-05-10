package modelo;

public class Animal extends SerVivo implements Vendible {

    private int id;
    private int edad;
    private double peso;
    private double precio;

    public Animal(
            int id,
            String nombre,
            int edad,
            double peso,
            double precio
    ) {

        super(nombre);

        this.id = id;
        this.edad = edad;
        this.peso = peso;
        this.precio = precio;
    }

    public int getId() {

        return id;
    }

    @Override
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

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public void setEdad(int edad) {

        this.edad = edad;
    }

    public void setPeso(double peso) {

        this.peso = peso;
    }

    public void setPrecio(double precio) {

        this.precio = precio;
    }

    @Override
    public double calcularVenta() {

        return precio;
    }

    @Override
    public void mostrarInfo() {

        System.out.println(
                "Animal: " + nombre +
                " | Precio: $" + precio
        );
    }
}