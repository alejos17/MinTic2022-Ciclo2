/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.*;
import Model.*;
import javax.swing.DefaultListModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author alejos17
 */
public class Control {
    
    private modelCliente modelCliente;
    private modelCuentas modelCuentas;
    private modelPedidos modelPedidos;
    private modelInventario modelInventario;
    
    public Control() {
        this.modelCliente = new modelCliente();
        this.modelCuentas = new modelCuentas();
        this.modelPedidos = new modelPedidos();
    }
    
    //Metodo para Crear objeto ya sea, persona, cliente, cuenta o pedido
    public boolean CrearCliente(clsCliente cliente){
        try{
            this.modelCliente.Crear(cliente);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean CrearCuenta(clsCuentas cuenta){
        try{
            this.modelCuentas.Crear(cuenta);
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
    
    //Metodo para modificar Clientes solamente
    public clsCliente EditarCliente(String idCliente, clsCliente clienteM){
        
        try{
            this.modelCliente.Editar(idCliente, clienteM);
        return null;
        }catch (Exception e){
            return null;
        }
    }
    
    //Metodo para modificar Clientes solamente
    public clsCuentas EditarCuenta(String idCuenta, clsCuentas cuentaM){
        
        try{
            this.modelCuentas.Editar(idCuenta, cuentaM);
        return null;
        }catch (Exception e){
            return null;
        }
    }
    
    //Para borrar, lo unico que eso hace es al llamarlo desde la vista, mira que tipo de mascota es y llama según el caso a los metodos del modelo.
    public boolean Borrar(String type, String idCliente){
        try{
        switch(type){
            case "Cliente":
                    this.modelCliente.Borrar(idCliente);
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
    public clsCliente BuscarCliente(String code){
        clsCliente cliente = null;
        try{
            cliente = this.modelCliente.Buscar(code);
        return cliente;
        }catch (Exception e){
            return null;
        }
    }
    
    public clsCuentas BuscarCuenta(String code){
        clsCuentas cuenta = null;
        try{
            cuenta = this.modelCuentas.Buscar(code);
        return cuenta;
        }catch (Exception e){
            return null;
        }
    }
    
    
    public DefaultListModel Listar(String tipo){
        DefaultListModel model = new DefaultListModel();
        try{
        switch(tipo){
            case "Cliente":
                model = this.modelCliente.Listar();
                break;
            case "Cuenta":
                model = this.modelCuentas.ListarCuentas();
                
                break;
            case "Pedido":
                model = this.modelPedidos.ListarPedidos();
                break;
        }
        return model;
        }catch (Exception e){
            return null;
        }
        
    }

    public DefaultComboBoxModel ListarCuentaClientes(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try{
            model = this.modelCliente.ListarCuentaClientes();
        return model;
        }catch (Exception e){
            return null;
        }
        
    }
}
