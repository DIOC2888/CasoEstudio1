package Clases;

// Importacion de interfaces y clases necesarias para pagos, servicios y utilidades
import Interfaces.MetodoPago;
import Pagos.PagoEfectivo;
import Pagos.PagoTarjeta;
import Servicios.ServicioCliente;
import Servicios.ServicioPedido;
import Servicios.ServicioProducto;
import Servicios.ServicioReporte;
import Utilidades.Utilidades;

import java.util.Scanner;

import static Utilidades.Utilidades.mostrarLinea;

public class Menu {

    // Scanner para leer datos del usuario desde consola
    private Scanner sc = new Scanner(System.in);

    // Instancias de servicios que manejan la logica del sistema
    private ServicioCliente servicioCliente = new ServicioCliente();
    private ServicioProducto servicioProducto = new ServicioProducto();
    private ServicioPedido servicioPedido = new ServicioPedido();
    private ServicioReporte servicioReporte = new ServicioReporte();

    // Metodo principal que muestra el menu general del sistema
    public void mostrarMenu() {
        int opc;

        // Ciclo que mantiene el menu activo hasta que el usuario decida salir
        do {
            mostrarLinea();
            Utilidades.mostrarTitulo("MENU PRINCIPAL");
            mostrarLinea();

            // Opciones disponibles
            System.out.println("1. Clientes");
            System.out.println("2. Productos");
            System.out.println("3. Pedidos");
            System.out.println("4. Reportes");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opcion: ");
            opc = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            // Redirige segun la opcion elegida
            switch (opc) {
                case 1:
                    menuClientes();
                    break;
                case 2:
                    menuProductos();
                    break;
                case 3:
                    menuPedidos();
                    break;
                case 4:
                    mostrarReportes();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opc != 5); // se repite hasta que el usuario salga
    }

    // Submenu para gestionar clientes
    private void menuClientes() {
        int opc;

        do {
            mostrarLinea();
            Utilidades.mostrarTitulo("CLIENTES");

            System.out.println("1. Registrar cliente");
            System.out.println("2. Mostrar clientes");
            System.out.println("3. Volver");

            System.out.print("Seleccione una opcion: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    registrarCliente(); // crea un cliente
                    break;
                case 2:
                    servicioCliente.mostrarClientes(); // muestra lista
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opc != 3);
    }

    // Metodo para registrar un nuevo cliente
    private void registrarCliente() {
        mostrarLinea();

        // Se solicitan los datos basicos
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Telefono: ");
        String telefono = sc.nextLine();

        System.out.print("Direccion: ");
        String direccion = sc.nextLine();

        // Se crea el objeto Cliente y se guarda en el servicio
        Cliente cliente = new Cliente(nombre, telefono, direccion);
        servicioCliente.registrarCliente(cliente);

        System.out.println("Cliente registrado con exito.");
        mostrarLinea();
    }

    // Submenu para gestionar productos
    private void menuProductos() {
        int opc;

        do {
            Utilidades.mostrarTitulo("PRODUCTOS");

            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Volver");

            System.out.print("Seleccione una opcion: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    registrarProducto(); // crea producto
                    break;
                case 2:
                    servicioProducto.mostrarProductos(); // muestra productos
                    break;
                case 3:
                    eliminarProducto(); // elimina producto
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opc != 4);
    }

    // Metodo para registrar un producto
    private void registrarProducto() {
        mostrarLinea();

        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        boolean disponible;

        // Validacion para asegurar que el usuario ingrese S o N
        do {
            System.out.print("¿Esta disponible? (S/N): ");
            String disponibleTexto = sc.nextLine();

            if (!disponibleTexto.equalsIgnoreCase("S") && !disponibleTexto.equalsIgnoreCase("N")) {
                System.out.println("Entrada invalida.");
            } else {
                disponible = disponibleTexto.equalsIgnoreCase("S");

                // Se crea el producto y se guarda
                Producto producto = new Producto(nombre, precio, disponible);
                servicioProducto.registrarProducto(producto);

                System.out.println("Producto registrado con exito.");
                mostrarLinea();
                break;
            }

        } while (true);
    }

    // Metodo para eliminar un producto por nombre
    private void eliminarProducto() {
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombre = sc.nextLine();

        servicioProducto.eliminarProducto(nombre);
    }

    // Submenu de pedidos
    private void menuPedidos() {
        int opc;

        do {
            mostrarLinea();
            Utilidades.mostrarTitulo("PEDIDOS");

            System.out.println("1. Crear pedido");
            System.out.println("2. Mostrar pedidos");
            System.out.println("3. Volver");

            System.out.print("Seleccione una opcion: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    crearPedido(); // proceso completo de pedido
                    break;
                case 2:
                    servicioPedido.mostrarPedidos();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opc != 3);
    }

    // Metodo mas importante: crea un pedido completo
    private void crearPedido() {

        // Validacion: debe haber clientes y productos registrados
        if (servicioCliente.getClientes().isEmpty()) {
            System.out.println("Debe registrar al menos un cliente primero.");
            return;
        }

        if (servicioProducto.getProductos().isEmpty()) {
            System.out.println("Debe registrar al menos un producto primero.");
            return;
        }

        // Se busca el cliente
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = sc.nextLine();

        Cliente cliente = servicioCliente.buscarClientePorNombre(nombreCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        // Seleccion de metodo de pago
        mostrarLinea();
        System.out.println("Seleccione metodo de pago:");
        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta");

        System.out.print("Seleccione una opcion: ");
        String opcionPagoTexto = sc.nextLine();

        int opcionPago;

        // Validacion de numero
        try {
            opcionPago = Integer.parseInt(opcionPagoTexto);
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida.");
            return;
        }

        mostrarLinea();

        MetodoPago metodoPago;

        // Se instancia el tipo de pago segun eleccion
        if (opcionPago == 1) {
            metodoPago = new PagoEfectivo(0);
        } else if (opcionPago == 2) {
            metodoPago = new PagoTarjeta("");
        } else {
            System.out.println("Metodo invalido.");
            return;
        }

        // Se crea el pedido
        Pedido pedido = servicioPedido.crearPedido(cliente, metodoPago);

        String respuesta;

        // Se agregan productos al pedido
        do {
            servicioProducto.mostrarProductos();

            System.out.print("Ingrese el nombre del producto: ");
            String nombreProducto = sc.nextLine();

            Producto producto = servicioProducto.buscarProductoPorNombre(nombreProducto);

            if (producto != null) {
                servicioPedido.agregarProductoAPedido(pedido, producto);
            } else {
                System.out.println("Producto no encontrado.");
            }

            System.out.print("¿Agregar otro? (S/N): ");
            respuesta = sc.nextLine();

        } while (respuesta.equalsIgnoreCase("S"));

        // Se calcula el total del pedido
        double total = pedido.calcularTotal();
        System.out.println("Total del pedido: C$ " + total);

        mostrarLinea();

        // Procesamiento del pago dependiendo del tipo
        if (metodoPago instanceof PagoEfectivo) {

            double montoRecibido;

            // Validacion del monto
            while (true) {
                System.out.print("Ingrese monto: ");
                String montoTexto = sc.nextLine();

                try {
                    montoRecibido = Double.parseDouble(montoTexto);

                    if (montoRecibido < total) {
                        System.out.println("Monto insuficiente.");
                        continue;
                    }

                    break;

                } catch (NumberFormatException e) {
                    System.out.println("Numero invalido.");
                }
            }

            metodoPago = new PagoEfectivo(montoRecibido);

        } else if (metodoPago instanceof PagoTarjeta) {

            String numeroTarjeta;

            // Validacion de tarjeta (16 digitos)
            while (true) {
                System.out.print("Ingrese numero de tarjeta: ");
                numeroTarjeta = sc.nextLine();

                if (!numeroTarjeta.matches("\\d{16}")) {
                    System.out.println("Numero invalido.");
                    continue;
                }

                break;
            }

            metodoPago = new PagoTarjeta(numeroTarjeta);
        }

        // Se asigna el metodo de pago final y se procesa
        pedido.setMetodoPago(metodoPago);
        pedido.procesarPago();
    }

    // Metodo para mostrar reportes del sistema
    private void mostrarReportes() {
        mostrarLinea();
        Utilidades.mostrarTitulo("REPORTES");

        servicioReporte.mostrarReporte(servicioPedido.getPedidos());

        mostrarLinea();
    }
}