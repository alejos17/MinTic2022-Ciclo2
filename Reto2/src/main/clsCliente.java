/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.util.Scanner;

/**
 *
 * @author alejos17
 */
public class clsCliente {
    Scanner input = new Scanner(System.in);
    private String idCliente;

    public clsCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void crearCliente(){
     
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
    
}
