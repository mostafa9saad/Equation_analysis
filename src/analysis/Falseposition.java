/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysis;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author user
 */
public class Falseposition {
    ExpressionBuilder e=new ExpressionBuilder();
    private double xl;
    private double xr;
    private double xu;
    static int itration = 0;

    public Falseposition() {
    }


    public double getXl() {
        return xl;
    }

    public void setXl(double xl) {
        this.xl = xl;
    }

    public double getXr() {
        return xr;
    }

    public void setXr(double xr) {
        this.xr = xr;
    }

    public double getXu() {
        return xu;
    }

    public void setXu(double xu) {
        this.xu = xu;
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
     public double fp(String f,String a,String b) throws ScriptException{
         
          xu = Double.parseDouble(b);
          xl = Double.parseDouble(a);
         
          if (func(f,a)*func(f,b) > 0) {
            System.out.println("You have not assumed"
                    + " right a and b");
            return 0;
        }String c;
          while(Math.abs(xu-xl) >=0.00001&&itration<50){
              
              xr=(xl*func(f, b)-xu*func(f, a))/(func(f, b)-func(f, a));
              c=Double.toString(xr);
              if (func(f,c) == 0.0) {
                
                return xr;

            } 
              else if(func(f, c)*func(f, a)<0){
                  xu=xr;
                  
                  
                  
              }else{
                  xl=xr;
              }
              
              
              itration++;
              
          }
      
         
         
         
         return xr;
         
     }
    
}
