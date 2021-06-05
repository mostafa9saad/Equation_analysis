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
public class ExpressionBuilder {

    private String function;
    private String x;

    public ExpressionBuilder() {
    }
    public ExpressionBuilder(String x) {
        this.x=x;
    }
   

    public ExpressionBuilder(String function, String x) {
        this.function = function;
        this.x = x;
    }

    public String getFunction() {
        return function;
    }

    public String getX() {
        return x;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String evaluate() throws ScriptException {
        String s = new String();
        String t = new String();
        String pow = new String();
        String p = new String();
        char v;
        int d;
        int k = 0;
        int z=0;

        for (int i = 0; i < function.length(); i++) {
            
            if (function.charAt(i) == 'X') {

                for (int j = 0; j < x.length(); j++) {
                    s = s + x.charAt(j);
                }

            } 
               
               else if(function.charAt(i) == 'c'){
                   s=s+"Math.cos";
                   i=i+2;
                   
                           
               }
             else if(function.charAt(i) == 's'){
                   s=s+"Math.sin";
                   i=i+2;
                   
                           
               }
             else if(function.charAt(i) == 'e'){
                   s=s+"Math.exp";
                   i=i+2;
                   
                           
               }
              
            else  {
                    s = s + function.charAt(i);

                }
            
        }
        d=s.length();
        
        for(int j=0;j<d;j++){
            
            
             if(s.charAt(j) == '^'){
                   k=j;
                    v=s.charAt(j+1);
                   int l;
                   for(int c=k;c>=z;c--){
                       if(s.charAt(c)=='-'||s.charAt(c) =='/'||s.charAt(c)=='*'||s.charAt(c) =='+'){
                          if(s.charAt(c-1) !='/'&&s.charAt(c-1)!='*'&&s.charAt(c-1) !='+'&&s.charAt(c-1)!='-'){
                           l=c;
                           z=s.length();
                           for(int g=l+1;g<k;g++){
                               pow=pow+s.charAt(g);
                               
                               
                           }
                          for(int i=l+1;i<k+2;i++){
                              p=p+s.charAt(i);
                          }
                       
                         
                        
                       }
                          else if(s.charAt(c-1)=='-'||s.charAt(c-1) =='/'||s.charAt(c-1)=='*'||s.charAt(c-1) =='+'){
                               l=c;
                           z=s.length();
                           for(int g=l;g<k;g++){
                               pow=pow+s.charAt(g);
                              
                               
                           }
                          for(int i=l;i<k+2;i++){
                              p=p+s.charAt(i);
                          }
                              
                          }
                       
                   }
                   }
                  
                          t=t+"Math.pow(";
                         t=t+pow;
                         t=t+",";
                         t=t+v;
                         t=t+")";
                       s= s.replace(p,t);
                        t="";
                        p="";
                       pow="";
                       z=0;
                       d=s.length();
                       
                       
                                     
                  
                   
                   
                           
               } 
           

                
            
              
        }
       
      
     
        return  s;

    }

}
