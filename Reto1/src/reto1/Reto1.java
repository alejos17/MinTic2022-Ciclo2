/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto1;
import java.util.Scanner;
import reto1.clsPaciente;

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
        clsPaciente pac1 = new clsPaciente();
        String nombre, apellido;
        int fecha_nac, edad;
    
        System.out.println("******* BIENVENIDO **********");
        System.out.println("Escriba el nombre");
        pac1.setNombre(input.nextLine());
        //nombre = input.nextLine();
        System.out.println("Escriba el apellido");
        pac1.setApellido(input.nextLine());
        //apellido = input.nextLine();
        System.out.println("Escriba la fecha de Nacimiento");
        pac1.setFecha_nac(input.nextInt());
        //fecha_nac = input.nextInt();
        System.out.println("Escriba la edad");
        pac1.setEdad(input.nextInt());
        //edad = input.nextInt();
    
        System.out.println("Lo escrito es: ");
        //System.out.println("Nombre Completo: "+nombre+" "+apellido);
        System.out.println("Lo guardado en el objeto es: ");
        pac1.mostrar();
        
    }
    
}
