package be.busiensstraining.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import be.businesstraining.ejb3.EntiersPremiersBean;
import be.businesstraining.ejb3.EntiersPremiersBeanRemote;

public class NombresPremiersClient {

	private static final String JNDI_HOME = "Chapter14-Migration-2-EJB3CallingEJB2/Chapter14-Migration-2-EJB3CallingEJB2-EJB3/EntiersPremiersBean!be.businesstraining.ejb3.EntiersPremiersBeanRemote";

	public static void main(String[] args) {
		try {

			// Se connecter sur le contexte d'annuaire JNDI de JBoss
			// Les paramètres de l'annuaire sont spécifiés dans le
			// fichier jndi.properties qui soit être mis dans le BuildPath du
			// projet
			// Attention : L'accès à l'annuaire JNDI exige une athentification
			// pour un utilisateur du type "Application User"
			// Voir le ReadMe.txt qui explique la procédure de création
			// d'utilsateur
			// sous JBoss AS 7.1.1
			Context ctx = new InitialContext();

			// Faire un lookup
			EntiersPremiersBeanRemote bean = (EntiersPremiersBeanRemote) ctx
					.lookup(JNDI_HOME);

			// Play with your bean ...
			System.out
					.println("===== LISTE DE TOUS LES NOMBRES PREMIERS INFERIEURS A 1000  ===== ");

			for (int i = 2; i < 100; i++)
				if (bean.estPremier(i))
					System.out.println("     " + i + " est premier");

			
			// Clean up !
			ctx.close();
			System.out
			.println("===== FIN DU PROGRAMME  ===== ");

		} catch (Exception ex) {
			System.out.println("Exception rencontrée : " + ex);
		}

	}

}
