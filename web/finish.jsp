<%-- 
    Document   : finish
    Created on : Jun 3, 2014, 2:17:24 PM
    Author     : dead
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="business.*"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Thank you for your order</title>
        <%
            
            
            String path = (String)session.getAttribute("orderPath");
            File file = new File(path);
            BufferedReader in = 
                new BufferedReader(
                new FileReader(file));

            String line;
            String lastLine = "";
            while ((line = in.readLine()) != null)
            { 
                lastLine = line;
            }
            in.close();
            
            int orderNum = 1;
            try
            {
                orderNum += Integer.parseInt(lastLine.split("\\t")[0]);
            }
            catch(Exception e)
            {orderNum = 9999;}
            
            String f = request.getParameter("firstName");
            String l = request.getParameter("lastName");
            String e = request.getParameter("email");
            Date d = new Date();
            String dateS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(d);
            Double total = 0.0;
            ArrayList<LineItem> items = (ArrayList<LineItem>)session.getAttribute("items");
            String content =String.format("%s\t%s\t%s\t%s\t%s", orderNum,dateS,f,l,e);
            for(LineItem li : items)
            {
                CellPhone cp = li.getCellPhone();
                total += li.getTotal();
                content += String.format("\t%s:%s:%s",cp.getName(),""+cp.getPrice(),""+li.getQuantity());
            }
            content += String.format("\t%.2f",total);

            BufferedWriter bw = 
                    new BufferedWriter(
                    new FileWriter(file,true));
            bw.newLine();
            bw.write(content);
            bw.close();             
        %>
    </head>
    <body>
         
        
        <h1>Super !</h1>
        <p>Thank you <%=f%> for your order</p><br />
        <p>Total is :$ <%= String.format("%.2f",total)%></p>
        
    </body>
</html>
