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
    private boolean cobrado;
    
    //Solo para pedidos procesados se meten por SET y GET
    private String idinventario;
    private int cantinv;
    private double valorunit;

    public clsPedidos(String idPedido, String producto, int cantidad, int valorUnitario, int iva, int valorTotal, boolean cobrado) {
        this.idPedido = idPedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.iva = iva;
        this.valorTotal = valorTotal;
        this.cobrado = false;
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

    /**
     * @return the cobrado
     */
    public boolean isCobrado() {
        return cobrado;
    }

    /**
     * @param cobrado the cobrado to set
     */
    public void setCobrado(boolean cobrado) {
        this.cobrado = cobrado;
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

        
}
