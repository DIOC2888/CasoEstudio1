package Interfaces;

// Interfaz que define el comportamiento de los metodos de pago
public interface MetodoPago {

    // Metodo que debe implementar cada tipo de pago para procesar el monto
    void procesarPago(double monto);

    // Metodo que devuelve el nombre del metodo de pago
    String getNombreMetodo();
}