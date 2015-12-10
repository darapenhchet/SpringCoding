package kh.com.kshrd.app.boostraps;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.SessionTrackingMode;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import kh.com.kshrd.app.configurations.WebConfiguration;

public class KSHRDBootstrap implements WebApplicationInitializer{
	
	@Override
	public void onStartup(ServletContext container) throws ServletException {
		
		// 1. Create AnnotationConfigWebApplicationContext object
		AnnotationConfigWebApplicationContext servletContext = new AnnotationConfigWebApplicationContext();
		// 2. Add the Configuration Class
		servletContext.register(WebConfiguration.class);
		
		// 3. Create DispatcherServlet, add it to the container 
		// and assign it to the servletRegistration   
		ServletRegistration.Dynamic dispatcherServlet = 
				container.addServlet("springDispatcher",
						new DispatcherServlet(servletContext));
		
		dispatcherServlet.addMapping("/");
		dispatcherServlet.setLoadOnStartup(1);
		
		
		Set<SessionTrackingMode> set = new HashSet<SessionTrackingMode>();
        set.add(SessionTrackingMode.COOKIE);
        container.setSessionTrackingModes(set);
	}
	
	

}
