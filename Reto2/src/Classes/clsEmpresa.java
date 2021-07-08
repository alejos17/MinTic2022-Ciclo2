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
public class clsEmpresa {
    private String nombre;
    private String nit;
    private String direccion;

    public clsEmpresa(String nombre, String nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
    }
    
    public void imprimir(){
        System.out.println("Los datos son: ");
        System.out.println("Nombre Completo: "+nombre);
        System.out.println("NIT: "+nit);
        System.out.println("Dirección: "+direccion);
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
