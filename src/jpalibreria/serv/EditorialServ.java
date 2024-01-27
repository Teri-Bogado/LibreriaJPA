/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpalibreria.serv;

import java.util.List;
import java.util.Scanner;
import jpalibreria.ents.Editorial;
import jpalibreria.pers.EditorialDAO;

/**
 *
 * @author "J"
 */
public class EditorialServ {
    
    private EditorialDAO edao = new EditorialDAO();
    private InputValidator validator = new InputValidator();
    private Scanner input = new Scanner(System.in).useDelimiter("\n");
    
    public void crearEditorial() throws Exception {
        
        
        try {
        Editorial ed = new Editorial();
        
        System.out.println("Ingrese el nombre de la Editorial:");
        String nombre = input.next();
        nombre = validator.validateInput(nombre);
        
        
        
        if (edao.buscarEditorial(nombre)!= null) {
            
        }
        }
        catch (Exception e) {
            throw e;
        }
        
    }
    
    
}
