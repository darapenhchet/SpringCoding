import java.util.Base64;

public class Base64Test {
	public static void main(String args[]){

		System.out.println(Base64.getUrlEncoder().encodeToString("admin:admin".getBytes()));
	}
}
