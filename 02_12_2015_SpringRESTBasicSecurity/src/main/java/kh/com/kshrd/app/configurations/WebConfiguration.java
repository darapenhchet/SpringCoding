package kh.com.kshrd.app.configurations;

import java.util.Base64;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="kh.com.kshrd.app")
@PropertySource(value={
		"classpath:application.properties"	
})
public class WebConfiguration extends WebMvcConfigurerAdapter{
	
	@Autowired
	Environment environment;
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		/*<resources mapping="/webjars/**" location="classpath:/META-INF/resources/webjars/"/>*/
	}
	
	@Bean
	public ViewResolver viewRsolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/spring_security_db");
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUsername("postgres");
		dataSource.setPassword("123456");
		return dataSource;
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		return new AcceptHeaderLocaleResolver();
	}
	
	@Bean
	public HttpHeaders httpHeaders(){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String credentials = environment.getProperty("khmeracademy.web.api.client_id") 
							+ ":" 
							+ environment.getProperty("khmeracademy.web.api.secret_id");
		String base64CredentialData = Base64.getUrlEncoder().encodeToString(credentials.getBytes());
		System.out.println(base64CredentialData);
		headers.set("Authorization", "Basic " + base64CredentialData);
		return headers;
	}
	
	@Bean
	public RestTemplate restTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		// Add the Jackson and String message converters
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		return restTemplate;
	}

	/*public static void main(String[] args) {
		String credentials =  "KA_WEB_API_KEY:24bccb33-b27d-4a5d-97b1-1af78d56d347"; 
		String base64CredentialData = Base64.getUrlEncoder().encodeToString(credentials.getBytes());
		System.out.println(base64CredentialData);
	}*/
}
