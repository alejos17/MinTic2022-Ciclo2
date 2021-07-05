/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colores;

import java.util.Scanner;

/**
 *
 * @author alejos17
 */
public class color {
    private float y;
    private float i;
    private float q;
    private float r;
    private float v;
    private float a;
    private float y1;
    private float cb;
    private float cr;
    private int op;

    public color() {
    }

    public color(float y, float i, float q, float r, float v, float a, float y1, float cb, float cr) {
        this.y = y;
        this.i = i;
        this.q = q;
        this.r = r;
        this.v = v;
        this.a = a;
        this.y1 = y1;
        this.cb = cb;
        this.cr = cr;
        this.op = op;
    }

    
    public void conversion(){
        Scanner input = new Scanner(System.in);
        
        if (getOp()==1) {
            System.out.println("*****************************");
            System.out.println("******** YIQ a rva **********");
            System.out.print("Ingrese el valor de Y: ");
            y = input.nextFloat();
            System.out.print("Ingrese el valor de I: ");
            i = input.nextFloat();
            System.out.print("Ingrese el valor de Q: ");
            q = input.nextFloat();
            convertir_yiq_a_rva();
            System.out.println("********************************************");
            System.out.println("el valor Y: "+y+" "+" I: "+i+" "+" Q; "+q);
            System.out.println("es en r: "+r+" "+" v: "+v+" "+" a; "+a);
        }else if (getOp()==2){
            System.out.println("*****************************");
            System.out.println("******** YIQ a YCbCr ********");
            System.out.print("Ingrese el valor de Y: ");
            y = input.nextFloat();
            System.out.print("Ingrese el valor de I: ");
            i = input.nextFloat();
            System.out.print("Ingrese el valor de Q: ");
            q = input.nextFloat();
            convertir_yiq_a_ycbcr();
            System.out.println("********************************************");
            System.out.println("el valor Y: "+y+" "+" I: "+i+" "+" Q; "+q);
            System.out.println("es en Y: "+y1+" "+" Cb: "+cb+" "+" Cr; "+cr);
        }else if (getOp()==3){
            System.out.println("*****************************");
            System.out.println("******** rva a YIQ ********");
            System.out.print("Ingrese el valor de r: ");
            r = input.nextFloat();
            System.out.print("Ingrese el valor de v: ");
            v = input.nextFloat();
            System.out.print("Ingrese el valor de a: ");
            a = input.nextFloat();
            convertir_rva_a_yiq();
            System.out.println("********************************************");
            System.out.println("el valor r: "+r+" "+" v: "+v+" "+" a; "+a);
            System.out.println("es en Y: "+y+" "+" I: "+i+" "+" Q; "+q);
        }else if (getOp()==4){
            System.out.println("*****************************");
            System.out.println("******** rva a YCbCr ********");
            System.out.print("Ingrese el valor de r: ");
            r = input.nextFloat();
            System.out.print("Ingrese el valor de v: ");
            v = input.nextFloat();
            System.out.print("Ingrese el valor de a: ");
            a = input.nextFloat();
            convertir_rva_a_ycbcr();
            System.out.println("********************************************");
            System.out.println("el valor r: "+r+" "+" v: "+v+" "+" a; "+a);
            System.out.println("es en Y: "+y1+" "+" Cb: "+cb+" "+" Cr; "+cr);
        }else if (getOp()==5){
            System.out.println("*****************************");
            System.out.println("******** YCbCr a rva ********");
            System.out.print("Ingrese el valor de Y: ");
            y1 = input.nextFloat();
            System.out.print("Ingrese el valor de Cb: ");
            cb = input.nextFloat();
            System.out.print("Ingrese el valor de Cr: ");
            cr = input.nextFloat();
            convertir_ycbcr_a_rva();
            System.out.println("********************************************");
            System.out.println("el valor Y: "+y1+" "+" Cb: "+cb+" "+" Cr; "+cr);
            System.out.println("es en r: "+r+" "+" v: "+v+" "+" a; "+a);
        }else if (getOp()==6){
            System.out.println("*****************************");
            System.out.println("******** YCbCr a YIQ ********");
            System.out.print("Ingrese el valor de Y: ");
            y1 = input.nextFloat();
            System.out.print("Ingrese el valor de Cb: ");
            cb = input.nextFloat();
            System.out.print("Ingrese el valor de Cr: ");
            cr = input.nextFloat();
            convertir_ycbcr_a_yiq();
            System.out.println("********************************************");
            System.out.println("el valor Y: "+y1+" "+" Cb: "+cb+" "+" Cr; "+cr);
            System.out.println("es en Y: "+y+" "+" I: "+i+" "+" Q; "+q);
        }else if (getOp()==7){
            System.out.println("Cerrando aplicación: SALIR");
            System.exit(0);
        }else {
            System.out.print("Opción no válida, por favor intente de nuevo!!...  Saliendo");
            System.exit(0);
        }
        
    }
    
    public void convertir_yiq_a_rva(){
        r = (float) (y+0.955*i+0.618*q);
        v = (float) (y-0.271*i-0.645*q);
        a = (float) (y-1.11*i+1.7*q);
    }
    
    public void convertir_yiq_a_ycbcr(){
        convertir_yiq_a_rva();
        convertir_rva_a_ycbcr();
    }
   
    public void convertir_rva_a_yiq(){
        y = (float) (0.299*r+0.587*v+0.114*a);
        i = (float) (0.596*r-0.275*v-0.321*a);
        q = (float) (0.212*r-0.528*v+0.311*a);
    }
    
    public void convertir_rva_a_ycbcr(){
        y1 = (float) (0.299*r+0.587*v+0.114*a);
        cb = (float) (0.1687*r+0.3313*v-0.5*a);
        cr = (float) (0.5*r-0.418*v+0.0813*a);
    }
    
    public void convertir_ycbcr_a_rva(){
        r = (float) (y1+1.402*cr);
        v = (float) (y1+0.344*cb-0.714*cr);
        a = (float) (y1+1.772*cb);
    }
    
    public void convertir_ycbcr_a_yiq(){
        convertir_ycbcr_a_rva();
        convertir_rva_a_yiq();
    }
        
    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * @return the i
     */
    public float getI() {
        return i;
    }

    /**
     * @param i the i to set
     */
    public void setI(float i) {
        this.i = i;
    }

    /**
     * @return the q
     */
    public float getQ() {
        return q;
    }

    /**
     * @param q the q to set
     */
    public void setQ(float q) {
        this.q = q;
    }

    /**
     * @return the r
     */
    public float getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(float r) {
        this.r = r;
    }

    /**
     * @return the v
     */
    public float getV() {
        return v;
    }

    /**
     * @param v the v to set
     */
    public void setV(float v) {
        this.v = v;
    }

    /**
     * @return the a
     */
    public float getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(float a) {
        this.a = a;
    }

    /**
     * @return the y1
     */
    public float getY1() {
        return y1;
    }

    /**
     * @param y1 the y1 to set
     */
    public void setY1(float y1) {
        this.y1 = y1;
    }

    /**
     * @return the cb
     */
    public float getCb() {
        return cb;
    }

    /**
     * @param cb the cb to set
     */
    public void setCb(float cb) {
        this.cb = cb;
    }

    /**
     * @return the cr
     */
    public float getCr() {
        return cr;
    }

    /**
     * @param cr the cr to set
     */
    public void setCr(float cr) {
        this.cr = cr;
    }

    /**
     * @return the op
     */
    public int getOp() {
        return op;
    }

    /**
     * @param op the op to set
     */
    public void setOp(int op) {
        this.op = op;
    }
    
    
}
