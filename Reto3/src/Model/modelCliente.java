/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Classes.*;
import Controller.*;
import java.util.LinkedList;
import javax.swing.DefaultListModel;

/**
 *
 * @author alejos17
 */
public class modelCliente {

    LinkedList<clsCliente> ListaClientes = new LinkedList<>();  //Lista de Clientes
    
    public modelCliente() {
    }
    
    //Metodo para crear cliente y devolver con el boolean si lo guardo correctamente o no.
    public boolean CrearCliente(clsCliente cliente){
        try{
            
            ListaClientes.add(cliente);
            
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }
    
    //Metodo para asignar cuenta a un cliente de la lista.
    public boolean AsignarCuentas(String Cliente, clsCuentas cuenta){
        
        try{
            
            for (clsCliente cliente : ListaClientes) {  //Buscar en la lista de clientes
                    if (cliente.getIdCliente().equals(Cliente)){
                        cliente.asignarCuentas(cuenta);  
                    }
                }    
        
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }

    //Para modificar
    public boolean EditarCliente(clsCliente cliente){
        try{
        
        
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }
    
    //Para borrar, lo unico que eso hace es al llamarlo desde la vista, mira que tipo de mascota es y llama según el caso a los metodos del modelo.
    public boolean BorrarCliente(clsCliente cliente){
        try{
                
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }
    
    //Metodo para buscar, se recibe el codigo y el tipo de mascota para segun el switch ejecutar si es perro o gato y retornar el objeto pets indicado.
    public clsCliente BuscarCliente(String idCliente){
        clsCliente cliente = null;
        try{
         
        
        return null;
        }catch (Exception e){
            return null;
        }
            
        
    }
    
    public DefaultListModel ListarClientes(){
        DefaultListModel model = new DefaultListModel();
        
        int index =0;
        
        //Modelo de lista model.
        for (clsCliente cliente : ListaClientes){
            String data = cliente.getIdCliente() + " - "+ cliente.getNombre() +" "+ cliente.getApellido();
            model.add(index, data);  //Agrega cada cliente al modelo para aplicar a la lista
            index++;
        }
        
        return model;
    }
    
    
}
