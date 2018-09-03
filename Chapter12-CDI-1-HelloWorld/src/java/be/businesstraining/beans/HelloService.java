package be.businesstraining.beans;

import javax.enterprise.context.Dependent;

@Dependent // The default Scope
 
public class HelloService {

    
    public String createHelloMessage(String name) {
        return "Hello/Bienvenue " + name + "!";
    }

}
