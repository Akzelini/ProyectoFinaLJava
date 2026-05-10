package modelo;

import java.util.Random;

public class RelojJuego {

    private int hora = 0;

    private double porcentajeMercado;

    private javax.swing.Timer timer;

    public RelojJuego() {

        generarMercado();

        timer = new javax.swing.Timer(30000, e -> {

            aumentarHora();
            generarMercado();

        });

        timer.start();
    }

    public int getHora() {
        return hora;
    }

    public double getPorcentajeMercado() {
        return porcentajeMercado;
    }

    public void aumentarHora() {

        hora++;

        if (hora >= 24) {
            hora = 0;
        }
    }

    private void generarMercado() {

        Random r = new Random();

        porcentajeMercado = -20 + (40 * r.nextDouble());
    }
}