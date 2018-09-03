package be.businesstraining.ejb3;

import javax.ejb.Local;

@Local
public interface SommeDiviseursBeanLocal {
	
	public int sommeDiviseurs(int param) ;

}
