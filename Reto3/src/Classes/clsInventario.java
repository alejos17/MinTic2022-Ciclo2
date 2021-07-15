/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author alejos17
 */
public class clsInventario {
    
    private String idProducto;
    private String Producto;
    private int cant_ext;
    private int valorUnit;

    public clsInventario(String idProducto, String Producto, int cant_ext, int valorUnit) {
        this.idProducto = idProducto;
        this.Producto = Producto;
        this.cant_ext = cant_ext;
        this.valorUnit = valorUnit;
    }

      
    /**
     * @return the idProducto
     */
    public String getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the Producto
     */
    public String getProducto() {
        return Producto;
    }

    /**
     * @param Producto the Producto to set
     */
    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    /**
     * @return the cant_ext
     */
    public int getCant_ext() {
        return cant_ext;
    }

    /**
     * @param cant_ext the cant_ext to set
     */
    public void setCant_ext(int cant_ext) {
        this.cant_ext = cant_ext;
    }

    /**
     * @return the valorUnit
     */
    public int getValorUnit() {
        return valorUnit;
    }

    /**
     * @param valorUnit the valorUnit to set
     */
    public void setValorUnit(int valorUnit) {
        this.valorUnit = valorUnit;
    }
    
    
}
