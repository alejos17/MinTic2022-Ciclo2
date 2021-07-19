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
    private List<clsCuentas> cuentas;  //Se crea una lista de cuentas para el objeto cliente

    public clsCliente(String idCliente, String nombre, String apellido, String direccion, String telefono, String correo) {
        super(nombre, apellido, direccion, telefono, correo);
        this.idCliente = idCliente;
        this.cuentas = new ArrayList<>();   //Se crea array para guardar la lista de cuentas de cada cliente
    }

    public void asignarCuentas(clsCuentas cuentas){   //Metodo para guardar la cuenta en la lista del cliente
        this.getCuentas().add(cuentas);
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
    public List<clsCuentas> getCuentas() {
        return cuentas;
    }

    /**
     * @param cuentas the cuentas to set
     */
    public void setCuentas(List<clsCuentas> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public String tipoCambio() {
        return "Cliente";
    }

    

    
    
    
}
