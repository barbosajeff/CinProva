/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.Cin.ControleEntidades;

import br.com.Cin.ControleEntidades.exceptions.NonexistentEntityException;
import br.com.Cin.Entidades.Reclamacao;
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
public class ReclamacaoJpaController implements Serializable {

    public ReclamacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reclamacao reclamacao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(reclamacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reclamacao reclamacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            reclamacao = em.merge(reclamacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = reclamacao.getId();
                if (findReclamacao(id) == null) {
                    throw new NonexistentEntityException("The reclamacao with id " + id + " no longer exists.");
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
            Reclamacao reclamacao;
            try {
                reclamacao = em.getReference(Reclamacao.class, id);
                reclamacao.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reclamacao with id " + id + " no longer exists.", enfe);
            }
            em.remove(reclamacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reclamacao> findReclamacaoEntities() {
        return findReclamacaoEntities(true, -1, -1);
    }

    public List<Reclamacao> findReclamacaoEntities(int maxResults, int firstResult) {
        return findReclamacaoEntities(false, maxResults, firstResult);
    }

    private List<Reclamacao> findReclamacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reclamacao.class));
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

    public Reclamacao findReclamacao(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reclamacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getReclamacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reclamacao> rt = cq.from(Reclamacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
