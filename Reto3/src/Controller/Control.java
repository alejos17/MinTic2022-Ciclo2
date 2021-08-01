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
import javax.swing.table.DefaultTableModel;

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
        this.modelInventario = new modelInventario();
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
    public boolean Borrar(String type, String code){
        try{
        switch(type){
            case "Cliente":
                    this.modelCliente.Borrar(code);
                break;
            case "Cuenta":
                    this.modelCuentas.Borrar(code);
                
                break;
            case "Pedido":
                
                break;
            case "Inventario":
                    this.modelInventario.Borrar(code);
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
    
    
    public DefaultListModel Listar(String tipo, String code){
        DefaultListModel model = new DefaultListModel();
        try{
        switch(tipo){
            case "Cliente":
                model = this.modelCliente.Listar();
                break;
            case "Cuenta":
                model = this.modelCuentas.Listar();
                break;
            case "ListaCuentaClientes":
                model = this.modelCliente.ListarCuentaClientes(code);
                break;
            case "Inventario":
                model = this.modelInventario.Listar();
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

    public DefaultComboBoxModel ListarComboBoxClientes(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try{
            model = this.modelCliente.ListarComboBoxClientes();
        return model;
        }catch (Exception e){
            return null;
        }
        
    }
    
    /*
    public DefaultTableModel Listar2(){
        DefaultTableModel model = new DefaultTableModel();
        try{
            model = this.modelInventario.Listar2();
        return model;
        }catch (Exception e){
            return null;
        }
    }*/
    
    
    
    public boolean AgregarInventario(clsInventario inv){
        try{
            this.modelInventario.Agregar(inv);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public clsInventario BuscarInv(String code){
        clsInventario inv = null;
        try{
            inv = this.modelInventario.Buscar(code);
        return inv;
        }catch (Exception e){
            return null;
        }
    }
    
    public clsCliente EditarInventario(String code, clsInventario invM){
        
        try{
            this.modelInventario.Editar(code, invM);
        return null;
        }catch (Exception e){
            return null;
        }
    }
    
    
    
}
