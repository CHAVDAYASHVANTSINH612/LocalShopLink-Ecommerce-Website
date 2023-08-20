package com.daoJDBC;

import java.io.InputStream;

import java.sql.*;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.http.Part;



public class ProductDAO {
	
	
	String productName;
	int productPrice;
	String productDescription;
	int productCategoryId;
	int productQuantity;
	Part productPhoto; 
	int productDiscount;
	
	 String base64EncodedImage;
	
	//Blob gotImage;
	// String contentType="image/jpeg";

	
	public ArrayList<ProductDAO> ProductArrayList;
	
	
	
public Boolean addProduct(  String productName ,int productPrice, String productDescription, int productCategoryId,
		int productQuantity,Part productPhoto) {
		
		try {
			
		InputStream inputstream= productPhoto.getInputStream();
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/buyindiadatabase","root","");
		PreparedStatement pstmt= con.prepareStatement("INSERT INTO products (product_name,product_price,product_description,product_category_id,product_quantity,product_photo) "
				                                 + "  VALUES(?,?,?,?,?,?);");
		
	     pstmt.setString(1,  productName);
	     pstmt.setInt(2, productPrice);
	     pstmt.setString(3, productDescription);
	     pstmt.setInt(4, productCategoryId);
	     pstmt.setInt(5, productQuantity);
	     pstmt.setBlob(6, inputstream);
	     
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



public Boolean addProduct(  String productName ,int productPrice,  int productCategoryId, int productQuantity,
		                    int productDiscount) {
	
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





public ArrayList<ProductDAO> getProducts(int CategoryId) {
	
	try {
		
		if(CategoryId==16) {
			return getProducts();
		}
		
		ProductArrayList=new ArrayList<ProductDAO>();
		
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
	    	 // ptemp.productPhoto        = (Part) rs.getBlob("product_photo"); 
	    	  ptemp.productDiscount     = rs.getInt("product_discount");
	    	  
	    	// get image Blob  and encode it in base64 string
	    	  byte[] contentImage = rs.getBytes("product_photo");
	    	  if(contentImage !=null) {
	    	  ptemp.base64EncodedImage = new String(Base64.getEncoder().encode(contentImage), "UTF-8");
	    	
	    	  }
	    	 
	    	  ProductArrayList.add(ptemp);
	    	 
	    	 
	     }
	     rs.close();
	     con.close();
	     
	     
	}
	catch(Exception e) {
		System.out.println(e);
	}
	   
		return ProductArrayList;
	
	
}

//get all products

public ArrayList<ProductDAO> getProducts() {
	
     try {
		
		ProductArrayList=new ArrayList<ProductDAO>();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/buyindiadatabase","root","");
		
		Statement stmt= con.createStatement();
		
		
		String sql2="SELECT * from products;";
	      
		ResultSet rs=stmt.executeQuery(sql2);
		
	    
	     while(rs.next()) {
	    	 
	    	  ProductDAO ptemp=new ProductDAO();
	    	  
	    	  ptemp.productName         = rs.getString("product_name");
	    	  ptemp.productPrice        = rs.getInt("product_price");
	    	  ptemp.productDescription  = rs.getString("product_description");
	    	  ptemp.productCategoryId   = rs.getInt("product_category_id");
	    	  ptemp.productQuantity     = rs.getInt("product_quantity");
	    	  ptemp.productDiscount     = rs.getInt("product_discount");
	    	
	    
	   // get image Blob  and encode it in base64 string
	    	  byte[] contentImage = rs.getBytes("product_photo");
	    	  if(contentImage !=null) {
	    	  ptemp.base64EncodedImage = new String(Base64.getEncoder().encode(contentImage), "UTF-8");
	    	
	    	  }
	    	  
	    	 
	    	
	    	 
	    	ProductArrayList.add(ptemp);
	    	
	     }
	     rs.close();
	     con.close();
	}
	catch(Exception e) {
		System.out.println(e);
	}
	   
		return ProductArrayList;
	
}


// get products by search-box string

public ArrayList<ProductDAO> getProducts(String searchBox) {
	
	try {
		
		if(searchBox==null) {
			return getProducts();
		}
		
		ProductArrayList=new ArrayList<ProductDAO>();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/buyindiadatabase","root","");
		
		Statement stmt= con.createStatement();
		
		
		String sql2="SELECT * from products WHERE product_name LIKE '%"+searchBox+"%';";
		
	      //	System.out.println(sql2);
		ResultSet rs=stmt.executeQuery(sql2);
		
	    
	     while(rs.next()) {
	    	 
	    	 
	    	  ProductDAO ptemp=new ProductDAO();
	    	  
	    	  ptemp.productName         = rs.getString("product_name");
	    	  ptemp.productPrice        = rs.getInt("product_price");
	    	  ptemp.productDescription  = rs.getString("product_description");
	    	  ptemp.productCategoryId   = rs.getInt("product_category_id");
	    	  ptemp.productQuantity     = rs.getInt("product_quantity");
	    	
	    	  ptemp.productDiscount     = rs.getInt("product_discount");
	    	  
	    	// get image Blob  and encode it in base64 string
	    	  byte[] contentImage = rs.getBytes("product_photo");
	    	  if(contentImage !=null) {
	    	  ptemp.base64EncodedImage = new String(Base64.getEncoder().encode(contentImage), "UTF-8");
	    	 
	    	  }
	    	 
	    	  ProductArrayList.add(ptemp);
	    	 
	    	 
	     }
	     rs.close();
	     con.close();
	     
	     
	}
	catch(Exception e) {
		System.out.println(e);
	}
	   
		return ProductArrayList;
	
	
}



	
	
	
	



public int getNumOfProducts() {
	
    try {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/buyindiadatabase","root","");
	
	Statement stmt= con.createStatement();
	
	
	String sql2="SELECT COUNT(*) from products;";
      
	ResultSet rs=stmt.executeQuery(sql2);
	
    if(rs.next()) {
    	
    	return rs.getInt(1);
    	
    }
     
     rs.close();
     con.close();
}
catch(Exception e) {
	System.out.println(e);
}
   
	return 0;

}









@Override
public String toString() {
	return "ProductDAO [productName=" + productName + ", productPrice=" + productPrice + ", productDescription="
			+ productDescription + ", productCategoryId=" + productCategoryId + ", productQuantity=" + productQuantity
			+ ", productPhoto=" + productPhoto + ", productDiscount=" + productDiscount + ", ProductArrayList="
			+ ProductArrayList + "]";
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public int getProductPrice() {
	return productPrice;
}

public void setProductPrice(int productPrice) {
	this.productPrice = productPrice;
}

public String getProductDescription() {
	return productDescription;
}

public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}

public int getProductCategoryId() {
	return productCategoryId;
}

public void setProductCategoryId(int productCategoryId) {
	this.productCategoryId = productCategoryId;
}

public int getProductQuantity() {
	return productQuantity;
}

public void setProductQuantity(int productQuantity) {
	this.productQuantity = productQuantity;
}

public Part getProductPhoto() {
	return productPhoto;
}

public void setProductPhoto(Part productPhoto) {
	this.productPhoto = productPhoto;
}

public int getProductDiscount() {
	return productDiscount;
}

public void setProductDiscount(int productDiscount) {
	this.productDiscount = productDiscount;
}

public ArrayList<ProductDAO> getProductArrayList() {
	return ProductArrayList;
}

public void setProductArrayList(ArrayList<ProductDAO> productArrayList) {
	ProductArrayList = productArrayList;
}

public String getBase64EncodedImage() {
	return base64EncodedImage;
}

public void setBase64EncodedImage(String base64EncodedImage) {
	this.base64EncodedImage = base64EncodedImage;
}

//public Blob getGotImage() {
//	return gotImage;
//}
//
//public void setGotImage(Blob gotImage) {
//	this.gotImage = gotImage;
//}
//
//public String getContentType() {
//	return contentType;
//}
//
//public void setContentType(String contentType) {
//	this.contentType = contentType;
//}






}

