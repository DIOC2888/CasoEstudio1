package Pagos;

import Interfaces.MetodoPago;

public class PagoEfectivo implements MetodoPago {

    private double montoRecibido;

    public PagoEfectivo(double montoRecibido) {
        this.montoRecibido = montoRecibido;
    }

    private boolean montoAlcanza(double monto) {
        return montoRecibido >= monto;
    }

    private double cambioEfectuado(double monto) {
        return montoRecibido - monto;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Método de pago: Efectivo");
        System.out.println("Total a pagar: C$ " + monto);

        if (!montoAlcanza(monto)) {
            System.out.println("El monto entregado no es suficiente para completar el pago.");
            return;
        }

        double cambio = cambioEfectuado(monto);

        System.out.println("Pago en efectivo procesado correctamente.");
        System.out.println("Monto recibido: C$ " + montoRecibido);
        System.out.println("Cambio a devolver: C$ " + cambio);
    }

    @Override
    public String getNombreMetodo() {
        return "Efectivo";
    }
}