/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructura;

import Garantia.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModuloGarantias { 
    ArrayList<Grafo> garantias = new ArrayList<Grafo>();  
    public void AgregarVehiculo(String marca) {
        boolean bandera = false;
        for (int i = 0; garantias.size() > i; i++) {
            if (garantias.get(i).getNombre().equals(marca)) {
                bandera = true;
            }
        }
        if (!bandera) {
            garantias.add(new Grafo(marca));
        }
    }
    public void buscarGarantia(String marca) {
        boolean bandera2 = false;
        for (int i = 0; garantias.size() > i; i++) {
            if (garantias.get(i).getNombre().equals(marca)) {
                bandera2 = true;
                garantias.get(i).imprimeGrafo();
                break;
            }
        }
        if (!bandera2) {
            JOptionPane.showMessageDialog(null, "No existe la garantia buscada del vehiculo...!");
        }
    }
}
