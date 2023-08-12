package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daoJDBC.*;

@WebServlet("/signup_user")
public class SignupUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SignupUser() {
        super();
       
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userName=request.getParameter("user_name");
		String userPassword=request.getParameter("password");
		String Address=request.getParameter("address");
		String pincode=request.getParameter("pincode");
		String userAddress=Address+"  "+pincode;
		String userPhone= request.getParameter("phonenumber");
	    
		UserDAO u= new UserDAO();
		
		String successMessage;
		String failMessage;
		
	
		HttpSession session= request.getSession();
		PrintWriter out= response.getWriter();
		
		try {
		
		if(userName==null || userName=="" || userPassword==null || userPassword=="") {
			failMessage="user name and password must not null";
			
			session.setAttribute("failMessage",failMessage);
			
			response.sendRedirect("signup.jsp");
			return;
		}
		
		
		if(userName!=null && userPassword!=null &&( userPhone!=null || !userPhone.equals(""))&& (userAddress!=null  || !userAddress.equals("")) ) {
			
			
	    	if(u.addUser(userName, userPassword, userPhone,"NULL", userAddress)) {
			
			successMessage="You have successfully Registered now login";
			session.setAttribute("successMessage",successMessage);
//			out.print(successMessage);
			response.sendRedirect("login.jsp");
			
	     	}
		   else {
		    	failMessage="failed to register ,User may exist already ";
			     session.setAttribute("failMessage", failMessage);
		    	response.sendRedirect("signup.jsp");
		       }
	
		}
		
	// when only required attributes are given
		else if(userName!=null && userPassword!=null ) {
			if(u.addUser(userName, userPassword)) {
				
				successMessage="You have successfully Registered now login";
				session.setAttribute("successMessage",successMessage);
				response.sendRedirect("login.jsp");
				
			}
			else {
				
				failMessage="failed to register ,User may exist already ";
				session.setAttribute("failMessage", failMessage);
				response.sendRedirect("signup.jsp");
				
			}
			
			}
		
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
			
			
		
		}
		
		
		
		
	}

}
