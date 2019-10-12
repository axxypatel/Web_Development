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
        min-height: 768px;
            padding-bottom: 100px;
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
            background: url("/resources/slider-1.jpg") no-repeat;
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
        .header-top ul li a{
            text-decoration: none;
            color: #000;
            padding: 10px 20px;
            margin-right: 11px;
            font-size: 18px;
        }
    .header-top form {
        width: 100px;
        float: left;
    }
    .header-top form input{
        border: 0;
        color: red;
/*        background: rgba(0, 0, 0, 0) linear-gradient(to right, #92fe9d, #00c9ff) repeat scroll 0 0;*/
        background: transparent;
        border: 0;
        padding: 10px 19px;
        color: #fff;
        color: #121212;
        cursor: pointer;

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
     .form-area {
    background-color: #fff;
    border: 2px solid #ddd;
    border-radius: 10px;
    width: 320px;
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
    margin-top: 10px;
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
            <form action="logout.htm" method="post">
                <input class="btn btn-success" type="submit" name="action" value="Logout">
            </form>
        </div>
        <div class="banner-over">
                <h1>Patient Detail</h1>
            </div>
        
        <div id="form" class="form-area">
            <form:form commandName="patient" action="patient.htm" method="post">
                <div class="form-padding">
                    <h4>Patient Detail</h4>
                    <div class="form-group">
                        <label for="">Patient Name: </label>
                        <form:input type="text" class="form-control" id="patientName" path="patientName" required="required" /><form:errors path="patientName" />
                    </div>
                    <div class="form-group">
                        <label for=""> Patient Age:</label>
                        <form:input type="text" class="form-control" id="patientAge" path="patientAge" required="required" /><form:errors path="patientAge" />
                    </div>
                    <div class="form-group">
                        <label for="">Patient Mobile: </label>
                        <form:input type="text" class="form-control" id="patientMobile" path="patientMobile" required="required" /><form:errors path="patientMobile" />
                    </div>
                    <div class="form-group">
                        <label for="">Address Line 1:</label>
                        <form:input type="text" class="form-control" id="addressLine1" path="addressLine1"  />
                    </div>
                    <div class="form-group">
                        <label for="">Address Line 2: </label>
                        <form:input type="text" class="form-control" id="addressLine2" path="addressLine2"  />
                    </div>
                    <div class="form-group">
                        <label for="">State: </label>
                        <form:input type="text" class="form-control" id="state" path="state"  />
                    </div>
                    <div class="form-group">
                        <label for="">City:</label>
                        <form:input type="text" class="form-control" id="city" path="city" required="required" /><form:errors path="city" />
                    </div>
                    <div class="form-group">
                        <label for="">Country:</label>
                        <form:input type="text" class="form-control" id="country" path="country"  />
                    </div>
                    <div class="form-group">
                        <label for="">Zip Code:</label>
                        <form:input type="text" class="form-control" id="zipcode" path="zipcode" required="required" /><form:errors path="zipcode"/></br>
                    </div>

                    </br>
                    <input type="submit" name="Add_Patient" class="btn" /></br>
                </div>
            </form:form>
        </div>
    </div>
</body>

</html>
