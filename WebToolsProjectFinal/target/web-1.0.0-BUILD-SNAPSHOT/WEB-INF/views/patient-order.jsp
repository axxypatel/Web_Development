<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        cursor: pointer;
    }
</style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="main-wrapper">
 <div class="header-top">
<form action="add-drug.htm" method="post">
	<input class = "btn btn-success" type="submit" name="action" value="Add more drug">
</form>
    </div>
<div class="banner-section">
            <div class="banner-over">
                <h1>Order Summary </h1>
            </div>

        </div>
<h1>Order Summary </h1>
<form:form>
<table width="100%">

	<tr class="heading-row">
		<td id="td1"> Patient Name</td>
		<td id="td1"> Patient Age </td>
		<td id="td1"> Patient Mobile</td>
		<td id="td1"> Patient Address</td>
	</tr>
	
	<tr>
		<td>${finalPatient.patientName}></td>
		<td>${finalPatient.patientAge}</td>
		<td>${finalPatient.patientMobile}</td>
		<td>${finalPatient.addressLine1}</td>
	</tr>

</table> 
<br>
<br>
<table  width="100%">

	<tr class="heading-row">
	<td id="td1"> Drug Name</td>
	<td id="td1"> Drug id </td>
	<td id="td1"> Drug Dosage</td>
	<td id="td1"> Drug Quantity</td>
	</tr>

	<c:forEach items="${drugList}" var="drug">
		<tr>
			<td>${drug.drugName}</td>
			<td><input type="text" name="drugid" value="${drug.drugcomid}" readonly></td>
			<td>${drug.dosageValue}</td>
			<td><input type="text" name="qty"/></td>
		</tr>
	</c:forEach>
</table> </br></br>
<input class = "btn btn-success" type="submit" name="action" value="Submit Summary">
</form:form>

<form:form action="check-interactions.htm" method="post">
	<input class = "btn btn-success" type="submit" name="action" value="Check Interactions">
</form:form>
    </div>
</body>
</html>