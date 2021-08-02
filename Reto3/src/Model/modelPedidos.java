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
public class modelPedidos {
    
    private Control control;
    Database database;
    private LinkedList<clsPedidos> pedidoList = new LinkedList<>();
    private DefaultListModel model = new DefaultListModel();
    private String idCliente;
    private int cantidad_final;
    
    public modelPedidos() {
        this.database = new Database();
        
    }
    
    public String fecha(){
        Date fecha = new Date();
        String formatofecha = "YYYY-MM-dd HH:mm:ss";
        SimpleDateFormat fecha2 = new SimpleDateFormat(formatofecha);
        String fecha1 = fecha2.format(fecha);
        return fecha1;
    }
    
    public Timestamp fechaSQL(){
        Date fecha = new Date();
        Timestamp timestamp = new Timestamp(fecha.getTime());
        return timestamp;
    }
    
    //Metodo para crear cliente y devolver con el boolean si lo guardo correctamente o no.
    public DefaultListModel CrearPedido(clsPedidos pedido, String idCliente1){
        idCliente = idCliente1;
        try{
            if (pedidoList.size() < 20){
                pedidoList.add(pedido);
                double valorTotal = (double) pedido.getCantidad() * pedido.getValorunit();
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
    
    //Hacer Pedido - ingresar el pedido a la BD tanto en la tabla pedido
    //en la tabla inventariopedido con los valores calculados y restando las cantidades en inventario.
    //y en la tabla clientepedido para asignar ese pedido a ese cliente.
    /*public boolean HacerPedido(){
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){       
            for (clsPedidos pedidos : pedidoList){
                String query1 = "INSERT INTO pedido (idpedido, producto, cantidad, valortotal) VALUES (?, ?, ?, ?)";
                PreparedStatement statementPedido = conexion.prepareStatement(query1);  
                statementPedido.setInt(1, Integer.parseInt(pedidos.getIdPedido()));  //Statements por cada ?
                statementPedido.setString(2, pedidos.getProducto());
                statementPedido.setInt(3, pedidos.getCantidad());
                statementPedido.setDouble(4, pedidos.getValorTotal());
                int rowsInsertedPedido = statementPedido.executeUpdate();  //Se cuenta la cantiad de datos insertados en tabla Pedido
                //Para la tabla inventariopedido
                String query2 = "INSERT INTO inventariopedido (id_pedido, id_inventario, fecha, cantidad) VALUES (?, ?, ?, ?)";
                PreparedStatement statementInvPedido = conexion.prepareStatement(query2);  
                statementInvPedido.setInt(1, Integer.parseInt(pedidos.getIdPedido()));
                statementInvPedido.setString(2, pedidos.getIdinventario());  
                Timestamp fechaSQL = this.fechaSQL();   //LLamo metodo para calcular fecha en formato SQL
                statementInvPedido.setTimestamp(3, fechaSQL);  //Envio parametro fecha
                statementInvPedido.setInt(4, pedidos.getCantidad());
                int rowsInsertedInvPedido = statementInvPedido.executeUpdate();  //Se cuenta la cantiad de datos insertados en tabla InventarioPedido
                //Para la table clientepedido
                String query3 = "INSERT INTO clientepedido (id_cliente, id_pedido, fecha) VALUES (?, ?, ?)";
                PreparedStatement statementClientePedido = conexion.prepareStatement(query3);
                statementClientePedido.setString(1, idCliente);
                statementClientePedido.setInt(2, Integer.parseInt(pedidos.getIdPedido()));
                statementClientePedido.setTimestamp(3, fechaSQL);
                int rowsInsertedClientePedido = statementClientePedido.executeUpdate();  //Se cuenta la cantiad de datos insertados en tabla InventarioPedido
                //Update para la tabla inventario donde se resta la cantidad seleccionada por el usuario.
                try{
                    cantidad_final = pedidos.getCantinv() - pedidos.getCantidad();   // Resta la cantidad al inventario
                }catch (Exception e){
                    System.out.println("Error en la resta no es");
                }
                String query4 = "UPDATE inventario SET existencia = ? WHERE idinventario = ?";
                PreparedStatement statementInventario = conexion.prepareStatement(query4);
                statementInventario.setInt(1, cantidad_final);
                statementInventario.setString(2, pedidos.getIdinventario());
                int rowsInsertedInventario = statementInventario.executeUpdate();  //Se cuenta la cantiad de datos insertados en tabla InventarioPedido
                
                if (rowsInsertedPedido > 0 && rowsInsertedInvPedido > 0 && rowsInsertedClientePedido > 0 && rowsInsertedInventario > 0){     //Si es mayor a cero quiere decir que si guardo los datos
                    return true; 
                }else{
                    return false;
                }
                    
            }
        }catch (Exception e){
                return false;
        }
        return true;
        
    }*/
    
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
