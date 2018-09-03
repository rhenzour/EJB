package be.businesstraining.web;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import be.businesstraining.domain.User;
import be.businesstraining.domain.UserDao;

@Named
@RequestScoped
public class CreateController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private UserDao userDao;

    @Named
    @Produces
    @RequestScoped
    private User newUser = new User();

    public void create() {
        try {
            userDao.createUser(newUser);
            String message = "A new user with id " + newUser.getId() + " has been created successfully";
            facesContext.addMessage(null, new FacesMessage(message));
        } catch (Exception e) {
            String message = "An error has occured while creating the user (see log for details)";
            facesContext.addMessage(null, new FacesMessage(message));
        }
    }
}
