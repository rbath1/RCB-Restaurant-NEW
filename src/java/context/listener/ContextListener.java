package context.listener;

import database.DBconfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Bob
 */
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        
        String urlString = sc.getInitParameter("UrlString");
        String driverClass = sc.getInitParameter("driverClass");
        String user = sc.getInitParameter("user");
        String password = sc.getInitParameter("password");
        
        DBconfig dbConfig = new DBconfig(urlString,driverClass,user,password);
        
        sc.setAttribute("dbConfig", dbConfig);  
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) { 
    }
    
}
