package Servicios;

import Clases.Cliente;
import java.util.ArrayList;

// Clase que maneja la logica relacionada a los clientes
public class ServicioCliente {

    // Lista donde se almacenan todos los clientes
    private ArrayList<Cliente> clientes = new ArrayList<>();

    // Metodo para agregar un nuevo cliente a la lista
    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Metodo que muestra todos los clientes registrados
    public void mostrarClientes() {

        // Verifica si la lista esta vacia
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        // Recorre la lista y muestra los datos de cada cliente
        for (Cliente cliente : clientes) {
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Telefono: " + cliente.getTelefono());
            System.out.println("Direccion: " + cliente.getDireccion());
            System.out.println("-------------------------");
        }
    }

    // Metodo que devuelve la lista completa de clientes
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    // Metodo para buscar un cliente por nombre
    public Cliente buscarClientePorNombre(String nombre) {

        // Recorre la lista para encontrar coincidencia
        for (Cliente cliente : clientes) {

            // Compara sin importar mayusculas o minusculas
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                return cliente; // retorna el cliente encontrado
            }
        }

        // Si no encuentra, retorna null
        return null;
    }
}