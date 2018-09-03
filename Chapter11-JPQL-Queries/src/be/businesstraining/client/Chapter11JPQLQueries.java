/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.businesstraining.client;

import be.businesstraining.entities.Compte;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Chapter11JPQLQueries {

    public static void main(String[] args) {

         //example_1_select_wrong_class();
       //example_2_select_all_objects();
        // example_3_select_single_object();
       //  example_4_select_single_data();
        // example_5_select_aggregate();
        // example_6_update();
       //  example_7_delete();
       // example_8_Criteria_list_of_objects();
        // example_9_Criteria_single_object();
        // example_10_Criteria_aggregate();
         example_11_StoredProcedure();
    }

    private static void example_1_select_wrong_class() {
        try {
            EntityManager em = getEntityManager();
            Query query = em.createQuery("SELECT c FROM Compte c");
            BrowseTheResult(query.getResultList());
        } catch (Exception ex) {
            System.out.println("Exception rencontrée : " + ex);
        }
    }

    private static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter11-JPQL-QueriesPU");
        return emf.createEntityManager();
    }

    private static void BrowseTheResult(List resultList) {
        for (Object o : resultList) {
            System.out.println(o);
        }
    }

    private static void example_2_select_all_objects() {
        try {
            EntityManager em = getEntityManager();
         
            Query query = em.createQuery("FROM Compte AS c");
            
            BrowseTheResult(query.getResultList());
        } catch (Exception ex) {
            System.out.println("Exception rencontrée : " + ex);
        }
    }

    private static void example_3_select_single_object() {
        try {
            EntityManager em = getEntityManager();
            Query query = em.createQuery("Select c FROM Compte c WHERE c.numero = :num");
            query.setParameter("num", "A100");

            System.out.println("A100 ===> " + query.getSingleResult());
        } catch (Exception ex) {
            System.out.println("Exception rencontrée : " + ex);
        }
    }

    private static void example_4_select_single_data() {
        try {
            EntityManager em = getEntityManager();
            Query query = em.createQuery("SELECT tt.proprietaire FROM Compte tt");
            BrowseTheResult(query.getResultList());
        } catch (Exception ex) {
            System.out.println("Exception rencontrée : " + ex);
        }
    }

    private static void example_5_select_aggregate() {
        try {
            EntityManager em = getEntityManager();
            Query query = em.createQuery("SELECT COUNT(c) FROM Compte c");
            System.out.println("Nombre de Comptes ===> " + query.getSingleResult());
            
            query = em.createQuery("SELECT MAX(c.solde) FROM Compte c");
            System.out.println("MAX des Soldes ===> " + query.getSingleResult());
        } catch (Exception ex) {
            System.out.println("Exception rencontrée : " + ex);
        }
    }

    private static void example_6_update() {
       
        try {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("UPDATE Compte c SET c.solde = '500' WHERE c.numero = 'A200'");
            int rowCount = query.executeUpdate();
            System.out.println("Nombre de lignes touchés : " + rowCount);
            em.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println("Exception rencontrée : " + ex);
        }
    }

    private static void example_7_delete() {
        try {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("DELETE FROM Compte c WHERE c.numero = 'ZZZZ'");
            int rowCount = query.executeUpdate();
            System.out.println("Nombre de lignes touchées : " + rowCount);
            em.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println("Exception rencontrée : " + ex);
        }
    }

    private static void example_11_StoredProcedure() {
// This is the code of the stored procedure
// CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_consulterSolde`(IN num VARCHAR(20))
//BEGIN
//  SELECT  c.Solde 
//  FROM COMPTES c
//  WHERE c.Numero = num;
//END
        try {
            EntityManager em = getEntityManager();
            StoredProcedureQuery spq = em.createStoredProcedureQuery("sp_consulterSolde");
            spq.registerStoredProcedureParameter("num", String.class, ParameterMode.IN);
            spq.setParameter("num", "A100");
            Object[] resultat = (Object[]) spq.getSingleResult();
            System.out.println("=====> Resultat : " + ((BigDecimal) resultat[0]));
        } catch (Exception ex) {
            System.out.println("Exception rencontrée : " + ex);
        }
    }

    private static void example_8_Criteria_list_of_objects() {
        try {
            EntityManager em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            // Query for a List of objects.
            CriteriaQuery cq = cb.createQuery();
            Root e = cq.from(Compte.class);
            cq.where(cb.greaterThan(e.get("solde"), 500));
            Query query = em.createQuery(cq);
            List<Compte> result = query.getResultList();
            BrowseTheResult(result);
        } catch (Exception ex) {
            System.out.println("Exception rencontrée : " + ex);
        }

    }

    private static void example_9_Criteria_single_object() {
        try {
            EntityManager em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            // Query for a single object.
            CriteriaQuery cq = cb.createQuery();
            Root e = cq.from(Compte.class);
            cq.where(cb.equal(e.get("numero"), cb.parameter(String.class, "id")));
            Query query = em.createQuery(cq);
            query.setParameter("id", "A200");
            Compte result = (Compte) query.getSingleResult();

            System.out.println(" ===> Compte trouvé : " + result);
        } catch (Exception ex) {
            System.out.println("Exception rencontrée : " + ex);
        }
    }

    private static void example_10_Criteria_aggregate() {
        try {
            EntityManager em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
           // Count the total comptes
            CriteriaQuery cq = cb.createQuery();
            Root compte = cq.from(Compte.class);
            cq.select(cb.count(compte));
            Query query = em.createQuery(cq);
            Object result = query.getResultList();
            System.out.println(" ===> Nombre total de comptes : " + result);
         // Maximum Solde
            cq.select(cb.max(compte.get("solde")));
            query = em.createQuery(cq);
            result = query.getResultList();
            System.out.println(" ===> Solde le plus élevé : " + result);
        } catch (Exception ex) {
            System.out.println("Exception rencontrée : " + ex);
        }
    }

}
