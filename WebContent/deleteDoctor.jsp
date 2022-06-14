<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%
int id = Integer.parseInt(request.getParameter("id"));
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "ruralhealth";
String userid = "root";
String password = "";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
PreparedStatement statement = null;
ResultSet resultSet = null;
%>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
String sql ="delete from specialistdoctor where id=?";
PreparedStatement pstmt=connection.prepareStatement(sql);
pstmt.setInt(1, id);
int i = pstmt.executeUpdate();
if(i>0){
	response.sendRedirect("adminDash.html");
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>