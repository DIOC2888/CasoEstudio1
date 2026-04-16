package Pagos;

import Interfaces.MetodoPago;

public class PagoEfectivo implements MetodoPago {

    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago en efectivo procesado por: C$" + monto);
    }

    @Override
    public String getNombreMetodo() {
        return "Efectivo";
    }
}