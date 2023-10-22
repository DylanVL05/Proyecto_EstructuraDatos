/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructura;

import Cliente.Lista_Clientes.ListaClientes;
import Cliente.NodoCliente;
import Cliente.*;
import javax.swing.JOptionPane;
/**
 *
 * @author andro
 */
public class Modulo_Cliente {
    
    
    
 public static void crearCliente(ListaClientes listaClientes) {
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
            JOptionPane.showMessageDialog(null, "Cliente creado exitosamente: " + nuevoCliente);
        }
 }
    
      public static void listarClientes(ListaClientes listaClientes) {
        NodoCliente aux = listaClientes.getCabeza();
        StringBuilder stringBuilder = new StringBuilder();
        
        while (aux != null) {
            stringBuilder.append(aux.getDato().toString()).append("\n");
            aux = aux.getSiguiente();
        }

        if (stringBuilder.length() > 0) {
            JOptionPane.showMessageDialog(null, "Lista de Clientes:\n" + stringBuilder.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No hay clientes en la lista.");
        }
    }
    
    
    
    
    
    public static void main(String[] args) {
   
    
        crearCliente(listaClientes);
        
  
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    
       public static void listarClientes() {
        // Suponiendo que tienes una instancia de ListaClientes llamada listaClientes.
        ListaClientes listaClientes = ListaClientes.leerVehiculos(); // Obtener la lista de clientes

        if (listaClientes != null && listaClientes.getCabeza() != null) {
            NodoCliente aux = listaClientes.getCabeza();

            while (aux != null) {
                System.out.println(aux.getDato().toString());
                aux = aux.getSiguiente();
            }
        } else {
            System.out.println("No hay clientes registrados.");
        }
    }

           public static void ejecutarModuloClientes() {
        String[] opciones = {"Mantenimiento de Clientes", "Mostrar información de la empresa", "Salir"};

        while (true) {
            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú Principal", 0,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            switch (seleccion) {
                case 0: // Mantenimiento de clientes
                    int submenuSeleccion = -1; 

                    while (submenuSeleccion != 4) {
                        String[] submenuOpciones = {"Crear", "Mostrar", "Eliminar", "Volver"};
                        submenuSeleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:",
                                "Mantenimiento de Clientes", 0, JOptionPane.QUESTION_MESSAGE, null, submenuOpciones,
                                submenuOpciones[0]);

                        switch (submenuSeleccion) {
                            case 0: // Crear cliente
                                Cliente nuevoCliente = crearNuevoCliente();
                                if (nuevoCliente != null) {
                                    ListaClientes listaClientes = ListaClientes.leerClientes();
                                    if (listaClientes == null) {
                                        listaClientes = new ListaClientes();
                                    }
                                    listaClientes.insertar(nuevoCliente);
                                    ListaClientes.guardarClientes(listaClientes);
                                    JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Se canceló la operación.");
                                }
                                break;
                            case 1: // Mostrar clientes
                                JOptionPane.showMessageDialog(null, listarClientes());
                                break;
                            case 2: // Eliminar cliente
                                String identificacion = JOptionPane.showInputDialog("Ingrese el ID del cliente a eliminar (o deje en blanco para cancelar):");
                                if (identificacion != null && !identificacion.isEmpty()) {
                                    ListaClientes listaClientes = ListaClientes.leerClientes();
                                    listaClientes.eliminar(identificacion);
                                    ListaClientes.guardarClientes(listaClientes);
                                }
                                break;
                            case 3: // Volver
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                    }
                    break;
                case 1: // Mostrar información de la empresa
                    InformacionEmpresa.mostrarInformacionEnDialogo();
                    break;
                case 2: // Salir
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.", "Salir", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }

    public static Cliente crearNuevoCliente() {
        String identificacion, nombre, direccion, telefono;

        identificacion = obtenerEntrada("Ingrese la identificación del cliente:");
        if (identificacion == null) {
            return null;
        }

        nombre = obtenerEntrada("Ingrese el nombre del cliente:");
        if (nombre == null) {
            return null;
        }

        direccion = obtenerEntrada("Ingrese la dirección del cliente:");
        if (direccion == null) {
            return null;
        }

        telefono = obtenerEntrada("Ingrese el teléfono del cliente:");
        if (telefono == null) {
            return null;
        }

        Cliente nuevoCliente = new Cliente(identificacion, nombre, direccion, telefono);
        return nuevoCliente;
    }

    public static String obtenerEntrada(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }

    
    

    public static String listarClientes() {
        ListaClientes listaClientes = ListaClientes.leerClientes();
        if (listaClientes != null) {
            return listaClientes.toString();
        } else {
            return "Lista de clientes vacía.";
        }
    }
    
     */
    
    
    
}
       
       
       
       
       
       
       
       
       
       
       

       
       
       

       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
  
    
    
    
    
    
    
    
    
    
    
    
    
    

