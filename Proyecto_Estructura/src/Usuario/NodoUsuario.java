/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

/**
 *
 * @author andro
 */
public class NodoUsuario {
    
    
    private Usuario dato;
    
    private NodoUsuario siguiente;

    public NodoUsuario(Usuario usuario) {
        this.dato = usuario;
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
    
    
     @Override
    public String toString() {
        return dato.toString();
    }
    
    
    
    
    
    
    
    
    
    
}
