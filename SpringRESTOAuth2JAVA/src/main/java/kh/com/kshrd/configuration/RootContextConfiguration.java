package kh.com.kshrd.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SpringRESTSecurityConfiguration.class})
public class RootContextConfiguration {
	
	
}
