package proyecto_estructura;

import Cliente.Lista_Clientes;
import Cliente.NodoCliente;
import Vehiculo.ListaVehiculos;
import javax.swing.JOptionPane;
import Vehiculo.ListaVehiculos;
import Vehiculo.Nodo;
import javax.swing.JOptionPane;
import proyecto_estructura.InformacionEmpresa;

/**
 *
 * @author Luis
 */
public class ModuloReportes {

    public static void main(String[] args) {
        EjecutarModulo();
    }

    public static void EjecutarModulo() {

        int op = 0;
        do {
            String menu = "";
            menu += "1.- Cantidad de autos \n";
            menu += "2.- Clientes \n";
            menu += "3.- Top 3 clientes \n";
            menu += "4.- Ventas por vendedor \n";
            menu += "5.- Reservas por vendedor \n";
            menu += "6.- Mostrar información de la empresa \n";
            menu += "7.- Volver al menu principal \n";
            menu += "Elija una opción";

            op = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (op) {

                case 1: //cantidad de vehiculos
                    int submenuSeleccion = -1; // Inicializa la selección del submenú con un valor no válido

                    while (submenuSeleccion != 4) { // Continúa hasta que el usuario seleccione "Volver"
                        String[] submenuOpciones = {"Vehiculos vendidos", "Vehiculos reservados", "Vehiculos disponibles", "Mostrar información de la empresa", "Volver"};
                        submenuSeleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Cantidad total de vehiculos", 0, JOptionPane.QUESTION_MESSAGE, null, submenuOpciones, submenuOpciones[0]);
                        switch (submenuSeleccion) {
                            case 0: // Vehiculos vendidos
                                ListaVehiculos vendidos = ListaVehiculos.leerVehiculos();
                                if (vendidos == null) {
                                    vendidos = new ListaVehiculos();
                                }
                                if (vendidos.getCabeza() == null) {
                                    System.out.println("La lista está vacía.");

                                } else {

                                    StringBuilder vehiculosVendidos = new StringBuilder();
                                    Nodo aux = vendidos.getCabeza();
                                    int val = 0;
                                    while (aux != null) {
                                        if (aux.getDato().getEstado().equals("Vendido")) {
                                            vehiculosVendidos.append("Modelo: ").append(aux.getDato().getModel()).append(", Estado: ").append(aux.getDato().getEstado()).append("\n");
                                            val++;
                                        }
                                        aux = aux.getSiguiente();
                                    }

                                    if (vehiculosVendidos.length() > 0) {
                                        JOptionPane.showMessageDialog(null, "Vehículos Vendidos:\n" + vehiculosVendidos.toString() + "\nTotal vendidos:" + val);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "No hay vehículos vendidos.");
                                    }

                                }

                                break;
                            case 1:// Vehiculos reservados
                                ListaVehiculos reservados = ListaVehiculos.leerVehiculos();
                                if (reservados == null) {
                                    reservados = new ListaVehiculos();
                                }
                                if (reservados.getCabeza() == null) {
                                    System.out.println("La lista está vacía.");

                                } else {
                                    StringBuilder vehiculosReservados = new StringBuilder();
                                    Nodo aux = reservados.getCabeza();
                                    int val = 0;
                                    while (aux != null) {
                                        if (aux.getDato().getEstado().equals("Reservado")) {
                                            vehiculosReservados.append("Modelo: ").append(aux.getDato().getModel()).append(", Estado: ").append(aux.getDato().getEstado()).append("\n");
                                            val++;
                                        }
                                        aux = aux.getSiguiente();
                                    }

                                    if (vehiculosReservados.length() > 0) {
                                        JOptionPane.showMessageDialog(null, "Vehículos Reservados:\n" + vehiculosReservados.toString() + "\nTotal reservados:" + val);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "No hay vehículos Reservados.");
                                    }
                                }

                                break;
                            case 2: // Vehiculos disponibles
                                ListaVehiculos disponibles = ListaVehiculos.leerVehiculos();
                                if (disponibles == null) {
                                    disponibles = new ListaVehiculos();
                                }
                                if (disponibles.getCabeza() == null) {
                                    System.out.println("La lista está vacía.");

                                } else {
                                    StringBuilder vehiculosDisponibles = new StringBuilder();
                                    Nodo aux = disponibles.getCabeza();
                                    int val = 0;
                                    while (aux != null) {
                                        if (aux.getDato().getEstado().equals("Disponible")) {
                                            vehiculosDisponibles.append("Modelo: ").append(aux.getDato().getModel()).append(", Estado: ").append(aux.getDato().getEstado()).append("\n");
                                            val++;
                                        }
                                        aux = aux.getSiguiente();
                                    }

                                    if (vehiculosDisponibles.length() > 0) {
                                        JOptionPane.showMessageDialog(null, "Vehículos Disponibles:\n" + vehiculosDisponibles.toString() + "\nTotal reservados:" + val);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "No hay vehículos Disponibles.");
                                    }
                                }

                                break;
                            case 3: // MostrarInfo
                                InformacionEmpresa.mostrarInformacionEnDialogo();
                                break;
                            case 4: // volver
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                    }
                    break;
                case 2: //Clientes
                    int submenuSeleccion1 = -1; // Inicializa la selección del submenú con un valor no válido

                    while (submenuSeleccion1 != 4) { // Continúa hasta que el usuario seleccione "Volver"
                        String[] submenuOpciones = {"Clientes registrados", "Clientes que compraron vehiculo", "Clientes que reservaron vehiculo", "Mostrar información de la empresa", "Volver"};
                        submenuSeleccion1 = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Clientes", 0, JOptionPane.QUESTION_MESSAGE, null, submenuOpciones, submenuOpciones[0]);

                        switch (submenuSeleccion1) {
                            case 0: // Clientes registrados
                                JOptionPane.showMessageDialog(null, "Clientes registrados:\n" + Modulo_Cliente.listarClientes());

                                break;
                            case 1:// Clientes que compraron vehiculo
                                Lista_Clientes liCli = Lista_Clientes.leerClientes();
                                if (liCli == null) {
                                    liCli = new Lista_Clientes();
                                }
                                StringBuilder str = new StringBuilder();
                                str.append("Clientes que compraron vehiculos:").append("\n");
                                NodoCliente aux = liCli.getCabeza();
                                while (aux != null) {
                                    if (aux.getDato().getCarrosComprados() > 0) {
                                        str.append("ID:").append(aux.getDato().getID()).append(", ").append(aux.getDato().getNombre()).append(" ").append(aux.getDato().getApellidos()).append(", cantidad:").append(aux.getDato().getCarrosComprados()).append("\n");
                                    }
                                    aux = aux.getSiguiente();
                                }
                                JOptionPane.showMessageDialog(null, str.toString());
                                break;
                            case 2: // Clientes que reservaron vehiculo
                                Lista_Clientes liCli2 = Lista_Clientes.leerClientes();
                                if (liCli2 == null) {
                                    liCli2 = new Lista_Clientes();
                                }
                                StringBuilder str1 = new StringBuilder();
                                str1.append("Clientes que compraron vehiculos:").append("\n");
                                NodoCliente aux1 = liCli2.getCabeza();
                                while (aux1 != null) {
                                    if (aux1.getDato().getCarrosReservados() > 0) {
                                        str1.append("ID:").append(aux1.getDato().getID()).append(", ").append(aux1.getDato().getNombre()).append(" ").append(aux1.getDato().getApellidos()).append(", cantidad:").append(aux1.getDato().getCarrosReservados()).append("\n");
                                    }
                                    aux1 = aux1.getSiguiente();
                                }
                                JOptionPane.showMessageDialog(null, str1.toString());
                                break;
                            case 3: // MostrarInfo
                                InformacionEmpresa.mostrarInformacionEnDialogo();
                                break;
                            case 4: // volver
                                // submenuSeleccion1=-1;
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                        }

                    }
                    break;

                case 3: //Top 3 clientes                  
                    //   ListaVehiculos top=ListaVehiculos.leerVehiculos();
                    //   top.getCabeza().getDato().getCliente();
                    //Como saber cuantos vehiculos tiene un cliente?             
                    ListaVehiculos top = ListaVehiculos.leerVehiculos();
                    if (top.getCabeza() == null) {
                        System.out.println("La lista está vacía.");

                    }

                    break;
                case 4: //Ventas por vendedor
                    //esto va con el modulo de Login
                    Usuario.Lista_Usuario ventasVendedor = Usuario.Lista_Usuario.leerUsuarios();
                    // if (ventasVendedor.getCabeza().getDato().)
                    //debe tener un contador de ventas

                    break;
                case 5:  //Reservas por vendedor
                    //esto va con el modulo de Login
                    Usuario.Lista_Usuario reservasVendedor = Usuario.Lista_Usuario.leerUsuarios();
                    //debe tener un contador de reservas
                    //con la lista de vehículo, crear una lista aux que no guarde
                    //iterar con la lista de lo que salga en reservado y hacer un push a la auxiliar(get dato)

                    break;
                case 6:
                    InformacionEmpresa.mostrarInformacionEnDialogo();
                    break;
                case 7:

                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (op >= 8);
    }
}
