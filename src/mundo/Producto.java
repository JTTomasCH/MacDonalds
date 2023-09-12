/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author SG702-03
 */
public class Producto<E> {

    private String nombre;
    private long tiempoPreparacion;
    private double costo;

    public Producto(String nombre, long tiempoPreparacion, double costo) {
        this.nombre = nombre;
        this.tiempoPreparacion = tiempoPreparacion;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public long getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public double getCosto() {
        return costo;
    }
    

}
