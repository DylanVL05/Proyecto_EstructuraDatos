package proyecto_estructura;

import Usuario.*;
import Cliente.*;
import Vehiculo.*;
import javax.swing.JOptionPane;

public class main {

    public static void main(String[] args) {
        Usuario Vendedor = ModuloLogin.login();
        String[] options = {"Usuarios", "Clientes", "Vehículos", "Garantías", "Informes", "Información", "Cancelar"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú de Selección",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            switch (choice) {
                case 0: // Usuarios
                    Modulo_Usuario.EjecutarModulo(Vendedor);
                    break;
                case 1: // Clientes
                    Modulo_Cliente.EjecutarModulo();
                    break;
                case 2: // Vehículos
                    ModuloVehiculos.EjecutarModulo(Vendedor);
                    break;
                case 3: // Garantías
                    JOptionPane.showMessageDialog(null, "No implementado");
                    break;
                case 4: // Informes
                    ModuloReportes.EjecutarModulo();
                    break;
                case 5: // Información
                    InformacionEmpresa.mostrarInformacionEnDialogo();
                    break;
                case 6: // Cancelar
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida?");
                    break;
            }
        }
    }
}
