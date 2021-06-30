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
public class MainClass {

    /**
     * @param args the command line arguments
     * programa que solicite la cantidad de horas trabajadas de un empleado
     * ingresar valor de la hora y generar reporte total
     * solicitar el nombre del trabajador
     */
    
    //Sin este metodo main, no arranca el programa, siempre debe ir
    public static void main(String[] args) {
        // TODO code application logic here
        String nombre;
        int cantidadHoras;
        float valorHora, sueldo;
        
        //Se crea el objeto entrada para capturar por teclado con System.in desde 
        //la clase Scanner
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingrese el nombre del empleado: ");
        nombre = entrada.nextLine();   //Se almacena lo entrado por teclado en la variable nombre
        System.out.print("Ingrese la cantidad de horas realizadas por "+nombre+": ");
        cantidadHoras = entrada.nextInt();  //Lo escrito por teclado se graba en forma INT en cantidadHoras
        System.out.print("Ingrese el valor de la hora: ");
        valorHora = entrada.nextFloat();  //Lo escrito por teclado se graba en forma Float en valorHora
        
        sueldo = cantidadHoras * valorHora;
        
        if (sueldo > 500000){
            System.out.println("------------------------------------------------------------------------------------------------------");
            System.out.println("El sueldo de "+nombre+" será de "+sueldo+" para este mes, laborando "+cantidadHoras+" horas, con un valor de "+valorHora+" por hora.");
            System.out.println(nombre+" DEBE PAGAR IMPUESTOS.....  OJO");
        } else {
            System.out.println("------------------------------------------------------------------------------------------------------");
            System.out.println("El sueldo de "+nombre+" será de "+sueldo+" para este mes, laborando "+cantidadHoras+" horas, con un valor de "+valorHora+" por hora.");
        }
        
        
        
    }
    
}
