package be.businesstraining.ejb3;

import javax.ejb.Stateless;

@Stateless 
public class SommeDiviseursBean implements SommeDiviseursBeanLocal {

	public int sommeDiviseurs(int param) {

		int somme = 0;

		for (int i = 1; i <= param / 2; i++) 
				somme += (param % i == 0) ? i : 0 ;
		
		return somme;
	}

}
