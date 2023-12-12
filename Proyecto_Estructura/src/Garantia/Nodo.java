/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Garantia;

/**
 *
 * @author andre
 */
public class Nodo {
    private int dato=0;
    
    public Nodo (){}

    public Nodo (int pDato){dato=pDato;}
    
    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "peso=" + dato ;
    }
}
