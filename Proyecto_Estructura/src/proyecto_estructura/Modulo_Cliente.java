/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructura;

import Cliente.Lista_Clientes;
import Cliente.NodoCliente;
import Cliente.*;
import javax.swing.JOptionPane;

/**
 *
 * @author andro
 */
public class Modulo_Cliente {

    /*
    public static void crearCliente(Lista_Clientes listaClientes) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del cliente:");
        String identificacion = JOptionPane.showInputDialog("Ingrese la identificación del cliente:");
        String correo = JOptionPane.showInputDialog("Ingrese el correo del cliente:");
        String tel = JOptionPane.showInputDialog("Ingrese el teléfono del cliente:");

        // Verificar si la identificación ya está ocupada
        if (listaClientes.existe(identificacion)) {
            JOptionPane.showMessageDialog(null, "La identificación ya está ocupada por otro cliente. No se pudo crear el cliente.");
        } else {
            Cliente nuevoCliente = new Cliente(nombre, apellidos, identificacion, correo, tel);
            listaClientes.insertar(nuevoCliente);
            Lista_Clientes.guardarClientes(listaClientes);
            JOptionPane.showMessageDialog(null, "Cliente creado exitosamente: " + nuevoCliente);
        }
    }
     */
    public static Cliente crearCliente() {

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del cliente:");
        String identificacion = JOptionPane.showInputDialog("Ingrese la identificación del cliente:");
        String correo = JOptionPane.showInputDialog("Ingrese el correo del cliente:");
        String tel = JOptionPane.showInputDialog("Ingrese el teléfono del cliente:");

        Cliente nuevoCliente = new Cliente(nombre, apellidos, identificacion, correo, tel);

        return nuevoCliente;

    }

    public static String listarClientes() {
        String salida = "";
        Lista_Clientes l = Lista_Clientes.leerClientes();
        if (l != null && l.getCabeza() != null) {
            salida = l.toString();
        } else {
            salida = "No hay clientes disponibles...";
        }
        return salida;
    }

 public static void EjecutarModulo() {
    String[] opciones = {"Crear Cliente", "Modificar Cliente", "Listar Clientes", "Salir"};

    while (true) {
        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú Clientes", 0,
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        switch (seleccion) {
            case 0:
                // Crear Cliente
                Cliente cliente = crearCliente();
                if (cliente != null) {
                    Lista_Clientes l = Lista_Clientes.leerClientes();
                    if (l == null) {
                        l = new Lista_Clientes();
                    }
                    l.insertar(cliente);
                    Lista_Clientes.guardarClientes(l);
                    JOptionPane.showMessageDialog(null, "Se ha creado un nuevo cliente");
                } else {
                    JOptionPane.showMessageDialog(null, "Se canceló la operación");
                }
                break;
            case 1:
                // Modificar Cliente
                String id = JOptionPane.showInputDialog("Ingrese el ID del cliente a modificar (o deje en blanco para cancelar):");
                if (id != null && !id.isEmpty()) {
                    Lista_Clientes li = Lista_Clientes.leerClientes();
                    li.modificar(id);
                    Lista_Clientes.guardarClientes(li);
                }
                break;
            case 2:
                // Listar Clientes
                JOptionPane.showMessageDialog(null, listarClientes());
                break;
            case 3:
                // Salir
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
}

 
    

    

    public static void main(String[] args) {
        EjecutarModulo();

    }

    
}
