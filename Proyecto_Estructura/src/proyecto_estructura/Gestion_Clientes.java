/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructura;
    
import java.util.Arrays;
import javax.swing.JOptionPane;







  //  import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
/**
 *
 * @author andro
 */
public class Gestion_Clientes {
    

    
 
    

    
    
       public static void listarClientesRegistrados() {
        // Leer los clientes desde el archivo
        Cliente[] clientesGuardados = Cliente.leerClientes();

        if (clientesGuardados != null) {
            System.out.println("Clientes registrados:");
            for (Cliente cliente : clientesGuardados) {
                JOptionPane.showMessageDialog(null,cliente);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron");
            
            
            
            
        }
        
        
       }
        
        
        public static void crearNuevoCliente() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del cliente:");
        String identificacion = JOptionPane.showInputDialog("Ingrese la identificación del cliente:");
        String correo = JOptionPane.showInputDialog("Ingrese el correo del cliente:");
        String tel = JOptionPane.showInputDialog("Ingrese el número de teléfono del cliente:");

        // Crear un nuevo objeto Cliente con los datos ingresados
        Cliente nuevoCliente = new Cliente(nombre, apellidos, identificacion, correo, tel);

        // Guardar el nuevo cliente en el archivo
        Cliente[] clientesGuardados = Cliente.leerClientes();
        if (clientesGuardados != null) {
            Cliente[] nuevosClientes = Arrays.copyOf(clientesGuardados, clientesGuardados.length + 1);
            nuevosClientes[nuevosClientes.length - 1] = nuevoCliente;
            Cliente.GuardarCliente(nuevosClientes);
            System.out.println("Nuevo cliente creado y guardado correctamente.");
        } else {
            // Si no hay clientes guardados, crear un nuevo array con el nuevo cliente
            Cliente.GuardarCliente(new Cliente[]{nuevoCliente});
            System.out.println("Nuevo cliente creado y guardado correctamente.");
        }
    }

    public static void actualizarClientePorId() {
        String idBuscada = JOptionPane.showInputDialog("Ingrese la identificación del cliente a actualizar:");
        Cliente[] clientesGuardados = Cliente.leerClientes();

        if (clientesGuardados != null) {
            boolean clienteEncontrado = false;
            for (int i = 0; i < clientesGuardados.length; i++) {
                if (clientesGuardados[i].getIdentificacion().equals(idBuscada)) {
                    // Cliente encontrado, solicitar nuevos datos y actualizarlos
                    String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del cliente:");
                    String nuevosApellidos = JOptionPane.showInputDialog("Ingrese los nuevos apellidos del cliente:");
                    String nuevoCorreo = JOptionPane.showInputDialog("Ingrese el nuevo correo del cliente:");
                    String nuevoTel = JOptionPane.showInputDialog("Ingrese el nuevo número de teléfono del cliente:");

                    // Actualizar los datos del cliente
                    clientesGuardados[i].setNombre(nuevoNombre);
                    clientesGuardados[i].setApellidos(nuevosApellidos);
                    clientesGuardados[i].setCorreo(nuevoCorreo);
                    clientesGuardados[i].setTel(nuevoTel);

                    // Guardar los cambios en el archivo
                    Cliente.GuardarCliente(clientesGuardados);
                    System.out.println("Cliente actualizado correctamente.");
                    clienteEncontrado = true;
                    break;
                }
            }

            if (!clienteEncontrado) {
                System.out.println("Cliente no encontrado con la identificación proporcionada.");
            }
        } else {
            System.out.println("No hay clientes registrados para actualizar.");
        }
    }
}
        
        
        
        
        
        
        
        
    

    

    
    
    
    
    
    
    
    
    
    
    
    
    
    

