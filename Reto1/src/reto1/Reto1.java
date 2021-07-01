/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto1;
import java.util.Scanner;
import reto1.clsPersona;

/**
 *
 * @author alejos17
 */
public class Reto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        clsPersona per1 = new clsPersona();
                
        System.out.println("******* BIENVENIDO **********");
        System.out.print("Escriba el nombre: ");
        per1.setNombre(input.nextLine());
        System.out.print("Escriba el apellido: ");
        per1.setApellido(input.nextLine());
        System.out.print("Escriba su direccion de la casa: ");
        per1.setDireccion(input.nextLine());
        System.out.print("Escriba el telefono: ");
        per1.setTelefono(input.nextLine());
        
        System.out.print("Escriba el año de Nacimiento: ");
        per1.setAnoNac(input.nextInt());
        System.out.println("********************************");
        System.out.print("Escriba la etapa que le asignaron: ");
        per1.setEtapa(input.nextInt());
        System.out.println("********************************");
        
        per1.calcularEdad();
        per1.vacuna();
        System.out.println("********************************");
        
    }
    
}
