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
public class AbstractClass {
    
    public static void main(String[] args) {
        
        //Instancia de veterinaria y doctor
        clsDoctor doctor = new clsDoctor("Maria Fernandez", "L12345");
        clsVeterinary veterinary = new clsVeterinary("Veterinaria UdC", "036 878 15 00", "Calle 65 N 26-10", doctor);
        
        veterinary.setData(veterinary.getName()+" - "+veterinary.getAddress());
        
        String data = veterinary.getHospitalInformation();
        String type = veterinary.getPatientType();
        String surgery = veterinary.Surgery();
        
        System.out.println("Data: "+data);
        System.out.println("Type: "+type);
        System.out.println("Surgery: "+surgery);
        
    }
    
}
