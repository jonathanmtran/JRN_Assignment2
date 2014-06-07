<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.File"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
</head>
<body>




<h1>Checkout </h1>
<p> Please enter your information : </p>
<p>Click on the browser's Back button to continue.</p>
    <form action="<%= response.encodeURL("finish.jsp")%>" method="post">
    <table cellpadding="5" border=1>

        <tr>
            <td>
                First Name :
            </td>
  <td>
    <input type=text size=10 name="firstName" 
               value="">
  </td>
        </tr>
        <tr>
            <td>
                Last Name : 
            </td>
  <td>
    <input type=text size=10 name="lastName" 
               value="">
  </td>
        </tr>
        <tr>
            <td>
                Email
            </td>
            <td>
    <input type=text size=10 name="email" 
               value="">
            </td>
        </tr>
        <tr>
            <td>
        <input type="submit" name="finish" value="Finish">
    </form>
            </td>
    </tr>
</table>
<%@ page import="business.User, java.util.ArrayList" %>



</body>
</html>