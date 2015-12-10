package kh.com.kshrd.bootstrap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import kh.com.kshrd.configuration.RootContextConfiguration;
import kh.com.kshrd.configuration.ServletContextConfiguration;

public class SpringWebBootstrap implements WebApplicationInitializer{
	
	@Override
	public void onStartup(ServletContext container) throws ServletException {
		 AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		 rootContext.register(RootContextConfiguration.class);
		 container.addListener(new ContextLoaderListener(rootContext));
		 
		 AnnotationConfigWebApplicationContext servletContext = new AnnotationConfigWebApplicationContext();
		 servletContext.register(ServletContextConfiguration.class);
		 ServletRegistration.Dynamic dispatcher = container.addServlet("springRESTDispatcher", 
				 new DispatcherServlet(servletContext));
		 			
		 dispatcher.addMapping("/");
	}

}
