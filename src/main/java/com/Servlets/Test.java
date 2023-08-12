package com.Servlets;

import java.util.ArrayList;

import com.daoJDBC.*;

public class Test {

	public static void main(String[] args) {
		
	//UserDAO u= new UserDAO();
	
//	if(u.addUser("yashvantsinhchavda2461@gmail.com","Yash@1234")) {
//		System.out.println("added user");
//	}
//	else {
//		System.out.println("can not add user");
//	}
	
	
	
//	if(u.checkLogin("yashvantsinhchavda2461@gmail.com","Yash@1234")) {
//		
//		System.out.println("true password");
//		
//	}
//	else {
//		System.out.println("wrong password");
//	}
	
	ProductDAO p= new ProductDAO();
	
	//String productName ,int productPrice,  int productCategoryId, int productQuantity, int productDiscount
//if(p.addProduct("Asus VivoBook k15",61000,1,12,15)) {
//		
//		System.out.println("product added");
//		
//	}
//	else {
//		System.out.println("cant add product to database");
//	}
	
	ArrayList<ProductDAO> pd= p.getProductsByCategoryId(1);
	
	System.out.println(pd.toString());
	
	
	
	}
	
}
