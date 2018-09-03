
package be.businesstraining.backing;

import be.businesstraining.qualifier.English;
import be.businesstraining.qualifier.French;
import be.businesstraining.qualifier.Spanish;
import be.businesstraining.service.TranslateService;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;


@Named("translation")

//@ManagedBean(name = "translation")
public class TranslationBackingBean {

    /*
     * Both of these injections is of the same base type: TranslationService, however, CDI is using the qualifiers to help
     * narrow which of the three implementations should be injected.
     */

     @Inject
    @French
    private TranslateService frenchTranslateService;
    
     @Inject
    @Spanish
    private TranslateService spanishTranslateService;

    @Inject
    @English
    private TranslateService englishTranslateService;

    public String getSpanishHello() {
        return spanishTranslateService.hello();
    }
     public String getFrenchHello() {
        return frenchTranslateService.hello();
    }

    public String getEnglishHello() {
        return englishTranslateService.hello();
    }
}
