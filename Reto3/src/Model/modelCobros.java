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
import java.sql.Timestamp;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author alejos17
 */
public class modelCobros {
    
    private Control control;
    Database database;

    public modelCobros() {
        this.database = new Database();
    }
    
    //Listar Pedidos pendientes de cobro: 
    public DefaultListModel ListarPedidosPendientesCobro(){
        LinkedList<clsPedidos> pedidosList = new LinkedList<>();
        DefaultListModel model = new DefaultListModel();
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT p.idpedido, c.fecha , p.producto, p.valortotal , c.id_cliente FROM pedido p JOIN  clientepedido c ON p.idpedido = c.id_pedido WHERE p.cobrado = 0";
            PreparedStatement statementListarPedidos = conexion.prepareStatement(query);  //Preparando statement
            ResultSet result = statementListarPedidos.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String idpedido = result.getString(1);
                String fecha = result.getString(2);
                String productos = result.getString(3);
                int valorTotal  = result.getInt(4);
                String idcliente  = result.getString(5);
                clsPedidos pedido1 = new clsPedidos(idpedido,productos,0,0,0,valorTotal,0);
                pedido1.setFecha(result.getString(2));
                pedido1.setIdCliente(result.getString(5));
                pedidosList.add(pedido1);
                
            }
        }catch (Exception e){
            return null;
        }
        
        int index =0;
        //Modelo de lista model.
        for (clsPedidos pedido : pedidosList){
            String data = pedido.getIdPedido() + " - "+ pedido.getFecha() +" - "+ pedido.getProducto()+" - "+pedido.getValorTotal()+" -- cliente: "+pedido.getIdCliente();
            model.add(index, data);  //Agrega cada cliente al modelo para aplicar a la lista
            index++;
        }
        return model;
    }
    
    
}
