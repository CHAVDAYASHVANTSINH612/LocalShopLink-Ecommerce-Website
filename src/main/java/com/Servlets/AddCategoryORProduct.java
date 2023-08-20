package com.Servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.daoJDBC.*;


@WebServlet("/AddCategoryORProduct")
@MultipartConfig(maxFileSize = 16177215)   
public class AddCategoryORProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	try {
		
		HttpSession session = request.getSession();
		
		String WhatToAdd = request.getParameter("WhatToAdd");
		
		// add category
		if(WhatToAdd.equals("AddCategory")) {
			
			String categoryName=request.getParameter("categoryName");
			String categoryDescription=request.getParameter("categoryDescription");
		
		
		     if(categoryName!=null && categoryDescription!= null && !categoryName.equals("") && !categoryDescription.equals("")) {
			
			  
		           CategoryDAO c=new CategoryDAO();
		
		
		
		           if(c.addCategory(categoryName, categoryDescription)) {
			
			
		                   String successMessage ="Category Added";
		                  	session.setAttribute("successMessage", successMessage);
		     	          response.sendRedirect("admin.jsp");
		     	         return;
		            }
		          else {
	 	
			        String failMessage="Cannot add category , Some error occured ";
			     	session.setAttribute("failMessage", failMessage);
			    	response.sendRedirect("admin.jsp");
				    return;
			
			
		           }
		
			     }
		
		  String failMessage ="Cannot add category , Some error occured ";
			session.setAttribute("failMessage", failMessage);
			response.sendRedirect("admin.jsp");
			return;
		}
		
		
		
		
//add product	
	else if(WhatToAdd.equals("AddProduct")) {
			
			    
			String productName=request.getParameter("productName");
			String Price=request.getParameter("productPrice");
			 
			String productDescription=request.getParameter("productDescription");
			String CategoryId=request.getParameter("productCategoryId");
			
			String Quantity=request.getParameter("productQuantity");
			  
			Part productPhoto= request.getPart("productPhoto");
			
//			String Discount=request.getParameter("productDiscount");
//			 int productDiscount= Integer.parseInt(Discount);
		
		
	 if(productName!=null && Price!=null && !(Price.equals("")) && productDescription!=null && CategoryId!=null && !(CategoryId.equals("")) && !(Quantity.equals("0") )
			         && (productPhoto != null) && (productPhoto.getSize() > 0) ){
			         
		    	 int productPrice= Integer.parseInt(Price);
				 int productCategoryId= Integer.parseInt(CategoryId);
				 int productQuantity= Integer.parseInt(Quantity);
				 
				 
			  
		           ProductDAO p=new ProductDAO();
		
		           if(p.addProduct(productName, productPrice,productDescription,productCategoryId,productQuantity,productPhoto)) {
			
			
		                   String successMessage ="Product Added";
		                  	session.setAttribute("successMessage", successMessage);
		     	          response.sendRedirect("admin.jsp");
		     	         return;
		            }
		         
	 	
		        String failMessage ="Cannot add product , Some error occured ";
				 		
				session.setAttribute("failMessage", failMessage);
				 response.sendRedirect("admin.jsp");
				 return;
			
			
		     }
		    
		    	 
		    	 String failMessage ="Cannot add product , Some error occured ";
		 		
		 		session.setAttribute("failMessage", failMessage);
		 		response.sendRedirect("admin.jsp");
			    return;
		     
		
	       }
	    
		
		
    }
	catch(Exception e) {
		System.out.println(e);
		e.printStackTrace();
	   }
	
	}
	
	

}
