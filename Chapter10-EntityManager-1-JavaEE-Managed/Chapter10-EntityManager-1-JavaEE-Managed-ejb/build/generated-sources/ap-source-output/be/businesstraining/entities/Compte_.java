package be.businesstraining.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-23T14:55:43")
@StaticMetamodel(Compte.class)
public class Compte_ { 

    public static volatile SingularAttribute<Compte, BigDecimal> solde;
    public static volatile SingularAttribute<Compte, String> proprietaire;
    public static volatile SingularAttribute<Compte, String> numero;

}