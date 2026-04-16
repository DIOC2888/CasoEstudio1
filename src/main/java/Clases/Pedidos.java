package Clases;

import servicio.IServicePedido;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Pedidos implements IServicePedido {
    private Productos p; // como pedidos contiene varios productos uso la clase Producto como atributo
    private ArrayList<Productos> listaProductos;


    public Pedidos(ArrayList<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Productos getP() {
        return p;
    }

    public void setP(Productos p) {
        this.p = p;
    }

    public ArrayList<Productos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public void agregarProducto(Productos p) {
        if(p.isDisponibilidad()) {     //Si esta disponible se agrega a la lista. No pongo true por q dice no es necesario lo asumne

            this.listaProductos.add(p);
        }
        else
        {
            System.out.println("El producto no esta disponible: ");
        }

    }

    @Override
    // Se tiene que pasar en parametros el nombre del producto que quiere eliminar, busca en la lista y lo elimina
    public void eliminarProducto(String nombreProducto ) {
        for(Productos p : listaProductos){
            if(p.getNombre().equalsIgnoreCase(nombreProducto))
            {
                this.listaProductos.remove(p);
                break;
            }
        }


    }

    @Override
    //Recorre la lista y multiplica el precio por cantidad de cada elemento y lo suma para obtener el total
    public double calcularTotal() {
        double total = 0;
        for(Productos p : listaProductos){
            total += p.getPrecio() * p.getCantidad();

        }
        return total;


    }


}
