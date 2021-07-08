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
public class clsVeterinary extends AbstHospital {     //Heredar desde clase abstracta
    private String name;
    private String phone;
    private String address;
    private clsDoctor doctor;  //Llamando un doctor cuando se cree un objeto veterinary...  obligado en el constructor para que siempre lo solicite  RELACION DE COMPOSICION!!

    public clsVeterinary(String name, String phone, String address, clsDoctor doctor) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.doctor = doctor;
    }
    
    public String petCare(clsPets pet){ //Devuelve el estado de salud de la mascota, este metodo recibe una mascota que es la que se evalua... por lo que se pone por parametro POLIMORFISMO PURO
        System.out.println("Atendiendo a la mascosta "+ pet.getName());
        return pet.getHealthStatus();   //Como pido string por parametro, retorno un string e imprimo mensaje por consola.
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
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the doctor
     */
    public clsDoctor getDoctor() {
        return doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(clsDoctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String getPatientType() {
        return "Animal";
    }

    @Override
    public String Surgery() {
        return "Surgery animal data";
    }
    
    
    
    
}
