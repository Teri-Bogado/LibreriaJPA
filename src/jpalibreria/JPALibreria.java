/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpalibreria;

import java.util.List;
import java.util.Scanner;
import jpalibreria.ents.Editorial;
import jpalibreria.pers.EditorialDAO;

/**
 *
 * @author "J"
 */
public class JPALibreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        EditorialDAO edao = new EditorialDAO();
        
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        
        System.out.println("Ingresa un nombre");
        
        String str = input.next();
        
        Editorial edx = edao.buscarEditorial(str);
        
        if(edx != null) {
            System.out.println("Existe: " + edx.getNombre());
        } else {
            System.out.println("NO EXISTE.");
        }
        
        
    }
    
}
