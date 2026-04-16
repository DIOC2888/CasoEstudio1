package servicio;

import Clases.Productos;

public interface IServicePedido {
    void agregarProducto(Productos p);
    void eliminarProducto(String nombreProducto);
    double calcularTotal();


}
