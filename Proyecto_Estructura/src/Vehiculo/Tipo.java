package Vehiculo;

import java.io.Serializable;

public enum Tipo implements Serializable {
    SUV("SUV"),
    SEDAN("SEDAN"),
    HATCHBACK("HATCHBACK");

    private String tipo;

    Tipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
