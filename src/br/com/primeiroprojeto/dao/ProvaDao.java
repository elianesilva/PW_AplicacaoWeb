package br.com.primeiroprojeto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.primeiroprojeto.modelo.Prova;
import br.com.primeiroprojetopw.conexao.Conexao;

public class ProvaDao {
	
	
	
	public int inserirProva(Prova prova) throws SQLException{
		Conexao c = new Conexao();
		Connection cc = c.conectar();
	
		
		String consulta = "Insert into prova(dataProva, descricao)values(' "
		+ prova.getDataProva()+ "','"+prova.getDescricao()+"')";
		
		Statement stm = (Statement) cc.createStatement();
		int result = stm.executeUpdate(consulta);
		
		c.desconectar();
		return result;
	}
	
	public List<Prova> buscarProva() throws SQLException{
		Conexao c = new Conexao();
		Connection cc = c.conectar();
		List<Prova> listProva = new ArrayList<Prova>();
		
		String consulta = "SELECT * FROM prova";
		Prova a = null;
		
		Statement stn = (Statement) cc.createStatement();
		ResultSet result = stn.executeQuery(consulta);
		
		while (result.next()){
			a = new Prova();
			a.setDescricao(result.getString("descricao"));
			a.setDataProva(result.getDate("dataProva"));
			
			listProva.add(a);
		}
		c.desconectar();
	return null;	
	}
	
	
	
}
