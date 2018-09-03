package be.businesstraining.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
//@DiscriminatorValue(value = "S")
// Joined table section
@Table(name = "SELLERS")
//@PrimaryKeyJoinColumn(name = "USER_ID")
public class Seller extends User {
    //...the rest of seller omitted for brevity
    private double creditWorth;
    
    private String sellerCountry;

    public String getSellerCountry() {
        return sellerCountry;
    }

    public void setSellerCountry(String sellerCountry) {
        this.sellerCountry = sellerCountry;
    }
            
    @Transient
    @Column(name = "CREDIT_WORTH")
    @Access(AccessType.PROPERTY)
    public double getCreditWorth() {
        return creditWorth;
    }

    public void setCreditWorth(double cw) {
        creditWorth = (cw <= 0) ? 50.0 : cw;
    }
}
