/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.*;

/**
 *
 * @author alejos17
 */
public class modelDog {

    public modelDog() {
    }
    
    //Metodo para guardar mascota y devolver con el boolean si lo guardo correctamente o no.
    public boolean CreatePet(clsDog dog){
        try{
                
        return true;
        }catch (Exception e){
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
