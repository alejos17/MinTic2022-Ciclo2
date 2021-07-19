/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Classes.*;
import Model.*;
import Controller.*;
import java.util.LinkedList;
import javax.swing.DefaultListModel;

/**
 *
 * @author alejos17
 */
public class modelPedidos {
    
    private modelCliente modelCliente;
    LinkedList<clsPedidos> ListaPedidos = new LinkedList<>();  //Lista de Pedidos
    
    public modelPedidos() {
    }
    
    public boolean InitPedidos(){
        
        try{
            
            clsPedidos pedido1 = new clsPedidos("001","Producto 1",2,0,0,0);
            clsPedidos pedido2 = new clsPedidos("010","Producto 10",1,0,0,0);
            clsPedidos pedido3 = new clsPedidos("004","Producto 4",3,0,0,0);
            clsPedidos pedido4 = new clsPedidos("007","Producto 7",1,0,0,0);
            clsPedidos pedido5 = new clsPedidos("003","Producto 3",1,0,0,0);
            clsPedidos pedido6 = new clsPedidos("002","Producto 2",4,0,0,0);
            clsPedidos pedido7 = new clsPedidos("001","Producto 1",2,0,0,0);
            clsPedidos pedido8 = new clsPedidos("009","Producto 9",2,0,0,0);
            clsPedidos pedido9 = new clsPedidos("003","Producto 3",3,0,0,0);
            clsPedidos pedido10 = new clsPedidos("004","Producto 4",1,0,0,0);
            clsPedidos pedido11 = new clsPedidos("006","Producto 6",1,0,0,0);
            clsPedidos pedido12 = new clsPedidos("005","Producto 5",1,0,0,0);
            clsPedidos pedido13 = new clsPedidos("010","Producto 10",1,0,0,0);
            clsPedidos pedido14 = new clsPedidos("008","Producto 8",2,0,0,0);
            clsPedidos pedido15 = new clsPedidos("002","Producto 2",2,0,0,0);
            clsPedidos pedido16 = new clsPedidos("004","Producto 4",3,0,0,0);
            clsPedidos pedido17 = new clsPedidos("009","Producto 9",4,0,0,0);
            clsPedidos pedido18 = new clsPedidos("008","Producto 8",2,0,0,0);
            clsPedidos pedido19 = new clsPedidos("004","Producto 4",1,0,0,0);
            clsPedidos pedido20 = new clsPedidos("003","Producto 3",2,0,0,0);
            
            this.modelCliente.AsignarPedidos("001", pedido1);
            this.modelCliente.AsignarPedidos("002", pedido2);
            this.modelCliente.AsignarPedidos("001", pedido3);
            this.modelCliente.AsignarPedidos("002", pedido4);
            this.modelCliente.AsignarPedidos("003", pedido5);
            this.modelCliente.AsignarPedidos("001", pedido6);
            this.modelCliente.AsignarPedidos("002", pedido7);
            this.modelCliente.AsignarPedidos("002", pedido8);
            this.modelCliente.AsignarPedidos("001", pedido9);
            this.modelCliente.AsignarPedidos("003", pedido10);
            this.modelCliente.AsignarPedidos("003", pedido11);
            this.modelCliente.AsignarPedidos("003", pedido12);
            ListaPedidos.add(pedido13);
            ListaPedidos.add(pedido14);
            ListaPedidos.add(pedido15);
            ListaPedidos.add(pedido16);
            ListaPedidos.add(pedido17);
            ListaPedidos.add(pedido18);
            ListaPedidos.add(pedido19);
            ListaPedidos.add(pedido20);
            
            
        return true;
        }catch (Exception e){
            return false;
        }
    
    
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
    
    
    public DefaultListModel ListarPedidos(){
        DefaultListModel model = new DefaultListModel();
        
        int index =0;
        
        //Modelo de lista model.
        for (clsPedidos pedido : ListaPedidos){
            String data = pedido.getIdPedido() + " - "+ pedido.getProducto();
            model.add(index, data);  //Agrega cada cliente al modelo para aplicar a la lista
            index++;
        }
        
        return model;
    }
    
}
