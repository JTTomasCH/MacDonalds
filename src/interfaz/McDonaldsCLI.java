/*
 * CentralPacienteCLI.java
 * This file is part of ISIS1206
 *
 * Copyright (C) 2015 - ISIS1206 Team
 */
package interfaz;

import mundo.AdministracionMcDonalds;
import java.util.Iterator;
import java.util.Scanner;
import mundo.ListaDoblementeEncadenada;
import mundo.Pedido;
import mundo.Producto;

//import taller.mundo.*;
//import taller.mundo.AdministracionMcDonalds.Pedido;
public class McDonaldsCLI {

    private AdministracionMcDonalds admin;
    private Scanner in;

    public McDonaldsCLI() {
        admin = new AdministracionMcDonalds();
        in = new Scanner(System.in);
    }

    public void mainMenu() throws InterruptedException {
        boolean finish = false;
        while (!finish) {
            System.out.println("------------------------------------------");
            System.out.println("-                                        -");
            System.out.println("-        McDonalds - Candelaria          -");
            System.out.println("                                                        \n"
                    + "                  ╥╣▒▒▒▒@,        ╥╢▒▒▒▒@╖                            \n"
                    + "                ╥▒▒▒▒▄▒▒▒▒▀█▄   ╓╣▒▒▒▄▒▒▒▒▒█▄                         \n"
                    + "               ╣▒▒▒▒███╢▒▒▒▒██ ╓▒▒╣▒███╚▒▒╢▒██                        \n"
                    + "              ╣▒▒▒▒███  ▒▒▒▒▒█▌▒▒╣▒▓██  ║▒▒▒▒██▄                      \n"
                    + "             ╣▒▒▒▒███   ]▒▒╢▒▒╣░║▒▒██U   ╢▒▒▒▒██µ                     \n"
                    + "            ║▒▒╣▒▐██     ▒▒▒▒▒░░▒▒▐██     ▒▒▒▒▒██                     \n"
                    + "            ╣▒▒▒▒███     ╢▒▒╢╣░║▒▒██▌     ╢▒▒▒▒▀██                    \n"
                    + "           ╢▒▒╢▒▒██      ]▒▒▒╣░▒▒▒██      ]▒▒▒▒▒██µ                   \n"
                    + "           ╣▒▒▒▒███       ▒▒▒╣░▒▒▐██       ▒▒▒▒▒▀██                   \n"
                    + "          ║░░╢▒▒██▌       ▒▒░╢║▒▒██▌       ║▒▒╢▒▒██                   \n"
                    + "          ▒░▒▒▒▒██        ╢▒░▒╢▒▒██▌       ]▒▒▒▒▒██▌                  \n"
                    + "          ╣░▒▒▒▐██        ║▒░▒▒▒▒██U        ▒▒▒▒▒▐██                  \n"
                    + "         ]▒░▒▒▒▐██        ║▒░▒▒▒▒██         ▒▒░▒▒▒██                  \n"
                    + "         ║▒░║▒▒██▌        ]▒▒╣▒▒▒██         ▒▒░▒▒▒██                  \n"
                    + "         ║▒╢▒▒▒██▌         ╙▓██████         ▒▒╢▒▒▒██                \n"
                    + "         ``██████▌          ╙▀▀▀▀▀▀         ``██████                ");
            System.out.println("-                                        -");
            System.out.println("------------------------------------------");
            System.out.println("Bienvenido McDonalds\n");

            System.out.println("Menú principal:");
            System.out.println("-----------------");
            System.out.println("1. Atención restaurante");
            System.out.println("2. Servicio a domicilio");
            System.out.println("3. Administrar Producto");
            System.out.println("4. Salir");
            System.out.print("\nSeleccione una opción: ");
            int opt1 = in.nextInt();
            in.nextLine();
            switch (opt1) {
                case 1:
                    System.out.println("1. Agregar cliente a la cola");
                    System.out.println("2. Atender cliente");
                    System.out.println("3. Entregar pedido");
                    System.out.println("4. Cantidad de clientes en cola");
                    System.out.println("5. Cola de pedidos en cocina");
                    int opt2 = in.nextInt();

                    switch (opt2) {
                        case 1:
                            agregarCliente();
                            break;
                        case 2:
                            atenderCliente();
                            break;
                        case 3:
                            entregarPedido();
                            break;
                        case 4:
                            numeroClientes();
                            break;
                        case 5:
                            pedidos();
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1. Agregar domicilio");
                    System.out.println("2. Despachar domicilio");
                    System.out.println("3. Cantidad domicilios");
                    int opt3 = in.nextInt();
                    switch (opt3) {
                        case 1:
                            agregarDomicilio();
                            break;
                        case 2:
                            despacharDomicilio();
                            break;
                        case 3:
                            numeroDomicilios();
                        default:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1. Ver Catalogo Productos");
                    System.out.println("2. Agregar Producto");
                    System.out.println("3. Eliminar Producto");
                    int opt4 = in.nextInt();
                    switch (opt4) {
                        case 1:
                            catalogoProductos();
                            break;
                        case 2:
                            AgregarProducto();
                            break;
                        case 3:
                            eliminarProducto();
                        default:
                            break;
                    }
                    break;
                case 4:
                    finish = true;
                    break;

                default:
                    break;
            }
        }
    }

    private void agregarCliente() throws InterruptedException {
        boolean finish = false;
        String nombre = "";
        while (!finish) {
            System.out.println("Agregar un cliente nuevo a la cola del restaurante");
            System.out.println("----------------------------------");
            System.out.println("Ingrese el nombre del cliente:");
            nombre = in.nextLine();
            admin.agregarCliente(nombre);
            System.out.println("Se agregó el cliente llamando - " + nombre + " - a la cola del restaurante");
            System.out.println("Presione enter para volver al menú principal");
            in.nextLine();
            finish = true;
        }

    }

    private void agregarDomicilio() throws InterruptedException {
        boolean finish = false;
        String nombre = "";
        while (!finish) {
            System.out.println("Agregar Domicilio");
            System.out.println("----------------------------------");
            System.out.println("Ingrese el Producto deseado:");
            int i = 1;

            for (Producto p : admin.getCatalogoProductos()) {
                System.out.println(i + ". Nombre: " + p.getNombre() + " , Costo: " + p.getCosto() + ", Tiempo preparacion: " + p.getTiempoPreparacion());
                i++;
            }
            int orden = in.nextInt();

            Producto producto = null;

            i = 1;
            for (Producto p : admin.getCatalogoProductos()) {
                if (i == orden) {
                    producto = p;
                    break;
                }
                i++;
            }

            System.out.println("Ingrese el tiempo que desea esperar:");
            long horaPedido = in.nextLong();

            System.out.println("Ingrese la dirección:");
            String direccion = in.nextLine();

            Pedido pedido = new Pedido(producto, horaPedido, direccion);

            admin.agregarDomicilio(pedido);

            System.out.println("Se agregó el Domicilio - " + producto.getNombre() + " - a la cola de Domicilios");
            System.out.println("Presione enter para volver al menú principal");
            in.nextLine();
            finish = true;
        }

    }

//    
    private void atenderCliente() throws InterruptedException {
        boolean finish = false;
        if (admin.clientesEnFila() == 0) {
            System.out.println("No hay clientes en la fila");
            return;
        }
        while (!finish) {
            System.out.println("Atender al primer cliente de la cola");
            System.out.println("----------------------------------");
            System.out.println("Escoja la orden del cliente:");
            int i = 1;

            for (Producto p : admin.getCatalogoProductos()) {
                System.out.println(i + ". Nombre: " + p.getNombre() + " , Costo: " + p.getCosto() + ", Tiempo preparacion: " + p.getTiempoPreparacion());
                i++;
            }
            int orden = in.nextInt();

            Producto producto = null;

            i = 1;
            for (Producto p : admin.getCatalogoProductos()) {
                if (i == orden) {
                    producto = p;
                    break;
                }
                i++;
            }

            System.out.println("atendiendo cliente por favor espere...");
            String nombre = admin.atenderCliente(producto);
            System.out.println("Se agregó la orden " + orden + " a la cola de pedidos de la cocina, a nombre del cliente " + nombre);
            System.out.println("Presione enter para volver al menú principal");
            in.nextLine();
            finish = true;
        }

    }

    private void entregarPedido() throws InterruptedException {
        if (admin.pedidosEnEspera() == 0) {
            System.out.println("No hay pedidos en la cocina");
            return;
        }
        System.out.println("Entregar el primer pedido en lista de la cocina");
        System.out.println("----------------------------------");
        System.out.println("Prepadando pedido porfavor espere .......");
        String pedido = admin.entregarPedido();
        System.out.println("Se entregó el pedido: " + pedido);
        System.out.println("Presione enter para volver al menú principal");
        in.nextLine();
        Thread.sleep(1000);
    }

    private void despacharDomicilio() throws InterruptedException {
        if (admin.domiciliosEnEspera() == 0) {
            System.out.println("No hay pedidos");
            return;
        }
        System.out.println("Entregar el primer domicilio en lista");
        System.out.println("----------------------------------");
        System.out.println("Prepadando pedido porfavor espere .......");
        String pedido = admin.entregarDomicilio();
        System.out.println("Se entregó el pedido: " + pedido);
        System.out.println("Presione enter para volver al menú principal");
        in.nextLine();
        Thread.sleep(1000);
    }

    private void numeroClientes() throws InterruptedException {
        System.out.println("Número de clientes esperando en fila");
        System.out.println("----------------------------------");
        int num = admin.clientesEnFila();
        System.out.println("Hay " + num + " clientes esperando en la fila.");
        System.out.println("Presione enter para volver al menú principal");
        in.nextLine();
        Thread.sleep(3000);
    }

    private void numeroDomicilios() throws InterruptedException {
        System.out.println("Número de domicilios esperando: ");
        System.out.println("----------------------------------");
        int num = admin.domiciliosEnEspera();
        System.out.println("Hay " + num + " clientes esperando su domicilio.");
        System.out.println("Presione enter para volver al menú principal");
        in.nextLine();
        Thread.sleep(3000);
    }

    private void pedidos() throws InterruptedException {
        System.out.println("Listar pedidos en cocina");
        System.out.println("----------------------------------");
        Iterator<Pedido> it = admin.pedidos();
        while (it.hasNext()) {
            System.out.println("Pedido: " + it.next().getProducto());
        }
        System.out.println("Presione enter para volver al menú principal");
        in.nextLine();
        Thread.sleep(3000);
    }

    private void catalogoProductos() {
        int i = 1;
        for (Producto p : admin.getCatalogoProductos()) {
            System.out.println(i + ". Nombre: " + p.getNombre() + " , Costo: " + p.getCosto() + ", Tiempo preparacion: " + p.getTiempoPreparacion());
            i++;
        }
        System.out.println("Presione enter para volver al menú principal");
        in.nextLine();

    }

    private void AgregarProducto() {
        System.out.println("Ingrese el nombre del producto: ");
        String nombre = in.nextLine();

        System.out.println("Ingrese el tiempo de preparación del producto: ");
        long tiempoPreparacion = in.nextLong();

        System.out.println("Ingrese el costo del producto: ");
        double costo = in.nextDouble();

        admin.agregarProducto(new Producto(nombre, tiempoPreparacion, costo));

        System.out.println("Presione enter para volver al menú principal");
        in.nextLine();
    }

    private void eliminarProducto() {
        System.out.println("Ingrese el número del producto a eliminar: ");
        int i = 1;

        for (Producto p : admin.getCatalogoProductos()) {
            System.out.println(i + ". Nombre: " + p.getNombre() + " , Costo: " + p.getCosto() + ", Tiempo preparacion: " + p.getTiempoPreparacion());
            i++;
        }
        int orden = in.nextInt();

        Producto producto = null;
        i = 1;
        for (Producto p : admin.getCatalogoProductos()) {
            if (i == orden) {
                producto = p;
                break;
            }
            i++;
        }

        System.out.println("Eliminando por favor espere...");
        admin.EliminarProducto(producto);

        System.out.println("Producto eliminado: " + producto.getNombre() + " " + producto.getCosto() + " " + producto.getTiempoPreparacion());
        in.nextLine();

        System.out.println("Presione enter para volver al menú principal");
        in.nextLine();
    }

}
