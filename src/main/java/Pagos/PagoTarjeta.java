package Pagos;

import Interfaces.MetodoPago;

// Clase que representa el pago con tarjeta
public class PagoTarjeta implements MetodoPago {

    // Atributo que guarda el numero de tarjeta
    private String numeroTarjeta;

    // Constructor que inicializa el numero de tarjeta
    public PagoTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    // Metodo privado que valida si la tarjeta tiene 16 digitos numericos
    private boolean validarTarjeta() {
        return numeroTarjeta != null && numeroTarjeta.matches("\\d{16}");
    }

    // Metodo obligatorio de la interfaz que procesa el pago
    @Override
    public void procesarPago(double monto) {

        // Muestra informacion del pago
        System.out.println("Metodo de pago: Tarjeta");
        System.out.println("Total a pagar: C$ " + monto);

        // Verifica si la tarjeta es valida
        if (!validarTarjeta()) {
            System.out.println("Numero de tarjeta invalido. El pago no pudo procesarse.");
            return;
        }

        // Si es valida, procesa el pago
        System.out.println("Pago con tarjeta procesado correctamente.");

        // Muestra solo los ultimos 4 digitos por seguridad
        System.out.println("Tarjeta utilizada: **** **** **** " + numeroTarjeta.substring(12));
    }

    // Metodo que devuelve el nombre del metodo de pago
    @Override
    public String getNombreMetodo() {
        return "Tarjeta";
    }
}