package proyecto_estructura;

import Cliente.Lista_Clientes;
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
    
    public static void EjecutarModulo(){  
        
        int op=0;        
        do{
            String menu="";
            menu+="1.- Cantidad de autos \n";
            menu+="2.- Clientes \n";
            menu+="3.- Top 3 clientes \n";
            menu+="4.- Ventas por vendedor \n";
            menu+="5.- Reservas por vendedor \n";
            menu+="6.- Mostrar información de la empresa \n";
            menu+="7.- Volver al menu principal \n";
            menu+="Elija una opción";
            
            op=Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch(op){
          
                
            case 1: //cantidad de vehiculos
                int submenuSeleccion = -1; // Inicializa la selección del submenú con un valor no válido

                    while (submenuSeleccion != 4) { // Continúa hasta que el usuario seleccione "Volver"
                        String[] submenuOpciones = {"Vehiculos vendidos", "Vehiculos reservados", "Vehiculos disponibles","Mostrar información de la empresa", "Volver"};
                        submenuSeleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Cantidad total de vehiculos", 0, JOptionPane.QUESTION_MESSAGE, null, submenuOpciones, submenuOpciones[0]);
                        switch (submenuSeleccion) {
                            case 0: // Vehiculos vendidos
                              ListaVehiculos vendidos=ListaVehiculos.leerVehiculos();                       
                              if (vendidos.getCabeza().getDato().getEstado() == null) {
                                    System.out.println("La lista está vacía.");
                                 
                                }else{
                               
                                        StringBuilder vehiculosVendidos = new StringBuilder();
                                        Nodo aux = vendidos.getCabeza();

                                        while (aux != null) {
                                            if (aux.getDato().getEstado().equals("Vendido")) {
                                                vehiculosVendidos.append("Modelo: ").append(aux.getDato().getModel()).append(", Estado: ").append(aux.getDato().getEstado()).append("\n");
                                            }
                                            aux = aux.getSiguiente();
                                        }

                                        if (vehiculosVendidos.length() > 0) {
                                            JOptionPane.showMessageDialog(null, "Vehículos Vendidos:\n" + vehiculosVendidos.toString());
                                        } else {
                                            JOptionPane.showMessageDialog(null, "No hay vehículos vendidos.");
                                        }
                                                                  
                              }
                              
                                break;
                            case 1:// Vehiculos reservados
                               ListaVehiculos reservados=ListaVehiculos.leerVehiculos();
                                if (reservados.getCabeza().getDato().getEstado() == null) {
                                    System.out.println("La lista está vacía.");
                                 
                                }  else{
                                StringBuilder vehiculosReservados = new StringBuilder();
                                        Nodo aux = reservados.getCabeza();

                                        while (aux != null) {
                                            if (aux.getDato().getEstado().equals("Reservado")) {
                                                vehiculosReservados.append("Modelo: ").append(aux.getDato().getModel()).append(", Estado: ").append(aux.getDato().getEstado()).append("\n");
                                            }
                                            aux = aux.getSiguiente();
                                        }

                                        if (vehiculosReservados.length() > 0) {
                                            JOptionPane.showMessageDialog(null, "Vehículos Reservados:\n" + vehiculosReservados.toString());
                                        } else {
                                            JOptionPane.showMessageDialog(null, "No hay vehículos Reservados.");
                                        }
                                }
                              
             
                                break;
                            case 2: // Vehiculos disponibles
                               ListaVehiculos disponibles=ListaVehiculos.leerVehiculos();
                                if (disponibles.getCabeza().getDato().getEstado() == null) {
                                    System.out.println("La lista está vacía.");
                                 
                                }else{
                                StringBuilder vehiculosDisponibles = new StringBuilder();
                                        Nodo aux = disponibles.getCabeza();

                                        while (aux != null) {
                                            if (aux.getDato().getEstado().equals("Disponible")) {
                                                vehiculosDisponibles.append("Modelo: ").append(aux.getDato().getModel()).append(", Estado: ").append(aux.getDato().getEstado()).append("\n");
                                            }
                                            aux = aux.getSiguiente();
                                        }

                                        if (vehiculosDisponibles.length() > 0) {
                                            JOptionPane.showMessageDialog(null, "Vehículos Disponibles:\n" + vehiculosDisponibles.toString());
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
                        String[] submenuOpciones = {"Clientes registrados", "Clientes que compraron vehiculo", "Clientes que reservaron vehiculo","Mostrar información de la empresa", "Volver"};
                        submenuSeleccion1 = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Clientes", 0, JOptionPane.QUESTION_MESSAGE, null, submenuOpciones, submenuOpciones[0]);

                        switch (submenuSeleccion1) {
                            case 0: // Clientes registrados
                                Lista_Clientes clientes=Lista_Clientes.leerClientes();
                        //       clientes.getCabeza().getDato().getNombre();
                                
                                if (clientes.getCabeza() == null) {
                                    System.out.println("La lista está vacía.");
                                 
                                }else
                                {
                                     String clientesRegistrados = clientes.toString();
                                    JOptionPane.showMessageDialog(null, "Clientes Registrados:\n" + clientesRegistrados);
                                }                
                              
                                break;
                            case 1:// Clientes que compraron vehiculo
                                ListaVehiculos comprados=ListaVehiculos.leerVehiculos();
                           // comprados.getCabeza().getDato().getEstado();
                                //implementar un conteins para que no se repita si un cliente compró varios vehiculos
                                if (comprados.getCabeza().getDato().getCliente() == null) {
                                    System.out.println("La lista de clientes está vacía.");
                                 
                                }else
                                {
                                   
                                }   
                                
                                
                                
                               
                                break;
                            case 2: // Clientes que reservaron vehiculo
                                ListaVehiculos reservados=ListaVehiculos.leerVehiculos();
                          //      reservados.getCabeza().getDato().getEstado();
                                //implementar un conteins para que no se repita si un cliente compró varios vehiculos
                                if (reservados.getCabeza().getDato().getEstado()== null) {
                                    System.out.println("La lista de clientes con reservas está vacía.");
                                 
                                }else
                                {
                                   
                                }
                                     
                               
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
        }while(op>=8);         
    }        
    }
