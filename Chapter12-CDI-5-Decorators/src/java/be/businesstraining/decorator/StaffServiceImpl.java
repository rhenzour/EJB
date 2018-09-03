package be.businesstraining.decorator;

public class StaffServiceImpl implements StaffService {

    @Override
    public Staff getStaff() {
        Staff staff = new Staff();
        staff.setPosition("Java Developer");
        staff.setBonus(100);
        return staff;
    }

    /**
     * CDI decorator can be abstract class and does not implement all methods of the StaffServiceImpl class.
     * {@link StaffServiceDecorator} are abstract and do not wrap deleteStaff(Staff staff) method.
     * 
     */
    @Override
    public void deleteStaff(Staff staff) {
        // Some implementation
    }

}
