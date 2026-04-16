package Servicios;

import Clases.Cliente;
import Clases.Pedido;
import Clases.Producto;
import Interfaces.MetodoPago;
import java.util.ArrayList;

public class ServicioPedido {
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    //Incializamos el arrayList de pedidos para almacenar los pedidos realizados

    // Metodo para crear un nuevo pedido a la lista de pedidos
    public Pedido crearPedido(Cliente cliente, MetodoPago metodoPago) {
        Pedido pedido = new Pedido(cliente, metodoPago);
        pedidos.add(pedido);
        return pedido;
    }

    public void agregarProductoAPedido(Pedido pedido, Producto producto) {
        // Agrega un producto al un pedido
        pedido.agregarProducto(producto);
    }

    public void eliminarProductoDePedido(Pedido pedido, String nombreProducto) {

        pedido.eliminarProducto(nombreProducto);
    }

    public void mostrarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
            return;
        }

        for (Pedido pedido : pedidos) {
            System.out.println("Cliente: " + pedido.getCliente().getNombre());
            System.out.println("Método de pago: " + pedido.getMetodoPago().getNombreMetodo());
            System.out.println("Total: C$" + pedido.calcularTotal());
            System.out.println("-------------------------");
        }
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}