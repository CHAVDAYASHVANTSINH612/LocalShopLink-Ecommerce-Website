<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Into LocalShopLink</title>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="">
    <!-- <link rel="stylesheet" href="./signup.css"> -->

</head>

<body>
    <!-- include navbar -->
     
        <%@include file="navbar.jsp" %>


    <div class="card" >
        <div class="card-body px-5">
            <h1 class="text-center mt-0 mb-3" >Register here </h1>
            
           

            <div class="row mt-2"   style="padding-left:39%">
                <div class="col-md-5">
                
                 <%@include file="SuccessFailMessage.jsp" %>

                    <form action="signup_user" method="post">
                        <div class="form-group mt-4">
                            <label for="exampleInputEmail1">Username(Email)</label><span
                                style="color: red; font-size: 20px;">*</span>
                            <input type="email" name="user_name" class="form-control" id="exampleInputEmail1"
                                aria-describedby="emailHelp" placeholder="Enter email as username"  required>

                        </div>

                        <div class="form-group  mt-2">
                            <label for="password">Password</label><span style="color: red; font-size: 20px;">*</span>
                            <input type="password" name="password" class="form-control" id="password"
                                aria-describedby="emailHelp" placeholder="Enter password" required>
                        </div>

                        <div class="form-group  mt-2">
                            <label for="address">Address</label> <span
                                style="color: red; font-size: 20px;">*</span>
                            <textarea class="form-control" id="address" name="address" rows="3"
                                placeholder="Enter full address " required></textarea>
                                
                            <label for="address">Pincode</label><span
                                style="color: red; font-size: 20px;">*</span>
                            <input class="form-control" type="number" id="pincode" name="pincode"
                                placeholder="Enter pincode"  required>

                        </div>
                        <div class="form-group  mt-2">
                            <label for="phonenumber">Phone Number</label><span
                                style="color: red; font-size: 20px;">*</span>
                            <input type="number" name="phonenumber" class="form-control" id="phonenumber"
                                 aria-describedby="emailHelp" placeholder="Enter Phone number" required>
                        </div>
                       <br>
                       
                     <a href="login.jsp">if already registered click here</a>
                        <div class="container mt-2 text-center">
                            <button type="submit" class="btn btn-success">Register</button>
                            <button class="btn btn-outline-warning m-lg-4 ">Reset</button>
                        </div>



                    </form>
                </div>
            </div>

        </div>
    </div>

   



</body>
</html>