/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.Cin.ControleEntidades;

import br.com.Cin.ControleEntidades.exceptions.NonexistentEntityException;
import br.com.Cin.Entidades.VitimaFood;
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
public class VitimaFoodJpaController implements Serializable {

    public VitimaFoodJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VitimaFood vitimaFood) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(vitimaFood);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VitimaFood vitimaFood) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            vitimaFood = em.merge(vitimaFood);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = vitimaFood.getId();
                if (findVitimaFood(id) == null) {
                    throw new NonexistentEntityException("The vitimaFood with id " + id + " no longer exists.");
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
            VitimaFood vitimaFood;
            try {
                vitimaFood = em.getReference(VitimaFood.class, id);
                vitimaFood.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vitimaFood with id " + id + " no longer exists.", enfe);
            }
            em.remove(vitimaFood);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VitimaFood> findVitimaFoodEntities() {
        return findVitimaFoodEntities(true, -1, -1);
    }

    public List<VitimaFood> findVitimaFoodEntities(int maxResults, int firstResult) {
        return findVitimaFoodEntities(false, maxResults, firstResult);
    }

    private List<VitimaFood> findVitimaFoodEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VitimaFood.class));
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

    public VitimaFood findVitimaFood(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VitimaFood.class, id);
        } finally {
            em.close();
        }
    }

    public int getVitimaFoodCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VitimaFood> rt = cq.from(VitimaFood.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
