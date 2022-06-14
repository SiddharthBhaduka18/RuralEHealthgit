

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddAarogya
 */
public class AddAarogya extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAarogya() {
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
//			String uAccNum = request.getParameter("id");
			int id=0;
			String uName = request.getParameter("name");
			String uemail = request.getParameter("email");
			String uMobNo = request.getParameter("mob_no");
			String upwd = request.getParameter("pwd");
			String uvillage = request.getParameter("village");
			String udistrict = request.getParameter("district");
			String s = "insert into aarogyavibhag values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setInt(1, id);
			pstmt.setString(2, uName);
			pstmt.setString(3, uemail);
			pstmt.setString(4, uMobNo);
			pstmt.setString(5, upwd);
			pstmt.setString(6, uvillage);
			pstmt.setString(7, udistrict);
			int i = pstmt.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("adminDash.html");					
			}
			else
			{
				response.sendRedirect("index.html");									
			}
//			else
//			{
//				response.sendRedirect("createremind.html");	
//			}
		}catch(Exception e)
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
