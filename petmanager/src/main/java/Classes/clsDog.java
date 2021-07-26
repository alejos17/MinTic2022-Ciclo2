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
public class clsDog extends clsPets {
    private String breed;
    private Boolean Pedigree;

    public clsDog(String breed, Boolean Pedigree, String code, String name, int born_year, String color, String healthStatus) {
        super(code, name, born_year, color, healthStatus);
        this.breed = breed;
        this.Pedigree = Pedigree;
    }
    
    public void WalkAround(){
        System.out.println("El perro "+ super.getName() +" esta caminando.");  //Llamando de la clase padre el nombre del perro
    }
    
    //Sobrecarga de metodos
    
    public void WalkAround(int km){
        System.out.println("El perro "+super.getName()+" esta caminando "+km+" km");
    }
    
    public void WalkAround(boolean dogLeash){
        String hasLeash = dogLeash ? "con correa" : "sin correa";  //Condicional de una sola linea, se guarda en hasLeash para concatenar en el mensaje
        System.out.println("El perro "+super.getName()+" esta caminando "+hasLeash);
    }
    
    @Override
    public void Sound(){
        System.out.println("El perro "+super.getName()+" hace guaaaaaauuuuu!");
    }
    
    @Override
    public String getAnimalType(){
        return "Dog";
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

    /**
     * @return the Pedigree
     */
    public Boolean getPedigree() {
        return Pedigree;
    }

    /**
     * @param Pedigree the Pedigree to set
     */
    public void setPedigree(Boolean Pedigree) {
        this.Pedigree = Pedigree;
    }

    public boolean isPedigree() {
        return Pedigree;
    }

    
    
    
    
}
