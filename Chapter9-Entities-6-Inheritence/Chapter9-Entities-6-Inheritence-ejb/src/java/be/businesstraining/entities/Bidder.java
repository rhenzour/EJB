package be.businesstraining.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue(value = "B")
// Joined table section
@Table(name = "BIDDERS")
//@PrimaryKeyJoinColumn(name = "USER_ID")
public class Bidder extends User {
    
      @Column(name = "BID_FREQUENCY")
    private double bidFrequency;

    public double getBidFrequency() {
        return bidFrequency;
    }

    public void setBidFrequency(double bidFrequency) {
        this.bidFrequency = bidFrequency;
    }
    
}
