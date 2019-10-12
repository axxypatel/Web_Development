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
<div class="header-top">
<form action="doctor-home.htm" method="post">
	<input class = "btn btn-success" type="submit" name="action" value="Home">
</form>
<form action="logout.htm" method="post">
                <input class="btn btn-success" type="submit" name="action" value="Logout">
            </form>
</div>

            <div class="banner-over">
                <h1>Show Interactions</h1>
            </div>

    <br>
    <br>
<table width="100%">

<tr class="heading-row">
	<td id="td1"> Interaction String</td>
</tr>

<tr>
	<td>${interaction}</td>
</tr>


</table> 
    </div>
</body>
</html>