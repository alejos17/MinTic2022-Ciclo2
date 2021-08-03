/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author alejos17
 */
public class Database {
    
    private final String driver = "org.mariadb.jdbc.Driver";
    private final String url = "jdbc:mariadb://192.168.1.2:3306/GESTIONPEDIDOS?user=root&password=Alesan.2021";

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }
    
}
