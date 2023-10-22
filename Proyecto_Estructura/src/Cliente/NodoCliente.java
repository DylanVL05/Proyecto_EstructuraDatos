/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;
import Cliente.Cliente;

import java.io.Serializable;
/**
 *
 * @author Josué Campos Acuña
 */
public class NodoCliente implements Serializable {

  private Cliente dato;
    private NodoCliente siguiente;

    public NodoCliente(Cliente cliente) {
        this.dato = cliente;
        this.siguiente = null;
    }

    public Cliente getDato() {
        return dato;
    }

    public void setDato(Cliente dato) {
        this.dato = dato;
    }

    public NodoCliente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCliente siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return dato.toString();
    }
  
    
  
}
