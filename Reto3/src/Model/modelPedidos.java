/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Classes.*;
import Controller.*;
import java.util.LinkedList;

/**
 *
 * @author alejos17
 */
public class modelPedidos {
    
    LinkedList<clsPedidos> ListaPedidos = new LinkedList<>();  //Lista de Pedidos
    
    public modelPedidos() {
    }
    
    //Metodo para crear cliente y devolver con el boolean si lo guardo correctamente o no.
    public boolean CrearPedido(clsPedidos pedido){
        try{
                
            ListaPedidos.add(pedido);
            
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }
    
    //Para modificar
    public boolean EditarPedido(clsPedidos pedido){
        try{
        
        
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }
    
    //Para borrar, lo unico que eso hace es al llamarlo desde la vista, mira que tipo de mascota es y llama según el caso a los metodos del modelo.
    public boolean BorrarPedido(clsPedidos pedido){
        try{
                
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }
    
    //Metodo para buscar, se recibe el codigo y el tipo de mascota para segun el switch ejecutar si es perro o gato y retornar el objeto pets indicado.
    public clsPedidos BuscarPedido(String idPedido){
        clsPedidos pedido = null;
        try{
        
        return pedido;
        }catch (Exception e){
            return pedido;
        }
            
        
    }
    
}
