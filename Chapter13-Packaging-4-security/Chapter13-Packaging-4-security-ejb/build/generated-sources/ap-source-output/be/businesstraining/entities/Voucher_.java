package be.businesstraining.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-25T12:22:56")
@StaticMetamodel(Voucher.class)
public class Voucher_ { 

    public static volatile SingularAttribute<Voucher, BigDecimal> amount;
    public static volatile SingularAttribute<Voucher, Long> id;
    public static volatile SingularAttribute<Voucher, Boolean> approved;
    public static volatile SingularAttribute<Voucher, String> name;
    public static volatile SingularAttribute<Voucher, String> destination;

}