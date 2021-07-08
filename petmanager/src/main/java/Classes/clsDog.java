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

    
    
    
    
}
