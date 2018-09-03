/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.businesstraining.beans;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;


@Stateless
@LocalBean
public class PaiementBean {

    public String payer(){
        return "Paiement effectue";
    }
}
