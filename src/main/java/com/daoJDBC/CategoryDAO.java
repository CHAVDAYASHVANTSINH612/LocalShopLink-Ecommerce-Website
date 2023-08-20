package com.daoJDBC;

import java.sql.*;

import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.*;



public class CategoryDAO {
	
	int categoryId;
	String CategoryName;
	String CategoryDescription;
	
	public int getNumOfCategories() {
         try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/buyindiadatabase","root","");
			
			String sql="SELECT COUNT(*) FROM category;";
			Statement stmt= con.createStatement();
			
		     ResultSet rs= stmt.executeQuery(sql);
		     
		     rs.next();
		     
		     int num=rs.getInt(1);
		     
		     rs.close();
		     con.close();
		     return num;
			
			
         }
         catch(Exception e) {
        	 System.out.println(e);
         }
			
         return 0;
		
	}


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
	
	
	
	// get categories while "adding new product"
	public List<CategoryDAO> getAllCategories(){
		List<CategoryDAO> L = new ArrayList<CategoryDAO>();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/buyindiadatabase","root","");
			
			String sql="SELECT * FROM category;";
			Statement stmt= con.createStatement();
			
			ResultSet rs= stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				CategoryDAO c=new CategoryDAO();
				
			      c.setCategoryId(rs.getInt("category_id"));
			      c.setCategoryName(rs.getString("category_name"));
			      c.setCategoryDescription(rs.getString("category_description"));
			      
				L.add(c);
				c=null;
				
			}
			
			rs.close();
			con.close();
			
			
		     
		}
		catch(Exception e) {
			
			System.out.println(e);
			
		}
		
		return L;
		
	}
	
	public int getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}



	public String getCategoryName() {
		return CategoryName;
	}



	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}



	public String getCategoryDescription() {
		return CategoryDescription;
	}



	public void setCategoryDescription(String categoryDescription) {
		CategoryDescription = categoryDescription;
	}



}
