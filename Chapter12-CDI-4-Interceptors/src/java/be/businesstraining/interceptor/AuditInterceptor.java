
package be.businesstraining.interceptor;

import be.businesstraining.service.History;
import java.text.DateFormat;
import java.util.Date;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;


@Interceptor
@Audit
public class AuditInterceptor {

    @AroundInvoke
    public Object aroundInvoke(InvocationContext ic) throws Exception {
        String methodName = ic.getMethod().getName();
        String time = DateFormat.getTimeInstance().format(new Date());
        if (methodName.equals("create")) {
            History.getItemHistory().add(String.format("Item created at %s", time));
        } else if (methodName.equals("getList")) {
            History.getItemHistory().add(String.format("List of Items retrieved at %s", time));
        }
        return ic.proceed();
    }
}
