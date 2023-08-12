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
            
           

            <div class="row mt-2 style="  width:75vw"  style="box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);">
                <div class="col-md-4 offset-4 ">
                
                 <%@include file="SuccessFailMessage.jsp" %>

                    <form action="signup_user" method="post">
                        <div class="form-group mt-4">
                            <label for="exampleInputEmail1">Username(Email)</label><span
                                style="color: red; font-size: 20px;">*</span>
                            <input type="email" name="user_name" class="form-control" id="exampleInputEmail1"
                                aria-describedby="emailHelp" placeholder="Enter email as username"  required>

                        </div>

                        <div class="form-group  mt-4">
                            <label for="password">Password</label><span style="color: red; font-size: 20px;">*</span>
                            <input type="password" name="password" class="form-control" id="password"
                                aria-describedby="emailHelp" placeholder="Enter password" required>
                        </div>

                        <div class="form-group  mt-4">
                            <label for="address">Address</label>
                            <textarea class="form-control" id="address" name="address" rows="3"
                                placeholder="enter full address "></textarea>
                            <label for="address">Pincode</label>
                            <input class="form-control" type="number" id="pincode" name="pincode"
                                style="width:200px; font-size:20px">

                        </div>
                        <div class="form-group  mt-4">
                            <label for="phonenumber">Phone Number</label>
                            <input type="number" name="phonenumber" class="form-control" id="phonenumber"
                                style="width:300px" aria-describedby="emailHelp" placeholder="Enter Phone number">
                        </div>
                       <br>
                       
                     <a href="login.jsp">if already registered click here</a>
                        <div class="container mt-4 text-center">
                            <button type="submit" class="btn btn-outline-success">Register</button>
                            <button class="btn btn-outline-warning m-lg-4 ">Reset</button>
                        </div>





                    </form>
                </div>
            </div>

        </div>
    </div>

   



</body>
</html>