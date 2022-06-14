<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<!-- <input type="text" name="comment"> -->
<%
int id = Integer.parseInt(request.getParameter("cid"));
/* String cmt = request.getParameter("comment"); */
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "ruralhealth";
String userid = "root";
String password = "";
System.out.println(id);
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
PreparedStatement statement = null;
ResultSet resultSet = null;
%>
<%-- <%
int id = Integer.parseInt(request.getParameter("cid"));
%> --%>
<input type="text" name="comment">
<a href="commentDr.jsp?comment=<%="comment"%>&cid=<%="id"%>">Comment</a>