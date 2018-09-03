package be.businesstraining.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BillingInfo {
 
  @Id
  protected Long billingId;
  protected String creditCardType;
  // ...
  @OneToOne
  protected User user;
}

