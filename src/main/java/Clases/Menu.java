package Clases;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    private Cliente gestorClientes = new Cliente();

    public void mostrarMenu(){
        int opc;
        do{
            System.out.println("-------------MENU------------");
            System.out.println("1. Clientes");
            System.out.println("2. Productos");
            System.out.println("3. Pedidos");
            System.out.println("4. Resumenes");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opción:");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc){
                case 1:
                    mostrarMenuClientes();
                    break;
                case 2:
                    //añadir metodo para gestionar productos
                    break;
                case 3:
                    //añadir metodo para gestionar pedidos
                    break;
                case 4:
                    //añadir metodo para mostrar resúmenes
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número del 1 al 5.");
            }
        }while(opc != 5);
    }

    public void registrarCliente() {
        System.out.println("---------REGISTRO DE CLIENTE----------");
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = sc.nextLine();

        System.out.println("Ingrese el teléfono del cliente:");
        String telefono = sc.nextLine();

        System.out.println("Ingrese la dirección del cliente:");
        String direccion = sc.nextLine();

        Cliente cliente = new Cliente(nombre, telefono, direccion);
        gestorClientes.registrarCliente(cliente);

        System.out.println("Cliente registrado exitosamente.");
        System.out.println("-----------------------------------");
    }

    public void mostrarClientes() {
        gestorClientes.mostrarClientes();
    }

    public void mostrarMenuClientes() {
        int opc;
        do {
            System.out.println("---------GESTIÓN DE CLIENTES----------");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Mostrar clientes registrados");
            System.out.println("3. Volver al menú principal");
            System.out.println("Seleccione una opción:");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    mostrarClientes();
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número del 1 al 3.");
            }
        } while (opc != 3);
    }



}