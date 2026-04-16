package Pagos;

import Interfaces.MetodoPago;

public class PagoTarjeta implements MetodoPago {

    private String numeroTarjeta;

    public PagoTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    private boolean validarTarjeta() {
        return numeroTarjeta != null && numeroTarjeta.matches("\\d{16}");
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Método de pago: Tarjeta");
        System.out.println("Total a pagar: C$ " + monto);

        if (!validarTarjeta()) {
            System.out.println("Número de tarjeta inválido. El pago no pudo procesarse.");
            return;
        }

        System.out.println("Pago con tarjeta procesado correctamente.");
        System.out.println("Tarjeta utilizada: **** **** **** " + numeroTarjeta.substring(12));
    }

    @Override
    public String getNombreMetodo() {
        return "Tarjeta";
    }
}