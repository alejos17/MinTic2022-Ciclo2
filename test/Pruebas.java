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
    
    @Mock
    
    
    public Pruebas() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Antes de clase");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Despues de clase");
    }
    
    @Before
    public void setUp() {
        System.out.println("Antes de metodo");
    }
    
    @After
    public void tearDown() {
        System.out.println("Despues de metodo");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void PruebaWalkarround(){
        int[] metros = new int[]{5,6,2,5};
        assertEquals(18, );
    }
    
    
}
