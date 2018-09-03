/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.businesstraining.sessionbeans;

import javax.ejb.Local;

/**
 *
 * @author Mohamed
 */
@Local
public interface CalculetteLocal {

    int additionner(int a, int b);
    
}
