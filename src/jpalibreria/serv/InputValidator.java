/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpalibreria.serv;

import java.util.Scanner;

/**
 *
 * @author "J"
 */
public class InputValidator {
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    
    public String validateInput(String str) throws Exception {
        try {
        while(true) {
            
            if (str.equalsIgnoreCase("") || str == null || str.isEmpty()) {
                
                System.out.println("Entrada inválida. Intente de nuevo.");
                str = input.next();
                
            } else {
                break;
            }
            
        }
        return str;
        }
        catch (Exception e) {
            throw e;
        }
        
    }
    
    public String validateYorN(String str) throws Exception {
        
        try {
        while (true) {
            
            validateInput(str);
         
            if (str.equalsIgnoreCase("S") || str.equalsIgnoreCase("si")) {
                return "s";
            }
            
            else if (str.equalsIgnoreCase("N") || str.equalsIgnoreCase("no")) {
                return "n";
            }
            
            else {
                System.out.println("Opción inválida. Intente de nuevo (S/N)");
                str = input.next();
            }
        }
        } catch(Exception e) {
            throw e;
        }
        
    }
    
    public Boolean isNum (String str) {
        
        if (str == null) {
            return false;
        }
        try {
            
            Integer i = Integer.parseInt(str);
            
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
}
