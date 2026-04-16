package Clases;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private List<Cliente> listaClientes = new ArrayList<>();
    private String nombre;
    private String telefono;
    private String direccion;

    public Cliente() {
    }

    public Cliente(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void registrarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void mostrarClientes() {
        for (Cliente cliente : listaClientes) {
            System.out.println("---------------------------------");
            System.out.println("Cliente numero: " + (listaClientes.indexOf(cliente) + 1));
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Teléfono: " + cliente.getTelefono());
            System.out.println("Dirección: " + cliente.getDireccion());
            System.out.println("----------------------------------");
        }
    }
}