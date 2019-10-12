<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
        .main-wrapper{
        width: 1170px;
        margin: 0 auto; 
        padding: 0px 20px;
        box-shadow: 0 0 10px #e3e3e3;
        height: 100%;
        min-height: 768px;
    }
    .header-top {
        background: #00c9ff;
        padding: 10px 0;
        margin-left: -20px;
        margin-right: -20px;
        display: block;
        height: 40px;

    }
    .form-area {
    background-color: #fff;
    border: 2px solid #ddd;
    border-radius: 10px;
    width: 400px;
    margin: 0 auto;
    margin-top: 100px;
    padding-right: 20px;
}
    .form-padding {
    padding: 20px;
}
    .form-padding h4 {
    margin: 0 0 25px;
    font-weight: 700;
}
    .form-group {
    margin-bottom: 15px;
}
    .form-area label {
    font-weight: 600;
    font-size: 12px;
    color: #575757;
}
    .form-control {
    display: block;
    width: 100%;
    height: 34px;
    padding: 6px 12px;
    font-size: 14px;
    line-height: 1.42857143;
    color: #555;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: 4px;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
    -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
    transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
}
    .form-area .form-control {
    height: 30px;
    border-radius: 30px;
    box-shadow: none;
    border: 1px solid #ddd;
}
    .btn{
            background: rgba(0, 0, 0, 0) linear-gradient(to right, #92fe9d, #00c9ff) repeat scroll 0 0;
    padding: 10px 19px;
    border: 0;
    border-radius: 5px;
    color: #fff;
        cursor: pointer;
    }
    </style>
</head>
<body>
<div class="main-wrapper">
<div class="header-top ">
    <h2 style=" margin-top: 2px; text-align: center;">Register form</h2>
    
</div>
<div id="form" class="form-area"> 
<form:form commandName="user" action="registerUser.htm" method="post">
   <div class="form-padding">
<h4>Register form</h4>
       <div class="form-group">
           <label for="">Username:</label>
           <form:input type="text" class="form-control" id="username" path="username" required="required" />
           <form:errors path="username" />
       </div>
       <div class="form-group">
           <label for="">FirstName:</label>
            <form:input type="text" class="form-control" id="firstname" path="firstName" required="required" />
            <form:errors path="firstName" />
       </div>
       <div class="form-group">
           <label for="">LastName:</label>
           <form:input type="text" class="form-control" id="lastname" path="lastName" required="required" />
           <form:errors path="lastName" />
           
       </div>
       <div class="form-group">
           <label for="">Mobile:</label>
           <form:input type="text" class="form-control" id="mobile" path="mobileNumber" required="required" />
           <form:errors path="mobileNumber" />
       </div>
       <div class="form-group">
           <label for="">Password:</label>
           <form:input type="password" class="form-control" id="password" path="password" required="required" />
           <form:errors path="password" />
       </div>
       <div class="form-group">
           <label for="">Role:</label>
           <form:select path="roleType" class="form-control" required="required">
					  <form:option value="D" label="Doctor" />
					  <form:option value="R" label="Receptionist" />
					  <form:option value="P" label="Pharmacist" />
		   </form:select>
           
       </div>
	 
	<input type="submit" name="register" class="btn"/>
    </div>
</form:form>
</div>
</div>
</body>
</html>