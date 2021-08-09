/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.LinkedList;

/**
 *
 * @author alejos17
 */
public class clsPersona {
    
    String nombre;
    String apellido;
    int metroscaminados;
    LinkedList<clsPersona> familiares = new LinkedList<>();
    
    public clsPersona(String nombre, String apellido) {
        this.nombre = "Andres";
        this.apellido = "Lopez";
    }

    public clsPersona() {
        
    }
    
    public int walkarroud(int[] metros){
        int i = 0;
        for (int num : metros) {
             metroscaminados += num;
        }
        return metroscaminados;
    }  
    
    public int addrelative(clsPersona familiar){
        familiares.add(familiar);
        int index = familiares.size()-1;
        return index;
    }
    
    public boolean updateperson(String nombre1, String apellido1){
        this.nombre = nombre1;
        this.apellido = apellido1;
        return true;
    }
    
    public int removerelative(){
        try{
            familiares.removeLast();
            return 1;
        }catch(Exception e){
            return 0;
        }
        
        
    }
    
}
