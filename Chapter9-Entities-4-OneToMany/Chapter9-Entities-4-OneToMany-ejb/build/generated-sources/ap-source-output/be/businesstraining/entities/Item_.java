package be.businesstraining.entities;

import be.businesstraining.entities.Bid;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-23T11:55:09")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, Date> postdate;
    public static volatile SingularAttribute<Item, String> title;
    public static volatile SingularAttribute<Item, String> description;
    public static volatile SetAttribute<Item, Bid> bids;
    public static volatile SingularAttribute<Item, Long> itemId;

}