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
 */
public class MainClassdowhile {
    
    public static void main(String[] args) {
        
        Scanner aux = new Scanner(System.in);
        int valor;
        
        
        do {
            System.out.print("Ingrese un valor entre 1 y 999 (salir con 0): ");
            valor = aux.nextInt();
            
            if (valor == 0){
                break;
            }else if(valor >=100){
                System.out.println("Tiene 3 digitos: ");
            }else if (valor >=10){
                System.out.println("Tiene 2 digitos: ");
            }else{
                System.out.println("Tiene 1 digito: ");
            }
        }while (true);
        
        
        
    }
    
}
