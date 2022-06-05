import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseBridge {

	public static Connection connect() {
		Connection connection = null;
		try {
			System.out.println("Database Connected");
			Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaFinal", "root", "");
		}catch(Exception e) {
			System.out.println("No Database Connected");
			e.printStackTrace();
		}
		return connection;
	}
}
