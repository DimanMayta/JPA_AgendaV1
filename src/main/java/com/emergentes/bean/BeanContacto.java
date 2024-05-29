package com.emergentes.bean;

import com.emergentes.Contacto;
import com.emergentes.jpa.ContactoJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diman
 */
public class BeanContacto {

    private EntityManagerFactory emf;
    private ContactoJpaController daoContacto;

    public BeanContacto() {
        emf = Persistence.createEntityManagerFactory("UPagenda");
        daoContacto = new ContactoJpaController(emf);
    }

    public List<Contacto> listarTodos() {
        return daoContacto.findContactoEntities();
    }

    public void insertar(Contacto c) {
        daoContacto.create(c);
    }

    public void editar(Contacto c) {
        try {
            daoContacto.edit(c);
        } catch (Exception ex) {
            Logger.getLogger(BeanContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(Integer id) {
        try {
            daoContacto.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(BeanContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Contacto buscar(Integer id) {
        Contacto c = new Contacto();
        c = daoContacto.findContacto(id);
        return c;
    }
}
