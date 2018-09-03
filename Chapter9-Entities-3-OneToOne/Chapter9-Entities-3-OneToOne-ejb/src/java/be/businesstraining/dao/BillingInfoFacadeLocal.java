/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.businesstraining.dao;

import be.businesstraining.entities.BillingInfo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author M. Romdhani
 */
@Local
public interface BillingInfoFacadeLocal {

    void create(BillingInfo billingInfo);

    void edit(BillingInfo billingInfo);

    void remove(BillingInfo billingInfo);

    BillingInfo find(Object id);

    List<BillingInfo> findAll();

    List<BillingInfo> findRange(int[] range);

    int count();
    
}
