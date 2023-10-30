/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import Cliente.Cliente;
import java.io.*;
import javax.swing.JOptionPane;

//  import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
/**
 *
 * @author andro
 */
public class Lista_Clientes implements Serializable {

    private NodoCliente cabeza;

    @Override
    public String toString() {
        String str = "";
        NodoCliente aux = cabeza;
        while (aux != null) {
            str += aux.toString() + "\n";
            aux = aux.getSiguiente();
        }
        return str;
    }

    public NodoCliente getCabeza() {
        return cabeza;
    }

    public Lista_Clientes(NodoCliente cabeza) {
        this.cabeza = cabeza;
    }

    public Lista_Clientes() {
    }

    //Funciones de la lista (Eliminar , insertar , guardarCLientes , leerclientes,modificar , existe , modificar , extraer 
    public void eliminar(String identificacion) {
        if (cabeza == null) {
            return;
        }

        if (cabeza.getDato().getID().equals(identificacion)) {
            cabeza = cabeza.getSiguiente();
            return;
        }

        NodoCliente nodoAux = cabeza;
        while (nodoAux.getSiguiente() != null) {
            if (nodoAux.getSiguiente().getDato().getID().equals(identificacion)) {
                nodoAux.setSiguiente(nodoAux.getSiguiente().getSiguiente());
                return;
            }
            nodoAux = nodoAux.getSiguiente();
        }

        JOptionPane.showMessageDialog(null, "Cliente no encontrado con Identificación: " + identificacion);
    }

    public void insertar(Cliente cliente) {
        String ultimoID = obtenerUltimoID();
        String nuevoID = generarNuevoID(ultimoID);

        cliente.setID(nuevoID);

        NodoCliente nuevo = new NodoCliente(cliente);
        if (cabeza == null || cliente.getID().compareTo(cabeza.getDato().getID()) < 0) {
            nuevo.setSiguiente(cabeza);
            this.cabeza = nuevo;
        } else {
            NodoCliente aux = cabeza;
            while (aux.getSiguiente() != null && cliente.getID().compareTo(aux.getSiguiente().getDato().getID()) >= 0) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
    }

    public static boolean guardarClientes(Lista_Clientes listaClientes) {
        try {
            String filename = "listaClientes.txt";
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(listaClientes);
            out.close();
            fileOut.close();
            File file = new File(filename);
            String absolutePath = file.getAbsolutePath();
            System.out.println("Archivo guardado en: " + absolutePath);
            System.out.println("Clientes han sido serializados y guardados en " + filename);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static Lista_Clientes leerClientes() {
        String filename = "listaClientes.txt";

        try (FileInputStream fileIn = new FileInputStream(filename); ObjectInputStream in = new ObjectInputStream(fileIn)) {
            ObjectStreamClass osc = ObjectStreamClass.lookup(Lista_Clientes.class);
            Lista_Clientes li = (Lista_Clientes) in.readObject();

            return li;
        } catch (FileNotFoundException e) {
            return null;
        } catch (InvalidClassException e) {
            System.err.println("La clase pertenece a una versión anterior");
            return new Lista_Clientes();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Lista_Clientes();
        }
    }

    public boolean existe(String pId) {
        if (cabeza == null) {
            return false;
        } else if (cabeza.getDato().getID().equals(pId)) {
            return true;
        } else {
            int comparacion = pId.compareTo(cabeza.getDato().getID());
            if (comparacion < 0) {
                return false;
            } else if (comparacion == 0) {
                return true;
            } else {
                NodoCliente aux = cabeza;

                while (aux.getSiguiente() != null) {
                    comparacion = pId.compareTo(aux.getSiguiente().getDato().getID());
                    if (comparacion == 0) {
                        return true;
                    } else if (comparacion < 0) {
                        return false;
                    }
                    aux = aux.getSiguiente();
                }
                return false;
            }
        }
    }

    
 public boolean existe_identificacion_CL(String identificacion) {
    NodoCliente aux = cabeza;
    while (aux != null) {
        Cliente cliente = aux.getDato();
        if (cliente != null && cliente.getIdentificacion() != null && cliente.getIdentificacion().equals(identificacion)) {
            return true;
        }
        aux = aux.getSiguiente();
    }
    return false;
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void modificar(String id) {
        NodoCliente nodoAux = cabeza;
        while (nodoAux != null) {
            if (nodoAux.getDato().getID().equals(id)) {
                int opcion = 0;
                while (opcion != 8) {
                    String menu = "Menú de Modificación de Propiedades del Cliente\n"
                            + "1. Modificar nombre\n"
                            + "2. Modificar apellidos\n"
                            + "3. Modificar correo\n"
                            + "4. Modificar teléfono\n"
                            + "5. Salir\n"
                            + "Seleccione una opción:";

                    try {
                        opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
                    } catch (NumberFormatException e) {
                        opcion = 0;
                    }

                    switch (opcion) {
                        case 1:
                            String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:");
                            nodoAux.getDato().setNombre(nuevoNombre);
                            break;
                        case 2:
                            String nuevosApellidos = JOptionPane.showInputDialog("Nuevos apellidos:");
                            nodoAux.getDato().setApellidos(nuevosApellidos);
                            break;
                        case 3:
                            String nuevoCorreo = JOptionPane.showInputDialog("Nuevo correo:");
                            nodoAux.getDato().setCorreo(nuevoCorreo);
                            break;
                        case 4:
                            String nuevoTelefono = JOptionPane.showInputDialog("Nuevo teléfono:");
                            nodoAux.getDato().setTel(nuevoTelefono);
                            break;
                        case 5:
                            JOptionPane.showMessageDialog(null, "Cliente actualizado:\n" + nodoAux.getDato());
                            return;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                }
                return;
            }
            nodoAux = nodoAux.getSiguiente();
        }

        // Si llegamos aquí, significa que no se encontró el cliente con la ID especificada.
        System.out.println("Cliente con ID " + id + " no encontrado en la lista.");
    }

    private String generarNuevoID(String ultimoID) {
        if (ultimoID == null) {
            return "CLI-1";
        } else {
            int ultimoNumero = Integer.parseInt(ultimoID.split("-")[1]);
            int nuevoNumero = ultimoNumero + 1;
            return "CLI-" + nuevoNumero;
        }
    }

    public String obtenerUltimoID() {
        NodoCliente aux = cabeza;
        String ultimoID = null;

        while (aux != null) {
            ultimoID = aux.getDato().getID();
            aux = aux.getSiguiente();
        }

        return ultimoID;
    }

    public Cliente extraer(String identificacion) {
        Cliente cliente = null;
        if (cabeza == null) {
            System.out.println("No es posible extraer");
            return null;
        }

        if (cabeza.getDato().getIdentificacion().equals(identificacion)) {
            cliente = cabeza.getDato();
            cabeza = cabeza.getSiguiente();
            return cliente;
        }

        NodoCliente nodoAux = cabeza;
        while (nodoAux.getSiguiente() != null) {
            if (nodoAux.getSiguiente().getDato().getIdentificacion().equals(identificacion)) {
                cliente = nodoAux.getSiguiente().getDato();
                nodoAux.setSiguiente(nodoAux.getSiguiente().getSiguiente());
                return cliente;
            }
            nodoAux = nodoAux.getSiguiente();
        }

        System.out.println("Cliente no encontrado con Identificación: " + identificacion);
        return cliente;
    }

}
