/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpalibreria.pers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author "J"
 */
public class DAO<T> {
    
    protected EntityManagerFactory EMF = Persistence.createEntityManagerFactory("JPAPU");
    protected EntityManager EM = EMF.createEntityManager();
   
    
    protected void conectar() {
        
        if (!EM.isOpen()) {
            EM = EMF.createEntityManager();
        }
        
    }
    
    protected void desconectar() {
        
        if(EM.isOpen()) {
            EM.close();
        }
    }
    
    protected void guardar(T obj) {
        conectar();
        EM.getTransaction().begin();
        EM.persist(obj);
        EM.getTransaction().commit();
        desconectar();
    }
    
    protected void editar(T obj) {
        
        conectar();
        EM.getTransaction().begin();
        EM.merge(obj);
        EM.getTransaction().commit();
        desconectar();
        
    }
    
    protected void eliminar(T obj) {
        conectar();
        EM.getTransaction().begin();
        EM.remove(obj);
        EM.getTransaction().commit();
        desconectar();
    }
    
}
