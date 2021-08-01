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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alejos17
 */
public class modelInventario {

    Database database;
    
    public modelInventario() {
        this.database = new Database();
    }
    
    public boolean Agregar(clsInventario inv){
        System.out.println("El metodo agregar de modInventario se esta llamando al hacer click");
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   
            String query = "INSERT INTO inventario (idinventario, categoria, producto, valorunitario, iva, existencia) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statementInv = conexion.prepareStatement(query);  
            statementInv.setString(1, inv.getIdProducto());  //Statements por cada ?
            statementInv.setString(2, inv.getCategoria());
            statementInv.setString(3, inv.getProducto());
            statementInv.setDouble(4, inv.getValorUnit());
            statementInv.setDouble(5, inv.getIva());
            statementInv.setInt(6, inv.getCant_ext());
            int rowsInserted = statementInv.executeUpdate();  //Se cuenta la cantiad de datos insertados devolviendo un entero
            if (rowsInserted > 0){     //Si es mayor a cero quiere decir que si guardo los datos
                return true; 
                }
            return false;
        }catch (Exception e){
            return false;
        }
    }
    
    public clsInventario Buscar(String idProducto){
        clsInventario inv = null;
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT * FROM inventario WHERE idinventario = ?";
            PreparedStatement statementCliente = conexion.prepareStatement(query);  //Preparando statement
            statementCliente.setString(1, idProducto);  //Statements en este caso le mando el codigo de usuario para busqueda
            ResultSet result = statementCliente.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String idinventario = result.getString(1);
                String categoria = result.getString(2);
                String producto = result.getString(3);
                double valorunitario = Double.parseDouble(result.getString(4));
                double iva = Double.parseDouble(result.getString(5));
                int existencia = Integer.parseInt(result.getString(6));
                inv = new clsInventario(idinventario, categoria, producto, existencia, iva, valorunitario);
            }
            return inv;
        }catch (Exception e){
            return inv;
        }
    }
    
    public boolean Editar(String code, clsInventario invM){
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "UPDATE inventario SET idinventario = ?, categoria = ?, producto = ?, valorunitario = ?, iva = ?, existencia = ? WHERE idinventario = ?";
            PreparedStatement statementInv = conexion.prepareStatement(query);  //Aca mandamos los datos de pet (clase padre), se crea registro y luego se obtiene el KEY para saber luego a clase dog y entrar los datos en la tabla dog.
            statementInv.setString(1, invM.getIdProducto());  //Statements por cada ?
            statementInv.setString(2, invM.getCategoria());
            statementInv.setString(3, invM.getProducto());
            statementInv.setDouble(4, invM.getValorUnit());
            statementInv.setDouble(5, invM.getIva());
            statementInv.setInt(6, invM.getCant_ext());
            statementInv.setString(7, code);
            int rowsUpdated = statementInv.executeUpdate();  //Se cuenta la cantiad de datos insertados devolviendo un entero
            if (rowsUpdated > 0){     //Si es mayor a cero quiere decir que si guardo los datos
                return true; 
                }
            return false;
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean Borrar(String idProducto){
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "DELETE FROM inventario WHERE idinventario = ?";
            PreparedStatement statementInv = conexion.prepareStatement(query);  //Preparando statement
            statementInv.setString(1, idProducto);  //Statements en este caso le mando el codigo de usuario para busqueda
            int rowsUpdated = statementInv.executeUpdate();  //Se cuenta la cantiad de datos insertados devolviendo un entero
            if (rowsUpdated > 0){     //Si es mayor a cero quiere decir que si guardo los datos
                return true; 
                }
            return false;
        }catch (Exception e){
            return false;
        }
    }
    
    public DefaultListModel Listar(){
        LinkedList<clsInventario> invList = new LinkedList<>();
        DefaultListModel model = new DefaultListModel();
        
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT * FROM inventario";
            PreparedStatement statementInv = conexion.prepareStatement(query);  //Preparando statement
            ResultSet result = statementInv.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String idinventario = result.getString(1);
                String categoria = result.getString(2);
                String producto = result.getString(3);
                double valorunitario = Double.parseDouble(result.getString(4));
                double iva = Double.parseDouble(result.getString(5));
                int existencia = Integer.parseInt(result.getString(6));
                clsInventario inv1 = new clsInventario(idinventario, categoria, producto, existencia, iva, valorunitario);
                invList.add(inv1);
            }
           
        }catch (Exception e){
            return null;
        }
        
        int index =0;
        //Modelo de lista model.
        for (clsInventario inv : invList){
            String data = inv.getIdProducto() + " - "+ inv.getProducto() +" - "+ inv.getCant_ext()+" - "+ inv.getValorUnit()+" - "+ inv.getIva();
            model.add(index, data);  //Agrega cada cliente al modelo para aplicar a la lista
            index++;
        }
        return model; 
    }
    
    public DefaultTableModel Listar2(){
        String[] titulos = {"ID", "Categoria", "Producto", "Valor", "IVA", "Cantidad"};
        //List<clsInventario> invList = new ArrayList<>();
        DefaultTableModel model = new DefaultTableModel(null, titulos);
        String[] registros = new String[6];
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT * FROM inventario";
            PreparedStatement statementInv = conexion.prepareStatement(query);  //Preparando statement
            ResultSet result = statementInv.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                registros[0] = result.getString("ID");
                registros[1] = result.getString("Categoria");
                registros[2] = result.getString("Producto");
                registros[3] = String.valueOf(result.getDouble("Valor"));
                registros[4] = String.valueOf(result.getDouble("IVA"));
                registros[5] = String.valueOf(result.getInt("Cantidad"));
                //clsInventario inv1 = new clsInventario(idProducto, categoria, producto, existencia, iva, valorunitario);
                //invList.add(inv1);
                model.addRow(registros);
            }
        }catch (Exception e){
            return null;
        }
        
        /*int index =0;
        //Modelo de lista model.
        for (clsCliente cliente : clienteList){
            String data = cliente.getIdCliente() + " - "+ cliente.getNombre() +" "+ cliente.getApellido()+" -- correo: "+ cliente.getCorreo();
            model.add(index, data);  //Agrega cada cliente al modelo para aplicar a la lista
            index++;
        }*/
        return model;
    }
    
    
}


