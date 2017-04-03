package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UserUtil;
import dao.UserDao;
import Servlets.HttpSession;
import Servlets.List;
import Servlets.String;
import customTools.emailUtil;
import model.TnUser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String useremail = request.getParameter("email");
        String userpassword = request.getParameter("password");       
        String action = request.getParameter("action");     
        String nextURL = "";       
        HttpSession session = request.getSession();          
        TnUser user = null;        
        
        System.out.println("LoginServlet action: "+action);
        if (action.equals("logout")){
        	System.out.println("Login Servlet: Logout");
            session.invalidate();
            nextURL = "/login.jsp";
            
        }else{        	
        	
        	if (action.equals("createaccount")) {
        		//create an account for a new user
        		System.out.println("Login: creating an account for a new user");
        		String username = request.getParameter("username");  
        		user = ;        	
        	
        	} else {        
        		//validate the user for login
        		System.out.println("Login: validating a user");
        		user = DBUser.getValidUser(useremail, userpassword);
        	}
        	
            if (user != null){            	
            	
            	System.out.println("found valid user"+useremail+" "+userpassword);
                session.setAttribute("user", user); 
                session.setAttribute("username", String.valueOf(user.getUsername()));
                
                
                nextURL = "/";
            }else{
                nextURL = "/login.jsp";
                String att = (String)session.getAttribute("loginattempts");
                if(att!=null){
                	int atts = Integer.parseInt(att);
                	if(atts>=2){
                		String to = "admin@samazon.com";
                		String from = "donotreply@samazon.com";
                		String subject = "User failed attempts";
                		String body = "Login in for user: "+ useremail +" failed repeatedly";
                		emailUtil.sendEmail(to, from, subject, body);
                	}
                	else{
                		atts++;
                    	session.setAttribute("loginattempts", ""+atts);
                	}
                }
                else{
                	session.setAttribute("loginattempts", "1");
                }
            }
            
        }
        //redirect to the next page    
        response.sendRedirect(request.getContextPath() + nextURL);
	}

}
