package be.businesstraining.beans;

import be.businesstraining.entities.Voucher;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class VoucherFacade extends AbstractFacade<Voucher> {
    @PersistenceContext(unitName = "Chapter13-Packaging-4-security-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public VoucherFacade() {
        super(Voucher.class);
    }

}
