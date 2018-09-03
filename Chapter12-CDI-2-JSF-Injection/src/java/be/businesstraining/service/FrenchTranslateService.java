
package be.businesstraining.service;

import be.businesstraining.qualifier.French;

@French
public class FrenchTranslateService implements TranslateService {

    @Override
    public String hello() {
        return "Bonjour";
    }

}
