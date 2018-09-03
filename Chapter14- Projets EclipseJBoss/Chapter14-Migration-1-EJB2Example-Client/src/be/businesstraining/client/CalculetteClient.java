package be.businesstraining.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import be.businesstraining.beans.Calculette;
import be.businesstraining.beans.CalculetteHome;

public class CalculetteClient {

	private static final String JNDI_HOME = "Chapter14-Migration-1-EJB2Example/Calculette!be.businesstraining.beans.CalculetteHome";

	public static void main(String[] args) {
		try {
	
			// Se connecter sur le contexte d'annuaire JNDI de JBoss
			// Les param�tres de l'annuaire sont sp�cifi�s dans le 
			// fichier jndi.properties qui soit �tre mis dans le BuildPath du projet
			// Attention : L'acc�s � l'annuaire JNDI exige une athentification
			// pour un utilisateur du type "Application User"
			// Voir le ReadMe.txt qui explique la proc�dure de cr�ation d'utilsateur
			// sous JBoss AS 7.1.1
			Context ctx = new InitialContext();
			
			// Faire un lookup sur la Home de l'interface Remote
			CalculetteHome cal = (CalculetteHome) ctx.lookup(JNDI_HOME);

			// Ordonner � la Home de cr�er une instance du bean
			Calculette bean = (Calculette) cal.create();

			// Play with your bean ...
			int resultat = bean.additionner(11, 22);
			System.out.println("=====> 11 + 22 =  " + resultat
					+ ", Selon l'EJB distant !");
		
			// Clean up !
			ctx.close();
			System.out
			.println("===== FIN DU PROGRAMME  ===== ");
		
		} catch (Exception ex) {
			System.out.println("Exception rencontr�e : " + ex);
		}

	}

}
