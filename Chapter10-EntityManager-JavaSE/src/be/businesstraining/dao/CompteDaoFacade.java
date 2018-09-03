
package be.businesstraining.dao;

import be.businesstraining.dao.exceptions.NonexistentEntityException;
import be.businesstraining.dao.exceptions.PreexistingEntityException;
import be.businesstraining.entities.Compte;
import java.util.List;

/**
 *
 * @author M. Romdhani
 */
public interface CompteDaoFacade {

    void create(Compte compte) throws PreexistingEntityException, Exception;

    void destroy(String id) throws NonexistentEntityException;

    void edit(Compte compte) throws NonexistentEntityException, Exception;

    Compte findCompte(String id);

    List<Compte> findCompteEntities();

    List<Compte> findCompteEntities(int maxResults, int firstResult);

    int getCompteCount();
    
}
