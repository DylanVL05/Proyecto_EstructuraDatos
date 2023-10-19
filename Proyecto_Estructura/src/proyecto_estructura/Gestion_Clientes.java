/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructura;
    
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

    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    

