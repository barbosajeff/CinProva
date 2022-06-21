/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.Cin.ControleEntidades;

import br.com.Cin.ControleEntidades.exceptions.NonexistentEntityException;
import br.com.Cin.Entidades.ReclamacaoEspecial;
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
public class ReclamacaoEspecialJpaController implements Serializable {

    public ReclamacaoEspecialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ReclamacaoEspecial reclamacaoEspecial) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(reclamacaoEspecial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ReclamacaoEspecial reclamacaoEspecial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            reclamacaoEspecial = em.merge(reclamacaoEspecial);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = reclamacaoEspecial.getId();
                if (findReclamacaoEspecial(id) == null) {
                    throw new NonexistentEntityException("The reclamacaoEspecial with id " + id + " no longer exists.");
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
            ReclamacaoEspecial reclamacaoEspecial;
            try {
                reclamacaoEspecial = em.getReference(ReclamacaoEspecial.class, id);
                reclamacaoEspecial.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reclamacaoEspecial with id " + id + " no longer exists.", enfe);
            }
            em.remove(reclamacaoEspecial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ReclamacaoEspecial> findReclamacaoEspecialEntities() {
        return findReclamacaoEspecialEntities(true, -1, -1);
    }

    public List<ReclamacaoEspecial> findReclamacaoEspecialEntities(int maxResults, int firstResult) {
        return findReclamacaoEspecialEntities(false, maxResults, firstResult);
    }

    private List<ReclamacaoEspecial> findReclamacaoEspecialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ReclamacaoEspecial.class));
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

    public ReclamacaoEspecial findReclamacaoEspecial(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ReclamacaoEspecial.class, id);
        } finally {
            em.close();
        }
    }

    public int getReclamacaoEspecialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ReclamacaoEspecial> rt = cq.from(ReclamacaoEspecial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
