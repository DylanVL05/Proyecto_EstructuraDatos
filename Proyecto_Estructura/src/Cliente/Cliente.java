/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import java.io.Serializable;

/**
 *
 * @author andro
 */
public class Cliente implements Serializable {

    private String nombre, apellidos, identificacion, correo, tel, ID;
    private int carrosComprados, carrosReservados;

    public Cliente(String nombre, String apellidos, String identificacion, String correo, String tel) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.correo = correo;
        this.tel = tel;
    }

    public Cliente() {
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
        return "ID: " + ID + ", Nombre: " + nombre + ", Apellidos: " + apellidos + ", Email: " + correo
                + ", Identificación: " + identificacion + ", Teléfono: " + tel + ", Veh-Comprados: " + carrosComprados + ", Veh-Reservados: " + carrosReservados;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getCarrosComprados() {
        return carrosComprados;
    }

    public void setCarrosComprados(int carrosComprados) {
        this.carrosComprados = carrosComprados;
    }

    public int getCarrosReservados() {
        return carrosReservados;
    }

    public void setCarrosReservados(int carrosReservados) {
        this.carrosReservados = carrosReservados;
    }

}
