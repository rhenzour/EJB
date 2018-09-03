package be.businesstraining.entities;

import be.businesstraining.entities.Item;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-23T11:55:09")
@StaticMetamodel(Bid.class)
public class Bid_ { 

    public static volatile SingularAttribute<Bid, Double> amount;
    public static volatile SingularAttribute<Bid, Date> timestamp;
    public static volatile SingularAttribute<Bid, Item> item;
    public static volatile SingularAttribute<Bid, Long> bidId;

}