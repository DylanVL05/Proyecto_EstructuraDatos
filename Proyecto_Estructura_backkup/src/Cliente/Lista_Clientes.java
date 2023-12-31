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
public class Lista_Clientes {
    


public class ListaClientes implements Serializable {

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

        public ListaClientes(NodoCliente cabeza) {
            this.cabeza = cabeza;
        }

        public ListaClientes() {
        }

    
    
    
    
    //Funciones de la lista (Eliminar , insertar , guardarCLientes , leerclientes,modificar , existe , modificar , extraer 
    
    public void eliminar(String identificacion) {
        if (cabeza == null) {
            return;
        }

        if (cabeza.getDato().getIdentificacion().equals(identificacion)) {
            cabeza = cabeza.getSiguiente();
            return;
        }

        NodoCliente nodoAux = cabeza;
        while (nodoAux.getSiguiente() != null) {
            if (nodoAux.getSiguiente().getDato().getIdentificacion().equals(identificacion)) {
                nodoAux.setSiguiente(nodoAux.getSiguiente().getSiguiente());
                return;
            }
            nodoAux = nodoAux.getSiguiente();
        }

        JOptionPane.showMessageDialog(null, "Cliente no encontrado con Identificación: " + identificacion);
    }
/*
    public void insertar(Cliente cliente) {
        NodoCliente nuevo = new NodoCliente(cliente);
        if (cabeza == null || cliente.getIdentificacion().compareTo(cabeza.getDato().getIdentificacion()) < 0) {
            nuevo.setSiguiente(cabeza);
            this.cabeza = nuevo;
        } else {
            NodoCliente aux = cabeza;
            while (aux.getSiguiente() != null && cliente.getIdentificacion().compareTo(aux.getSiguiente().getDato().getIdentificacion()) >= 0) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
    }

 */
    
    
    
     public void insertar(Cliente cliente) {
        String ultimoID = obtenerUltimoID();
        String nuevoID = generarNuevoID(ultimoID);

        cliente.setIdentificacion(nuevoID);

        NodoCliente nuevo = new NodoCliente(cliente);
        if (cabeza == null || cliente.getIdentificacion().compareTo(cabeza.getDato().getIdentificacion()) < 0) {
            nuevo.setSiguiente(cabeza);
            this.cabeza = nuevo;
        } else {
            NodoCliente aux = cabeza;
            while (aux.getSiguiente() != null && cliente.getIdentificacion().compareTo(aux.getSiguiente().getDato().getIdentificacion()) >= 0) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
    }

    
    
    public static boolean guardarClientes(ListaClientes listaClientes) {
        try {
            String filename = "listaClientes.ser";
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

   public static ListaClientes leerClientes() {
        String filename = "listaVehiculos.sat";

        try (FileInputStream fileIn = new FileInputStream(filename); ObjectInputStream in = new ObjectInputStream(fileIn)) {   
            ObjectStreamClass osc = ObjectStreamClass.lookup(ListaClientes.class);
            ListaClientes li = (ListaClientes) in.readObject();

            return li;
        } catch (FileNotFoundException e) {
            return null;
        } catch (InvalidClassException e) {
            System.err.println("La clase pertenece a una versión anterior");
            return null;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    
   
   
   
   
   
   
   
   
   
   
   
    public boolean existe(String pId) {
        if (cabeza == null) {
            return false;
        } else if (cabeza.getDato().getIdentificacion().equals(pId)) {
            return true;
        } else {
            int comparacion = pId.compareTo(cabeza.getDato().getIdentificacion());
            if (comparacion < 0) {
                return false;
            } else if (comparacion == 0) {
                return true;
            } else {
                NodoCliente aux = cabeza;

                while (aux.getSiguiente() != null) {
                    comparacion = pId.compareTo(aux.getSiguiente().getDato().getIdentificacion());
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

    
   
   public void modificar(String identificacion) {
        NodoCliente nodoAux = cabeza;
        while (nodoAux != null) {
            if (nodoAux.getDato().getIdentificacion().equals(identificacion)) {
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
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                return;
            }
            nodoAux = nodoAux.getSiguiente();
        }

        // Si llegamos aquí, significa que no se encontró el cliente con la ID especificada.
        System.out.println("Cliente con ID " + identificacion + " no encontrado en la lista.");
    }
   
   
    
    
     private String generarNuevoID(String ultimoID) {
        if (ultimoID == null) {
            return "CLI-1"; // El primer cliente tendrá el ID CLI-1
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
            ultimoID = aux.getDato().getIdentificacion();
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
}       
        
        
        
        
        
    

    

    
    
    
    
    
    
    
    
    
    
    
    
    
    

