package be.businesstraining.beans;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class AchatBean {

    public String acheter(){
        return "Achat affectue";
    }
    
}
