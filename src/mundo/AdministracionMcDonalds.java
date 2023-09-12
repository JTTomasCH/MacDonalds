package mundo;

import estructuras.Cola;
import java.util.Iterator;

public class AdministracionMcDonalds {

    private Cola<String> colaClientes;
    private Cola<Pedido> colaPedidos;
    private Cola<Pedido> colaDomicilios;
    public ListaDoblementeEncadenada<Producto> catalogoProductos;

    public AdministracionMcDonalds() {
        colaClientes = new Cola<String>();
        colaPedidos = new Cola<Pedido>();
        colaDomicilios = new Cola<Pedido>();
        catalogoProductos = new ListaDoblementeEncadenada();
        catalogoProductos.addLast(new Producto("Mc Flurry", 20, 8000));
        catalogoProductos.addLast(new Producto("Combo cuarto de libra", 30, 20000));
        catalogoProductos.addLast(new Producto("Combo Big Mac", 30, 15000));
        catalogoProductos.addLast(new Producto("Combo Nuggets", 20, 10000));

    }

    public void agregarCliente(String nombre) {
        colaClientes.encolar(nombre);
    }

    public void agregarDomicilio(Pedido pedido) {
        colaDomicilios.encolar(pedido);
    }

    public void agregarProducto(Producto producto) {
        catalogoProductos.addFirst(producto);
    }
    
    public void EliminarProducto(Producto producto) {
        catalogoProductos.eliminarElemento(producto);
    }
    

    public ListaDoblementeEncadenada<Producto> getCatalogoProductos() {
        return catalogoProductos;
    }

    public Cola<String> getColaClientes() {
        return colaClientes;
    }

    public Cola<Pedido> getColaPedidos() {
        return colaPedidos;
    }

    public Cola<Pedido> getColaDomicilios() {
        return colaDomicilios;
    }

    public String atenderCliente(Producto producto) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        colaPedidos.encolar(new Pedido(producto, System.currentTimeMillis(), ""));
        return colaClientes.desencolar();
    }

    public String entregarPedido() {
        Pedido p = colaPedidos.desencolar();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        return p.getProducto();
    }

    public String entregarDomicilio() {
        Pedido p = colaDomicilios.desencolar();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        return p.getProducto();
    }

    public int clientesEnFila() {
        return colaClientes.tamanio();
    }

    public int pedidosEnEspera() {
        return colaPedidos.tamanio();
    }

    public int domiciliosEnEspera() {
        return colaDomicilios.tamanio();
    }

    public Iterator<String> clientes() {
        return colaClientes.iterator();
    }

    public Iterator<Pedido> pedidos() {
        return colaPedidos.iterator();
    }

}
