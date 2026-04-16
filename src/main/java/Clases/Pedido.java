package Clases;

import Interfaces.MetodoPago;
import java.util.ArrayList;

public class Pedido {
    //usamos de atributo la clase Metodopago por que un pedido tiene un metodo de pago
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

    //Agregamos el producto pero verificando si esta disponible . Si esta se agrega, si no esta no se agrega.
    public void agregarProducto(Producto producto) {
        if (producto.isDisponible()) {
            productos.add(producto);
            System.out.println("Producto agregado al pedido.");
        } else {
            System.out.println("El producto no está disponible.");
        }
    }
    //Elimina productos recorriendo la lista y buscando el nombre del producto que se desea eliminar.
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

    /* Calcula el total recorriendo la lista de los productos agregados multiplicando el precio por la cantada
    de cada producto y sumandolo la total*/
    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }
   //Procesa el pago llamando al metodo procesarPago de la clase Metodo Pago.
    public void procesarPago() {
        metodoPago.procesarPago(calcularTotal());
    }
}