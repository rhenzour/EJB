package be.businesstraining.ejb3;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.businesstraining.ejb2.SommeDiviseursLocal;
import be.businesstraining.ejb2.SommeDiviseursLocalHome;

@Stateless
public class EntiersPremiersBean implements EntiersPremiersBeanRemote {

	@EJB
	SommeDiviseursLocalHome diviseursLocalHome;

	public boolean estPremier(int param) {

		SommeDiviseursLocal bean = null;
		int somme = 0;
		try {
			bean = (SommeDiviseursLocal) diviseursLocalHome.create();
			somme = bean.sommeDiviseurs(param);
		} catch (Exception e) {
			System.out.println("====Attention, il y a eu l'exception : " + e);
		}
		return somme == 1; // Un entier est dit premier
							// s'il n'est divisible que par
							// 1 ou par lui même.

	}

}
