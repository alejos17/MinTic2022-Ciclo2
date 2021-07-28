/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Classes.*;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author alejos17
 */
public class modelCuentas {
    
    Database database;
    
    public modelCuentas() {
         this.database = new Database();
    }
    
    //Metodo para crear cliente y devolver con el boolean si lo guardo correctamente o no.
    public boolean Crear(clsCuentas cuenta){
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "INSERT INTO cuenta (idcuenta, tipocuenta, saldo, id_cliente) VALUES (?, ?, ?, ?)";
            PreparedStatement statementCuenta = conexion.prepareStatement(query);  //Aca mandamos los datos de pet (clase padre), se crea registro y luego se obtiene el KEY para saber luego a clase dog y entrar los datos en la tabla dog.
            statementCuenta.setString(1, cuenta.getIdCuenta());  //Statements por cada ?
            statementCuenta.setString(2, cuenta.getCuenta());
            statementCuenta.setInt(3, cuenta.getSaldo());
            statementCuenta.setString(4, cuenta.getIdcuentacliente());
            int rowsInserted = statementCuenta.executeUpdate();  //Se cuenta la cantiad de datos insertados devolviendo un entero
            if (rowsInserted > 0){     //Si es mayor a cero quiere decir que si guardo los datos
                return true; 
                }
                        
            return false;
        }catch (Exception e){
            return false;
        }
            
        
    }
    
 
    
    //Para modificar
    public boolean Editar(String idCuenta, clsCuentas cuentaM){
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "UPDATE cuenta SET idcuenta = ?, tipocuenta = ?, saldo = ?, id_cliente = ? WHERE idcuenta = ?";
            PreparedStatement statementCuenta = conexion.prepareStatement(query);  //Aca mandamos los datos de pet (clase padre), se crea registro y luego se obtiene el KEY para saber luego a clase dog y entrar los datos en la tabla dog.
            statementCuenta.setString(1, cuentaM.getIdCuenta());  //Statements por cada ?
            statementCuenta.setString(2, cuentaM.getCuenta());
            statementCuenta.setInt(3, cuentaM.getSaldo());
            statementCuenta.setString(4, cuentaM.getIdcuentacliente());
            statementCuenta.setString(5, idCuenta);
            int rowsUpdated = statementCuenta.executeUpdate();  //Se cuenta la cantiad de datos insertados devolviendo un entero
            if (rowsUpdated > 0){     //Si es mayor a cero quiere decir que si guardo los datos
                return true; 
                }
            return false;
        }catch (Exception e){
            return false;
        }
    }
    
    //Para borrar, lo unico que eso hace es al llamarlo desde la vista, mira que tipo de mascota es y llama según el caso a los metodos del modelo.
    public boolean BorrarCuenta(clsCuentas cuenta){
        try{
                
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }
    
    //Metodo para buscar, se recibe el codigo y el tipo de mascota para segun el switch ejecutar si es perro o gato y retornar el objeto pets indicado.
    public clsCuentas Buscar(String idCuenta){
        clsCuentas cuenta1 = null;
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT * FROM cuenta WHERE idcuenta = ?";
            PreparedStatement statementCuenta = conexion.prepareStatement(query);  //Preparando statement
            statementCuenta.setString(1, idCuenta);  //Statements en este caso le mando el codigo de usuario para busqueda
            ResultSet result = statementCuenta.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String idcuenta = result.getString(1);
                String tipocuenta = result.getString(2);
                int saldo = result.getInt(3);
                String id_cliente = result.getString(4);
                cuenta1 = new clsCuentas(idcuenta, tipocuenta, saldo, id_cliente);
            }
            return cuenta1;
        }catch (Exception e){
            return cuenta1;
        }
            
        
    }
    
    public DefaultListModel Listar(){
        LinkedList<clsCuentas> cuentasList = new LinkedList<>();
        DefaultListModel model = new DefaultListModel();
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT * FROM cuenta";
            PreparedStatement statementCuenta = conexion.prepareStatement(query);  //Preparando statement
            ResultSet result = statementCuenta.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String idcuenta = result.getString(1);
                String tipocuenta = result.getString(2);
                int saldo = result.getInt(3);
                String id_cliente  = result.getString(4);
                clsCuentas cuenta1 = new clsCuentas(idcuenta, tipocuenta, saldo, id_cliente);
                cuentasList.add(cuenta1);
            }
        }catch (Exception e){
            return null;
        }
        
        int index =0;
        //Modelo de lista model.
        for (clsCuentas cuenta : cuentasList){
            String data = cuenta.getIdCuenta() + " - "+ cuenta.getCuenta() +" -- cliente: "+ cuenta.getIdcuentacliente();
            model.add(index, data);  //Agrega cada cliente al modelo para aplicar a la lista
            index++;
        }
        return model;
    }
    
}
