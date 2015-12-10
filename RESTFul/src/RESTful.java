

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Address;
import model.Student;

/**
 * Servlet implementation class RESTful
 */
@WebServlet("/api/*")
public class RESTful extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RESTful() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf8");
		Map<String, Object> model = new HashMap<String,Object>();
		try{
			List<Student> students = new ArrayList<Student>();
			
			Student student = new Student();
			Address address = new Address();
			student.setId(1);
			student.setName("DARA PENHCHET");
			student.setGender("MALE");
			address.setCity("PHNOM PENH");
			student.setAddress(address);
			
			Student student1 = new Student();
			student1.setId(2);
			student1.setName("LEANG BUNRONG");
			student1.setGender("FEMALE");
			student1.setAddress(address);
			
			students.add(student);
			students.add(student1);
			
			model.put("CODE", HttpServletResponse.SC_OK);
			model.put("STATUS", true);
			model.put("MESSAGE", "GET ALL STUDENTS SUCCESSFULLY. GET METHOD");
			model.put("RESP_DATA", students);
			response.setStatus(HttpServletResponse.SC_OK);
		}catch(Exception ex){
			model.put("MESSAGE", ex.getMessage());
			model.put("CODE", "99999");
			model.put("STATUS", false);
		}
		response.getWriter().write(new Gson().toJson(model));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		System.out.println(servletPath);
		response.setContentType("application/json");
		response.setCharacterEncoding("utf8");
		Map<String, Object> model = new HashMap<String,Object>();
		try{
			List<Student> students = new ArrayList<Student>();
			
			Student student = new Student();
			Address address = new Address();
			student.setId(1);
			student.setName("DARA PENHCHET");
			student.setGender("MALE");
			address.setCity("PHNOM PENH");
			student.setAddress(address);
			
			Student student1 = new Student();
			student1.setId(2);
			student1.setName("LEANG BUNRONG");
			student1.setGender("FEMALE");
			student1.setAddress(address);
			
			students.add(student);
			students.add(student1);
			
			model.put("CODE", HttpServletResponse.SC_OK);
			model.put("STATUS", true);
			model.put("MESSAGE", "GET ALL STUDENTS SUCCESSFULLY. POST METHOD");
			model.put("RESP_DATA", students);
			response.setStatus(HttpServletResponse.SC_OK);
		}catch(Exception ex){
			model.put("MESSAGE", ex.getMessage());
			model.put("CODE", "99999");
			model.put("STATUS", false);
		}
		response.getWriter().write(new Gson().toJson(model));
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf8");
		Map<String, Object> model = new HashMap<String,Object>();
		try{
			List<Student> students = new ArrayList<Student>();
			
			Student student = new Student();
			Address address = new Address();
			student.setId(1);
			student.setName("DARA PENHCHET");
			student.setGender("MALE");
			address.setCity("PHNOM PENH");
			student.setAddress(address);
			
			Student student1 = new Student();
			student1.setId(2);
			student1.setName("LEANG BUNRONG");
			student1.setGender("FEMALE");
			student1.setAddress(address);
			
			students.add(student);
			students.add(student1);
			
			model.put("CODE", HttpServletResponse.SC_OK);
			model.put("STATUS", true);
			model.put("MESSAGE", "GET ALL STUDENTS SUCCESSFULLY. DELETE METHOD");
			model.put("RESP_DATA", students);
			response.setStatus(HttpServletResponse.SC_OK);
		}catch(Exception ex){
			model.put("MESSAGE", ex.getMessage());
			model.put("CODE", "99999");
			model.put("STATUS", false);
		}
		response.getWriter().write(new Gson().toJson(model));
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf8");
		Map<String, Object> model = new HashMap<String,Object>();
		try{
			List<Student> students = new ArrayList<Student>();
			
			Student student = new Student();
			Address address = new Address();
			student.setId(1);
			student.setName("DARA PENHCHET");
			student.setGender("MALE");
			address.setCity("PHNOM PENH");
			student.setAddress(address);
			
			Student student1 = new Student();
			student1.setId(2);
			student1.setName("LEANG BUNRONG");
			student1.setGender("FEMALE");
			student1.setAddress(address);
			
			students.add(student);
			students.add(student1);
			
			model.put("CODE", HttpServletResponse.SC_OK);
			model.put("STATUS", true);
			model.put("MESSAGE", "GET ALL STUDENTS SUCCESSFULLY. PUT METHOD");
			model.put("RESP_DATA", students);
			response.setStatus(HttpServletResponse.SC_OK);
		}catch(Exception ex){
			model.put("MESSAGE", ex.getMessage());
			model.put("CODE", "99999");
			model.put("STATUS", false);
		}
		response.getWriter().write(new Gson().toJson(model));
	}

}
