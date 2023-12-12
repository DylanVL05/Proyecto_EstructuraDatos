package Garantia;
import javax.swing.JOptionPane;
public class Grafo {

    private String nombre;
    private Nodo matriz[][];

    public Grafo(String pNombre) {

        matriz = new Nodo[3][3];
        nombre = pNombre;
        matriz[0][0] = new Nodo(Integer.parseInt(JOptionPane.showInputDialog("ingresar suv % cashback")));
        matriz[0][1] = new Nodo(Integer.parseInt(JOptionPane.showInputDialog("ingresar suv % km garantia")));
        matriz[0][2] = new Nodo(Integer.parseInt(JOptionPane.showInputDialog("ingresar suv % mantenimientos")));
        matriz[1][0] = new Nodo(Integer.parseInt(JOptionPane.showInputDialog("ingresar sedan % cashback")));
        matriz[1][1] = new Nodo(Integer.parseInt(JOptionPane.showInputDialog("ingresar sedan % km garantia")));
        matriz[1][2] = new Nodo(Integer.parseInt(JOptionPane.showInputDialog("ingresar sedan % mantenimientos")));
        matriz[2][0] = new Nodo(Integer.parseInt(JOptionPane.showInputDialog("ingresar hatchback % cashback")));
        matriz[2][1] = new Nodo(Integer.parseInt(JOptionPane.showInputDialog("ingresar hatchback % km garantia")));
        matriz[2][2] = new Nodo(Integer.parseInt(JOptionPane.showInputDialog("ingresar hatchback % mantenimientos")));
    }

    public String getNombre() {
        return nombre;
    }

    public void imprimeGrafo() {
        String j = "Los pesos entre los nodos son:\n";
        j += "suv % cashback " + matriz[0][0].toString() + " km de garantía  "
                + matriz[0][1].toString() + " cantidad de mantenimientos gratis " + matriz[0][2].toString() + "\n";
        j += "sedan % cashback " + matriz[1][0].toString() + " km de garantía  "
                + matriz[1][1].toString() + " cantidad de mantenimientos gratis " + matriz[1][2].toString() + "\n";
        j += "hatchback % cashback " + matriz[2][0].toString() + " km de garantía  "
                + matriz[2][1].toString() + " cantidad de mantenimientos gratis " + matriz[2][2].toString() + "\n";
        JOptionPane.showMessageDialog(null, j);
    }

}
