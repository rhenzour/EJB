package be.businesstraining.decorator;

import java.util.logging.Logger;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public abstract class StaffServiceDecorator implements StaffService {

    @Inject
    @Delegate
    private StaffService staffService;
    private final Logger log = Logger.getLogger(StaffServiceDecorator.class.getName());

    /**
     * We wrap {@link StaffServiceImpl#getStaff()} method of delegate object and decorate it with additional functionality. In
     * this case after call to delegated method, we change {@link Staff} attributes and log information.
     * 
     */
    @Override
    public Staff getStaff() {
        Staff staff = staffService.getStaff();
        staff.setBonus(200);
        staff.setPosition("Team Lead");
        log.info("CDI decorator method was called!");
        return staff;
    }

}
