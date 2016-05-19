package agenda.teste;

import java.sql.Connection;
import java.sql.SQLException;

import agenda.jdbc.ConnectionFactory;

public class TestaConexao  {


	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	Connection con = new ConnectionFactory().getConnection();
	System.out.println("conexao aberta...");
	con.close();
	
	}
	
}
