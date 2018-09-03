/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.businesstraining.facade;

import be.businesstraining.entities.Compte;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "container_managed_em")
public class CompteFacade_managed_em extends AbstractFacade<Compte> implements CompteFacadeLocal {
    @PersistenceContext(unitName = "Chapter10-EntityManager-2-JavaEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompteFacade_managed_em() {
        super(Compte.class);
    }
    
}
