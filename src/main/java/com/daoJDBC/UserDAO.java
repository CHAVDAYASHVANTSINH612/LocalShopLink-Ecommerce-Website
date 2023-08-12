package com.daoJDBC;

import java.sql.*;

import java.util.*;


public class UserDAO {
	
    private int userId;
	private String userName;
	private String userPassword;
	private String userPhone;
	private String userPic;
	private String userAddress;
	
	
	public UserDAO(){
		
	}
	
	
	public boolean checkLogin(String userName,String givenPassword)  {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/buyindiadatabase","root","");
		Statement stmt= con.createStatement();
		
		
			String sql2="SELECT user_password from users WHERE user_name='"+userName+"';";
		      //	System.out.println(sql2);
			ResultSet rs=stmt.executeQuery(sql2);
			rs.next();
				
			 
			if(rs.getString(1).equals(givenPassword)){
				con.close();
				return true;
			}
			con.close();
				return false;
			
		
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return false;
		
	}
	
	public UserDAO getUser(String userName,String password) {
		
		UserDAO user= new UserDAO();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/buyindiadatabase","root","");
			Statement stmt= con.createStatement();
			
			String sqlLogin="SELECT user_id, user_name, user_phone, user_pic, user_address  FROM users WHERE user_name='"+userName+"' AND user_password='"+password+"';";
	        
		    ResultSet rs= stmt.executeQuery(sqlLogin);
		    
		   
		      if(rs.next()) {
		
	                user.userId=rs.getInt(1);
	                user.userName= rs.getString(2);
	                user.userPhone= rs.getString(3);
	                user.userPic= rs.getString(4);
	                user.userAddress=rs.getString(5);
	    
	               rs.close();
	               con.close();	    	
	    
	               return user;
		      }
		      
		      rs.close();
              con.close();	    	
             
		
		} catch(Exception e) {
			
			System.out.println(e);
			
		}
		
		return null;
		
		
	}
	
	
	public Boolean addUser(  String userName , String userPassword, String userPhone, String userPic, String userAddress) {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/buyindiadatabase","root","");
		PreparedStatement pstmt= con.prepareStatement("INSERT INTO users (user_name,user_password,user_phone,user_pic,user_address) "
				                                 + "  VALUES(?,?,?,?,?)");
		
	     pstmt.setString(1, userName);
	     pstmt.setString(2, userPassword);
	     pstmt.setString(3, userPhone);
	     pstmt.setString(4, userPic);
	     pstmt.setString(5, userAddress);
	     
	     
	    
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
	
public Boolean addUser(  String userName , String userPassword) {
		
		try {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/buyindiadatabase","root","");
		  PreparedStatement pstmt= con.prepareStatement("INSERT INTO users (user_name,user_password) "
				                                 + "  VALUES(?,?)");
		
	       pstmt.setString(1, userName);
	       pstmt.setString(2, userPassword);
	     
	     
	     
	    
	     if(pstmt.executeUpdate()>=1) {
	    	  con.close();	
	    	 return true;
	     }
	     
	     con.close();	
		
	     }catch(Exception e) {
			System.out.println(e);
	       }
		
		;	
		return false;
		
		
	}

   
public int getUserId() {
	return userId;
}


public void setUserId(int userId) {
	this.userId = userId;
}


public String getUserName() {
	return userName;
}


public void setUserName(String userName) {
	this.userName = userName;
}


public String getUserPassword() {
	return userPassword;
}


public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}


public String getUserPhone() {
	return userPhone;
}


public void setUserPhone(String userPhone) {
	this.userPhone = userPhone;
}


public String getUserPic() {
	return userPic;
}


public void setUserPic(String userPic) {
	this.userPic = userPic;
}


public String getUserAddress() {
	return userAddress;
}


public void setUserAddress(String userAddress) {
	this.userAddress = userAddress;
}


	
	
	
	
	
	
	

}
