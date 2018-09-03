package be.businesstraining.ejb3;

import javax.ejb.Remote;

@Remote
public interface EntiersPremiersBeanRemote {
	
	public boolean estPremier(int param);

}
