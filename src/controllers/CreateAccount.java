package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import model.TnUser;
import util.UserUtil;
import dao.UserDao;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		try {
			TnUser newuser = new TnUser();
			String address = request.getParameter("address");
			String username = request.getParameter("username");
			String useremail = request.getParameter("useremail");
			String zipcode = request.getParameter("zipcode");
			int zipc = Integer.parseInt(zipcode);
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			newuser.setAddress(address);
			newuser.setUsername(username);
			newuser.setLastname(lastname);
			newuser.setFirstname(firstname);
			newuser.setUseremail(useremail);
			newuser.setZipcode(zipc);
			UserDao.insertUser(newuser);
			String nextURL = "./login.jsp";
			// redirect to the next page
			response.sendRedirect(request.getContextPath() + nextURL);
		} catch (Exception e) {
			request.getRequestDispatcher("JavaError.jsp").forward(request, response);
		}
	}
}
