/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructura;

import Usuario.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Josué Campos Acuña
 */
public class ModuloLogin {

    public static Usuario login() {
        Usuario user;
        do {
            user = logica();
        } while (user == null);
        return user;
    }

    public static void Salir() {
        JOptionPane.showMessageDialog(null, "Se ha cancelado el inicio de sesión, saliendo...");
        System.exit(0);
    }

    public static Usuario logica() {
        String username = JOptionPane.showInputDialog(null, "Ingrese el nombre de usuario:");
        if (username.toLowerCase().equals("salida")) {
            Salir();
        }
        String password = JOptionPane.showInputDialog(null, "Ingrese la contraseña:");

        if (password.toLowerCase().equals("salida")) {
            Salir();
        }
        Lista_Usuario li = Lista_Usuario.leerUsuarios();
        if (li == null) {
            li = new Lista_Usuario();
            li.insertar(new Usuario("Admin", "admin", "0", "admin@AzzaCar.com", "8888-8888", "password"));
            Lista_Usuario.guardarUsuario(li);
        }

        NodoUsuario current = li.getCabeza();
        Usuario user = null;

        while (current != null) {
            if (current.getDato().getContrasena().equalsIgnoreCase(password) && current.getDato().getNombre().equalsIgnoreCase(username)) {
                user = current.getDato();
                break;
            }
            current = current.getSiguiente();
        }

        if (user == null) {
            JOptionPane.showMessageDialog(null, "Usuario inválido\nValide que sus credenciales sean correctas...");
        } else {
            JOptionPane.showMessageDialog(null, "Bienvenido " + user.getNombre() + "\n" + user.getCorreo());
        }

        return user;
    }
    /*public static void main(String[] args) {
        login();
    }*/
}
