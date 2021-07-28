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
import Model.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    public boolean CrearCuenta(clsCuentas cuenta){
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
    public boolean EditarCuenta(String idCuenta, clsCuentas cuentaM){
        try{
            
           
        
        return true;
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
    public clsCuentas BuscarCuenta(String idCuenta){
        clsCuentas cuenta1 = null;
        try{
            
          
        
        return cuenta1;
        }catch (Exception e){
            return cuenta1;
        }
            
        
    }
    
    public DefaultListModel ListarCuentas(){
        DefaultListModel model = new DefaultListModel();
        
        int index =0;
        
        //Modelo de lista model.
      
        
        return model;
    }
    
}
