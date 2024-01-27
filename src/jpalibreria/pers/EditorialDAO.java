/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpalibreria.pers;

import java.util.List;
import javax.persistence.NoResultException;
import jpalibreria.ents.Editorial;

/**
 *
 * @author "J"
 */
public class EditorialDAO extends DAO<Editorial> {

    public void guardarEditorial(Editorial ed) {
        guardar(ed);
    }

    public void eliminarEditorial(String n) throws Exception {
        try {
            Editorial ed = buscarEditorial(n);
            eliminar(ed);
        } catch (Exception e) {
            desconectar();
            throw e;
        }

    }

    public void eliminarEditorial(Long id) throws Exception {
        try {
            Editorial ed = buscarEditorial(id);
            eliminar(ed);
        } catch (Exception e) {
            desconectar();
            throw e;
        }

    }

    public void editarEditorial(Editorial ed) throws Exception {
        try {
            editar(ed);
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

    /**
     * Busca editorial por id
     *
     * @param id El id de la editorial a buscar.
     * @return Editorial con el id buscado.
     * @throws Exception
     */
    public Editorial buscarEditorial(Long id) throws Exception {

        try {
            conectar();
            Editorial ed = (Editorial) EM.createQuery("SELECT e FROM Editorial e WHERE e.id LIKE :id")
                    .setParameter("id", id)
                    .getSingleResult();
            desconectar();
            return ed;

        } catch (NoResultException NRE) {
            desconectar();
            return null;
        } catch (Exception e) {
            desconectar();
            throw e;
        }

    }

    /**
     * Busca editorial por nombre
     *
     * @param nombre El nombre de la editorial a buscar.
     * @return Editorial con el nombre buscado.
     * @throws Exception
     */
    public Editorial buscarEditorial(String nombre) throws Exception {
        try {
            conectar();
            System.out.println("SELECT e FROM Editorial e WHERE e.nombre LIKE CONCAT('%'," + nombre + ",'%')");
            Editorial ed = (Editorial) EM.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE CONCAT('%',:nombre,'%')")
                    .setParameter("nombre", nombre)
                    .getSingleResult();
            desconectar();
            return ed;
        } catch (NoResultException NRE) {
            desconectar();
            return null;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

    public List<Editorial> listarEditoriales() {
        try {
            conectar();
            List<Editorial> editoriales = EM.createQuery("SELECT ed FROM Editorial ed")
                    .getResultList();
            desconectar();
            return editoriales;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

}
