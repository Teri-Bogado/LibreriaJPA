/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpalibreria.pers;

import java.util.List;
import jpalibreria.ents.Libro;

/**
 *
 * @author "J"
 */
public class LibroDAO extends DAO<Libro> {

    public void guardarLibro(Libro l) throws Exception {
        try {
            guardar(l);
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

    public Libro buscarLibro(Long ISBN) throws Exception {

        try {
            conectar();
            Libro l = (Libro) EM.createQuery("SELECT l FROM Libro l WHERE l.isbn LIKE :isbn")
                    .setParameter("isbn", ISBN)
                    .getSingleResult();
            desconectar();
            return l;
        } catch (Exception e) {
            desconectar();
            throw e;
        }

    }

    public Libro buscarLibro(String titulo) throws Exception {
        try {
            conectar();
            Libro l = (Libro) EM.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE CONCAT('%',:titulo,'%')")
                    .setParameter("titulo", titulo)
                    .getSingleResult();
            desconectar();
            return l;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
    
    public List<Libro> listarLibros() throws Exception {
        try {
            conectar();
            List<Libro> libros = EM.createQuery("SELECT l from Libro l")
                    .getResultList();
            desconectar();
            return libros;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

    public void eliminarLibro(Long ISBN) throws Exception{
        try {
            Libro l = buscarLibro(ISBN);
            eliminar(l);
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
    
    public void eliminarLibro(String titulo) throws Exception{
        try {
            Libro l = buscarLibro(titulo);
            eliminar(l);
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
    
    public List<Libro> buscarPorAutor(String str){
        
        try {
            conectar();
            List<Libro> libros = EM.createQuery("SELECT l from Libro l WHERE l.autor.nombre LIKE CONCAT('%',:nombre,'%')")
                    .setParameter("nombre", str)
                    .getResultList();
            desconectar();
            return libros;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
        
    }
    
    public List<Libro> buscarPorEditorial(String str){
        
        try {
            conectar();
            List<Libro> libros = EM.createQuery("SELECT l from Libro l WHERE l.editorial.nombre LIKE CONCAT('%',:nombre,'%')")
                    .setParameter("nombre", str)
                    .getResultList();
            desconectar();
            return libros;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
        
    }
}
