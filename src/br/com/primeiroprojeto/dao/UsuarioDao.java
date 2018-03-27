package br.com.primeiroprojeto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;


import br.com.primeiroprojetopw.conexao.Conexao;
import br.com.primeiroprojetopw.controlle.Usuario;

public class UsuarioDao {
	
	ResultSet result;
	
	public Usuario buscaUsuario(int matricula, String senha)throws SQLException{
		
		Conexao c = new Conexao();
		Connection cc = c.conectar();
		
		String consulta = "SELECT * FROM usuario WHERE matricula = "
		+ matricula+" and senha = '"+ senha+"'";
		Usuario u = null;
		
		Statement stn = (Statement) cc.createStatement();
		ResultSet result = stn.executeQuery(consulta);
		
		while (result.next()){
			u = new Usuario();
			u.setMatricula(result.getInt("Matricula"));
			u.setSenha(result.getString("senha"));
			u.setNome(result.getString("nome"));
			
		}
		c.desconectar();
		return u;
	}

}
