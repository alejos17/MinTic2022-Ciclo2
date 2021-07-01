/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.util.Scanner;
import java.lang.Math;  //Libreria para traer constante PI
import java.text.DecimalFormat; //Libreria para limitar el tamaño de los decimales

/**
 *
 * @author alejos17 - Alejandro Tamayo > Grupo 20
 * Reto 2 del ciclo1 de Python pasado a Java
 */
public class castillo {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("****************************************************************************************************");
        System.out.println("Bienvenido al Reto Semana 2 de MinTIC2022");
        System.out.println("esta pequeña aplicación intenta resolver el siguiente problema");
        System.out.println("");
        System.out.println("La puerta del castillo");
        System.out.println("");
        System.out.println("El rey Arturito (antecesor de R2D2), está muy preocupado porque le han informado que el ejército Vaderiano está muy cerca de su castillo con la idea de atacarlo...");
        System.out.println("");
        System.out.println("");
        System.out.println("Con los datos que vamos a solicitar a continuación evaluaremos la solución propuesta y estas preguntas: ");
        System.out.println("");
        System.out.println("1. Cuantas vueltas se debe dar a la polea para cerrar la puerta?");
        System.out.println("2. Cuantos Chewbaccas son necesarios? (Cada uno puede solo 3 vueltas) ");
        System.out.println("3. A un tiempo dado para que se cierre la puerta, a que velocidad se debe girar la polea?");
        System.out.println("");
        System.out.println("");
        System.out.println("****************************************************************************************************");
        System.out.println("");
        
        System.out.print("Por favor indique la longitud de la puerta en metros: ");
        float p = input.nextFloat();
        System.out.println("");
        System.out.print("Por favor indique el perimetro de la polea en centimetros: (50 cms) ");
        float po = input.nextFloat();
        System.out.println("");
        System.out.print("En cuanto tiempo desea que se cierre la puerta? (En minutos): ");
        float t = input.nextFloat();
        System.out.println("");
        
        float m = p;  //Puerta del mismo tamaño del muro para que cierre
        double a = Math.pow(m, 2);  //Elevando a potencia 2 a m
        double b = Math.pow(p, 2);  //Elevando a potencia 2 a p
        double c = Math.sqrt((a)+(b)); //Raiz cuadrada completando pitagoras con a y b... ya elevados
        DecimalFormat d = new DecimalFormat("0.00"); //Definiendo objeto para formato decimal de 2 decimales
        String c2 = d.format(c);  //Pasando c a c2 con formato de 2 decimales
        double cm = c*100;  //Se convierte metros a centimetros
        String cm2 = d.format(cm);  //Pasando a formato 2 decimales
        double radio = po/2;  //Calcular radio de la polea
        double per = 2*radio*Math.PI;  //Calcular el perimetro de la polea
        String per2 = d.format(per);  //Pasando a formato 2 decimales
        double v = cm/per;  //Calculo de la cantidad de vueltas
        String v2 = d.format(v);  //Pasando a formato 2 decimales
        double ch = v/3;  //Calculo de la cantidad de chewbaccas
        String ch2 = d.format(ch);  //Pasando a formato 2 decimales
        double ts = t*60;  //Pasando tiempo a segundos
        double vel = cm/ts;  //Calculando velocidad
        String vel2 = d.format(vel); //Pasando a formato 2 decimales
        
        System.out.println("****************************************************************************************************");
        System.out.println("");
        System.out.println("Longitud de la puerta: "+p+" metros");
        System.out.println("Perimetro de la polea: "+per2+" centimetros");
        System.out.println("Longitud del Muro: "+p+" metros");
        System.out.println("Longitud de la Cuerda: "+cm2+" centimetros o "+c2+" metros");
        System.out.println("Cantidad de Vueltas para cerrar la puerta: "+v2+" vueltas");
        System.out.println("Cantidad de Chewbaccas necesarios para cerrar la puerta: "+ch2+" chewbaccas");
        System.out.println("Tiempo requerido para cerrar la puerta: "+ts+" segundos o "+t+" minutos");
        System.out.println("Velocidad necesaria para cerrar en ese tiempo: "+vel2+" cm/seg");
        System.out.println("****************************************************************************************************");
        
        
    }
    
}
