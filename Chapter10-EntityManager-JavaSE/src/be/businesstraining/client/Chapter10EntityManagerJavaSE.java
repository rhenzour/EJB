package be.businesstraining.client;

import be.businesstraining.dao.CompteDao;
import be.businesstraining.dao.CompteDaoFacade;
import be.businesstraining.entities.Compte;
import java.math.BigDecimal;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Chapter10EntityManagerJavaSE {
    
    public static void main(String[] args) {

        //  test_FindAll();
        test_FindByNumero_Using_JPQL();
      

    }

    private static void test_FindAll() {
        CompteDaoFacade dao = new CompteDao();
           
//        try {
//            dao.create(new Compte("A600","Gregory", new BigDecimal(500.5)));
//        } catch (Exception ex) {
//            Logger.getLogger(Chapter10EntityManagerJavaSE.class.getName()).log(Level.SEVERE, null, ex);
//        }
//      
        
        for (Compte compte : dao.findCompteEntities()) {
            System.out.println("====> " + compte);
        }
    }

    private static void test_FindByNumero_Using_JPQL() {
       CompteDaoFacade dao = new CompteDao();
        System.out.println(dao.findCompte("A100"));
        
    }

}
