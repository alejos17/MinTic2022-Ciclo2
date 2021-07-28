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
    private modelCliente modelCliente;
    LinkedList<clsCuentas> ListaCuentas = new LinkedList<>();  //Lista de Cuentas
    
    public modelCuentas() {
         this.database = new Database();
    }
    
    public boolean InitCuentas(){
        try{
            
            /*clsCuentas cuenta1 = new clsCuentas("345678902","Ahorros",2450000);
            clsCuentas cuenta2 = new clsCuentas("378984657","Tarjeta",457000);
            clsCuentas cuenta3 = new clsCuentas("789465902","Corriente",1060000);
            clsCuentas cuenta4 = new clsCuentas("132649865","Ahorros",135000);
            clsCuentas cuenta5 = new clsCuentas("754623103","Ahorros",842000);
            clsCuentas cuenta6 = new clsCuentas("965323156","Tarjeta",658000);
            ListaCuentas.add(cuenta1);
            ListaCuentas.add(cuenta2);
            ListaCuentas.add(cuenta3);
            ListaCuentas.add(cuenta4);
            ListaCuentas.add(cuenta5);
            ListaCuentas.add(cuenta6);
            
            this.modelCliente.AsignarCuentas("001", cuenta1);
            this.modelCliente.AsignarCuentas("001", cuenta2);
            this.modelCliente.AsignarCuentas("002", cuenta3);
            this.modelCliente.AsignarCuentas("002", cuenta4);
            this.modelCliente.AsignarCuentas("003", cuenta5);
            this.modelCliente.AsignarCuentas("004", cuenta6);*/
            
        return true;
        }catch (Exception e){
            return false;
        }
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
            
            for (clsCuentas cuenta : ListaCuentas){
                if(cuenta.getIdCuenta().equals(idCuenta)){
                    cuenta.setCuenta(cuentaM.getCuenta());
                    cuenta.setSaldo(cuentaM.getSaldo());
                }
            }
        
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
            
            for (clsCuentas cuenta : ListaCuentas){
                if(cuenta.getIdCuenta().equals(idCuenta)){
                    cuenta1 = cuenta;
                }
            }
        
        return cuenta1;
        }catch (Exception e){
            return cuenta1;
        }
            
        
    }
    
    public DefaultListModel ListarCuentas(){
        DefaultListModel model = new DefaultListModel();
        
        int index =0;
        
        //Modelo de lista model.
        for (clsCuentas cuenta : ListaCuentas){
            String data = cuenta.getIdCuenta() + " - "+ cuenta.getCuenta() +" "+ cuenta.getSaldo();
            model.add(index, data);  //Agrega cada cliente al modelo para aplicar a la lista
            index++;
        }
        
        return model;
    }
    
}
