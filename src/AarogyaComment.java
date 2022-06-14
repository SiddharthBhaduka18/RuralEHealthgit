

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
 * Servlet implementation class AarogyaComment
 */
public class AarogyaComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AarogyaComment() {
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
			/*int aid = 0;*/
			DbConnection db = new DbConnection();
			Connection con = db.connect();
			int did = Integer.parseInt(request.getParameter("did"));
			String dname = request.getParameter("dname");
			int cid = Integer.parseInt(request.getParameter("cid"));
			String cname = request.getParameter("cname");
			String disease = request.getParameter("disease");
			String avcomment = request.getParameter("avcomment");
			String comment = "";
			System.out.println(SelectDisease.getEmail());
			System.out.println(SelectDisease.getPwd());
			System.out.println("ABC");
			
			String s1 = "select id from aarogyavibhag where email=? and pwd=?";
			PreparedStatement pstmt3 = con.prepareStatement(s1);
			pstmt3.setString(1, SelectDisease.getEmail());
			pstmt3.setString(2, SelectDisease.getPwd());
			ResultSet rs = pstmt3.executeQuery();
			while(rs.next())
			{
				int dd = rs.getInt("id");
				System.out.println(dd);
			
			
				String q = "select * from addcomment where did=? and cid=?";
				PreparedStatement pstmt = con.prepareStatement(q);
				pstmt.setInt(1, did);
				pstmt.setInt(2, cid);
				ResultSet rs1 = pstmt.executeQuery();
				if(rs1.next())
				{
					String u = "update addcomment set avcomment=? where did=? and cid=?";
					PreparedStatement pstmt4 = con.prepareStatement(u);
					pstmt4.setString(1, avcomment);
					pstmt4.setInt(2, did);
					pstmt4.setInt(3, cid);
					int i = pstmt4.executeUpdate();
					if(i>0){
						response.sendRedirect("aarogyaDash.html");
					}
				}
				else
				{
			
			
			
			
			String s = "insert into addcomment values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt2 = con.prepareStatement(s);
			pstmt2.setInt(1, cmtid);
			pstmt2.setInt(2, dd);
			pstmt2.setInt(3, did);
			pstmt2.setString(4, dname);
			pstmt2.setInt(5, cid);
			pstmt2.setString(6, cname);
			pstmt2.setString(7, disease);
			pstmt2.setString(8, comment);
			pstmt2.setString(9, avcomment);
			int i = pstmt2.executeUpdate();
			if(i>0){
				response.sendRedirect("aarogyaDash.html");
			}
		}
			
			}
		}catch (Exception e) {
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
