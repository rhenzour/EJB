package be.businesstraining.timers;

import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class ScheduleExample {
  
    @Schedule(second="*/2", minute="*",hour="*", persistent=true)
    public void doWork(){
        System.out.println( "=======> Hi from the EJB timer example! : "+ new Date().toString());
    }
    
}
