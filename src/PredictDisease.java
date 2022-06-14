

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import abc.SelectDisease;

/**
 * Servlet implementation class PredictDisease
 */
public class PredictDisease extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PredictDisease() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			DbConnection db = new DbConnection();
			Connection con = db.connect();
			String s1 = SelectDisease.getSymptom_1();
			String s2 = SelectDisease.getSymptom_2();
			String s3 = SelectDisease.getSymptom_3();
			
			String sql ="select Disease from dataset where Symptom_1=? and Symptom_2=? and Symptom_3=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s1);
			pstmt.setString(2, s2);
			pstmt.setString(3, s3);
			ResultSet rs = pstmt.executeQuery(sql);
			if(rs.next())
			{
				String dis = rs.getString("Disease");
			String s = "update aarogyacase set disease=? where Symptom_1=? and Symptom_2=? and Symptom_3=?";
			PreparedStatement pstmt2 = con.prepareStatement(s);
			pstmt2.setString(1, dis);
			pstmt2.setString(2, s1);
			pstmt2.setString(3, s2);
			pstmt2.setString(4, s3);
			pstmt2.executeUpdate();
			response.sendRedirect("aarogyaDash.html");
			}
			
			
			
			
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
