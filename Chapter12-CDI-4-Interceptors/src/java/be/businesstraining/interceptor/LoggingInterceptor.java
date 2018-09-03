package be.businesstraining.interceptor;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;


@Interceptor
// Binding the interceptor below. Now any business method or bean annotated with @Logging will be intercepted by
// LoggingInterceptor.aroundInvoke(..) method.
@Logging
public class LoggingInterceptor {

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object aroundInvoke(InvocationContext ic) throws Exception {
        String methodName = ic.getMethod().getName();
        logger.info("Executing " + ic.getTarget().getClass().getSimpleName() + "." + methodName + " method");
        return ic.proceed();
    }
}
