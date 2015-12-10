package kh.com.kshrd.configuration;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class KSHRDBootstrap implements WebApplicationInitializer{
	
	@Override
	public void onStartup(ServletContext container) throws ServletException {
		container.getServletRegistration("default").addMapping("/resources/*", "*.css", "*.js", "*.png", "*.gif", "*.jpg");
		AnnotationConfigWebApplicationContext servletConfiguration = new AnnotationConfigWebApplicationContext();
		servletConfiguration.register(KSHRDConfiguration.class);
		servletConfiguration.setServletContext(container);
		
		ServletRegistration.Dynamic dispatcher = container.addServlet(
				"springDispatcherServlet", new DispatcherServlet(servletConfiguration));
		dispatcher.addMapping("/");
		dispatcher.setMultipartConfig(getMultipartConfigElement());
		
	}
	
	private MultipartConfigElement getMultipartConfigElement(){
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
        return multipartConfigElement;
    }
     
    /*Set these variables for your project needs*/
     
    private static final String LOCATION = "C:/mytemp/";
 
    private static final long MAX_FILE_SIZE = 1024 * 1024 * 25;//25MB
     
    private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 30;//30MB
 
    private static final int FILE_SIZE_THRESHOLD = 0;

}
