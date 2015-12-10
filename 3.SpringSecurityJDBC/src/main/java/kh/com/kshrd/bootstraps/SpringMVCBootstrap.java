package kh.com.kshrd.bootstraps;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import kh.com.kshrd.configurations.SpringMVCConfiguration;

public class SpringMVCBootstrap implements WebApplicationInitializer{
	
	@Override
	public void onStartup(ServletContext container) throws ServletException {

		AnnotationConfigWebApplicationContext servletContext = new AnnotationConfigWebApplicationContext();
		servletContext.register(SpringMVCConfiguration.class);
		servletContext.setServletContext(container);
		
		ServletRegistration.Dynamic dispatcherServlet = container.addServlet(
				"springDispatcher", new DispatcherServlet(servletContext));
		
		dispatcherServlet.addMapping("/");
		dispatcherServlet.setLoadOnStartup(1);
	}

}
