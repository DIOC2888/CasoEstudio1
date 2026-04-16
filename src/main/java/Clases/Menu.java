package Clases;

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
    private Scanner sc = new Scanner(System.in);

    private ServicioCliente servicioCliente = new ServicioCliente();
    private ServicioProducto servicioProducto = new ServicioProducto();
    private ServicioPedido servicioPedido = new ServicioPedido();
    private ServicioReporte servicioReporte = new ServicioReporte();

    public void mostrarMenu() {
        int opc;

        do {
            mostrarLinea();
            Utilidades.mostrarTitulo("MENU PRINCIPAL");
            mostrarLinea();
            System.out.println("1. Clientes");
            System.out.println("2. Productos");
            System.out.println("3. Pedidos");
            System.out.println("4. Reportes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opc = sc.nextInt();
            sc.nextLine();

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
                    System.out.println("Opción inválida.");
            }
        } while (opc != 5);
    }

    private void menuClientes() {
        int opc;
        do {
            mostrarLinea();
            Utilidades.mostrarTitulo("CLIENTES");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Mostrar clientes");
            System.out.println("3. Volver");
            System.out.print("Seleccione una opción: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    servicioCliente.mostrarClientes();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opc != 3);
    }

    private void registrarCliente() {
        mostrarLinea();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Dirección: ");
        String direccion = sc.nextLine();

        Cliente cliente = new Cliente(nombre, telefono, direccion);
        servicioCliente.registrarCliente(cliente);
        System.out.println("Cliente registrado con éxito.");
        mostrarLinea();
    }

    private void menuProductos() {
        int opc;
        do {
            Utilidades.mostrarTitulo("PRODUCTOS");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opción: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    servicioProducto.mostrarProductos();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opc != 4);
    }

    private void registrarProducto() {
        mostrarLinea();
        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        boolean disponible;
        do {
            System.out.print("¿Está disponible? (S/N): ");
            String disponibleTexto = sc.nextLine();

            if (!disponibleTexto.equalsIgnoreCase("S") && !disponibleTexto.equalsIgnoreCase("N")) {
                System.out.println("Entrada inválida. Por favor ingrese 'S' para sí o 'N' para no.");
            } else {
                disponible = disponibleTexto.equalsIgnoreCase("S");
                Producto producto = new Producto(nombre, precio, disponible);
                servicioProducto.registrarProducto(producto);
                System.out.println("Producto registrado con éxito.");
                mostrarLinea();
                break;
            }
        } while (true);
    }
    private void eliminarProducto() {

        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombre = sc.nextLine();
        servicioProducto.eliminarProducto(nombre);
    }
    private void menuPedidos() {
        int opc;
        do {
            mostrarLinea();
            Utilidades.mostrarTitulo("PEDIDOS");
            System.out.println("1. Crear pedido");
            System.out.println("2. Mostrar pedidos");
            System.out.println("3. Volver");
            System.out.print("Seleccione una opción: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    crearPedido();
                    break;
                case 2:
                    servicioPedido.mostrarPedidos();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opc != 3);
    }

    private void crearPedido() {
        if (servicioCliente.getClientes().isEmpty()) {
            System.out.println("Debe registrar al menos un cliente primero.");
            return;
        }

        if (servicioProducto.getProductos().isEmpty()) {
            System.out.println("Debe registrar al menos un producto primero.");
            return;
        }

        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = sc.nextLine();

        Cliente cliente = servicioCliente.buscarClientePorNombre(nombreCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        mostrarLinea();
        System.out.println("Seleccione método de pago:");
        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta");
        System.out.print("Seleccione una opción: ");

        String opcionPagoTexto = sc.nextLine();
        int opcionPago;

        try {
            opcionPago = Integer.parseInt(opcionPagoTexto);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Debe ingresar un número.");
            return;
        }

        mostrarLinea();

        MetodoPago metodoPago;

        if (opcionPago == 1) {
            metodoPago = new PagoEfectivo(0);
        } else if (opcionPago == 2) {
            metodoPago = new PagoTarjeta("");
        } else {
            System.out.println("Método de pago inválido.");
            return;
        }

        Pedido pedido = servicioPedido.crearPedido(cliente, metodoPago);

        String respuesta;
        do {
            servicioProducto.mostrarProductos();
            System.out.print("Ingrese el nombre del producto que desea agregar: ");
            String nombreProducto = sc.nextLine();

            Producto producto = servicioProducto.buscarProductoPorNombre(nombreProducto);

            if (producto != null) {
                servicioPedido.agregarProductoAPedido(pedido, producto);
            } else {
                System.out.println("Producto no encontrado.");
            }

            System.out.print("¿Desea agregar otro producto? (S/N): ");
            respuesta = sc.nextLine();

        } while (respuesta.equalsIgnoreCase("S"));

        double total = pedido.calcularTotal();
        System.out.println("Total del pedido: C$ " + total);
        mostrarLinea();

        if (metodoPago instanceof PagoEfectivo) {
            double montoRecibido;

            while (true) {
                System.out.print("Ingrese el monto entregado por el cliente: C$ ");
                String montoTexto = sc.nextLine();

                try {
                    montoRecibido = Double.parseDouble(montoTexto);

                    if (montoRecibido < total) {
                        System.out.println("El monto no cubre el total. Intente nuevamente.");
                        continue;
                    }

                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Ingrese un número válido.");
                }
            }

            metodoPago = new PagoEfectivo(montoRecibido);

        } else if (metodoPago instanceof PagoTarjeta) {
            String numeroTarjeta;

            while (true) {
                System.out.print("Ingrese el número de tarjeta (16 dígitos): ");
                numeroTarjeta = sc.nextLine();

                if (!numeroTarjeta.matches("\\d{16}")) {
                    System.out.println("Número inválido. Debe tener 16 dígitos.");
                    continue;
                }

                break;
            }

            metodoPago = new PagoTarjeta(numeroTarjeta);
        }

        pedido.setMetodoPago(metodoPago);
        pedido.procesarPago();
    }

    private void mostrarReportes() {
        mostrarLinea();
        Utilidades.mostrarTitulo("REPORTES");
        servicioReporte.mostrarReporte(servicioPedido.getPedidos());
        mostrarLinea();
    }
}