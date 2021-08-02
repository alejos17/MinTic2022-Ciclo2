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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author alejos17
 */
public class modelPedidos {
    
    private Control control;
    Database database;
    private LinkedList<clsPedidos> pedidoList = new LinkedList<>();
    private DefaultListModel model = new DefaultListModel();
   
    public modelPedidos() {
        this.database = new Database();
        
    }
    
    //Metodo para crear cliente y devolver con el boolean si lo guardo correctamente o no.
    public DefaultListModel CrearPedido(clsPedidos pedido, clsInventario inv){
        try{
            if (pedidoList.size() < 20){
                pedidoList.add(pedido);
                double valorTotal = (double) pedido.getCantidad() * inv.getValorUnit();
                String data = pedido.getCantidad() +" - "+   pedido.getProducto()+" - "+ valorTotal;
                model.addElement(data);
            }else{
                control.PedidoMax();
            }
            
        }catch (Exception e){
            return null;
        }
        
        /*int index =0;
            //Modelo de lista model.
        for (int i = 0; i <= pedidoList.size(); i++){
        //for (clsPedidos pedidos : pedidoList){
            
            
            model.add(index, data);  //Agrega cada cliente al modelo para aplicar a la lista
            index++;
        }*/
        
        return model; 
            
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
        
       
        
        return model;
    }
    
    
    public DefaultComboBoxModel ListarComboBoxCuentaPedido(String code){
        LinkedList<clsCuentas> cuentasList = new LinkedList<>();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT idcuenta FROM cuenta INNER JOIN cliente as c on id_cliente = c.idcliente WHERE id_cliente = ?";
            PreparedStatement statementCuentas = conexion.prepareStatement(query);  //Preparando statement
            statementCuentas.setString(1, code);
            ResultSet result = statementCuentas.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String idcuenta = result.getString(1);
                clsCuentas cuentas1 = new clsCuentas(idcuenta, null, 0, null);
                cuentasList.add(cuentas1);
            }
        }catch (Exception e){
            return null;
        }
        
        int index =0;
        //Modelo de lista model.
        for (clsCuentas cuenta : cuentasList){
            String data = cuenta.getIdCuenta();
            model.addElement(data);
            index++;
        }
        return model;
    }
    
    
    
    
    
    
    
    
    
}
