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
public class MainClasswhile {
    
    public static void main(String[] args) {
        int x = 1;
        
        while (x<=10){
            System.out.println(x);
            x++;
        }
        
        //ingresar un numero que sea la cantidad de iteraciones
        Scanner aux = new Scanner(System.in);
        int n, y;
        
        System.out.print("Hasta cuanto se itera?: ");
        n = aux.nextInt();
        y = 1;
        
        while (y<=n){
            System.out.println(y);
            y++;
        }
        
    }
    
}
