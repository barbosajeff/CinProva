/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.Cin.ControleEntidades;

import br.com.Cin.ControleEntidades.exceptions.NonexistentEntityException;
import br.com.Cin.Entidades.ReclamacaoAnimal;
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
public class ReclamacaoAnimalJpaController implements Serializable {

    public ReclamacaoAnimalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ReclamacaoAnimal reclamacaoAnimal) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(reclamacaoAnimal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ReclamacaoAnimal reclamacaoAnimal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            reclamacaoAnimal = em.merge(reclamacaoAnimal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = reclamacaoAnimal.getId();
                if (findReclamacaoAnimal(id) == null) {
                    throw new NonexistentEntityException("The reclamacaoAnimal with id " + id + " no longer exists.");
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
            ReclamacaoAnimal reclamacaoAnimal;
            try {
                reclamacaoAnimal = em.getReference(ReclamacaoAnimal.class, id);
                reclamacaoAnimal.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reclamacaoAnimal with id " + id + " no longer exists.", enfe);
            }
            em.remove(reclamacaoAnimal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ReclamacaoAnimal> findReclamacaoAnimalEntities() {
        return findReclamacaoAnimalEntities(true, -1, -1);
    }

    public List<ReclamacaoAnimal> findReclamacaoAnimalEntities(int maxResults, int firstResult) {
        return findReclamacaoAnimalEntities(false, maxResults, firstResult);
    }

    private List<ReclamacaoAnimal> findReclamacaoAnimalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ReclamacaoAnimal.class));
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

    public ReclamacaoAnimal findReclamacaoAnimal(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ReclamacaoAnimal.class, id);
        } finally {
            em.close();
        }
    }

    public int getReclamacaoAnimalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ReclamacaoAnimal> rt = cq.from(ReclamacaoAnimal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
