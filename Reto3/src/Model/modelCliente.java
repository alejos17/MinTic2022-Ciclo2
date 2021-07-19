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
    
    public boolean InitClientes(){
        
        try{
            
            clsCliente cliente1 = new clsCliente("001","Alejandro","Tamayo","Calle 25 34-09","3249087893","tam@gmail.com");
            clsCliente cliente2 = new clsCliente("002","Carlos","Gonzalez","Craa 34 12-45","3120983451","cgonza@gmail.com");
            clsCliente cliente3 = new clsCliente("003","Ramiro","Ramirez","Calle 65 12A-89","3003450976","ramram@gmail.com");
            ListaClientes.add(cliente1);
            ListaClientes.add(cliente2);
            ListaClientes.add(cliente3);
            
        return true;
        }catch (Exception e){
            return false;
        }
        
        
        
        
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
    public boolean AsignarCuentas(String idCliente, clsCuentas cuenta){
        
        try{
            
            for (clsCliente cliente : ListaClientes) {  //Buscar en la lista de clientes
                    if (cliente.getIdCliente().equals(idCliente)){
                        cliente.asignarCuentas(cuenta);  
                    }
                }    
        
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }
    
    //Metodo para asignar cuenta a un cliente de la lista.
    public boolean AsignarPedidos(String idCliente, clsPedidos pedido){
        
        try{
            
            for (clsCliente cliente : ListaClientes) {  //Buscar en la lista de clientes
                    if (cliente.getIdCliente().equals(idCliente)){
                        cliente.asignarPedido(pedido);  
                    }
                }    
        
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }

    //Para modificar
    public boolean EditarCliente(String idCliente, clsCliente clienteM){
        
        try{
            
            for (clsCliente cliente : ListaClientes){
                if(cliente.getIdCliente().equals(idCliente)){
                    cliente.setNombre(clienteM.getNombre());
                    cliente.setApellido(clienteM.getApellido());
                    cliente.setDireccion(clienteM.getDireccion());
                    cliente.setCorreo(clienteM.getCorreo());
                    cliente.setTelefono(clienteM.getTelefono());
                }
            }
        
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }
    
    //Para borrar, lo unico que eso hace es al llamarlo desde la vista, mira que tipo de mascota es y llama según el caso a los metodos del modelo.
    public boolean BorrarCliente(String idCliente){
        try{
            
            for (clsCliente cliente : ListaClientes){
                if (cliente.getIdCliente().equals(idCliente)){
                    this.ListaClientes.remove(cliente);
                }
            }
            
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }
    
    //Metodo para buscar, se recibe el codigo y el tipo de mascota para segun el switch ejecutar si es perro o gato y retornar el objeto pets indicado.
    public clsCliente BuscarCliente(String idCliente){
        clsCliente cliente1 = null;
        try{
            
            for (clsCliente cliente : ListaClientes){
                if(cliente.getIdCliente().equals(idCliente)){
                    cliente1 = cliente;
                }
            }
        
        return cliente1;
        }catch (Exception e){
            return cliente1;
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
    
    
    public DefaultListModel ListarCuentaClientes(){
        DefaultListModel model = new DefaultListModel();
        
        int index =0;
        
        //Modelo de lista model.
        for (clsCliente cliente : ListaClientes){
            String data = cliente.getIdCliente()+ " - "+ cliente.getNombre()+ " "+cliente.getApellido()+" -- "+cliente.getCuentas().toString();
            model.add(index, data);  //Agrega cada cliente al modelo para aplicar a la lista
            index++;
        }
        
        return model;
    }
    
    
}
