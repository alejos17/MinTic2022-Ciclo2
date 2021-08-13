/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.DefaultListModel;

/**
 *
 * @author alejos17
 */
public class modelGraficos {
    
    Database database;

    public modelGraficos() {
        this.database = new Database();
    }
    
    public LinkedList<clsInventario> InfoInventario(){
        LinkedList<clsInventario> Lista = new LinkedList<>();
        //DefaultListModel model = new DefaultListModel();
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT producto, existencia FROM inventario GROUP BY idinventario ";
            PreparedStatement statementCuenta = conexion.prepareStatement(query);  //Preparando statement
            ResultSet result = statementCuenta.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String producto = result.getString(1);
                int existencia = result.getInt(2);
                clsInventario inv1 = new clsInventario(null, null, producto, existencia, 0, 0);
                Lista.add(inv1);
            }
        }catch (Exception e){
            return null;
        }
        
        return Lista;
    }
    
    
    public LinkedList<clsCliente> InfoClienteCuenta(){
        LinkedList<clsCliente> Lista = new LinkedList<>();
        //DefaultListModel model = new DefaultListModel();
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT cliente.nombre, COUNT(cuenta.idcuenta) FROM cliente INNER JOIN cuenta ON cliente.idcliente = cuenta.id_cliente GROUP BY cliente.idcliente";
            PreparedStatement statementCuenta = conexion.prepareStatement(query);  //Preparando statement
            ResultSet result = statementCuenta.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String nombre = result.getString(1);
                int cuentas = result.getInt(2);
                clsCliente cli1 = new clsCliente(null, nombre, null, null, null, null);
                cli1.setCuentas(cuentas);
                Lista.add(cli1);
            }
        }catch (Exception e){
            return null;
        }
        
        return Lista;
    }
    
    
    public LinkedList<clsCuentas> InfoTipoCuenta(){
        LinkedList<clsCuentas> Lista = new LinkedList<>();
        //DefaultListModel model = new DefaultListModel();
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT tipocuenta, COUNT(idcuenta) FROM cuenta GROUP BY tipocuenta";
            PreparedStatement statementCuenta = conexion.prepareStatement(query);  //Preparando statement
            ResultSet result = statementCuenta.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String tipo = result.getString(1);
                int cantidad = result.getInt(2);   //Por la variable saldo que es tipo INT del objeto cuenta, para este caso envio la cantidad nada mas.
                clsCuentas cuenta1 = new clsCuentas(null, tipo, cantidad, null);
                Lista.add(cuenta1);
            }
        }catch (Exception e){
            return null;
        }
        
        return Lista;
    }
    
    public LinkedList<clsCliente> InfoPedidosxCliente(){
        LinkedList<clsCliente> Lista = new LinkedList<>();
        //DefaultListModel model = new DefaultListModel();
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT cliente.nombre, COUNT(clientepedido.id_pedido) FROM cliente INNER JOIN clientepedido ON cliente.idcliente = clientepedido.id_cliente GROUP BY cliente.idcliente";
            PreparedStatement statementCuenta = conexion.prepareStatement(query);  //Preparando statement
            ResultSet result = statementCuenta.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String nombre = result.getString(1);
                int cantidad = result.getInt(2);   //Por la variable saldo que es tipo INT del objeto cuenta, para este caso envio la cantidad nada mas.
                clsCliente cli1 = new clsCliente(null, nombre, null, null, null, null);
                cli1.setCuentas(cantidad);
                Lista.add(cli1);
            }
        }catch (Exception e){
            return null;
        }
        
        return Lista;
    }
    
}
