package be.businesstraining.entities;

import be.businesstraining.entities.Item;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-23T12:07:16")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SetAttribute<Category, Item> items;
    public static volatile SingularAttribute<Category, Long> categoryId;
    public static volatile SingularAttribute<Category, String> name;

}