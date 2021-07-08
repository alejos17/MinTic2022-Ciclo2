/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author alejos17
 */
public class clsPets {
    private String code;
    private String name;
    private int born_year;
    private String color;
    private String healthStatus;
    private clsVeterinary veterinary;   //LLamo un objeto de veterinaria para asignarlo cuando se crea una mascota...  RELACION DE AGREGACION....  Y LO MANDO CON EL METODO SET 

    public clsPets() {
    }

    public clsPets(String code, String name, int born_year, String color, String healthStatus) {
        this.code = code;
        this.name = name;
        this.born_year = born_year;
        this.color = color;
        this.healthStatus = healthStatus;
    }

    

    public void Eat(){
        System.out.println("La mascota "+ this.name + " esta comiendo");
    }
    
    public void Move(){
        System.out.println("La mascota "+ this.name + " se esta moviendo");
    }
    
    public void Sound(){
        System.out.println("La mascota "+ this.name + " esta haciendo sonidos");
    }
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the born_year
     */
    public int getBorn_year() {
        return born_year;
    }

    /**
     * @param born_year the born_year to set
     */
    public void setBorn_year(int born_year) {
        this.born_year = born_year;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the healthStatus
     */
    public String getHealthStatus() {
        return healthStatus;
    }

    /**
     * @param healthStatus the healthStatus to set
     */
    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    /**
     * @return the veterinary
     */
    public clsVeterinary getVeterinary() {
        return veterinary;
    }

    /**
     * @param veterinary the veterinary to set
     */
    public void setVeterinary(clsVeterinary veterinary) {
        this.veterinary = veterinary;
    }
}