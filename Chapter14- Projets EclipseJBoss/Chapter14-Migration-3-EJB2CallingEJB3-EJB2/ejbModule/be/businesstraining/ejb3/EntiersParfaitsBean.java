/**
 * 
 */
package be.businesstraining.ejb3;

import java.rmi.RemoteException;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 *
 * <!-- begin-user-doc -->
 * A generated session bean
 * <!-- end-user-doc -->
 * *
 * <!-- begin-xdoclet-definition --> 
 * @ejb.bean name="EntiersParfaits"	
 *           description="An EJB named EntiersParfaits"
 *           display-name="EntiersParfaits"
 *           jndi-name="EntiersParfaits"
 *           type="Stateless" 
 *           transaction-type="Container"
 * 
 * <!-- end-xdoclet-definition --> 
 * @generated
 */


public abstract class EntiersParfaitsBean implements javax.ejb.SessionBean {

	//@EJB
	//SommeDiviseursBeanLocal sommeDiviseursBeanLocal;
	private static final String JNDI_NAME = 
			"java:global/Chapter14-Migration-3-EJB2CallingEJB3/Chapter14-Migration-3-EJB2CallingEJB3-EJB3/SommeDiviseursBean!be.businesstraining.ejb3.SommeDiviseursBeanLocal";
	
	
	/** 
	 * <!-- begin-xdoclet-definition --> 
	 * <!-- end-xdoclet-definition --> 
	 * @generated
	 */
	private static final long serialVersionUID = 1L;

	/** 
	 *
	 * <!-- begin-xdoclet-definition --> 
	 * @ejb.create-method view-type="remote"
	 * <!-- end-xdoclet-definition --> 
	 * @generated
	 *
	 * //TODO: Must provide implementation for bean create stub
	 */
	public void ejbCreate() {
	}

	/** 
	 *
	 * <!-- begin-xdoclet-definition --> 
	 * @ejb.interface-method view-type="remote"
	 * <!-- end-xdoclet-definition --> 
	 * @generated
	 *
	 * //TODO: Must provide implementation for bean method stub
	 */
	public boolean estParfait(int param) {
		
		boolean resultat = false;
		
		try {
			Context context = new InitialContext();
		    SommeDiviseursBeanLocal bean = (SommeDiviseursBeanLocal)context.lookup(JNDI_NAME);
			resultat = bean.sommeDiviseurs(param) == param;
		    
		} catch (Exception e) {
			System.out.println("ATTENTION : Il y eu l'exception : "+e);
		}
		
		// Un nombre est dit parfait s'il égale la somme de ses diviseurs
		return resultat; //sommeDiviseursBeanLocal.sommeDiviseurs(param)== param;
	}

	/* (non-Javadoc)
	 * @see javax.ejb.SessionBean#ejbActivate()
	 */
	
	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.ejb.SessionBean#ejbPassivate()
	 */
	
	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.ejb.SessionBean#ejbRemove()
	 */
	
	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
	 */
	
	public void setSessionContext(SessionContext arg0) throws EJBException,
			RemoteException {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 */
	public EntiersParfaitsBean() {
		// TODO Auto-generated constructor stub
	}
}
