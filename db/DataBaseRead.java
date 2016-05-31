import java.sql.*;

/*
 * add sqlite-jdbc-3.8.11.2.jar to workpathx
 */

public class DataBaseRead {
	
	private Connection c;
	
	public DataBaseRead() {
		c = null;
		create_db_table();
	}

	private void create_db_table(){
		
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:score.db");
			if(c != null){
				Statement stmt = c.createStatement();
				stmt.execute("CREATE TABLE IF NOT EXISTS SCORE(name varChar(3),score int);");
			}
			c.close();
		}
		catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
	}
	
	public void insertScore(String name, int score){
		if(name.length() > 3){
			System.out.println("Name must be 3 characters long");
		}
		else{
			try {
				c = DriverManager.getConnection("jdbc:sqlite:score.db");
				PreparedStatement statement = c.prepareStatement( "INSERT INTO SCORE (name, score) VALUES(?,?)");
				statement.setString(1, name);
				statement.setInt(2, score);
				statement.executeUpdate();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String toString(){
		String result = "";
		try {
			c = DriverManager.getConnection("jdbc:sqlite:score.db");
			Statement stmt = c.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM SCORE ORDER BY score DESC");
			
			while(rset.next()){
				result += rset.getString(1) +": ";
				result += rset.getInt(2) + "\n";
			}
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "failed to retrieve data";
		}
	}
	
}
