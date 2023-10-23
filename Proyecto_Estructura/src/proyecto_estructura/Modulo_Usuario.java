/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructura;
import Usuario.*;
import Usuario.Lista_Usuario;
/**
 *
 * @author andro
 */
import javax.swing.JOptionPane;

public class Modulo_Usuario {

    public static Usuario crearUsuario(Lista_Usuario listaUsuarios) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
        String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del usuario:");
        String identificacion = JOptionPane.showInputDialog("Ingrese la identificación del usuario:");
        String correo = JOptionPane.showInputDialog("Ingrese el correo del usuario:");
        String numero = JOptionPane.showInputDialog("Ingrese el número de teléfono del usuario:");

        // Verificar si la identificación ya está ocupada
        if (listaUsuarios.existe(identificacion)) {
            throw new IllegalArgumentException("La identificación ya está ocupada por otro usuario.");
        }

        Usuario nuevoUsuario = new Usuario(nombre, apellidos, identificacion, correo, numero, correo);
        return nuevoUsuario;
    }

    public static String listarUsuarios() {
        Lista_Usuario listaUsuarios = Lista_Usuario.leerUsuarios();
        if (listaUsuarios != null && listaUsuarios.getCabeza() != null) {
            return listaUsuarios.toString();
        } else {
            return "No hay usuarios disponibles...";
        }
    }

    public static void EjecutarModulo() {
        String[] opciones = {"Crear Usuario", "Modificar Usuario", "Listar Usuarios", "Eliminar Usuario", "Salir"};

        while (true) {
            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú Usuarios", 0,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            switch (seleccion) {
                case 0:
                    // Crear Usuario
                    try {
                        Usuario usuario = crearUsuario(Lista_Usuario.leerUsuarios());
                        Lista_Usuario listaUsuarios = Lista_Usuario.leerUsuarios();
                        if (listaUsuarios == null) {
                            listaUsuarios = new Lista_Usuario();
                        }
                        listaUsuarios.insertar(usuario);
                        Lista_Usuario.guardarUsuario(listaUsuarios);
                        JOptionPane.showMessageDialog(null, "Se ha creado un nuevo usuario");
                    } catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 1:
                    // Modificar Usuario
                    String id = JOptionPane.showInputDialog("Ingrese el ID del usuario a modificar (o deje en blanco para cancelar):");
                    if (id != null && !id.isEmpty()) {
                        Lista_Usuario listaUsuarios = Lista_Usuario.leerUsuarios();
                        listaUsuarios.modificar(id);
                        Lista_Usuario.guardarUsuario(listaUsuarios);
                    }
                    break;
                case 2:
                    // Listar Usuarios
                    JOptionPane.showMessageDialog(null, listarUsuarios());
                    break;
                case 3:
                    // Eliminar Usuario
                    String idEliminar = JOptionPane.showInputDialog("Ingrese el ID del usuario a eliminar (o deje en blanco para cancelar):");
                    if (idEliminar != null && !idEliminar.isEmpty()) {
                        Lista_Usuario listaUsuarios = Lista_Usuario.leerUsuarios();
                        listaUsuarios.eliminar(idEliminar);
                        Lista_Usuario.guardarUsuario(listaUsuarios);
                    }
                    break;
                case 4:
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
