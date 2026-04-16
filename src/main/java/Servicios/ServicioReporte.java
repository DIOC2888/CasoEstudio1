package Servicios;

import Clases.Pedido;
import java.util.ArrayList;

// Clase que se encarga de generar reportes del sistema
public class ServicioReporte {

    // Metodo que calcula el total de ventas sumando todos los pedidos
    public double calcularTotalVentas(ArrayList<Pedido> pedidos) {

        double total = 0;

        // Recorre todos los pedidos y acumula sus totales
        for (Pedido pedido : pedidos) {
            total += pedido.calcularTotal();
        }

        return total;
    }

    // Metodo que devuelve la cantidad total de pedidos
    public int cantidadPedidos(ArrayList<Pedido> pedidos) {
        return pedidos.size();
    }

    // Metodo que muestra el reporte en consola
    public void mostrarReporte(ArrayList<Pedido> pedidos) {

        // Muestra el total de ventas
        System.out.println("Total de ventas: C$" + calcularTotalVentas(pedidos));

        // Muestra la cantidad de pedidos realizados
        System.out.println("Cantidad de pedidos realizados: " + cantidadPedidos(pedidos));
    }
}