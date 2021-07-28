/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.*;
import Model.*;
import java.util.LinkedList;
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
public class modelInventario {

    Database database;
    LinkedList<clsInventario> Inventario = new LinkedList<>();  //Lista de Pedidos
    
    public modelInventario() {
        this.database = new Database();
    }
    
    public boolean InitInventario(){
        
        try{
            
            clsInventario producto1 = new clsInventario("001","Producto 1",30,3500);
            clsInventario producto2 = new clsInventario("002","Producto 2",10,8600);
            clsInventario producto3 = new clsInventario("003","Producto 3",20,12500);
            clsInventario producto4 = new clsInventario("004","Producto 4",15,3800);
            clsInventario producto5 = new clsInventario("005","Producto 5",5,22000);
            clsInventario producto6 = new clsInventario("006","Producto 6",8,17900);
            clsInventario producto7 = new clsInventario("007","Producto 7",17,500);
            clsInventario producto8 = new clsInventario("008","Producto 8",35,13850);
            clsInventario producto9 = new clsInventario("009","Producto 9",40,9900);
            clsInventario producto10 = new clsInventario("010","Producto 10",50,2000);
            Inventario.add(producto1);
            Inventario.add(producto2);
            Inventario.add(producto3);
            Inventario.add(producto4);
            Inventario.add(producto5);
            Inventario.add(producto6);
            Inventario.add(producto7);
            Inventario.add(producto8);
            Inventario.add(producto9);
            Inventario.add(producto10);
            
        return true;
        }catch (Exception e){
            return false;
        }
    
    
    }
}
