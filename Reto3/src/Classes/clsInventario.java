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
    private String Categoria;
    private String Producto;
    private int cant_ext;
    private double iva;
    private double valorUnit;

    public clsInventario(String idProducto, String Categoria, String Producto, int cant_ext, double iva, double valorUnit) {
        this.idProducto = idProducto;
        this.Categoria = Categoria;
        this.Producto = Producto;
        this.cant_ext = cant_ext;
        this.iva = iva;
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
    public double getValorUnit() {
        return valorUnit;
    }

    /**
     * @param valorUnit the valorUnit to set
     */
    public void setValorUnit(double valorUnit) {
        this.valorUnit = valorUnit;
    }

    /**
     * @return the Categoria
     */
    public String getCategoria() {
        return Categoria;
    }

    /**
     * @param Categoria the Categoria to set
     */
    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    /**
     * @return the iva
     */
    public double getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(double iva) {
        this.iva = iva;
    }
    
    
}
