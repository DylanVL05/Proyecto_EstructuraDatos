/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructura;

import Vehiculo.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Josué Campos Acuña
 */
public class ModuloVehiculos {

    public static void main(String[] args) {
        EjecutarModulo();
    }

    public static void EjecutarModulo() {
        String[] opciones = {"Mantenimiento de Vehículos", "Venta de Vehículos", "Mostrar información de la empresa", "Salir"};
        while (true) {
            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú Principal", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            switch (seleccion) {
                case 0: //Mantenimiento de vehiculos
                    int submenuSeleccion = -1; // Inicializa la selección del submenú con un valor no válido

                    while (submenuSeleccion != 5) { // Continúa hasta que el usuario seleccione "Volver"
                        String[] submenuOpciones = {"Crear", "Mostrar", "Editar", "Eliminar", "Detalles de la empresa", "Volver"};
                        submenuSeleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Mantenimiento de Vehículos", 0, JOptionPane.QUESTION_MESSAGE, null, submenuOpciones, submenuOpciones[0]);

                        switch (submenuSeleccion) {
                            case 0: // Crear
                                Vehiculo vehiculo = crearNuevoVehiculo();
                                if (vehiculo != null) {
                                    ListaVehiculos l = ListaVehiculos.leerVehiculos();
                                    if (l == null) {
                                        l = new ListaVehiculos();
                                    }
                                    l.inserta(vehiculo);
                                    ListaVehiculos.guardarVehiculos(l);
                                    JOptionPane.showMessageDialog(null, "Se ha agregado un vehículo");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Se canceló la operación");
                                }
                                break;
                            case 1:// Mostrar
                               JOptionPane.showMessageDialog(null, listarVehiculos());
                                break;
                            case 2: // Modificar
                                String id = JOptionPane.showInputDialog("Ingrese el ID del vehículo a modificar (o deje en blanco para cancelar):");
                                if (id != null && !id.isEmpty()) {
                                    ListaVehiculos li = ListaVehiculos.leerVehiculos();
                                    li.modificar(id);
                                    ListaVehiculos.guardarVehiculos(li);
                                }
                                break;
                            case 3: // Eliminar
                                String id2 = JOptionPane.showInputDialog("Ingrese el ID del vehículo a eliminar (o deje en blanco para cancelar):");
                                if (id2 != null && !id2.isEmpty()) {
                                    ListaVehiculos li2 = ListaVehiculos.leerVehiculos();
                                    li2.elimina(id2);
                                    ListaVehiculos.guardarVehiculos(li2);
                                }
                                break;
                            case 4: // MostrarInfo
                                InformacionEmpresa.mostrarInformacionEnDialogo();
                                break;
                            case 5: // Salir
                                break;
                        }
                    }

                    break;
                case 1:
                    // Agrega código para la opción de Venta de Vehículos aquí
                    // Puedes mostrar un diálogo para gestionar la venta de vehículos.
                    break;

                case 2:
                    InformacionEmpresa.mostrarInformacionEnDialogo();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.", "Salir", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }

    public static Vehiculo crearNuevoVehiculo() {
        String color, year, CC, model, mileage, details;
        Tipo brand = null;

        color = obtenerEntrada("Ingrese el color del vehículo:");
        if (color == null) {
            return null;
        }

        year = obtenerEntrada("Ingrese el año del vehículo:");
        if (year == null || !esNumero(year)) {
            return null;
        }

        CC = obtenerEntrada("Ingrese la cilindrada del vehículo:");
        if (CC == null || !esNumero(CC)) {
            return null;
        }

        brand = seleccionarMarca();

        model = obtenerEntrada("Ingrese el modelo del vehículo:");
        if (model == null) {
            return null;
        }

        mileage = obtenerEntrada("Ingrese el kilometraje del vehículo:");
        if (mileage == null || !esNumero(mileage)) {
            return null;
        }

        details = obtenerEntrada("Ingrese detalles adicionales del vehículo:");

        if (color == null || year == null || CC == null || model == null || mileage == null || details == null) {
            return null;
        }

        Vehiculo nuevoVehiculo = new Vehiculo(color, year, CC, brand, model, mileage, details);

        return nuevoVehiculo;
    }

    private static boolean esNumero(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String obtenerEntrada(String mensaje) {
        String entrada;
        do {
            entrada = JOptionPane.showInputDialog(mensaje);
        } while (entrada == null || entrada.trim().isEmpty());
        return entrada;
    }

    private static Tipo seleccionarMarca() {
        String[] opciones = {Tipo.SUV.getTipo(), Tipo.SEDAN.getTipo(), Tipo.HATCHBACK.getTipo()};
        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione la marca (Tipo) del vehículo:", "Marca", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        switch (seleccion) {
            case 0:
                return Tipo.SUV;
            case 1:
                return Tipo.SEDAN;
            case 2:
                return Tipo.HATCHBACK;
            default:
                return Tipo.SUV;
        }
    }

    public static String listarVehiculos() {
        String salida = "";
        ListaVehiculos l = ListaVehiculos.leerVehiculos();
        if (l != null && l.getCabeza()!=null) {
            salida = l.toString();
        } else {
            salida = "No hay vehiculos disponibles...";
        }
        return salida;
    }

}
