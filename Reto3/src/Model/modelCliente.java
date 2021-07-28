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
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author alejos17
 */
public class modelCliente {
    
    Database database;

    public modelCliente() {
        this.database = new Database();
    }
    
    //Metodo para crear cliente y devolver con el boolean si lo guardo correctamente o no.
    public boolean Crear(clsCliente cliente){
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "INSERT INTO cliente (idcliente, nombre, apellido, direccion, telefono, correo) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statementCliente = conexion.prepareStatement(query);  //Aca mandamos los datos de pet (clase padre), se crea registro y luego se obtiene el KEY para saber luego a clase dog y entrar los datos en la tabla dog.
            statementCliente.setString(1, cliente.getIdCliente());  //Statements por cada ?
            statementCliente.setString(2, cliente.getNombre());
            statementCliente.setString(3, cliente.getApellido());
            statementCliente.setString(4, cliente.getDireccion());
            statementCliente.setString(5, cliente.getTelefono());
            statementCliente.setString(6, cliente.getCorreo());
            int rowsInserted = statementCliente.executeUpdate();  //Se cuenta la cantiad de datos insertados devolviendo un entero
            if (rowsInserted > 0){     //Si es mayor a cero quiere decir que si guardo los datos
                return true; 
                }
            return false;
        }catch (Exception e){
            return false;
        }
    }
    
    //Metodo para asignar cuenta a un cliente de la lista.
    public boolean AsignarCuentas(String idCliente, clsCuentas cuenta){
        
        try{
            
            
        
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }
    
    //Metodo para asignar cuenta a un cliente de la lista.
    public boolean AsignarPedidos(String idCliente, clsPedidos pedido){
        
        try{
            
           
        
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }

    //Para modificar
    public boolean Editar(String idCliente, clsCliente clienteM){
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "UPDATE cliente SET idcliente = ?, nombre = ?, apellido = ?, direccion = ?, telefono = ?, correo = ? WHERE idcliente = ?";
            PreparedStatement statementCliente = conexion.prepareStatement(query);  //Aca mandamos los datos de pet (clase padre), se crea registro y luego se obtiene el KEY para saber luego a clase dog y entrar los datos en la tabla dog.
            statementCliente.setString(1, clienteM.getIdCliente());  //Statements por cada ?
            statementCliente.setString(2, clienteM.getNombre());
            statementCliente.setString(3, clienteM.getApellido());
            statementCliente.setString(4, clienteM.getDireccion());
            statementCliente.setString(5, clienteM.getTelefono());
            statementCliente.setString(6, clienteM.getCorreo());
            statementCliente.setString(7, idCliente);
            int rowsUpdated = statementCliente.executeUpdate();  //Se cuenta la cantiad de datos insertados devolviendo un entero
            if (rowsUpdated > 0){     //Si es mayor a cero quiere decir que si guardo los datos
                return true; 
                }
            return false;
        }catch (Exception e){
            return false;
        }
    }
    
    //Para borrar, lo unico que eso hace es al llamarlo desde la vista, mira que tipo de mascota es y llama según el caso a los metodos del modelo.
    public boolean Borrar(String idCliente){
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "DELETE FROM cliente WHERE idcliente = ?";
            PreparedStatement statementCliente = conexion.prepareStatement(query);  //Preparando statement
            statementCliente.setString(1, idCliente);  //Statements en este caso le mando el codigo de usuario para busqueda
            int rowsUpdated = statementCliente.executeUpdate();  //Se cuenta la cantiad de datos insertados devolviendo un entero
            if (rowsUpdated > 0){     //Si es mayor a cero quiere decir que si guardo los datos
                return true; 
                }
            return false;
        }catch (Exception e){
            return false;
        }
    }
    
    //Metodo para buscar, se recibe el codigo y el tipo de mascota para segun el switch ejecutar si es perro o gato y retornar el objeto pets indicado.
    public clsCliente Buscar(String idCliente){
        clsCliente cliente1 = null;
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT * FROM cliente WHERE idcliente = ?";
            PreparedStatement statementCliente = conexion.prepareStatement(query);  //Preparando statement
            statementCliente.setString(1, idCliente);  //Statements en este caso le mando el codigo de usuario para busqueda
            ResultSet result = statementCliente.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String idcliente = result.getString(1);
                String nombre = result.getString(2);
                String apellido = result.getString(3);
                String direccion = result.getString(4);
                String telefono = result.getString(5);
                String correo = result.getString(6);
                cliente1 = new clsCliente(idcliente, nombre, apellido, direccion, telefono, correo);
            }
            return cliente1;
        }catch (Exception e){
            return cliente1;
        }
    }
    
    public DefaultListModel Listar(){
        LinkedList<clsCliente> clienteList = new LinkedList<>();
        DefaultListModel model = new DefaultListModel();
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT * FROM cliente";
            PreparedStatement statementCliente = conexion.prepareStatement(query);  //Preparando statement
            ResultSet result = statementCliente.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String idcliente = result.getString(1);
                String nombre = result.getString(2);
                String apellido = result.getString(3);
                String direccion = result.getString(4);
                String telefono = result.getString(5);
                String correo = result.getString(6);
                clsCliente cliente1 = new clsCliente(idcliente, nombre, apellido, direccion, telefono, correo);
                clienteList.add(cliente1);
            }
        }catch (Exception e){
            return null;
        }
        
        int index =0;
        //Modelo de lista model.
        for (clsCliente cliente : clienteList){
            String data = cliente.getIdCliente() + " - "+ cliente.getNombre() +" "+ cliente.getApellido()+" -- correo: "+ cliente.getCorreo();
            model.add(index, data);  //Agrega cada cliente al modelo para aplicar a la lista
            index++;
        }
        return model;
    }
    
    
    public DefaultComboBoxModel ListarCuentaClientes(){
        LinkedList<clsCliente> clienteList = new LinkedList<>();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT * FROM cliente";
            PreparedStatement statementCliente = conexion.prepareStatement(query);  //Preparando statement
            ResultSet result = statementCliente.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String idcliente = result.getString(1);
                String nombre = result.getString(2);
                String apellido = result.getString(3);
                String direccion = result.getString(4);
                String telefono = result.getString(5);
                String correo = result.getString(6);
                clsCliente cliente1 = new clsCliente(idcliente, nombre, apellido, direccion, telefono, correo);
                clienteList.add(cliente1);
            }
        }catch (Exception e){
            return null;
        }
        
        int index =0;
        //Modelo de lista model.
        for (clsCliente cliente : clienteList){
            String data = cliente.getIdCliente();
            model.addElement(data);
            index++;
        }
        return model;
    }
    
    
}
