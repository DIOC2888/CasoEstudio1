package Servicios;

import Clases.Pedido;
import java.util.ArrayList;

public class ServicioReporte {

    public double calcularTotalVentas(ArrayList<Pedido> pedidos) {
        double total = 0;
        for (Pedido pedido : pedidos) {
            total += pedido.calcularTotal();
        }
        return total;
    }

    public int cantidadPedidos(ArrayList<Pedido> pedidos) {
        return pedidos.size();
    }

    public void mostrarReporte(ArrayList<Pedido> pedidos) {
        System.out.println("Total de ventas: C$" + calcularTotalVentas(pedidos));
        System.out.println("Cantidad de pedidos realizados: " + cantidadPedidos(pedidos));
    }
}