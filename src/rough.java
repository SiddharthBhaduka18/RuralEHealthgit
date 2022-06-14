

import java.io.IOException;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class rough
 */
public class rough extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rough() {
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
		String uSymptom1 = "Malaria";
//		String uSymptom2 = "skin_rash";
		String sql ="select * from specialistdoctor where diseasedtreat=?";
		PreparedStatement pstmt2 = con.prepareStatement(sql);
		pstmt2.setString(1, uSymptom1);
//		pstmt2.setString(2, uSymptom2);
//		pstmt2.setString(3, uSymptom3);
		ResultSet rs = pstmt2.executeQuery();
		System.out.println("d");
		while(rs.next())
		{
			String d = rs.getString("id");
			String n = rs.getString("name");
			System.out.println(d);
			System.out.println(n);
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
