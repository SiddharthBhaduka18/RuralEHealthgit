

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
 * Servlet implementation class AddCase
 */
public class AddCase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCase() {
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
//			String uDisease = "";
			String uName = request.getParameter("pname");
			String uAge = request.getParameter("age");
			String uGender = request.getParameter("gender");
			String uAddress = request.getParameter("address");
			String uMobNo = request.getParameter("mob_no");
			String uSymptom1 = request.getParameter("symptom1");
			String uSymptom2 = request.getParameter("symptom2");
			String uSymptom3 = request.getParameter("symptom3");
//			String uDisease = request.getParameter("disease");
			System.out.println("1");
			
			
			String sql ="select disease from disease where symptom1=? and symptom2=? and symptom3=?";
			PreparedStatement pstmt2 = con.prepareStatement(sql);
			pstmt2.setString(1, uSymptom1);
			pstmt2.setString(2, uSymptom2);
			pstmt2.setString(3, uSymptom3);
			ResultSet rs = pstmt2.executeQuery();
			while(rs.next())
			{
				System.out.println("1");
				String ddd = rs.getString("disease");
				System.out.println(ddd);
						
						
				String ad = "select id from aarogyavibhag where email=? and pwd=?";
				PreparedStatement pstmt6 = con.prepareStatement(ad);
				pstmt6.setString(1, SelectDisease.getEmail());
				pstmt6.setString(2, SelectDisease.getPwd());
				ResultSet rs3 = pstmt6.executeQuery();
				while(rs3.next())
				{
					int aid = rs3.getInt("id");
				
					System.out.println("2");
				
				
				
				String uDisease = rs.getString("disease");
				String s = "insert into aarogyacase values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(s);
				pstmt.setInt(1, aid);
				pstmt.setInt(2, id);
				pstmt.setString(3, uName);
				pstmt.setString(4, uAge);
				pstmt.setString(5, uGender);
				pstmt.setString(6, uAddress);
				pstmt.setString(7, uMobNo);
				pstmt.setString(8, uSymptom1);
				pstmt.setString(9, uSymptom2);
				pstmt.setString(10, uSymptom3);
				pstmt.setString(11, uDisease);
				int i = pstmt.executeUpdate();
				if(i>0)
				{
					
					String uDis = uDisease;
					String sd ="select * from specialistdoctor where diseasedtreat=?";
					PreparedStatement pstmt3 = con.prepareStatement(sd);
					pstmt3.setString(1, uDis);
					ResultSet rs1 = pstmt3.executeQuery();
					System.out.println("d");
					while(rs1.next())
					{
						int drid = rs1.getInt("id");
						String drname = rs1.getString("name");
						System.out.println("3");
						
						String ac ="select * from aarogyacase where pname=? and mob_no=?";
						PreparedStatement pstmt5 = con.prepareStatement(ac);
						pstmt5.setString(1, uName);
						pstmt5.setString(2, uMobNo);
						ResultSet rs2 = pstmt5.executeQuery();
						while(rs2.next())
						{
							int cid = rs2.getInt("pid");

							System.out.println("4");
						
						String s1 = "insert into viewdrcase values(?,?,?,?,?)";
						PreparedStatement pstmt4 = con.prepareStatement(s1);
						pstmt4.setInt(1, drid);
						pstmt4.setString(2, drname);
						pstmt4.setInt(3, cid);
						pstmt4.setString(4, uName);
						pstmt4.setString(5, uDisease);
						
						int j = pstmt4.executeUpdate();
						if(j>0)
						{
							response.sendRedirect("aarogyaDash.html");												
						}
						}
					
					}										
				}
				else
				{
					response.sendRedirect("index.html");									
				}
			}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			
			
			/*String s = "insert into aarogyacase values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setInt(1, id);
			pstmt.setString(2, uName);
			pstmt.setString(3, uAge);
			pstmt.setString(4, uGender);
			pstmt.setString(5, uAddress);
			pstmt.setString(6, uMobNo);
			pstmt.setString(7, uSymptom1);
			pstmt.setString(8, uSymptom2);
			pstmt.setString(9, uSymptom3);
			pstmt.setString(10, uDisease);
			int i = pstmt.executeUpdate();
			SelectDisease.setSymptom_1(uSymptom1);
			SelectDisease.setSymptom_2(uSymptom2);
			SelectDisease.setSymptom_3(uSymptom3);
			
			String s1 = SelectDisease.getSymptom_1();
			String s2 = SelectDisease.getSymptom_2();
			String s3 = SelectDisease.getSymptom_3();
			
			String sql ="select Disease from dataset where Symptom_1=? and Symptom_2=? and Symptom_3=?";
			PreparedStatement pstmt2 = con.prepareStatement(sql);
			pstmt2.setString(1, s1);
			pstmt2.setString(2, s2);
			pstmt2.setString(3, s3);
			ResultSet rs = pstmt.executeQuery(sql);
			
			if(i>0)
			{
				
				response.sendRedirect("PredictDisease.java");					
									
			}
			else
			{
				response.sendRedirect("index.html");									
			}*/
//			else
//			{
//				response.sendRedirect("createremind.html");	
//			}
		
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
