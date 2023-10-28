package Vehiculo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import javax.swing.JOptionPane;
import Cliente.*;
import Usuario.*;

public class ListaVehiculos implements Serializable {

    private Nodo cabeza;

    @Override
    public String toString() {
        String str = "";
        Nodo aux = cabeza;
        while (aux != null) {
            str += aux.toString() + "\n";
            aux = aux.getSiguiente();
        }
        return str;
    }

    public void VenderVehiculo(String id, Usuario vendedor) {
        Nodo nodoAux = cabeza;
        while (nodoAux != null) {
            if (nodoAux.getDato().getId().equals(id)) {
                if (nodoAux.getDato().getEstado().equals("Disponible")) {
                    String[] options = {"Reservar vehículo", "Vender vehículo"};
                    int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:",
                            "Opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                    String opt = "";
                    switch (choice) {
                        case 0:
                            opt = "Reservado";
                            break;
                        case 1:
                            opt = "Vendido";
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                    Lista_Clientes l = Lista_Clientes.leerClientes();
                    if (l == null) {
                        l = new Lista_Clientes();
                    }
                    NodoCliente ClientesNodo = l.getCabeza();
                    String nombCliente = JOptionPane.showInputDialog(l.toString() + "\nIngrese el ID del cliente:");
                    while (ClientesNodo != null) {
                        if (ClientesNodo.getDato().getID().equals(nombCliente)) {
                            Vehiculo v = nodoAux.getDato();
                            v.setEstado(opt);
                            v.setCliente(ClientesNodo.getDato().getNombre());
                            if ("Reservado".equals(opt)) {
                                ClientesNodo.getDato().setCarrosReservados(ClientesNodo.getDato().getCarrosReservados() + 1);
                            } else {
                                ClientesNodo.getDato().setCarrosComprados(ClientesNodo.getDato().getCarrosComprados() + 1);
                            }
                            nodoAux.setDato(v);
                            
                            return;
                        }
                        ClientesNodo = ClientesNodo.getSiguiente();
                    }
                    JOptionPane.showMessageDialog(null, "Cliente con ID:" + nombCliente + " no encontrado");
                } else {
                    JOptionPane.showMessageDialog(null, "No es posible vender el vehiculo, su dueño es:" + nodoAux.getDato().getCliente());
                }
            }
            nodoAux = nodoAux.getSiguiente();
        }

        System.out.println("Nodo con ID " + id + " no encontrado en la lista.");
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void elimina(String id) {
        if (cabeza == null) {
            return;
        }

        if (cabeza.getDato().getId().equals(id)) {

            cabeza = cabeza.getSiguiente();
            return;
        }

        Nodo nodoAux = cabeza;
        while (nodoAux.getSiguiente() != null) {
            if (nodoAux.getSiguiente().getDato().getId().equals(id)) {

                nodoAux.setSiguiente(nodoAux.getSiguiente().getSiguiente());
                return;
            }
            nodoAux = nodoAux.getSiguiente();
        }

        JOptionPane.showMessageDialog(null, "Elemento no encontrado con ID: " + id);
    }

    public void modificar(String id) {
        Nodo nodoAux = cabeza;
        while (nodoAux != null) {
            if (nodoAux.getDato().getId().equals(id)) {
                if (nodoAux.getDato().getEstado().equals("Disponible")) {
                    int opcion = 0;
                    while (opcion != 8) {
                        String menu = "Menú de Modificación de Propiedades del Vehículo\n"
                                + "1. Modificar color\n"
                                + "2. Modificar año\n"
                                + "3. Modificar CC\n"
                                + "4. Modificar modelo\n"
                                + "5. Modificar kilometraje\n"
                                + "6. Modificar detalles\n"
                                + "7. Modificar marca\n"
                                + "8. Salir\n"
                                + "Seleccione una opción:";

                        try {
                            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
                        } catch (NumberFormatException e) {
                            opcion = 0;
                        }

                        switch (opcion) {
                            case 1:
                                String newColor = JOptionPane.showInputDialog("Nuevo color:");
                                nodoAux.getDato().setColor(newColor);
                                break;
                            case 2:
                                String newYear = JOptionPane.showInputDialog("Nuevo año:");
                                nodoAux.getDato().setYear(newYear);
                                break;
                            case 3:
                                String newCC = JOptionPane.showInputDialog("Nuevo CC:");
                                nodoAux.getDato().setCC(newCC);
                                break;
                            case 4:
                                String newModel = JOptionPane.showInputDialog("Nuevo modelo:");
                                nodoAux.getDato().setModel(newModel);
                                break;
                            case 5:
                                String newMileage = JOptionPane.showInputDialog("Nuevo kilometraje:");
                                nodoAux.getDato().setMileage(newMileage);
                                break;
                            case 6:
                                String newDetails = JOptionPane.showInputDialog("Nuevos detalles:");
                                nodoAux.getDato().setDetails(newDetails);
                                break;
                            case 7:
                                String[] marcas = {Tipo.HATCHBACK.getTipo(), Tipo.SEDAN.getTipo(), Tipo.SUV.getTipo()};
                                int marcaChoice = JOptionPane.showOptionDialog(null, "Seleccione una marca:", "Marca", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, marcas, marcas[0]);

                                if (marcaChoice >= 0 && marcaChoice < marcas.length) {
                                    nodoAux.getDato().setBrand(Tipo.valueOf(marcas[marcaChoice]));
                                } else {
                                    JOptionPane.showMessageDialog(null, "Marca no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                                break;
                            case 8:
                                JOptionPane.showMessageDialog(null, "Vehículo actualizado:\n" + nodoAux.getDato());
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    }

                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "El vehiculo no está disponible");
                    return;
                }
            }
            nodoAux = nodoAux.getSiguiente();
        }

        // Si llegamos aquí, significa que no se encontró el nodo con el ID especificado.
        System.out.println("Nodo con ID " + id + " no encontrado en la lista.");
    }

    public Vehiculo extrae(String id) {
        Vehiculo p = null;
        if (cabeza == null) {
            System.out.println("No es posible extraer");
            return null;
        }

        if (cabeza.getDato().getId().equals(id)) {
            p = cabeza.getDato();
            cabeza = cabeza.getSiguiente();
            return p;
        }

        Nodo nodoAux = cabeza;
        while (nodoAux.getSiguiente() != null) {
            if (nodoAux.getSiguiente().getDato().getId().equals(id)) {

                p = nodoAux.getSiguiente().getDato();
                nodoAux.setSiguiente(nodoAux.getSiguiente().getSiguiente());
                return p;
            }
            nodoAux = nodoAux.getSiguiente();
        }

        System.out.println("Elemento no encontrado con ID: " + id);
        return p;
    }

    public boolean existe(String pId) {
        if (cabeza == null) {
            return false;
        } else if (cabeza.getDato().getId().equals(pId)) {
            return true;
        } else {
            int comparacion = pId.compareTo(cabeza.getDato().getId());
            if (comparacion < 0) {
                return false;
            } else if (comparacion == 0) {
                return true;
            } else {
                Nodo aux = cabeza;

                while (aux.getSiguiente() != null) {
                    comparacion = pId.compareTo(aux.getSiguiente().getDato().getId());
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

    private String generarNuevoID(String ultimoID) {
        if (ultimoID == null) {
            return "VEH-1"; // El primer vehículo tendrá el ID VEH-1
        } else {
            int ultimoNumero = Integer.parseInt(ultimoID.split("-")[1]);
            int nuevoNumero = ultimoNumero + 1;
            return "VEH-" + nuevoNumero;
        }
    }

    public String obtenerUltimoID() {
        Nodo aux = cabeza;
        String ultimoID = null;

        while (aux != null) {
            ultimoID = aux.getDato().getId();
            aux = aux.getSiguiente();
        }

        return ultimoID;
    }

    public void inserta(Vehiculo pdato) {
        String ultimoID = obtenerUltimoID();
        String nuevoID = generarNuevoID(ultimoID);

        pdato.setId(nuevoID);
        pdato.setEstado("Disponible");
        Nodo nuevo = new Nodo(pdato);
        if (cabeza == null || pdato.getId().compareTo(cabeza.getDato().getId()) < 0) {
            nuevo.setSiguiente(cabeza);
            this.cabeza = nuevo;
        } else {
            Nodo aux = cabeza;
            while (aux.getSiguiente() != null && pdato.getId().compareTo(aux.getSiguiente().getDato().getId()) >= 0) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
    }

    public static boolean guardarVehiculos(ListaVehiculos l) {
        try {
            String filename = "listaVehiculos.sat"; // Nombre archivo.extension
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(l);
            out.close();
            fileOut.close();
            File file = new File(filename);
            String absolutePath = file.getAbsolutePath();
            System.out.println("Archivo guardado en: " + absolutePath);
            System.out.println("Vehiculo objects have been serialized and saved to " + filename + ":");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static ListaVehiculos leerVehiculos() {
        String filename = "listaVehiculos.sat";

        try (FileInputStream fileIn = new FileInputStream(filename); ObjectInputStream in = new ObjectInputStream(fileIn)) {
            ObjectStreamClass osc = ObjectStreamClass.lookup(ListaVehiculos.class);
            ListaVehiculos li = (ListaVehiculos) in.readObject();

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
}
