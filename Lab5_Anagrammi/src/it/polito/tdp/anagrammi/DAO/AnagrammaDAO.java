package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {
	
	public boolean corretto(String s) {
		String sql="SELECT nome FROM parola WHERE nome=?";
		String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root&password=juventus&serverTimezone=Europe/Rome";
		boolean result;
		
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl);
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, s);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				result=true;
			}
			else {
				result=false;
			}
			conn.close();
			return result;
		}
		
		catch(SQLException e) {
			e.printStackTrace();
			return false ;
		}
		
		
	}

}
