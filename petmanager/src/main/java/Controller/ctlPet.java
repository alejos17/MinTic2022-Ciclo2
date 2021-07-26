/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.*;
import Model.*;

/**
 *
 * @author alejos17
 * Aquí estaran los metodos para la lógica del negocio
 */
public class ctlPet {
    
    private modelDog modelDog;  //Variable para la instancia de Perro
        
    public ctlPet() {
        this.modelDog = new modelDog();  //Instancia entre el controller y el modelo de Dog
    }
    
    //Metodo para guardar mascota y devolver con el boolean si lo guardo correctamente o no.
    public boolean CreatePet(clsPets pet){
        try{
        switch(pet.getAnimalType()){
            case "Cat":
                
                break;
            case "Dog":
                this.modelDog.CreatePet((clsDog)pet);  //Envio el objeto a crear como un perro
                
                break;
        }
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }
    
    //Para modificar
    public boolean EditPet(clsPets pet){
        try{
        switch(pet.getAnimalType()){
            case "Gato":
                
                break;
            case "Perro":
                this.modelDog.EditPet((clsDog)pet);
                
                break;
        }
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }
    
    //Para borrar, lo unico que eso hace es al llamarlo desde la vista, mira que tipo de mascota es y llama según el caso a los metodos del modelo.
    public boolean DeletePet(clsPets pet){
        try{
        switch(pet.getAnimalType()){
            case "Gato":
                
                break;
            case "Perro":
                this.modelDog.DeletePet((clsDog)pet);
                
                break;
        }
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }
    
    //Metodo para buscar, se recibe el codigo y el tipo de mascota para segun el switch ejecutar si es perro o gato y retornar el objeto pets indicado.
    public clsPets SearchPet(String code, String type){
        clsPets pet = null;
        try{
        switch(type){
            case "Gato":
                
                break;
            case "Perro":
                pet = this.modelDog.SearchPet(code);
                
                break;
        }
        return pet;
        }catch (Exception e){
            return null;
        }
            
        
    }
    
}
