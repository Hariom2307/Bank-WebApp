package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.UserAccount;
import Model.UserRegister;
import Service.UserService;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long accNo = Long.parseLong(request.getParameter("accNo"));
		float accBal = Float.parseFloat(request.getParameter("accBal"));
		String branchCity = request.getParameter("branchCity");
		String IFSCcode = (request.getParameter("IFSCcode"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		long phoneNo = Long.parseLong(request.getParameter("PhoneNo"));
		String city = request.getParameter("City");

		UserRegister user=new UserRegister(username, password, email, phoneNo, city);
		UserAccount account=new UserAccount(accNo, accBal, branchCity,IFSCcode ,user);
		UserService userservice=new UserService();
		PrintWriter pw=response.getWriter();
        pw.print("1");
		try {
			boolean validate= userservice.validateAccountNumber(accNo,email,phoneNo);
		      
			if(validate) {
				int isUserSaved=userservice.saveUserToDatabase(account);
		        pw.print("2");
              if (isUserSaved>0) {
					response.sendRedirect("LoginView.jsp");
			        pw.print("3");

				}
			}
			else {
				request.setAttribute("errorMessage", "Account Number, Email, or Phone Number already exists.");
				request.setAttribute("errorMessage", "Registration failed. Please try again.");
				request.getRequestDispatcher("RegisterView.jsp").forward(request, response);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.print("4");
	}
	
}


