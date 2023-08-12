package com.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.*;
import com.daoJDBC.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LoginServlet() {
    	
        super();
        
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String userName=  request.getParameter("username");
		String password= request.getParameter("password");
		HttpSession session= request.getSession();
		
		
		UserDAO u= new UserDAO();
		
		UserDAO user= u.getUser(userName,password);
		
		
		
		if(user!=null) {
			
				session.setAttribute("user",user);
				response.sendRedirect("welcomeUser.jsp");
			
		}
		else{
			
			session.setAttribute("failMessage","Wrong username or password! or user may not exsist ");
			response.sendRedirect("login.jsp");
			return;
		}
		
		
		
		
	}

}
