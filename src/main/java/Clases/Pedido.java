package Clases;

import Interfaces.MetodoPago;
import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private MetodoPago metodoPago;

    public Pedido(Cliente cliente, MetodoPago metodoPago) {
        this.cliente = cliente;
        this.metodoPago = metodoPago;
        this.productos = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void agregarProducto(Producto producto) {
        if (producto.isDisponible()) {
            productos.add(producto);
            System.out.println("Producto agregado al pedido.");
        } else {
            System.out.println("El producto no está disponible.");
        }
    }

    public void eliminarProducto(String nombreProducto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equalsIgnoreCase(nombreProducto)) {
                productos.remove(i);
                System.out.println("Producto eliminado del pedido.");
                return;
            }
        }
        System.out.println("Producto no encontrado en el pedido.");
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public void procesarPago() {
        metodoPago.procesarPago(calcularTotal());
    }
}