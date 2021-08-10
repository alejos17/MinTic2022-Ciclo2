/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Clases.clsPersona;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author alejos17
 */

@RunWith(MockitoJUnitRunner.class)
public class Pruebas {
    
    @InjectMocks
    clsPersona per;
    clsPersona per1 = new clsPersona("Ramon", "Lopez");
    
    @Mock
    clsPersona prueba;
    
    public Pruebas() {
        this.per = new clsPersona();
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Inicio de Prueba Clase Persona");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin de Prueba Clase Persona");
    }
    
    @Before
    public void setUp() {
        System.out.println("Probando metodo ...");
    }
    
    @After
    public void tearDown() {
        System.out.println("Termino....");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void PruebaWalkarround(){
        int[] metros = new int[]{5,6,2,5};
        assertEquals(18, per.walkarroud(metros));
    }
    
    @Test
    public void PruebaAddRelative(){
        assertEquals(0, this.per.addrelative(per1));
    }
    
    @Test
    public void PruebaUpdatePerson(){
        assertEquals(true, this.per.updateperson("Name", "LastName"));
    }
    
    @Test /*(expected = Exception.class)*/
    public void PruebaRemoveRelative(){
        this.per.addrelative(per1);
        assertEquals(1, this.per.removerelative());
    }
    
    @Test /*(expected = Exception.class)*/
    public void PruebaRemoveRelativeError(){
        assertEquals(0, this.per.removerelative());
    }
    
    
}
