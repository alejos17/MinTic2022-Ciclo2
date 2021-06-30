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
 * solicitar ingreso de valor y nos muestre la suma de los valores y el promedio
 */
public class MainClassfor {
    
    public static void main(String[] args) {
        
        Scanner aux = new Scanner(System.in);
        int suma, valor, promedio, cant;
        
        System.out.print("Cuantos elementos almacenar?: ");
        cant = aux.nextInt();
        suma = 0;
        
        for (int f = 1; f <= cant; f++) {
            System.out.print("Ingrese el valor: ");
            valor = aux.nextInt();
            suma = suma+valor;
        }
        
        System.out.println("La suma es: "+suma);
        promedio = suma / cant;
        System.out.println("El promedio es: "+promedio);
        
        
    }
    
}
