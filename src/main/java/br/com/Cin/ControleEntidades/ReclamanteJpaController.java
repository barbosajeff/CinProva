/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.Cin.ControleEntidades;

import br.com.Cin.ControleEntidades.exceptions.NonexistentEntityException;
import br.com.Cin.Entidades.Reclamante;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Jefferson
 */
public class ReclamanteJpaController implements Serializable {

    public ReclamanteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reclamante reclamante) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(reclamante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reclamante reclamante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            reclamante = em.merge(reclamante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = reclamante.getId();
                if (findReclamante(id) == null) {
                    throw new NonexistentEntityException("The reclamante with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reclamante reclamante;
            try {
                reclamante = em.getReference(Reclamante.class, id);
                reclamante.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reclamante with id " + id + " no longer exists.", enfe);
            }
            em.remove(reclamante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reclamante> findReclamanteEntities() {
        return findReclamanteEntities(true, -1, -1);
    }

    public List<Reclamante> findReclamanteEntities(int maxResults, int firstResult) {
        return findReclamanteEntities(false, maxResults, firstResult);
    }

    private List<Reclamante> findReclamanteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reclamante.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Reclamante findReclamante(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reclamante.class, id);
        } finally {
            em.close();
        }
    }

    public int getReclamanteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reclamante> rt = cq.from(Reclamante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
