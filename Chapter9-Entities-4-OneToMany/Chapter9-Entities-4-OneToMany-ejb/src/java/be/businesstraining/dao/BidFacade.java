package be.businesstraining.dao;

import be.businesstraining.entities.Bid;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BidFacade extends AbstractFacade<Bid> {
    @PersistenceContext(unitName = "Chapter9-Entities-4-OneToMany-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BidFacade() {
        super(Bid.class);
    }
    
}
