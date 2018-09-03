/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.businesstraining.facade;

import be.businesstraining.entities.Compte;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Stateless(name = "application_em")
public class CompteFacade_application_em implements CompteFacadeLocal {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @PostConstruct
    public void initialize() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void create(Compte compte) {
        entityManager.joinTransaction();
        entityManager.persist(compte);

    }

    @Override
    public void edit(Compte compte) {
       entityManager.joinTransaction();
        entityManager.merge(compte); }

    @Override
    public void remove(Compte compte) {
        entityManager.joinTransaction();
       entityManager.remove(entityManager.merge(compte));   
    
    }

    @Override
    public Compte find(Object id) {
          entityManager.joinTransaction();
         entityManager.joinTransaction();
        return entityManager.find(Compte.class, id);
    }

    @Override
    public List<Compte> findAll() {
          entityManager.joinTransaction();
      javax.persistence.criteria.CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Compte.class));
        return entityManager.createQuery(cq).getResultList();    
    }

    @Override
    public List<Compte> findRange(int[] range) {
         entityManager.joinTransaction(); 
            javax.persistence.criteria.CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Compte.class));
        javax.persistence.Query q = entityManager.createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

   

    @PreDestroy
    public void cleanup() {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

}
