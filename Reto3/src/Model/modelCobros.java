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
    private LinkedList<clsPedidos> pedidosxCobrarList = new LinkedList<>();
    private int saldo_actual;
    private double TotalCobro;

    public modelCobros() {
        this.database = new Database();
        
    }
    
    public Timestamp fechaSQL(){
        Date fecha = new Date();
        Timestamp timestamp = new Timestamp(fecha.getTime());
        return timestamp;
    }
    
    public boolean Ejecutar(int idcobro){
        int r = 0;
        //Se recorre la lista de pedidos pendientes por cobro, osea con el campo cobro = 0
        for (clsPedidos pedidos : pedidosxCobrarList){ 
            TotalCobro = TotalCobro + pedidos.getValorTotal();
            try (Connection conexion = DriverManager.getConnection(database.getUrl())){           
                //Para la tabla cobros
                String query = "INSERT INTO cobros (idcobro, fecha, valorcobro, id_cuenta, id_pedido, id_pcompuesto) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement statementCobro = conexion.prepareStatement(query);  
                statementCobro.setInt(1, idcobro);
                Timestamp fechaSQL = this.fechaSQL();   //LLamo metodo para calcular fecha en formato SQL
                statementCobro.setTimestamp(2, fechaSQL);  //Envio parametro fecha
                statementCobro.setDouble(3, TotalCobro);
                statementCobro.setString(4, pedidos.getIdCuenta());
                statementCobro.setInt(5, Integer.parseInt(pedidos.getIdPedido()));  
                statementCobro.setInt(6, Integer.parseInt(pedidos.getIdPedidoComp()));  
                int rowsInsertedCobro = statementCobro.executeUpdate();  
                //Para la tabla cuenta realizando el descuento del saldo por el valor del pedido
                    //Capturar el saldo actual de la cuenta seleccionada para pagar el pedido
                String query2 = "SELECT saldo FROM cuenta WHERE idcuenta = ?";
                PreparedStatement statementSaldo1 = conexion.prepareStatement(query2);
                statementSaldo1.setString(1, pedidos.getIdCuenta());  
                ResultSet result = statementSaldo1.executeQuery();
                while (result.next()){    
                    saldo_actual = result.getInt(1);
                }
                statementSaldo1.close();
                    //Calcular el nuevo saldo y guardarlo en la tabla cuenta
                int saldo_final = saldo_actual - pedidos.getValorTotal();
                String query3 = "UPDATE cuenta SET saldo = ? WHERE idcuenta = ?";
                PreparedStatement statementSaldo2 = conexion.prepareStatement(query3);  
                statementSaldo2.setInt(1, saldo_final);
                statementSaldo2.setString(2, pedidos.getIdCuenta());
                int rowsInsertedSaldo = statementSaldo2.executeUpdate();  
                //Para la tabla pedido cambiar el valor del campo cobro = 1
                String query4 = "UPDATE pedido SET cobrado = 1 WHERE idpedido = ?";
                PreparedStatement statementCobro2 = conexion.prepareStatement(query4);
                statementCobro2.setString(1, pedidos.getIdPedido());
                int rowsInsertedCobro2 = statementCobro2.executeUpdate();  //Se cuenta la cantiad de datos insertados en tabla InventarioPedido
                
                if (rowsInsertedCobro > 0){
                    if (rowsInsertedSaldo > 0){
                        if (rowsInsertedCobro2 > 0){
                            r = 1;
                        }
                    }    
                }else{
                    r = 0;
                }
            conexion.close();  //Cierre de Conexiones para cada ciclo.
            statementCobro.close();
            statementSaldo2.close();
            statementCobro2.close();
            }catch (Exception e){
                return false;
            }
                
        }
        pedidosxCobrarList.clear();
        saldo_actual = 0;
        //this.LimpiarDatos();
        if (r == 1){
            return true;
        }else{
            return false;
        }
        
    }
    
    
    
    //Listar Pedidos pendientes de cobro: 
    public DefaultListModel ListarPedidosPendientesCobro(){
        LinkedList<clsPedidos> pedidoxCxList = new LinkedList<>();
        DefaultListModel model = new DefaultListModel();
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT p.idpedido, c.fecha , p.producto, p.valortotal , c.id_cliente, c.id_cuenta, p.cobrado FROM pedido p JOIN  clientepedido c ON p.idpedido = c.id_pedido WHERE p.cobrado = 0";
            PreparedStatement statementListarPedidos = conexion.prepareStatement(query);  //Preparando statement
            ResultSet result = statementListarPedidos.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String idpedido = result.getString(1);
                String fecha = result.getString(2);
                String productos = result.getString(3);
                int valorTotal  = result.getInt(4);
                String idcliente  = result.getString(5);
                String idcuenta = result.getString(6);
                int cobrado = result.getInt(7);
                clsPedidos pedido1 = new clsPedidos(idpedido,productos,0,0,0,valorTotal,cobrado);
                pedido1.setFecha(fecha);
                pedido1.setIdCliente(idcliente);
                pedido1.setIdCuenta(idcuenta);
                pedidoxCxList.add(pedido1);
            }
            
        }catch (Exception e){
            return null;
        }
        
        //Se realiza clonación de la lista del metodo a la lista del modelCobros para poder usarla en otros metodos.
        pedidosxCobrarList = (LinkedList) pedidoxCxList.clone();
        
        int index =0;
        //Modelo de lista model.
        for (clsPedidos pedido : pedidosxCobrarList){
            String data = pedido.getIdPedido() + " - "+ pedido.getFecha() +" - "+pedido.getValorTotal()+" -- cuenta: "+pedido.getIdCuenta()+" -- "+pedido.getCobrado();
            model.add(index, data);  //Agrega cada cliente al modelo para aplicar a la lista
            index++;
        }
        return model;
    }
    
    
    public DefaultListModel ListarPedidosCobrados(){
        LinkedList<clsPedidos> pedidosList = new LinkedList<>();
        DefaultListModel model = new DefaultListModel();
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT p.idpedido, c.fecha , p.producto, p.valortotal , c.id_cliente, c.id_cuenta, p.cobrado, cb.idcobro, cb.fecha FROM pedido p JOIN  clientepedido c ON p.idpedido = c.id_pedido JOIN cobros cb ON p.idpedido = cb.id_pedido WHERE p.cobrado = 1";
            PreparedStatement statementListarPedidos = conexion.prepareStatement(query);  //Preparando statement
            ResultSet result = statementListarPedidos.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String idpedido = result.getString(1);
                String fecha = result.getString(2);
                String productos = result.getString(3);
                int valorTotal  = result.getInt(4);
                String idcliente  = result.getString(5);
                String idcuenta = result.getString(6);
                int cobrado = result.getInt(7);
                int idcobro = result.getInt(8);
                String fechacobro = result.getString(9);
                clsPedidos pedido1 = new clsPedidos(idpedido,productos,0,0,0,valorTotal,cobrado);
                pedido1.setFecha(fecha);
                pedido1.setIdCliente(idcliente);
                pedido1.setIdCuenta(idcuenta);
                pedido1.setIdCobro(idcobro);
                pedido1.setFechaCobro(fechacobro);
                pedidosList.add(pedido1);
                
            }
        }catch (Exception e){
            return null;
        }
        
        int index =0;
        //Modelo de lista model.
        for (clsPedidos pedido : pedidosList){
            String data = pedido.getIdPedido() + " - "+ pedido.getFecha() +" - "+pedido.getValorTotal()+" -- cuenta: "+pedido.getIdCuenta()+" -- "+pedido.getCobrado()+" -- "+pedido.getIdCobro()+" -- "+pedido.getFechaCobro();
            model.add(index, data);  //Agrega cada cliente al modelo para aplicar a la lista
            index++;
        }
        return model;
    }
    
    
    
    
    
}
