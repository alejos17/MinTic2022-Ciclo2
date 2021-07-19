/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.*;
import Model.*;
import javax.swing.DefaultListModel;

/**
 *
 * @author alejos17
 */
public class Control {
    
    private modelCliente modelCliente;
    private modelCuentas modelCuentas;
    private modelPedidos modelPedidos;
    
    public Control() {
        this.modelCliente = new modelCliente();
        this.modelCuentas = new modelCuentas();
        this.modelPedidos = new modelPedidos();
    }
    
    
    //Metodo para Crear objeto ya sea, persona, cliente, cuenta o pedido
    public boolean CrearCliente(clsCliente cliente){
        try{
            this.modelCliente.CrearCliente(cliente);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean CrearCuenta(clsCuentas cuenta){
        try{
            this.modelCuentas.CrearCuenta(cuenta);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    //Metodo para asignar cuentas a clientes
    public boolean AsignarCuentas(String cliente, clsCuentas cuenta){
        try{
            this.modelCliente.AsignarCuentas(cliente, cuenta);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    //Para modificar
    public boolean Editar(clsPersona persona){
        try{
        switch(persona.tipoCambio()){
            case "Cliente":
                
                break;
            case "Cuenta":
                
                
                break;
            case "Pedido":
                
                break;
        }
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }
    
    //Para borrar, lo unico que eso hace es al llamarlo desde la vista, mira que tipo de mascota es y llama según el caso a los metodos del modelo.
    public boolean Borrar(clsPersona persona){
        try{
        switch(persona.tipoCambio()){
            case "Cliente":
                
                break;
            case "Cuenta":
                
                
                break;
            case "Pedido":
                
                break;
        }
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }
    
    //Metodo para buscar, se recibe el codigo y el tipo de mascota para segun el switch ejecutar si es perro o gato y retornar el objeto pets indicado.
    public clsPersona Buscar(String code, String type){
        clsPersona persona = null;
        try{
        switch(type){
            case "Cliente":
                this.modelCliente.BuscarCliente(code);
                break;
            case "Cuenta":
                
                
                break;
            case "Pedido":
                
                break;
        }
        return persona;
        }catch (Exception e){
            return null;
        }
            
        
    }
    
    public DefaultListModel Listar(String tipo){
        DefaultListModel model = new DefaultListModel();
        try{
        switch(tipo){
            case "Cliente":
                model = this.modelCliente.ListarClientes();
                break;
            case "Cuenta":
                
                
                break;
            case "Pedido":
                
                break;
        }
        return model;
        }catch (Exception e){
            return null;
        }
        
    }

    
}
