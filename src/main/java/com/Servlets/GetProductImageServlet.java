package com.Servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.*;
import com.daoJDBC.*;

@WebServlet("/GetProductImageServlet")
public class GetProductImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("in GetProductImageServlet");
		
		HttpSession session = request.getSession();
		ProductDAO productDaoForImage= (ProductDAO)session.getAttribute("productDaoForImage");
		
		// Blob imageBlob = productDaoForImage.getGotImage();
	   //  String contentType = productDaoForImage.getContentType();
	     
	    // response.setContentType(contentType);
         
         // Write the Blob data to the response output stream
         try  {
        	 //InputStream inputStream = imageBlob.getBinaryStream();
         
             byte[] buffer = new byte[4096];
             int bytesRead;
           //  while ((bytesRead = inputStream.read(buffer)) != -1) {
           //      response.getOutputStream().write(buffer, 0, bytesRead);
           //  }
         }  
         catch(Exception e) {
        	 e.printStackTrace();
        	 System.out.println(e);
         }
	     
		
	}

	

}
