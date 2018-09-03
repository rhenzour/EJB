package be.businesstraining.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.businesstraining.domain.User;
import be.businesstraining.domain.UserDao;

@Named
@RequestScoped
public class GreetController {

    @Inject
    private UserDao userDao;

    private String username;

    private String greeting;

    public void greet() {
        User user = userDao.getForUsername(username);
        if (user != null) {
            greeting = "Hello, " + user.getFirstName() + " " + user.getLastName() + "!";
        } else {
            greeting = "No such user exists! Use 'emuster' or 'jdoe'";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGreeting() {
        return greeting;
    }

}
