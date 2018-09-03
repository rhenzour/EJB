package be.businesstraining.beans;

public class EchoBeanFacade {
    
    public String echo(String name){
        return "Bienvenue "+ name + "- Je suis un EJB qui fonctionne sans annotations";
    
    }
}
