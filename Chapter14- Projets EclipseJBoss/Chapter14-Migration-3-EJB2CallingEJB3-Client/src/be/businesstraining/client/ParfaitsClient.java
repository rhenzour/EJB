package be.businesstraining.client;

import javax.naming.Context;
import javax.naming.InitialContext;

import be.businesstraining.ejb3.EntiersParfaits;
import be.businesstraining.ejb3.EntiersParfaitsHome;

public class ParfaitsClient {

	private static final String JNDI_HOME = "Chapter14-Migration-3-EJB2CallingEJB3/Chapter14-Migration-3-EJB2CallingEJB3-EJB2/EntiersParfaits!be.businesstraining.ejb3.EntiersParfaitsHome";

	public static void main(String[] args) {
		try {

			// Se connecter sur le contexte d'annuaire JNDI de JBoss
			// Les param�tres de l'annuaire sont sp�cifi�s dans le
			// fichier jndi.properties qui soit �tre mis dans le BuildPath du
			// projet
			
			Context ctx = new InitialContext();

			// Faire un lookup sur la Home de l'interface Remote
			EntiersParfaitsHome home = (EntiersParfaitsHome) ctx
					.lookup(JNDI_HOME);

			// Ordonner � la Home de cr�er une instance du bean
			EntiersParfaits bean = (EntiersParfaits) home.create();

			// Play with your bean ...
			System.out
					.println("=====      LISTE DE TOUS LES NOMBRES PARFAITS INFERIEURS A 1000      ===== ");
			System.out
			.println("===== Un nombre est dit parfait s'il �gale la somme de ses diviseurs  ===== ");

			for (int i = 2; i < 1000; i++)
				if (bean.estParfait(i))
					System.out.println("     " + i + " est parfait");

			// Clean up !
			ctx.close();
			System.out
			.println("===== FIN DU PROGRAMME  ===== ");

		} catch (Exception ex) {
			System.out.println("Exception rencontr�e : " + ex);
		}

	}

}
