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
        
       
    try {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
        String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del usuario:");
        String identificacion;

        while (true) {
            identificacion = JOptionPane.showInputDialog("Ingrese la identificación del usuario:");
            if (!listaUsuarios.existe_identificacion(identificacion)) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un usuario con esa identificación. Inténtelo de nuevo.");
            }
        }

        String correo = JOptionPane.showInputDialog("Ingrese el correo del usuario:");
        String numero = JOptionPane.showInputDialog("Ingrese el número de teléfono del usuario:");
        String pass1, pass2;
        do {
            pass1 = JOptionPane.showInputDialog("Ingrese la nueva contraseña:");
            pass2 = JOptionPane.showInputDialog("Confirme la nueva contraseña:");

            if (pass1.equals(pass2)) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden. Inténtelo de nuevo.");
            }
        } while (true);

        Usuario nuevoUsuario = new Usuario(nombre, apellidos, identificacion, correo, numero, pass1);
        return nuevoUsuario;
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Ha ocurrido un error al crear el usuario.");
        return null;
    }


        
        
    
        
    }

    public static String listarUsuarios(Usuario user) {
        Lista_Usuario listaUsuarios = Lista_Usuario.leerUsuarios();
        if (listaUsuarios != null && listaUsuarios.getCabeza() != null) {
            return listaUsuarios.toString(user);
        } else {
            return "No hay usuarios disponibles...";
        }
    }

    public static void EjecutarModulo(Usuario user) {
        String[] opciones = {"Crear Usuario", "Modificar Usuario", "Listar Usuarios", "Eliminar Usuario", "Información de la Empresa", "Salir"};

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
                    JOptionPane.showMessageDialog(null, listarUsuarios(user));
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
                    // Información de la Empresa
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



    
    
    
    
    
    
    
    
    
}