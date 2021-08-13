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
        
        /*int index =0;
        //Modelo de lista model.
        for (clsInventario inv : Lista){
            String data = inv.getProducto() + " - "+ inv.getCant_ext();
            model.add(index, data);  //Agrega cada cliente al modelo para aplicar a la lista
            index++;
        }*/
        return Lista;
    }
    
    
}
