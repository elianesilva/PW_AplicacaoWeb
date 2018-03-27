package br.com.primeiroprojetopw.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao{
	private Connection con = null;
	public Statement stmt;
	
	public Connection conectar(){
		String endereco = "jdbc:postgresql://localhost:5432/BD_WEB";
		String usuario = "postgres";
		String senha = "admim";
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(endereco, usuario, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public void desconectar(){
		
	
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	}
