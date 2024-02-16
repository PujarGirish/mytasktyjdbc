package connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Connectionpol {
	private static String url = "jdbc:postgresql://localhost:5432/Userss";
	private static String username = "postgres";
	private static String password = "123";
	private static List<Connection> connectiopool = new ArrayList<>();
	private static final int poolsize = 4;

	static {
		try {
			Class.forName("org.postgresql.Driver");
			for (int i = 0; i < poolsize; i++) {
				connectiopool.add(createConnection());

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection createConnection() {
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

	public static Connection getConnectionObject()
		{
			if (!connectiopool.isEmpty())
		     {
			return connectiopool.remove(0);	
			}
			else
			{
				return createConnection();
			}
		}
public static void reciveConnectionobject(Connection con)
{
	if (connectiopool.size()<poolsize) {
		connectiopool.add(con);
	}
	else
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
