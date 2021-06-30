/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo20_30_06;
import java.util.Scanner;

/**
 *
 * @author alejos17
 * solicitar ingreso de valores y preguntar cual de ellos es el mayor
 */
public class MainClass2 {
    
     public static void main(String[] args) {
         int n1, n2, n3;
         
         Scanner aux = new Scanner(System.in);
         
         System.out.print("Ingrese valor: ");
         n1 = aux.nextInt();
         
         System.out.print("Ingrese valor: ");
         n2 = aux.nextInt();
         
         System.out.print("Ingrese valor: ");
         n3 = aux.nextInt();
         
         // condicional con operador logico  AND &&   o OR 
         if (n1 > n2 && n1 > n3){
            System.out.println("El mayor es N1: "+n1);
         }else if (n2 > n3){
            System.out.println("El mayor es N2: "+n2); 
         }else{
            System.out.println("El mayor es N3: "+n3);
         }
         
     }
    
}
