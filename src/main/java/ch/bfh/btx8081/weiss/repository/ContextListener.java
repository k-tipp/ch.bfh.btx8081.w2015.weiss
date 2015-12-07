package ch.bfh.btx8081.weiss.repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * The listener interface for receiving context events. The class that is
 * interested in processing a context event implements this interface, and the
 * object created with that class is registered with a component using the
 * component's <code>addContextListener<code> method. When the context event
 * occurs, that object's appropriate method is invoked.
 *
 * @see ContextEvent
 */
@WebListener
public class ContextListener implements ServletContextListener {

    /** The <code>EntityManagerFactory</code>. */
    private static EntityManagerFactory emf;

    /* (non-Javadoc)
     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        emf = Persistence.createEntityManagerFactory("Shrinkie");
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        emf.close();
    }
	
    /**
	 * Gets the entity manager factory.
	 *
	 * @return the entity manager factory
	 */
    protected static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            throw new IllegalStateException("Context is not initialized yet.");
        }

        return emf;
    }

}