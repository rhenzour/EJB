package be.businesstraining.service;


import be.businesstraining.interceptor.Audit;
import be.businesstraining.interceptor.Logging;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;


@Stateless
public class ItemServiceBean {

    @Inject
    private EntityManager em;

    @Audit
    @Logging
    public void create(Item item) {
        em.persist(item);
    }

    @Audit
    @Logging
    public List<Item> getList() {
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }

}
