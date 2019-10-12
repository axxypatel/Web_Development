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
     .banner-section{
            background: url(slider-1.jpg) no-repeat;
            height: 300px;
            background-size: cover;
            margin-left: -20px;
          margin-right: -20px;
         position: relative;
             background-position: 0 37%;
    }
    .banner-over{
        position: absolute;
        color: #fff;
        text-align: center;
        transform: translate(-50% , -50%);
        left: 50%;
        top: 50%;
        
    }
    banner-over{
            font-size: 43px;
    }
        .header-top ul{
            margin: 0;
            margin-top: 7px;
        }
        .header-top ul li{
            list-style: none;
            float: left;
        }
         .header-top ul li a {
		    text-decoration: none;
		    color: #fff;
		    padding: 5px 20px;
		    margin-right: 11px;
		    font-size: 18px;
		    border: 1px solid #fff;
		}
    .header-top form {
        width: 100px;
        float: left;
    }
   .header-top form input {
    border: 0;
    color: red;
    / background: rgba(0, 0, 0, 0) linear-gradient(to right, #92fe9d, #00c9ff) repeat scroll 0 0; /
    background: transparent;
    border: 0;
    padding: 10px 19px;
    color: #fff;
    color: #f4f4f4;
    cursor: pointer;
    border: 1px solid #fff;
    border-radius: 0;
    margin-left: 20px;
}
    table{
            background: #f2ecec;
    }
    table tr td{
        border: 0;
    }
    table .heading-row td{
        padding: 10px;
        border: 0;
    }
    table .heading-row{
        background: #92fe9d;
    }
    table tr td{
        padding: 10px;
/*        border: 1px solid #c9c9c9;*/
    }
    .btn-success{
         background: rgba(0, 0, 0, 0) linear-gradient(to right, #92fe9d, #00c9ff) repeat scroll 0 0;
         padding: 10px 19px;
        border: 0;
        border-radius: 5px;
        color: #fff;
    }
</style>
</head>
<body>
<div class="main-wrapper">
<div class="header-top ">
<form action="logout.htm" method="post">
	<input class = "btn btn-success" type="submit" name="action" value="Logout">
</form>
    </div>
     <div class="banner-section">
            <div class="banner-over">
                <h1>Patient Detail</h1>
            </div>

        </div>
<form:form commandName="patient" action="patient.htm" method="post">
	Patient Name: <form:input type="text" class="form-control" id="patientName" path="patientName" required="required"/></br>
	Patient Age: <form:input type="text" class="form-control" id="patientAge" path="patientAge" required="required"/></br>
	Patient Mobile: <form:input type="text" class="form-control" id="patientMobile" path="patientMobile" required="required"/></br>
	Address Line 1: <form:input type="text" class="form-control" id="addressLine1" path="addressLine1" required="required"/></br>
	Address Line 2: <form:input type="text" class="form-control" id="addressLine2" path="addressLine2" required="required"/></br>
	State: <form:input type="text" class="form-control" id="state" path="state" required="required"/></br>
	City: <form:input type="text" class="form-control" id="city" path="city" required="required"/></br>
	Country: <form:input type="text" class="form-control" id="country" path="country" required="required"/></br>
	Zip Code: <form:input type="text" class="form-control" id="zipcode" path="zipcode" required="required"/></br>
<input type="submit" name="Add_Patient"/></br>
</form:form>
</div>
</body>
</html>