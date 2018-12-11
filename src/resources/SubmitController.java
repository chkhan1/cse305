//
//package resources;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import dao.CustomerDao;
//import dao.EmployeeDao;
//import dao.LoginDao;
//import model.Login;
///**
// * Servlet implementation class LoginController
// */
///*
//public class SubmitController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public SubmitController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//*/
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		/*
//		 * This method is called by the login button
//		 * It receives the username and password values and sends them to LoginDao's login method for processing
//		 * On Success (receiving "true" from login method), it redirects to the Home page
//		 */
//
//
//
//		//String username = request.getParameter("username");
//		//String password = request.getParameter("password");
//		String firstname = request.getParameter("firstname");
//		String lastname = request.getParameter("lastname");
//		String ssn = request.getParameter("ssn");
//		String address = request.getParameter("address");
//		String city = request.getParameter("city");
//		String state = request.getParameter("state");
//		String zip = request.getParameter("zipcode");
//		String number = request.getParameter("number");
//		String email = request.getParameter("email");
//		String userEmail = request.getParameter("username");
//		String userPassword = request.getParameter("password");
//		
//		
//		
//		LoginDao loginDao = new LoginDao();
//		String newUser = loginDao.addMyUser(firstname, lastname, ssn, address, city, state, zip, number, email, userEmail, userPassword);
//		
//		if(newUser.equalsIgnoreCase("success")) {
//				CustomerDao customerDao = new CustomerDao();
//				String customerID = customerDao.getCustomerID(username);
//				request.getSession(true).setAttribute("customerID", customerID);
//				response.sendRedirect("home.jsp");	
//		}
//		else {
//			response.sendRedirect("index.jsp?status=false");
//		}
//		
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
