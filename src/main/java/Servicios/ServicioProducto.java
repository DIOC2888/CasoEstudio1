package Servicios;

import Clases.Producto;
import java.util.ArrayList;

public class ServicioProducto {
    private ArrayList<Producto> productos = new ArrayList<>();

    public void registrarProducto(Producto producto) {
        productos.add(producto);
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        for (Producto producto : productos) {
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: C$" + producto.getPrecio());
            System.out.println("Disponible: " + producto.isDisponible());
            System.out.println("-------------------------");
        }
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
    public void eliminarProducto(String nombre) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                productos.remove(i);
                System.out.println("Producto eliminado correctamente.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }
}