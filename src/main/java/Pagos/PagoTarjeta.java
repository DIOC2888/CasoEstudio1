package Pagos;

import Interfaces.MetodoPago;

public class PagoTarjeta implements MetodoPago {

    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago con tarjeta procesado por: C$" + monto);
    }

    @Override
    public String getNombreMetodo() {
        return "Tarjeta";
    }
}