package Assignment1;

import java.sql.*;

public class Student{

	static Database database;

	public static void main(String[] args) throws SQLException {
		// Connect to database
		database = Database.getInstance();

		// Retrieve results from the table]
		String qu = "Select * from Student";
		ResultSet rs = database.execQuery(qu);

		// Print columns headers
		ResultSetMetaData rsmd =rs.getMetaData(); 
		int i =rsmd.getColumnCount();

		for(int j=1; j<=i; j++) { 
			System.out.print(rsmd.getColumnName(j)); 
			System.out.print("         "); 
		} 

		System.out.println();
		// Print records
		while(rs.next( ) ) { 
			for(int j=1; j<=i; j++) { 
				System.out.print( rs.getString(j));
				System.out.print("       ");
				if(j % 3 == 0) {
					System.out.println();
				}
			}
		}


	}
}