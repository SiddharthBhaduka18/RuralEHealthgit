<%--
    Document   : index
    Created on : Sep 16, 2017, 9:19:42 PM //last updated Feb 22, 2018, 23:07:00 PM
    Author     : Dharmesh
--%>

<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="FileUploadServlet" method="post" enctype="multipart/form-data">
            <table width="400px" align="center" border=2>
                <tr>
                    <td align="center" colspan="2">Form Details</td>
                </tr>
                <tr>
                    <td>Id </td>
                    <td><input type="number" name="did" /></td>
                </tr>
                <tr>
                    <td>PID</td>
                    <td>
                        <input type="text" name="pid">
                    </td>
                </tr>
                
                <tr>
                    <td>Image Link: </td>
                    <td>
                        <input type="file" name="file">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit"></td>
                </tr>
            </table>

        </form><br>
    <center><a href="viewAll.jsp">View All </a></center>
</body>
</html>
