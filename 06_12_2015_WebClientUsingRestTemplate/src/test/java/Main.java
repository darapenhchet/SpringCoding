import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Main {
	public static void main(String[] args) {
		PasswordEncoder encode = new BCryptPasswordEncoder();
		String password = "admin";
		System.out.println(encode.matches("admin", "$2a$10$eFM5RS/SxBLWKs0trvVBuej92Rd796.Ap1vJl145WDblbqXpO50Dy"));
	}
}
