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
public class clsCliente extends clsPersona {

    private String idCliente;
    private clsCuentas cuentas;

    public clsCliente(String idCliente, String nombre, String apellido, String direccion, String telefono, String correo) {
        super(nombre, apellido, direccion, telefono, correo);
        this.idCliente = idCliente;
    
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
     * @return the cuentas
     */
    public clsCuentas getCuentas() {
        return cuentas;
    }

    /**
     * @param cuentas the cuentas to set
     */
    public void setCuentas(clsCuentas cuentas) {
        this.cuentas = cuentas;
    }
    
    

    
    
    
}
