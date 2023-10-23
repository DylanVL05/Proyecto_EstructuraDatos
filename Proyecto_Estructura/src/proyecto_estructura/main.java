package proyecto_estructura;

import Usuario.*;
import Cliente.*;
import Vehiculo.*;
import javax.swing.JOptionPane;

public class main {

    public static void main(String[] args) {
        Usuario Vendedor = ModuloLogin.login();
        String[] options = {"Usuarios", "Clientes", "Vehículos", "Función Adicional", "Cancelar"};
        int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú de Selección",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0: // Usuarios
                // Agregar código para gestionar Usuarios
                JOptionPane.showMessageDialog(null, "Gestionar Usuarios seleccionado");
                break;
            case 1: // Clientes
                // Agregar código para gestionar Clientes
                JOptionPane.showMessageDialog(null, "Gestionar Clientes seleccionado");
                break;
            case 2: // Vehículos
                // Agregar código para gestionar Vehículos
                JOptionPane.showMessageDialog(null, "Gestionar Vehículos seleccionado");
                break;
            case 3: // Función Adicional
                // Agregar código para la Función Adicional
                JOptionPane.showMessageDialog(null, "Función Adicional seleccionada");
                break;
            case 4: // Cancelar
                // Opcional: Agregar código para manejar la cancelación
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                break;
            default:
                // Manejar otros casos
                break;
        }
    }

}
