/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructura;

import javax.swing.JOptionPane;

/**
 *
 * @author Josué Campos Acuña
 */
public class InformacionEmpresa {
    private static String nombre = "AzzaCar";
    private static String telefono = "8888-8888";
    private static String direccion = "Cartago, Cartago, Occidental";
    public static String obtenerInformacionEmpresa() {
        // Concatenar la información en una cadena de texto
        String informacionEmpresa = "Nombre: " + nombre + "\n" +
                                    "Teléfono: " + telefono + "\n" +
                                    "Dirección: " + direccion;
        return informacionEmpresa;
    }
    public static void mostrarInformacionEnDialogo() {
        String informacion = obtenerInformacionEmpresa();
        JOptionPane.showMessageDialog(null, informacion, "Información de la Empresa", JOptionPane.INFORMATION_MESSAGE);
    }

}
