/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interface.Itipo;

/**
 *
 * @author alejos17
 */
public class clsCuentas implements Itipo {
    
    private String idCuenta;
    private String Cuenta;
    private int saldo;
    private String idcuentacliente;

    public clsCuentas(String idCuenta, String Cuenta, int saldo, String idcuentacliente) {
        this.idCuenta = idCuenta;
        this.Cuenta = Cuenta;
        this.saldo = saldo;
        this.idcuentacliente = idcuentacliente;
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
     * @return the Cuenta
     */
    public String getCuenta() {
        return Cuenta;
    }

    /**
     * @param Cuenta the Cuenta to set
     */
    public void setCuenta(String Cuenta) {
        this.Cuenta = Cuenta;
    }

    /**
     * @return the saldo
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public String tipoCambio() {
        return "Cuenta";
    }

    /**
     * @return the idcuentacliente
     */
    public String getIdcuentacliente() {
        return idcuentacliente;
    }

    /**
     * @param idcuentacliente the idcuentacliente to set
     */
    public void setIdcuentacliente(String idcuentacliente) {
        this.idcuentacliente = idcuentacliente;
    }
    
    
    
    
}
