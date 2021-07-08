/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import Classes.*;
import java.util.Scanner;

/**
 *
 * @author alejos17
 */
public class main {
    
    public static void main(String[] args) {
        //Instancia input para datos por teclado
        Scanner input = new Scanner(System.in);
                
        //Instancia de Empresa
        clsEmpresa empresa1 = new clsEmpresa("Arcos Ltda","800.345.234-8","Cra 23 N 34-29");
        clsEmpresa empresa2 = new clsEmpresa("Celema","810.589.145-2","Calle 45 N 12A-32");
        
        //Instancias de Empleado, asignando a una empresa obligatoriamente
        clsEmpleado empleado1 = new clsEmpleado("001","Administrativo","RRHH","N3",1450000,empresa1,"Carolina","Ramirez","1025896542","cramirez@arcos.co","Cra 34A N23-09","320789332");
        clsEmpleado empleado2 = new clsEmpleado("002","Operativo","Logistica","N5",989000,empresa1,"Carlos","Gutierrez","16852469","logistica@arcos.co","Cra 23 N 15-23","3142568795");
        clsEmpleado empleado3 = new clsEmpleado("001","Administrativo","Producción","N2",2150000,empresa2,"Mario","Lopez","10784523","mlopez@celema.co","Calle 56B N 34-70 Apto 402","3205697445");
        clsEmpleado empleado4 = new clsEmpleado("002","Operativo","Contabilidad","N3",1450000,empresa2,"Ramón","Calderon","15965302","contabiliad@celema.co","Calle 24G N12-34","3058651247");
        
        //Instancia Cliente sin necesidad de empresa
        clsCliente cliente1 = new clsCliente("C001","Maria","Gonzalez","30558796","mariag@hotmail.com","Calle 74 N 23-24 Apto 201","3004561125");
        //Asignación de empresa a cliente si es necesario a través del set
        cliente1.setEmpresa(empresa1);
        clsCliente cliente2 = new clsCliente("C001","Maria","Gonzalez","30558796","mariag@hotmail.com","Calle 74 N 23-24 Apto 201","3004561125");
        cliente2.setEmpresa(empresa2);
        clsCliente cliente3 = new clsCliente("C002","Fernando","Asociados","890256489-9","gerencia@fdoasociados.com","Calle 34 N 23-00 Bloque 1","3508942256");
        cliente3.setEmpresa(empresa1);
        
 
        System.out.println("************************************************************");
        System.out.println("********************** Bienvenido **************************");
        System.out.println("Que desea hacer?");
        System.out.println("1. Mostrar Empresas");
        System.out.println("2. Mostrar Empleados Empresa 1");
        System.out.println("3. Mostrar Clientes Empresa 1");
        System.out.println("4. Mostrar Empleados Empresa 2");
        System.out.println("5. Mostrar Clientes Empresa 2");
        System.out.println("6. Salir");
        System.out.println("************************************************************");
        int op = input.nextInt();

        
        
        if (op==1){
            System.out.println("************************************************************");
            System.out.println("****************** Listado de Empresas**********************");
            empresa1.imprimir();
            System.out.println("------------------------------------------------------------");
            empresa2.imprimir();
            System.out.println("------------------------------------------------------------");
        }else if (op==2){
            System.out.println("************************************************************");
            System.out.println("****************** Empleados Empresa 1**********************");
            empleado1.imprimir();
            System.out.println("------------------------------------------------------------");
            empleado2.imprimir();
            System.out.println("------------------------------------------------------------");
        }else if (op==3){
            System.out.println("************************************************************");
            System.out.println("****************** Clientess Empresa 1**********************");
            cliente1.imprimir();
            System.out.println("------------------------------------------------------------");
            cliente3.imprimir();
            System.out.println("------------------------------------------------------------");
        }else if (op==4){
            System.out.println("************************************************************");
            System.out.println("****************** Empleados Empresa 2**********************");
            empleado3.imprimir();
            System.out.println("------------------------------------------------------------");
            empleado4.imprimir();
            System.out.println("------------------------------------------------------------");
        }else if (op==5){
            System.out.println("************************************************************");
            System.out.println("****************** Clientess Empresa 2**********************");
            cliente2.imprimir();
            System.out.println("------------------------------------------------------------");
        }else if (op==6){
            System.exit(0);
        }else {
            System.out.println("Opción no válida, intente de nuevo");
        }
        
        
        
                
    }
    
    
}
