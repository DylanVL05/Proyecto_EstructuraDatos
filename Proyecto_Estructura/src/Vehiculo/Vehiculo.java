package Vehiculo;

import java.io.Serializable;

public class Vehiculo implements Serializable {

    private String id;
    private String color;
    private String year;
    private String CC;
    private Tipo Brand; //Enum
    private String Model;
    private String Mileage;
    private String details;
    private String cliente;
    private String estado;
    private String vendedor;

    /* public static void main(String[] args) {
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
        
    }*/
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

    @Override

    public String toString() {
        return "Carro #: " + id
                + ", Color: " + color
                + ", Año: " + year
                + ", Cilindrada: " + CC
                + ", Marca: " + Brand.getTipo()
                + ", Modelo: " + Model
                + ", Kilometraje: " + Mileage
                + ", Detalles: " + details
                + ", Cliente: " + cliente
                + ", Estado: " + estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
}
