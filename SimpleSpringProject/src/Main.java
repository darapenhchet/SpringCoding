import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.simple.GreetingMessageService;

public class Main {
	public static void main(String[] args) {
		// loads Spring beans configuration file named beans.xml
		// for creating and initializing all the bean objects.
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		// getBean() method uses bean ID and bean class to return a bean object.
		GreetingMessageService service = context.getBean("greetingMessageServiceImpl", GreetingMessageService.class);
		
		System.out.println(service.greetUser());
	}
}
