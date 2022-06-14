import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	static Connection connect()
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded......");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ruralhealth","root","");
			System.out.println("Connection Established......");
		}catch(Exception e){
			e.printStackTrace();
		}
		return(con);
	}
}
