package Pagos;

import Interfaces.MetodoPago;

// Clase que representa el pago en efectivo
public class PagoEfectivo implements MetodoPago {

    // Atributo que guarda el dinero recibido del cliente
    private double montoRecibido;

    // Constructor que inicializa el monto recibido
    public PagoEfectivo(double montoRecibido) {
        this.montoRecibido = montoRecibido;
    }

    // Metodo privado que verifica si el dinero alcanza para pagar
    private boolean montoAlcanza(double monto) {
        return montoRecibido >= monto;
    }

    // Metodo privado que calcula el cambio a devolver
    private double cambioEfectuado(double monto) {
        return montoRecibido - monto;
    }

    // Metodo obligatorio de la interfaz que procesa el pago
    @Override
    public void procesarPago(double monto) {

        // Muestra informacion del pago
        System.out.println("Metodo de pago: Efectivo");
        System.out.println("Total a pagar: C$ " + monto);

        // Verifica si el dinero es suficiente
        if (!montoAlcanza(monto)) {
            System.out.println("El monto entregado no es suficiente para completar el pago.");
            return;
        }

        // Calcula el cambio
        double cambio = cambioEfectuado(monto);

        // Muestra resultado del pago
        System.out.println("Pago en efectivo procesado correctamente.");
        System.out.println("Monto recibido: C$ " + montoRecibido);
        System.out.println("Cambio a devolver: C$ " + cambio);
    }

    // Metodo que devuelve el nombre del metodo de pago
    @Override
    public String getNombreMetodo() {
        return "Efectivo";
    }
}