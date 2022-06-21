/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.Cin.ControleEntidades;

import br.com.Cin.ControleEntidades.exceptions.NonexistentEntityException;
import br.com.Cin.Entidades.ReclamacaoFood;
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
public class ReclamacaoFoodJpaController implements Serializable {

    public ReclamacaoFoodJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ReclamacaoFood reclamacaoFood) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(reclamacaoFood);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ReclamacaoFood reclamacaoFood) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            reclamacaoFood = em.merge(reclamacaoFood);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = reclamacaoFood.getId();
                if (findReclamacaoFood(id) == null) {
                    throw new NonexistentEntityException("The reclamacaoFood with id " + id + " no longer exists.");
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
            ReclamacaoFood reclamacaoFood;
            try {
                reclamacaoFood = em.getReference(ReclamacaoFood.class, id);
                reclamacaoFood.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reclamacaoFood with id " + id + " no longer exists.", enfe);
            }
            em.remove(reclamacaoFood);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ReclamacaoFood> findReclamacaoFoodEntities() {
        return findReclamacaoFoodEntities(true, -1, -1);
    }

    public List<ReclamacaoFood> findReclamacaoFoodEntities(int maxResults, int firstResult) {
        return findReclamacaoFoodEntities(false, maxResults, firstResult);
    }

    private List<ReclamacaoFood> findReclamacaoFoodEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ReclamacaoFood.class));
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

    public ReclamacaoFood findReclamacaoFood(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ReclamacaoFood.class, id);
        } finally {
            em.close();
        }
    }

    public int getReclamacaoFoodCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ReclamacaoFood> rt = cq.from(ReclamacaoFood.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
