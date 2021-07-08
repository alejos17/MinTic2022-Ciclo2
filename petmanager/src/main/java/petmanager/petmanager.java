/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petmanager;

import Classes.*;
import java.util.Date;

/**
 *
 * @author alejos17
 */
public class petmanager {

    public static void main(String[] args) {
        
        
        clsDog dog1 = new clsDog("Criollo",false,"001","Firulais",2013,"Negro","Sano");      
        
        clsCat cat1 = new clsCat("Angora","002","Minino",2017,"blanco","Enfermo");
        
        
        Date fecha_actual = new Date();
        int anioActual = fecha_actual.getYear();
        int edadPet1 = anioActual - dog1.getBorn_year();
        int edadPet2 = anioActual - cat1.getBorn_year();
        
        if(edadPet1 > edadPet2){
            System.out.println("La mascota "+ dog1.getName() + " es mayor que la mascota "+ cat1.getName());
        }else {
            if(edadPet2 > edadPet1){
                System.out.println("La mascota "+ cat1.getName() + " es mayor que la mascota "+ dog1.getName());
            }else{   
                System.out.println("La mascota "+ dog1.getName() + " tiene la misma edad que la mascota "+ cat1.getName());
            }
        }
        
        dog1.Eat();
        cat1.Eat();
        cat1.Move();
        cat1.Sound();
        
        dog1.WalkAround();
        cat1.SelfCleaning();
        
        
    }
    
        
}
    