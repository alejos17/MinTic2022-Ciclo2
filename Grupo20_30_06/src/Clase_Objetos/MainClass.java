/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase_Objetos;

import java.util.Scanner;

/**
 *
 * @author alejos17
 * declaracion de clase y objetos
 */
public class MainClass {
    
    private Scanner aux;
    private String nombre;
    private int edad;
    
    public void Inicializar(){
        aux = new Scanner(System.in);
        
        System.out.print("Ingrese el nombre: ");
        nombre = aux.nextLine();
        System.out.print("Ingrese la edad: ");
        edad = aux.nextInt();
        
    }
    
    
    public void Imprimir(){
        System.out.println("Nombre: "+nombre+" y tiene "+edad+" años");
    }
    
    public void Esmayor(){
        if (edad >= 18){
            System.out.println(nombre+" es mayor de edad");
        }else{
            System.out.println(nombre+" es menor de edad");
        }
    }
    
    
    public static void main(String[] args) {
        
        //Se crea objeto MainClass que tiene scanner, nombre y edad
        MainClass objeto = new MainClass();  
        
        //Llamar metodos de la clase
        objeto.Inicializar();  //Instancia al objeto de la clase
        objeto.Imprimir();
        objeto.Esmayor();
        
    }
    
}
