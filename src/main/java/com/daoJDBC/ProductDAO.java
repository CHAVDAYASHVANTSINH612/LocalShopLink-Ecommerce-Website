package com.daoJDBC;

import java.sql.*;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class ProductDAO {
	
	
	String productName;
	int productPrice;
	String productDescription;
	int productCategoryId;
	int productQuantity;
	String productPhoto; 
	int productDiscount;
	
	public ArrayList<ProductDAO> ProductArrayList=new ArrayList();
	
	
	
public Boolean addProduct(  String productName ,int productPrice, String productDescription, int productCategoryId, int productQuantity,String productPhoto, int productDiscount) {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/buyindiadatabase","root","");
		PreparedStatement pstmt= con.prepareStatement("INSERT INTO users (product_name,product_price,product_description,product_category_id,product_quantity,product_photo,product_discount) "
				                                 + "  VALUES(?,?,?,?,?,?,?);");
		
	     pstmt.setString(1,  productName);
	     pstmt.setInt(2, productPrice);
	     pstmt.setString(3, productDescription);
	     pstmt.setInt(4, productCategoryId);
	     pstmt.setInt(5, productQuantity);
	     pstmt.setString(6, productPhoto);
	     pstmt.setInt(7,productDiscount);
	     
	    
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

public Boolean addProduct(  String productName ,int productPrice,  int productCategoryId, int productQuantity, int productDiscount) {
	
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/buyindiadatabase","root","");
	PreparedStatement pstmt= con.prepareStatement("INSERT INTO products (product_name,product_price,product_category_id,product_quantity,product_discount)  VALUES(?,?,?,?,?);");
	
     pstmt.setString(1,  productName);
     pstmt.setInt(2, productPrice);
     pstmt.setInt(3, productCategoryId);
     pstmt.setInt(4, productQuantity);
     pstmt.setInt(5,productDiscount);
     
    
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


public ArrayList<ProductDAO> getProductsByCategoryId(int CategoryId) {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/buyindiadatabase","root","");
		
		Statement stmt= con.createStatement();
		
		
		String sql2="SELECT * from products WHERE product_category_id='"+CategoryId+"';";
	      //	System.out.println(sql2);
		ResultSet rs=stmt.executeQuery(sql2);
		
	    
	     while(rs.next()) {
	    	  ProductDAO ptemp=new ProductDAO();
	    	  
	    	  ptemp.productName         = rs.getString("product_name");
	    	  ptemp.productPrice        = rs.getInt("product_price");
	    	  ptemp.productDescription  = rs.getString("product_description");
	    	  ptemp.productCategoryId   = rs.getInt("product_category_id");
	    	  ptemp.productQuantity     = rs.getInt("product_quantity");
	    	  ptemp.productPhoto        = rs.getString("product_photo"); 
	    	  ptemp.productDiscount     = rs.getInt("product_discount");
	    	 
	    	ProductArrayList.add(ptemp);
	    	 
	    	 
	     }
	}
	catch(Exception e) {
		System.out.println(e);
	}
	   
		return ProductArrayList;
	
	
}

@Override
public String toString() {
	return "ProductDAO [productName=" + productName + ", productPrice=" + productPrice + ", productDescription="
			+ productDescription + ", productCategoryId=" + productCategoryId + ", productQuantity=" + productQuantity
			+ ", productPhoto=" + productPhoto + ", productDiscount=" + productDiscount + ", ProductArrayList="
			+ ProductArrayList + "]";
}





}
