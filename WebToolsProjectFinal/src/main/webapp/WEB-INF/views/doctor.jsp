<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Doctor Home</title>
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
        text-align: center;
        transform: translate(-50% , -50%);
        left: 50%;
        top: 50%;
        
    }
    banner-over{
            font-size: 43px;
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
        
        <c:set var="contextPath" value="${pageContext.request.contextPath}" />
        <c:set var="patientslist" value="${patients}" />
        <div class="header-top">
            <form action="doctor-home.htm" method="post">
                <input class="btn btn-success" type="submit" name="action" value="Home">
            </form>

            <form action="logout.htm" method="post">
                <input class="btn btn-success" type="submit" name="action" value="Logout">
            </form>
        </div>
      		 
        <h1 style="color: #00c9ff;">Below are the Patients </h1>

        <table width="100%">

            <tr class="heading-row">
                <td id="td1"> Patient Name</td>
                <td id="td1"> Patient Age </td>
                <td id="td1"> Patient Mobile</td>
                <td id="td1"> Patient Address Line1</td>
                <td id="td1" colspan="2"> Patient City </td>


            </tr>
            <c:forEach items="${patientslist}" var="patient">

                <form:form action="finalPatient.htm" commandName="patientslist" method="post">
                    <tr>
                        <td><input type="text" name="pname" value="${patient.patientName}" readonly></td>
                        <td>${patient.patientAge}</td>
                        <td><input type="text" name="pmobile" value="${patient.patientMobile}" readonly></td>
                        <td>${patient.addressLine1}</td>
                        <td>${patient.state}</td>
                        <td><input class="btn btn-success" type="submit" name="action" value="Select"></td>
                    </tr>
                </form:form>


            </c:forEach>
        </table>

    </div>

</body>

</html>
