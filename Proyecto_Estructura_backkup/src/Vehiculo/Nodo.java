/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculo;
import java.io.Serializable;
/**
 *
 * @author Josué Campos Acuña
 */
public class Nodo implements Serializable {

    public Vehiculo getDato() {
        return dato;
    }

    public void setDato(Vehiculo dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    private Vehiculo dato;
    private Nodo siguiente;

    public Nodo(Vehiculo dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return dato.toString();
    }
    

}
