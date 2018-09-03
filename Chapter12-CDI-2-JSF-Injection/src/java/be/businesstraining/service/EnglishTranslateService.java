
package be.businesstraining.service;

import be.businesstraining.qualifier.English;

@English
public class EnglishTranslateService implements TranslateService {

    @Override
    public String hello() {
        return "Hello";
    }

}
