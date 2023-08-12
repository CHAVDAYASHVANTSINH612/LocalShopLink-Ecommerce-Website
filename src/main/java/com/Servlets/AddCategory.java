package com.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daoJDBC.*;


@WebServlet("/AddCategoryORProduct")
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		String categoryName=request.getParameter("categoryName");
		String categoryDescription=request.getParameter("categoryDescription");
		
		if(categoryName!=null && categoryDescription!= null) {
			
			try {
		CategoryDAO c=new CategoryDAO();
		
		
		
		if(c.addCategory(categoryName, categoryDescription)) {
			
			
		  String successCategory ="Category Added";
			session.setAttribute("successCategory", successCategory);
			response.sendRedirect("admin.jsp");
			return;
		}
		else {
		
			 String failCategory ="Cannot add category , Some error occured ";
				session.setAttribute("failCategory", failCategory);
				response.sendRedirect("admin.jsp");
				return;
			
			
		}
		
			}
			catch(Exception e) {
				System.out.println(e);
			}
		
		
		}
		
		System.out.println("outside2 c-name "+categoryName+" c-desc : "+categoryDescription);
		  String failCategory ="Cannot add category , Some error occured ";
			session.setAttribute("failCategory", failCategory);
			response.sendRedirect("admin.jsp");
			return;
		
		   
		
	}

}
