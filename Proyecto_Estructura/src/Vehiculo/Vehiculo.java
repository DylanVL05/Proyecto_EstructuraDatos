package Vehiculo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Vehiculo implements Serializable {

    private String color;
    private String year;
    private String CC;
    private Tipo Brand; //Enum
    private String Model;
    private String Mileage;
    private String details;
    //private Cliente cliente;
    //private Vendedor vendedor;
    public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setColor("Negro");
        vehiculo.setBrand(Tipo.SEDAN);
        
        Vehiculo vehiculo1 = new Vehiculo();
        vehiculo1.setColor("Blanco");
        vehiculo1.setBrand(Tipo.HATCHBACK);
        
        Vehiculo[] vehiculos= new Vehiculo[2];
        vehiculos[0]= vehiculo;
        vehiculos[1]= vehiculo1;
        GuardarVehiculos(vehiculos);
        vehiculos= null;
        vehiculos= leerVehiculos();
        System.out.println(vehiculos[0].toString());
        System.out.println(vehiculos[1].toString());
        
    }
    public Vehiculo() {
        
        
    }
    public static boolean GuardarVehiculos(Vehiculo[] vehiculos){
          try {
            String filename = "vehiculo.DYLAN"; //Nombre archivo.extension
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(vehiculos);
            out.close();
            fileOut.close();
            File file = new File(filename);
            String absolutePath = file.getAbsolutePath();
            System.out.println("File saved at: " + absolutePath);
            System.out.println("Vehiculo object has been serialized and saved to " + filename + ":");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    public static Vehiculo[] leerVehiculos(){
        try {
            String filename = "vehiculo.DYLAN";  
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Vehiculo[] vehiculos = (Vehiculo[]) in.readObject();
            in.close();
            fileIn.close();
            return vehiculos;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Vehiculo(String color, String year, String CC, Tipo Brand, String Model, String Mileage, String details) {
        this.color = color;
        this.year = year;
        this.CC = CC;
        this.Brand = Brand;
        this.Model = Model;
        this.Mileage = Mileage;
        this.details = details;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCC() {
        return CC;
    }

    public void setCC(String CC) {
        this.CC = CC;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getMileage() {
        return Mileage;
    }

    public void setMileage(String Mileage) {
        this.Mileage = Mileage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getBrand() {
        return Brand.toString();
    }

    public void setBrand(Tipo Brand) {
        this.Brand = Brand;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "color=" + color + ", year=" + year + ", CC=" + CC + ", Brand=" + Brand + ", Model=" + Model + ", Mileage=" + Mileage + ", details=" + details + '}';
    }
    
}
