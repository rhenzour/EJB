package be.businesstraining.service;

import be.businesstraining.qualifier.Spanish;

@Spanish
public class SpanishTranslateService implements TranslateService {

    @Override
    public String hello() {
        return "Hola";
    }

}
