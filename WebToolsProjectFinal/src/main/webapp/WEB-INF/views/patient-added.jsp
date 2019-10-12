<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
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
</style>
</head>
<body>

<div class="header-top ">
            <form action="logout.htm" method="post">
                <input class="btn btn-success" type="submit" name="action" value="Logout">
            </form>
        </div></br></br>
	<h1>Patient Added Successfully</h1></br></br>
</body>
</html>