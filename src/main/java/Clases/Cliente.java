package Clases;

// Clase que representa a un cliente del sistema
public class Cliente {

    // Atributos que guardan la informacion del cliente
    private String nombre;
    private String telefono;
    private String direccion;

    // Constructor que inicializa los datos del cliente al crearlo
    public Cliente(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // Metodo get para obtener el nombre del cliente
    public String getNombre() {
        return nombre;
    }

    // Metodo set para modificar el nombre del cliente
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Metodo get para obtener el telefono
    public String getTelefono() {
        return telefono;
    }

    // Metodo set para modificar el telefono
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Metodo get para obtener la direccion
    public String getDireccion() {
        return direccion;
    }

    // Metodo set para modificar la direccion
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}