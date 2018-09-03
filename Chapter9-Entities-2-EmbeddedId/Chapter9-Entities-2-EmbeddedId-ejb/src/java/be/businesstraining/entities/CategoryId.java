package be.businesstraining.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class CategoryId implements Serializable {

    private String name;

    @Temporal(TemporalType.DATE)
    private Date createDate;

     public CategoryId() {
    }
    public CategoryId(String name, Date createDate) {
        this.name = name;
        this.createDate = createDate;
    }

    public boolean equals(Object other) {
        if (other instanceof CategoryId) {
            final CategoryId otherCategoryKey = (CategoryId) other;
            return (otherCategoryKey.name.equals(name)
                    && otherCategoryKey.createDate.equals(createDate));
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String getName() {
        return name;
    }

    public Date getCreateDate() {
        return createDate;
    }

	// ...
}
