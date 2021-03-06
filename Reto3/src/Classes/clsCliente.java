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
public class clsCliente extends clsPersona implements Itipo {

    private String idCliente;
    private int cuentas;  //Se usa para comprobar la cantidad de cuentas de cada cliente en la grafica 
    
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

    @Override
    public String tipoCambio() {
        return "Cliente";
    }

    /**
     * @return the cuentas
     */
    public int getCuentas() {
        return cuentas;
    }

    /**
     * @param cuentas the cuentas to set
     */
    public void setCuentas(int cuentas) {
        this.cuentas = cuentas;
    }

}
    
