package be.businesstraining.decorator;

import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "staff")
public class StaffController {

    @Inject
    private StaffService staffService;

    public String getPosition() {
        return staffService.getStaff().getPosition();
    }

    public Integer getBonus() {
        return staffService.getStaff().getBonus();
    }
}
