/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Classes.*;
import Controller.*;
import java.util.LinkedList;

/**
 *
 * @author alejos17
 */
public class modelCuentas {

    LinkedList<clsCuentas> ListaCuentas = new LinkedList<>();  //Lista de Cuentas
    
    public modelCuentas() {
    }
    
    //Metodo para crear cliente y devolver con el boolean si lo guardo correctamente o no.
    public boolean CrearCuenta(clsCuentas cuenta){
        try{
            
            ListaCuentas.add(cuenta);
            
        return true;
        }catch (Exception e){
            return false;
        }
            
        
    }
    
 
    
    //Para modificar
    public boolean EditarCuenta(clsCuentas cuenta){
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
        clsCuentas cuenta = null;
        try{
        
        return cuenta;
        }catch (Exception e){
            return cuenta;
        }
            
        
    }
    
}
