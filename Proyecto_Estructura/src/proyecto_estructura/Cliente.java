/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructura;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author andro
 */
public class Cliente implements Serializable{

 
     private String nombre, apellidos , identificacion , correo, tel ;

    public Cliente(String nombre, String apellidos, String identificacion, String correo, String tel) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.correo = correo;
        this.tel = tel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", identificacion=" + identificacion + ", correo=" + correo + ", tel=" + tel + '}';
    }

 
         public static boolean GuardarCliente(Cliente[] vehiculos){
          try {
            String filename = "Cliente.DYLAN"; //Nombre archivo.extension
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(vehiculos);
            out.close();
            fileOut.close();
            File file = new File(filename);
            String absolutePath = file.getAbsolutePath();
            System.out.println("File saved at: " + absolutePath);
            System.out.println("Cliente object has been serialized and saved to " + filename + ":");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    
      public static Cliente[] leerVehiculos(){
        try {
            String filename = "vehiculo.DYLAN";  
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Cliente[] clientes = (Cliente[]) in.readObject();
            in.close();
            fileIn.close();
            return clientes;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }    
         
    
      
          public static Cliente[] leerClientes(){
        try {
            String filename = "Cliente.DYLAN";  
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Cliente[] clientes = (Cliente[]) in.readObject();
            in.close();
            fileIn.close();
            return clientes;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
      
      
      
      
      
      
      
      
      
      
  public static void main(String[] args) {
    // Crear un array de objetos Cliente para probar
    Cliente[] clientes = new Cliente[2];
    clientes[0] = new Cliente("Nombre1", "Apellido1", "12345", "correo1@example.com", "123456789");
    clientes[1] = new Cliente("Nombre2", "Apellido2", "67890", "correo2@example.com", "987654321");

    // Guardar los objetos Cliente en un archivo
    if (GuardarCliente(clientes)) {
        System.out.println("Clientes guardados correctamente.");
    } else {
        System.out.println("Error al guardar los clientes.");
    }

    // Leer los objetos Cliente desde el archivo
    Cliente[] clientesGuardados = leerClientes();
    if (clientesGuardados != null) {
        System.out.println("Clientes leídos desde el archivo:");
        for (Cliente cliente : clientesGuardados) {
            System.out.println(cliente);
        }
    } else {
        System.out.println("Error al leer los clientes desde el archivo.");
        
    }
    
    Gestion_Clientes.listarClientesRegistrados();
    
    
    
}

        
  
  
        
         
         
         
         
         
         
         
         
         
         
         
         
         
         
    
    
    
}
