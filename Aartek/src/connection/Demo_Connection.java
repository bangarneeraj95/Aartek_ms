package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Demo_Connection 
{
	public Connection connection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/aartek_ms","root","root");
		return con;
	}
}
