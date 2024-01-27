/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpalibreria.pers;

import java.util.List;
import jpalibreria.ents.Autor;

/**
 *
 * @author "J"
 */
public class AutorDAO extends DAO<Autor> {
    
    
    public void guardarAutor(Autor autor) {
        guardar(autor);
    }
    
    public void eliminarAutor(String str) throws Exception {
        try {
        
        Autor autor = buscarAutor(str);
            eliminar(autor);
            
        }
        catch (Exception e) {
            desconectar();
            throw e;
        }
        
    }
   
    public void eliminarAutor(Long id) throws Exception {
        try {
        
        Autor autor = buscarAutor(id);
            eliminar(autor);
            
        }
        catch (Exception e) {
            desconectar();
            throw e;
        }
        
    }
    
    public void editarAutor(Autor a){
        try {
            editar(a);
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
    
    
    /**
     * Lista autores.
     * @return Una lista de todos los autores.
     * @throws Exception 
     */
    public List<Autor> listarAutores() throws Exception{
        
        try {
        conectar();
        List<Autor> autores = EM.createQuery("SELECT a FROM Autor a")
                .getResultList();
        desconectar();
        return autores;
        }
        catch (Exception e) {
            desconectar();
            throw e;
        }
        
    }
    
    /**
     * Busca un autor por id
     * @param id El id por el cual buscar al autor.
     * @return El autor buscado por id.
     * @throws Exception 
     */
    public Autor buscarAutor(Long id) throws Exception{
        
        try {
        conectar();
        Autor autor = (Autor) EM.createQuery("SELECT a FROM Autor a WHERE a.id LIKE :id")
                .setParameter("id", id)
                .getSingleResult();
        desconectar();
        return autor;
        }
        catch (Exception e) {
            desconectar();
            throw e;
        }
        
        
    }
    
    /**
     * Busca un autor por nombre.
     * @param nombre El nombre por el cual buscar al autor.
     * @return El autor buscado por nombre.
     * @throws Exception 
     */
    public Autor buscarAutor(String nombre) throws Exception{
        try {
        conectar();
        Autor autor = (Autor) EM.createQuery("SELECT a from Autor a WHERE a.nombre LIKE CONCAT('%',:nombre,'%')")
                .setParameter("nombre", nombre)
                .getSingleResult();
        desconectar();
        return autor;
        }
        catch(Exception e) {
            desconectar();
            throw e;
        }
        
        
    }
}
