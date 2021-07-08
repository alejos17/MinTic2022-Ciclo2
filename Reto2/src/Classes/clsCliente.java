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
    private clsEmpresa empresa;

    public clsCliente(String idCliente, String nombre, String apellido, String documento, String correo, String direccion, String telefono) {
        super(nombre, apellido, documento, correo, direccion, telefono);
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
     * @return the empresa
     */
    public clsEmpresa getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(clsEmpresa empresa) {
        this.empresa = empresa;
    }
    
    
}
