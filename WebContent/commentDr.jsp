<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="abc.SelectDisease"%>
<!-- <input type="text" name="comment"> -->
<%
int id = Integer.parseInt(request.getParameter("cid"));
int cmtid=0;
/* String cmt = request.getParameter("comment");*/
String cmt = SelectDisease.getName();
int dd = SelectDisease.getId();
String dname = SelectDisease.getName();
String cname = SelectDisease.getCname();
String cdisease = SelectDisease.getCdisease();

String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "ruralhealth";
String userid = "root";
String password = "";
System.out.println(id);
System.out.println(dd);
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
String sql ="select * from viewdrcase where cid=?";
PreparedStatement pstmt=connection.prepareStatement(sql);
pstmt.setInt(1, id);
ResultSet rs = pstmt.executeQuery();
while(rs.next())
{
/* 	int did = rs.getInt("did");
	String dname = rs.getString("dname");
	int cid = rs.getInt("cid");
	String cname = rs.getString("cname");
	String disease = rs.getString("disease");
*/

String s = "insert into addcomment values(?,?,?,?,?,?,?)";
PreparedStatement pstmt2 = connection.prepareStatement(s);
pstmt2.setInt(1, cmtid);
pstmt2.setInt(2, dd);
pstmt2.setString(3, dname);
pstmt2.setInt(4, id);
pstmt2.setString(5, cname);
pstmt2.setString(6, cdisease);
pstmt2.setString(7, cmt);
int i = pstmt2.executeUpdate();
if(i>0){
	response.sendRedirect("addComment.jsp");
}
connection.close();
}
}catch (Exception e) {
e.printStackTrace();
}
%>