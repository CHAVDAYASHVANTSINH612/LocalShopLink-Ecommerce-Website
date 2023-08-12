package com.daoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CategoryDAO {
	
	int categoryId;
	String CategoryName;
	String CategoryDescription;
	
	
	
	
	
	public Boolean addCategory(  String CategoryName ,String CategoryDescription ) {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/buyindiadatabase","root","");
		PreparedStatement pstmt= con.prepareStatement("INSERT INTO category (category_name,category_description)  VALUES(?,?);");
		
	     pstmt.setString(1,  CategoryName);
	     pstmt.setString(2, CategoryDescription);
	    
	     
	    
	     if(pstmt.executeUpdate()>=1) {
	    	  con.close();	
	    	 return true;
	     }
	     
	     con.close();		
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return false;
		
		
	}
	
	

	
	

}
