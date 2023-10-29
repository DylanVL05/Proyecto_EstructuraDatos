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

    public static Cliente crearCliente(Lista_Clientes listaClientes) {
        try {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
            String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del cliente:");
            String identificacion;

            while (true) {
                identificacion = JOptionPane.showInputDialog("Ingrese la identificación del cliente:");
                if (!listaClientes.existe_identificacion_CL(identificacion)) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe un cliente con esa identificación. Inténtelo de nuevo.");
                }
            }

            String correo = JOptionPane.showInputDialog("Ingrese el correo del cliente:");
            String tel = JOptionPane.showInputDialog("Ingrese el teléfono del cliente:");

            Cliente nuevoCliente = new Cliente(nombre, apellidos, identificacion, correo, tel);
            return nuevoCliente;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al crear el cliente.");
            return null;
        }
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
        String[] opciones = {"Crear Cliente", "Modificar Cliente", "Listar Clientes", "Eliminar Cliente", "Información de la empresa", "Salir"};

        while (true) {
            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú Clientes", 0,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            Lista_Clientes listaClientes = Lista_Clientes.leerClientes();
            if (listaClientes == null) {
                listaClientes = new Lista_Clientes();
            }

            switch (seleccion) {
                case 0:
                    // Crear Cliente
                    Cliente cliente = crearCliente(listaClientes);
                    if (cliente != null) {
                        listaClientes.insertar(cliente);
                        Lista_Clientes.guardarClientes(listaClientes);
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
                    // Eliminar Cliente
                    String id2 = JOptionPane.showInputDialog("Ingrese el ID del cliente a eliminar (o deje en blanco para cancelar):");
                    if (id2 != null && !id2.isEmpty()) {
                        Lista_Clientes li2 = Lista_Clientes.leerClientes();
                        li2.eliminar(id2);
                        Lista_Clientes.guardarClientes(li2);
                    }
                    break;
                case 4:
                    InformacionEmpresa.mostrarInformacionEnDialogo();
                    break;
                case 5:
                    return;
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
