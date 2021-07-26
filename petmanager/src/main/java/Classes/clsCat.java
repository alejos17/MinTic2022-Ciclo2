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
public class clsCat extends clsPets {
    private String breed;
    
    //Constructor
    public clsCat(String breed, String code, String name, int born_year, String color, String healthStatus) {
        super(code, name, born_year, color, healthStatus);  //Super la clase mayor en este caso clsPets para consultar.
        this.breed = breed;
    }
    
    
    public void SelfCleaning(){
        System.out.println("El gato "+ super.getName() +" se esta limpiando.");  //Trayendo nombre de gato desde la clase padre.
    }
    
    @Override
    public void Sound(){
        System.out.println("El gato "+super.getName()+" hace miaaaaauuuuu!");
    }
    
    
    @Override
    public int getNumberOfBones(){
        return 230;
    }
    
    @Override
    public String getAnimalType(){
        return "Cat";
    }
    
    /**
     * @return the breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * @param breed the breed to set
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }
}
