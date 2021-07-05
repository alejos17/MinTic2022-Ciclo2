/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.util.Scanner;
import colores.color;

/**
 *
 * @author alejos17
 */
public class main {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        color convert = new color();
        
        System.out.println("******* BIENVENIDO **********");
        System.out.println("Vamos a realizar una conversión: ");
        System.out.println("*****************************");
        System.out.println("Por favor ingrese la opción: ");
        System.out.println("1. YIQ a rva");
        System.out.println("2. YIQ a YCbCr");
        System.out.println("3. rva a YIQ");
        System.out.println("4. rva a YCbCr");
        System.out.println("5. YCbCr a rva");
        System.out.println("6. YCbCr a YIQ");
        System.out.println("7. Exit");
        System.out.println("*****************************");
        System.out.print("Indique una opción: ");
        convert.setOp(input.nextInt());
        convert.conversion();
        
    }
    
}
