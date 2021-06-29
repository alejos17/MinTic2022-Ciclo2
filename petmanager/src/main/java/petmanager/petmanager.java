/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petmanager;

import Classes.clsPets;
import java.util.Date;

/**
 *
 * @author alejos17
 */
public class petmanager {

    public static void main(String[] args) {
        clsPets pet1 = new clsPets();
        pet1.setName("Firulais");
        pet1.setBorn_year(2015);
        pet1.setHealthStatus("Sano");
        pet1.setCode("001");
        pet1.setColor("Negro");
        pet1.setBreed("Criollo");
        
        clsPets pet2 = new clsPets("002","Carambas",2017,"Criollo","blanco","Enfermo");
        Date fecha_actual = new Date();
        int anioActual = fecha_actual.getYear();
        int edadPet1 = anioActual - pet1.getBorn_year();
        int edadPet2 = anioActual - pet2.getBorn_year();
        
        if(edadPet1 > edadPet2){
            System.out.println("La mascota "+ pet1.getName() + " es mayor que la mascota "+ pet2.getName());
        }else {
            if(edadPet2 > edadPet1){
                System.out.println("La mascota "+ pet2.getName() + " es mayor que la mascota "+ pet1.getName());
            }else{   
                System.out.println("La mascota "+ pet1.getName() + " tiene la misma edad que la mascota "+ pet2.getName());
            }
        }
        
        pet1.Eat();
        pet2.Eat();
        pet2.Move();
        pet2.Sound();
        
        
    }
    
        
}
    