/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.*;
import Model.DbData;
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
public class modelDog {
    
    DbData dbData;
    
    public modelDog() {
        this.dbData = new DbData();
    }
    
    //Metodo para guardar mascota y devolver con el boolean si lo guardo correctamente o no.
    public boolean CreatePet(clsDog dog){
        try (Connection conn = DriverManager.getConnection(dbData.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "INSERT INTO tb_pet (code, name, born_year, color, health_status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statementPet = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);  //Aca mandamos los datos de pet (clase padre), se crea registro y luego se obtiene el KEY para saber luego a clase dog y entrar los datos en la tabla dog.
            statementPet.setString(1, dog.getCode());  //Statements por cada ? en el parametro de arriba   Codigo perro
            statementPet.setString(2, dog.getName());
            statementPet.setInt(3, dog.getBorn_year());   //Por ser entero
            statementPet.setString(4, dog.getColor());
            statementPet.setString(5, dog.getHealthStatus());
            int rowsInserted = statementPet.executeUpdate();  //Se cuenta la cantiad de datos insertados devolviendo un entero
            if (rowsInserted > 0){     //Si es mayor a cero quiere decir que si guardo los datos en la tabla ahora a sacar el KEY para la clase DOG
                ResultSet generatedKeys = statementPet.getGeneratedKeys();  // Tomando el KEY generado al insertar la mascota
                if (generatedKeys.next()){       //Si existe porque se genero
                    int idPet = generatedKeys.getInt(1);  //Lo guardo en idPet
                    query = "INSERT INTO tb_dog (breed, pedigree, id_pet) VALUES (?, ?, ?)";  //Lanzo el query a la tabla tb_dog con raza, pedigree y el id_pet para que se reconozca
                    PreparedStatement statementDog = conn.prepareStatement(query);
                    statementDog.setString(1, dog.getBreed());
                    statementDog.setBoolean(2, dog.isPedigree());
                    statementDog.setInt(3, idPet);
                    rowsInserted = statementDog.executeUpdate();
                    if (rowsInserted > 0){
                        return true;
                    }
                    
                }
            }
            
            return false;
        }catch (SQLException e){
            return false;
        }
            
        
    }
    
    //Para modificar
    public boolean EditPet(clsDog dog){
        try{
        
        
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }
    
    //Para borrar, lo unico que eso hace es al llamarlo desde la vista, mira que tipo de mascota es y llama según el caso a los metodos del modelo.
    public boolean DeletePet(clsDog dog){
        try{
                
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }
    
    //Metodo para buscar, se recibe el codigo y el tipo de mascota para segun el switch ejecutar si es perro o gato y retornar el objeto pets indicado.
    public clsDog SearchPet(String code){
        clsDog dog = null;
        try{
        
        return dog;
        }catch (Exception e){
            return dog;
        }
            
        
    }
    
}
