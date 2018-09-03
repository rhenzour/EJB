/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.businesstraining.jaxws;

import be.businesstraining.dao.CompteFacadeLocal;
import be.businesstraining.entities.Compte;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author M. Romdhani
 */
@WebService(serviceName = "ComptesServiceWS")
@Stateless()
public class ComptesServiceWS {
    @EJB
    private CompteFacadeLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "compte") Compte compte) {
        ejbRef.create(compte);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "compte") Compte compte) {
        ejbRef.edit(compte);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "compte") Compte compte) {
        ejbRef.remove(compte);
    }

    @WebMethod(operationName = "find")
    public Compte find(@WebParam(name = "id") String id) {
        return ejbRef.find((String)id);
    }

    @WebMethod(operationName = "findAll")
    public List<Compte> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Compte> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    
}
