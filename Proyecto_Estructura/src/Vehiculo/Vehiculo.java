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
   /* public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setColor("Negro");
        vehiculo.setBrand(Tipo.SEDAN);
        String filename = "vehiculo.ser";   
        try {
            // Serialize the object
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(vehiculo);
            out.close();
            fileOut.close();
            File file = new File(filename);
            String absolutePath = file.getAbsolutePath();
            System.out.println("File saved at: " + absolutePath);

            System.out.println("Vehiculo object has been serialized and saved to " + filename + ":");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // Deserialize the object
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            vehiculo = (Vehiculo) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Check if vehiculo is successfully deserialized
        if (vehiculo != null) {
            // Log the details to the console
            System.out.println("Deserialized Vehiculo object:");
            System.out.println("Color: " + vehiculo.getColor());
            System.out.println("Year: " + vehiculo.getYear());
            System.out.println("CC: " + vehiculo.getCC());
            System.out.println("Brand: " + vehiculo.getBrand());
            System.out.println("Model: " + vehiculo.getModel());
            System.out.println("Mileage: " + vehiculo.getMileage());
            System.out.println("Details: " + vehiculo.getDetails());
        } else {
            System.out.println("Failed to deserialize the Vehiculo object.");
        }
    }
*/
    public Vehiculo() {
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
}
