package Assignment1;

import java.sql.*;
import javax.swing.JOptionPane;

public final class Database {

	private static Database handler = null;
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/assignment1?useSSL=false";
	private static Connection conn = null;
	private static Statement stmt = null;
	
	public Database() throws SQLException {
		createConnection();
	}
	
	public static Database getInstance() throws SQLException {
		if(handler == null) {
			handler = new Database();
		}
		return handler;
	}
	
	public void createConnection(){
		try {
			conn = DriverManager.getConnection(DB_URL,"root","DdMmyY312138!");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Can't Load Database", "Database Error!", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
	
	public ResultSet execQuery(String query) {
		ResultSet result;
		try {
			stmt = conn.createStatement();
			result = stmt.executeQuery(query);
		} catch(SQLException ex) {
			System.out.println("Exception at execQuery:dataHandler " + ex.getLocalizedMessage());
			return null;
		} finally {
			
		}
		return result;
	}
	
	public boolean execAction(String qu) {
		try {
			stmt = conn.createStatement();
			stmt.execute(qu);
			return true;
		} catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage(), "Error Occured", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
			return false;
		} finally {
			
		}
	}
}
