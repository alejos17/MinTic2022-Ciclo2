/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebajdbc;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alejos17
 */
public class PruebaJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String driver = "org.mariadb.jdbc.Driver";
        //String user = "root";
        //String password = "Alesan.2021";
        String url = "jdbc:mariadb://192.168.1.2:3306/administracionmascotasbd?user=root&password=Alesan.2021";
        
        Connection connection;
        
        try{
            Class.forName(driver);
            connection = (Connection) DriverManager.getConnection(url);
            if (connection != null){
                System.out.println("Conexión Exitosa");
                        
            }
                    
        }catch(Exception e) {
            System.out.println("Error en la conexión " + e.getMessage());
        }
        
        
        
       /* String driver = "com.mysql.jdbc.driver";
        String user = "root";
        String password = "Alesan.2021";
        String url = "jdbc:mysql://192.168.1.2:3306/administracionmascotasbd";
        
        Connection connection;
        
        try{
            Class.forName(driver);
            connection = (Connection) DriverManager.getConnection(url, user, password);
            if (connection != null){
                System.out.println("Conexión Exitosa");
                        
            }
                    
        }catch(Exception e) {
            System.out.println("Error en la conexión " + e.getMessage());
        }
        */
    }
    
}
