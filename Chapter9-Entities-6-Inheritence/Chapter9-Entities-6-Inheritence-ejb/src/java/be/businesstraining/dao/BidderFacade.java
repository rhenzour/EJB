package be.businesstraining.dao;

import be.businesstraining.entities.Bidder;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class BidderFacade extends AbstractFacade<Bidder> {
    @PersistenceContext(unitName = "Chapter9-Entities-6-Inheritence-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BidderFacade() {
        super(Bidder.class);
    }
    
}
