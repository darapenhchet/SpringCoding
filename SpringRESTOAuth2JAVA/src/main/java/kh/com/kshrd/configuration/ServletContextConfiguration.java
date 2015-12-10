package kh.com.kshrd.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan("kh.com.kshrd.controller")
public class ServletContextConfiguration extends WebMvcConfigurerAdapter{
	

}
