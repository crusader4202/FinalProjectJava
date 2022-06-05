import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class DatabaseController {
	
	Connection connection;

	public DatabaseController() {
		try {
			initConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void initConnection() throws SQLException {
		connection = DatabaseBridge.connect();
		if (connection == null) {
			throw new SQLException("Connection");
		}
	}
	
	public void insertMenu(String id, String itemName, String price, String stock) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "INSERT INTO menu " + "VALUES ('" + id + "', '" + itemName + "', '" + price
					+ "', '" + stock + "')";
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Vector<Vector<String>> getData() {
		Vector<Vector<String>> data = new Vector<>();
		try {
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM menu";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Vector<String> rows = new Vector<>();
				rows.add(rs.getString(1));
				rows.add(rs.getString(2));
				rows.add(rs.getString(3));
				rows.add(rs.getString(4));
				data.add(rows);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public void deleteMenu(String id) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "DELETE FROM menu " + "WHERE id = '" + id + "'";
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateMenu(String id, String price, String stock) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "UPDATE menu " + "SET price = '" + price + "', stock = '" + stock + "' WHERE id = '"+ id + "'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
