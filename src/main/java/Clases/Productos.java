package Clases;

public class Productos {
    private String nombre;
    private double precio;
    private int cantidad;  // le agregue cantidad como atributo por que sino no iba a poder calcular el total en pedidos
    private boolean disponibilidad;

    public Productos(String nombre, double precio, int cantidad, boolean disponibilidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.disponibilidad = disponibilidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
