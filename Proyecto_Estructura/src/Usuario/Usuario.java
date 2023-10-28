/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import java.io.Serializable;

/**
 *
 * @author andro
 */
public class Usuario implements Serializable {

    private String nombre, apellidos, identificacion, correo, numero_telefono, contrasena, ID;
    private int carrosVendidos;

    public Usuario(String nombre, String apellidos, String identificacion, String correo, String numero, String contrasena) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.correo = correo;
        this.numero_telefono = numero;
        this.contrasena = contrasena;
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

    public String getNumero() {
        return numero_telefono;
    }

    public void setNumero(String numero) {
        this.numero_telefono = numero;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String toString(Usuario user) {
        if (user.getNombre().toLowerCase().equals("admin")) {
            return "ID: " + ID + ", Nombre: " + nombre + ", Apellidos: " + apellidos + ", Email: " + correo
                    + ", Identificación: " + identificacion + ", Teléfono: " + numero_telefono + ", Contraseña: " + contrasena;
        } else {
            return "ID: " + ID + ", Nombre: " + nombre + ", Apellidos: " + apellidos + ", Email: " + correo
                    + ", Identificación: " + identificacion + ", Teléfono: " + numero_telefono + ", Contraseña: " + "********";

        }
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getCarrosVendidos() {
        return carrosVendidos;
    }

    public void setCarrosVendidos(int carrosVendidos) {
        this.carrosVendidos = carrosVendidos;
    }

}
