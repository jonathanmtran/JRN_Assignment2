<%@page import="java.util.ArrayList"%>
<%@page import="java.util.StringTokenizer"%>
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

<h1>CD list</h1>

<table cellpadding="5" border=1>

  
  <tr valign="bottom">
    <td align="left"><b>Name</b></td>
    <td align="left"><b>Image</b></td>
    <td align="left"><b>Description</b></td>
    <td align="left"><b>Specs</b></td>
    <td align="left"><b>Price</b></td>
    <td align="left"></td>
  </tr> 
<%
    ServletContext sc = getServletContext();
            String path = sc.getRealPath("/WEB-INF/phones.txt");
            String path2 = sc.getRealPath("/WEB-INF/orders.txt");
            session.setAttribute("orderPath", path2);
            //String img = sc.getRealPath("WEB-INF/phones/");
    ArrayList<String[]> a = new ArrayList<String[]>();
    try
        {
            File file = new File(path);
            BufferedReader in = 
                new BufferedReader(
                new FileReader(file));

            String line = in.readLine();
            while (line != null)
            {
                String[]b = line.split("\\|"); 
                out.print("<tr valign=\"top\">"
                +"<td>"+b[1]+"</td>"
                +"<td><img src=\"phones\\"+b[2]+"\" /></td>"
                +"<td>"+b[3]+"</td>"
                +"<td>"+b[4]+"</td>"
                +"<td>"+b[5]+"</td>"
                +"<td><a href="+response.encodeURL("cart?cellPhoneCode="+b[0])+">Add To Cart</a></td></tr>");
                a.add(line.split("\\|"));
                line = in.readLine();
            }
            in.close();
        }
        catch(Exception e)
        {
        }
%>
</table>
</body>
</html>