package Vehiculo;

public enum Tipo {
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
