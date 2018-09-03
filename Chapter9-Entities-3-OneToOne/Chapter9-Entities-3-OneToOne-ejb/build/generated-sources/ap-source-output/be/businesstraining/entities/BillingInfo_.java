package be.businesstraining.entities;

import be.businesstraining.entities.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-23T11:32:11")
@StaticMetamodel(BillingInfo.class)
public class BillingInfo_ { 

    public static volatile SingularAttribute<BillingInfo, Long> billingId;
    public static volatile SingularAttribute<BillingInfo, User> user;
    public static volatile SingularAttribute<BillingInfo, String> creditCardType;

}