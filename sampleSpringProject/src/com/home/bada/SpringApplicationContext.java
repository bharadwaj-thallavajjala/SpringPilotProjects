/**
 *
 */
package com.home.bada;

import org.apache.log4j.Logger;

//SpringApplicationContext.java

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Wrapper to always return a reference to the Spring Application Context from within non-Spring enabled beans. Unlike Spring MVC's
 * WebApplicationContextUtils we do not need a reference to the Servlet context for this. All we need is for this bean to be initialized during
 * application startup.
 */
public class SpringApplicationContext implements ApplicationContextAware {

    /**
     * Log4j Logger that is used to log information and some debug statements.
     */
	protected static Logger logger = Logger.getLogger("SampleLogger");
    /**
     *
     */
    private static ApplicationContext CONTEXT;

    /**
     * This method is called from within the ApplicationContext once it is done starting up, it will stick a reference to itself into this bean.
     * 
     * @param context
     *            a reference to the ApplicationContext.
     */
    @Override
    public final void setApplicationContext(final ApplicationContext context) {
        setCONTEXT(context);
    }

    /**
     * This is about the same as context.getBean("beanName"), except it has its own static handle to the Spring context,so calling this method
     * statically will give access to the beans by name in the Spring application context. As in the context.getBean("beanName") call, the caller must
     * cast to the appropriate target class.If the bean does not exist,then a Runtime error will be thrown.
     * 
     * @param beanName
     *            the name of the bean to get.
     * @return an Object reference to the named bean.
     */
    public static Object getBean(final String beanName) {
        logger.debug("===>SpringApplicationContext " + ": getBean :CONTEXT.getBeanDefinitionCount():" + CONTEXT.getBeanDefinitionCount());
        return CONTEXT.getBean(beanName);
    }

    /**
     * @return CONTEXT
     */
    public static ApplicationContext getContext() {
        return CONTEXT;
    }

    /**
     * @param value
     *            the cONTEXT to set
     */
    public static final void setCONTEXT(final ApplicationContext value) {
        CONTEXT = value;
    }
}
