/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.businesstraining.dao;

import be.businesstraining.entities.BillingInfo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author M. Romdhani
 */
@Stateless
public class BillingInfoFacade extends AbstractFacade<BillingInfo> implements BillingInfoFacadeLocal {
    @PersistenceContext(unitName = "Chapter9-_Entities-OneToOne-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BillingInfoFacade() {
        super(BillingInfo.class);
    }
    
}
