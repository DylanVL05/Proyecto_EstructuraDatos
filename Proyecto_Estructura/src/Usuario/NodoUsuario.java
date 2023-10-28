/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import java.io.Serializable;

/**
 *
 * @author andro
 */
public class NodoUsuario  implements Serializable {
    private Usuario dato;
    private NodoUsuario siguiente;

    public NodoUsuario(Usuario cliente) {
        this.dato = cliente;
        this.siguiente = null;
    }
 
    public Usuario getDato() {
        return dato;
    }

    public void setDato(Usuario dato) {
        this.dato = dato;
    }

    public NodoUsuario getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoUsuario siguiente) {
        this.siguiente = siguiente;
    }

    public String toString(Usuario user) {
        return dato.toString(user);
    }
}
