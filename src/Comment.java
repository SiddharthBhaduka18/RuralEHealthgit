

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Comment
 */
public class Comment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Comment() {
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
			int cmtid = 0;
			int aid = 0;
			DbConnection db = new DbConnection();
			Connection con = db.connect();
			int did = Integer.parseInt(request.getParameter("did"));
			String dname = request.getParameter("dname");
			int cid = Integer.parseInt(request.getParameter("cid"));
			String cname = request.getParameter("cname");
			String disease = request.getParameter("disease");
			String comment = request.getParameter("comment");
			String avcomment = "";
			
			
			String q = "select * from addcomment where did=? and cid=?";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, did);
			pstmt.setInt(2, cid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				String u = "update addcomment set comment=? where did=? and cid=?";
				PreparedStatement pstmt3 = con.prepareStatement(u);
				pstmt3.setString(1, comment);
				pstmt3.setInt(2, did);
				pstmt3.setInt(3, cid);
				int i = pstmt3.executeUpdate();
				if(i>0){
					response.sendRedirect("specialistDash.html");
				}
			}
			else
			{
				
		
			String s = "insert into addcomment values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt2 = con.prepareStatement(s);
			pstmt2.setInt(1, cmtid);
			pstmt2.setInt(2, aid);
			pstmt2.setInt(3, did);
			pstmt2.setString(4, dname);
			pstmt2.setInt(5, cid);
			pstmt2.setString(6, cname);
			pstmt2.setString(7, disease);
			pstmt2.setString(8, comment);
			pstmt2.setString(9, avcomment);
			int j = pstmt2.executeUpdate();
			if(j>0){
				response.sendRedirect("specialistDash.html");
			}
			}
			
			}catch (Exception e) {
			e.printStackTrace();
			}

			
			
			
			
			
			
			
			
			
			
			
			
			/*String sql ="select * from viewdrcase";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				int did = rs.getInt("did");
				String dname = rs.getString("dname");
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				String disease = rs.getString("disease");

			String ucomment = request.getParameter("comment");
			String s = "insert into addcomment values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt2 = con.prepareStatement(s);
			pstmt2.setInt(1, cmt);
			pstmt2.setInt(2, did);
			pstmt2.setString(3, dname);
			pstmt2.setInt(4, cid);
			pstmt2.setString(5, cname);
			pstmt2.setString(6, disease);
			pstmt2.setString(7, ucomment);
			int i = pstmt2.executeUpdate();
			if(i>0){
				response.sendRedirect("specialistDash.html");
			}
			}
			}catch (Exception e) {
			e.printStackTrace();
			}*/
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
