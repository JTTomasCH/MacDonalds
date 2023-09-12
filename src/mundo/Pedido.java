/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author SG702-03
 */
public class Pedido<E> {
    private Producto producto;
    private long horaPedido;
    private String direccion;
    
    public Pedido(Producto producto, long horaPedido, String direccion) {
        this.producto = producto;
        this.horaPedido = horaPedido;
        this.direccion = direccion;
    }

    public String getProducto() {
        return producto.getNombre();
    }

    public long getHoraPedido() {
        return horaPedido;
    }

    public String getDireccion() {
        return direccion;
    }
    
   
    public boolean esDomicilio(){
        return true;
    } 
    
    
}
