package kh.com.kshrd.cofiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SecurityConfiguration.class})
public class RootContextConfiguration {

}
