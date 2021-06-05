/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysis;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.*;
import jdk.nashorn.internal.ir.BreakNode;

public class bisection {
ExpressionBuilder e = new ExpressionBuilder();
    private static double xr;
    private static double a;
    private static double b;

    static int itration = 0;

    public double getXr() {
        return xr;
    }

    public void setXr(float xr) {
        this.xr = xr;
    }

    public double getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public double func(String f, String x) throws ScriptException {
        
        e.setX(x);;
        e.setFunction(f);
        String s = e.evaluate();
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        
         double value = Double.parseDouble(engine.eval(s).toString());
        

        return value;
    }

    public double bs(String f, String xu, String xl) throws ScriptException {
double temp,n;
        b = Double.parseDouble(xu);
        a = Double.parseDouble(xl);
        if (func(f,xl) * func(f,xu) > 0) {
            System.out.println("You have not assumed"
                    + " right a and b");
            return 0;
        }

        String c, l,z;
        while (Math.abs(b-a) >=0.00001 && itration <= 50) {
            // Find middle point 
            
            xr = (a + b) / 2;
          
           System.out.printf("The value of root is : %.6f\n",xr);
            c = Double.toString(xr);
            l = Double.toString(a);
            z = Double.toString(b);
            
            // Check if middle point is root
            temp=func(f, c);
            n=func(f, l);
            if (func(f,c) == 0.0) {
                
                return xr;

            } // Decide the side to repeat the steps 
           
            else if (temp*n < 0) {
                b = xr;
            } else {
                a = xr;
            }
            itration++;
        }
        //prints value of c upto 4 decimal places 
        System.out.printf("The value of root is : %.4f\n", xr);
        return xr;
    }

    // Driver program to test above function 
}
