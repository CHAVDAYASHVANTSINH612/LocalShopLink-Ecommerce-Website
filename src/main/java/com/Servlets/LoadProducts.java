package com.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.daoJDBC.*;


@WebServlet("/LoadProducts")
public class LoadProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("in LoadProducts get method");
		HttpSession session= request.getSession();
		ProductDAO  p= new ProductDAO();
		
		String categoryId = request.getParameter("category");
		String searchBox  = request.getParameter("searchbox");
		
		System.out.println(categoryId);
		
		if(categoryId.equals(null) &&  searchBox==null) {
	    	session.setAttribute("productList", p.getProducts());
			
	    //	RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
	       //   response.sendRedirect("index.jsp");
		
	           return;
			
			
		}
		
//		else if(!categoryId.equals("0") &&  searchBox==null ){
//			
//			
//			
//			session.setAttribute("productList", p.getProductsByCategoryId(Integer.parseInt(categoryId)));
//			
//	          response.sendRedirect("index.jsp");
//		
//	           return;
//			
//		}
//		else{
//			System.out.println("in else");
//		}
		
	}
	
	
	

}
