/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.util.Scanner;

/**
 *
 * @author alejos17 - Alejandro Tamayo > Grupo 20
 * Taller 3.1 de Python pasado a Java, calculadora
 */
public class calculadora {
   
    public static void main(String[] args) {
        int n1, n2, op;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("******* BIENVENIDO **********");
        System.out.println("Ingrese la operación a realizar");
        System.out.println("1. Calcular Suma +");
        System.out.println("2. Calcular Resta -");
        System.out.println("3. Calcular Multiplicación x");
        System.out.println("4. Calcular División /");
        System.out.println("******************************");
        System.out.print("Indique la opción: ");
        op = input.nextInt();
        
        System.out.println("******************************");
        System.out.print("Escriba el primer numero: ");
        n1 = input.nextInt();
        System.out.print("Escriba el segundo numero: ");
        n2 = input.nextInt();
        System.out.println("******************************");
        
        if (op==1){
            int suma = n1 + n2;
            System.out.println("Ha seleccionado sumar los numeros");
            System.out.println("Resultado: "+suma);
        }else if (op==2){
            int resta = n1 - n2;
            System.out.println("Ha seleccionado restar los numeros");
            System.out.println("Resultado: "+n1+" - "+n2+" = "+resta);
        }else if (op==3){
            int mult = n1 * n2;
            System.out.println("Ha seleccionado multiplicar los numeros");
            System.out.println("Resultado: "+n1+" * "+n2+" = "+mult);
        }else if (op==4){
            if (n2 ==0){
                System.out.println("La división por cero es indeterminada, no es posible continuar");
                System.exit(0);
            }else{
                float div = n1 / n2;
                System.out.println("Ha seleccionado dividir los numeros");
                System.out.println("Resultado: "+n1+" / "+n2+" = "+div);
            }
            
        }
        
        
        
    }
    
}
