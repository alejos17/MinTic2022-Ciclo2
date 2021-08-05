/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interface.Itipo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alejos17
 */
public class clsPedidos implements Itipo {
    
    private String idPedido;
    private String producto;
    private int cantidad;
    private int valorUnitario;
    private int iva;
    private int valorTotal;
    private int cobrado;
    
    //Solo para pedidos procesados se meten por SET y GET
    private String idinventario;  //ID desde la tabla inventario para gestionar el pedido.
    private int cantinv;   //Cantidad desde la tabla de inventario para gestionar el pedido.
    private double valorunit;  //Valor en double del precio.
    private String fecha;   //Fecha en la que se realiza un pedido
    private String idCliente;  //Se usa para saber que cliente hace un pedido
    private String idCuenta;  //Se usa para saber que cuenta usa un usuario para pagar un pedido.
    private int tamListPedido;   //Entero para capturar la cantidad de items de un pedido.
    private int idCobro;  //Se utiliza para consultar el id del cobro para un pedido ya ejecutado.
    private String idPedidoComp;  //ID si es pedidocompuesto.
    private String fechaCobro;   //Se utiliza para consultar la fecha de un cobro ya ejecutado en un pedido.

    public clsPedidos(String idPedido, String producto, int cantidad, int valorUnitario, int iva, int valorTotal, int cobrado) {
        this.idPedido = idPedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.iva = iva;
        this.valorTotal = valorTotal;
        this.cobrado = cobrado;
    }
    
    
    /**
     * @return the idPedido
     */
    public String getIdPedido() {
        return idPedido;
    }

    /**
     * @param idPedido the idPedido to set
     */
    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the valorUnitario
     */
    public int getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(int valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * @return the iva
     */
    public int getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(int iva) {
        this.iva = iva;
    }

    /**
     * @return the valorTotal
     */
    public int getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String tipoCambio() {
        return "Pedido";
    }

    /**
     * @return the idinventario
     */
    public String getIdinventario() {
        return idinventario;
    }

    /**
     * @param idinventario the idinventario to set
     */
    public void setIdinventario(String idinventario) {
        this.idinventario = idinventario;
    }

    /**
     * @return the cantinv
     */
    public int getCantinv() {
        return cantinv;
    }

    /**
     * @param cantinv the cantinv to set
     */
    public void setCantinv(int cantinv) {
        this.cantinv = cantinv;
    }

    /**
     * @return the valorunit
     */
    public double getValorunit() {
        return valorunit;
    }

    /**
     * @param valorunit the valorunit to set
     */
    public void setValorunit(double valorunit) {
        this.valorunit = valorunit;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the idCliente
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the idCuenta
     */
    public String getIdCuenta() {
        return idCuenta;
    }

    /**
     * @param idCuenta the idCuenta to set
     */
    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * @return the tamListPedido
     */
    public int getTamListPedido() {
        return tamListPedido;
    }

    /**
     * @param tamListPedido the tamListPedido to set
     */
    public void setTamListPedido(int tamListPedido) {
        this.tamListPedido = tamListPedido;
    }

    /**
     * @return the cobrado
     */
    public int getCobrado() {
        return cobrado;
    }

    /**
     * @param cobrado the cobrado to set
     */
    public void setCobrado(int cobrado) {
        this.cobrado = cobrado;
    }

    /**
     * @return the idCobro
     */
    public int getIdCobro() {
        return idCobro;
    }

    /**
     * @param idCobro the idCobro to set
     */
    public void setIdCobro(int idCobro) {
        this.idCobro = idCobro;
    }

    /**
     * @return the fechaCobro
     */
    public String getFechaCobro() {
        return fechaCobro;
    }

    /**
     * @param fechaCobro the fechaCobro to set
     */
    public void setFechaCobro(String fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    /**
     * @return the idPedidoComp
     */
    public String getIdPedidoComp() {
        return idPedidoComp;
    }

    /**
     * @param idPedidoComp the idPedidoComp to set
     */
    public void setIdPedidoComp(String idPedidoComp) {
        this.idPedidoComp = idPedidoComp;
    }

        
}
