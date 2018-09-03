/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.businesstraining.sessionbeans;

import javax.ejb.Stateless;

/**
 *
 * @author Mohamed
 */
@Stateless
public class Calculette implements CalculetteLocal {

    @Override
    public int additionner(int a, int b) {
        return a + b;
    }


    
}
