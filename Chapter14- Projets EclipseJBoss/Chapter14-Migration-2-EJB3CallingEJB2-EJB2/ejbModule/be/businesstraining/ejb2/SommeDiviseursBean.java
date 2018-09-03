/**
 * 
 */
package be.businesstraining.ejb2;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionContext;

/**
 *
 * <!-- begin-user-doc --> A generated session bean <!-- end-user-doc --> * <!--
 * begin-xdoclet-definition -->
 * 
 * @ejb.bean name="SommeDiviseurs" description="An EJB named SommeDiviseurs"
 *           display-name="SommeDiviseurs" jndi-name="SommeDiviseurs"
 *           type="Stateless" transaction-type="Container"
 * 
 *           <!-- end-xdoclet-definition -->
 * @generated
 */

public abstract class SommeDiviseursBean implements javax.ejb.SessionBean {

	/**
	 * <!-- begin-xdoclet-definition --> <!-- end-xdoclet-definition -->
	 * 
	 * @generated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 * <!-- begin-xdoclet-definition -->
	 * 
	 * @ejb.create-method view-type="remote" <!-- end-xdoclet-definition -->
	 * @generated
	 *
	 *            //TODO: Must provide implementation for bean create stub
	 */
	public void ejbCreate() {
	}

	/**
	 *
	 * <!-- begin-xdoclet-definition -->
	 * 
	 * @ejb.interface-method view-type="local" <!-- end-xdoclet-definition -->
	 * @generated
	 *
	 *            //TODO: Must provide implementation for bean method stub
	 */
	public int sommeDiviseurs(int param) {

		int somme = 0;

		for (int i = 1; i <= param / 2; i++) {
			somme += (param % i == 0) ? i : 0;
		}
		return somme;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ejb.SessionBean#ejbActivate()
	 */

	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ejb.SessionBean#ejbPassivate()
	 */

	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ejb.SessionBean#ejbRemove()
	 */

	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
	 */

	public void setSessionContext(SessionContext arg0) throws EJBException,
			RemoteException {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 */
	public SommeDiviseursBean() {
		// TODO Auto-generated constructor stub
	}
}
