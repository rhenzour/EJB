package be.businesstraining.timers;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.ScheduleExpression;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Singleton
@Startup
public class TimeOutExample {

    @Resource
    TimerService timerService;

    @PostConstruct
    public void initTimer() {
        if (timerService.getTimers() != null) {
            for (Timer timer : timerService.getTimers()) {
                if (timer.getInfo().equals("dummyTimer3.1")
                        || timer.getInfo().equals("dummyTimer3.2")) {
                    timer.cancel();
                }
            }
        }
       // timerService.createSingleActionTimer(5000, new TimerConfig("Non cyclic Timer", false));
      //  timerService.createIntervalTimer(2000,3000, new TimerConfig("dummyTimer3.0", false));
        timerService.createCalendarTimer(new ScheduleExpression().
                hour("*").
                minute("*").
                second("*/10"),
                new TimerConfig("dummyTimer3.1", true));
        timerService.createCalendarTimer(
                new ScheduleExpression().
                hour("*").
                minute("*").
                second("*/45"), new TimerConfig("dummyTimer3.2", true));
    }

    @Timeout
    public void timeout(Timer timer) {
        System.out.println(getClass().getName() + ": " + timer.getInfo() + " - " + new Date());
    }
}
