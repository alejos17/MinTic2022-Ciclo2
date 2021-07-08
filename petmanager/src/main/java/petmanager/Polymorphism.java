/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petmanager;

import Classes.*;


/**
 *
 * @author alejos17
 */
public class Polymorphism {
    
    public static void main(String[] args) {
        //Instancias de las clases hijas
        clsDog dog = new clsDog("Criollo",false,"001","Firulais",2013,"Negro","Sano");      
        clsCat cat = new clsCat("Angora","002","Minino",2017,"blanco","Enfermo");
        
        //Instancia de veterinaria y doctor
        clsDoctor doctor = new clsDoctor("Maria Fernandez", "L12345");
        clsVeterinary veterinary = new clsVeterinary("Veterinaria UdC", "036 878 15 00", "Calle 65 N 26-10", doctor);
        
        //En esta variable careDog voy a guardar el estado de la mascota, llamo el metodo petCare y me recibe un objeto clase Pet..  
        //En este caso puede ser el dog o cat.
        String careDog = veterinary.petCare(dog);
        System.out.println("El estado de salud de "+ dog.getName()+" es "+ careDog);
        
        String careCat = veterinary.petCare(cat);
        System.out.println("El estado de salud de "+ cat.getName()+" es "+ careCat);
        
        
    }
    
}
