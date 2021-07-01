/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto1;

/**
 *
 * @author alejos17
 * Clase persona con los datos necesarios
 */
public class clsPersona {
    private String nombre;
    private String apellido;
    private int edad;
    private String direccion;
    private String telefono;
    private int etapa;
    private int anoNac;

    public clsPersona() {
    }

    public clsPersona(String nombre, String apellido, int edad, String direccion, String telefono, int etapa, int anoNac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.etapa = etapa;
        this.anoNac = anoNac;
    }
    
    public void vacuna(){
        if (etapa == 1){
            System.out.println(nombre+" "+apellido+" esta asignado a etapa "+etapa+", usted ya debió ser de los primeros vacunados");
        }else if (etapa == 2 || etapa == 3){
            System.out.println(nombre+" "+apellido+" esta asignado a etapa "+etapa+", usted ya debió ser vacunado, si no es así, por favor acuda al centro de vacunación más cercano");
        }else if (etapa == 4 || etapa ==5){
            System.out.println(nombre+" "+apellido+" esta asignado a etapa "+etapa+", usted está próximo a ser vacunado");
        }
    }
    
    public void calcularEdad(){
        int anoActual = 2021;           
        edad = anoActual - anoNac;
        System.out.println(nombre+", usted tiene "+edad+" años");
    }
    
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the etapa
     */
    public int getEtapa() {
        return etapa;
    }

    /**
     * @param etapa the etapa to set
     */
    public void setEtapa(int etapa) {
        this.etapa = etapa;
    }

    /**
     * @return the anoNac
     */
    public int getAnoNac() {
        return anoNac;
    }

    /**
     * @param anoNac the anoNac to set
     */
    public void setAnoNac(int anoNac) {
        this.anoNac = anoNac;
    }
    
    
    
}
