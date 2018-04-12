package br.com.primeiroprojeto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.primeiroprojeto.modelo.Aluno;
import br.com.primeiroprojetopw.conexao.Conexao;

public class AlunoDao {
	
	
	
	public int inserirAluno(Aluno aluno) throws SQLException{
		Conexao c = new Conexao();
		Connection cc = c.conectar();
	
		
		String consulta = "Insert into aluno(nome, matricula, data_nascimento, data_matricula)values(' "
		+ aluno.getNome()+ "','"+aluno.getMatricula()+"','"+aluno.getDataNasc()+"','"+ aluno.getDataMatricula()+"')";
		
		Statement stm = (Statement) cc.createStatement();
		int result = stm.executeUpdate(consulta);
		
		c.desconectar();
		return result;
	}
	
	public List<Aluno> buscarAluno() throws SQLException{
		Conexao c = new Conexao();
		Connection cc = c.conectar();
		List<Aluno> listAlunos = new ArrayList<Aluno>();
		
		String consulta = "SELECT * FROM aluno";
		Aluno a = null;
		
		Statement stn = (Statement) cc.createStatement();
		ResultSet result = stn.executeQuery(consulta);
		
		while (result.next()){
			a = new Aluno();
			a.setMatricula(result.getString("Matricula"));
			a.setNome(result.getString("nome"));
			a.setDataMatricula(result.getDate("data_matricula"));
			a.setDataNasc(result.getDate("dataNasc"));
			
			listAlunos.add(a);
		}
		c.desconectar();
	return null;	
	}
	
	public List<Aluno> buscarAlunoPorNome(String nome) throws SQLException{
		Conexao c = new Conexao();
		Connection cc = c.conectar();
		List<Aluno> Alunos = new ArrayList<Aluno>();
		
		String consulta = "SELECT * FROM aluno were nome like '%" +nome +"%'";
		Aluno a = null;
		
		Statement stn = (Statement) cc.createStatement();
		ResultSet result = stn.executeQuery(consulta);
		
		while (result.next()){
			a = new Aluno();
			a.setMatricula(result.getString("Matricula"));
			a.setNome(result.getString("nome"));
			a.setDataMatricula(result.getDate("data_matricula"));
			a.setDataNasc(result.getDate("dataNasc"));
			
			Alunos.add(a);
		}
		c.desconectar();
	return null;	
	}

	
	public List<Aluno> buscaTodosAlunos() throws SQLException{
		Conexao c = new Conexao();
		Connection cc = c.conectar();
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		String consulta = "SELECT * FROM aluno";
		Statement stm = (Statement) cc.createStatement();
		ResultSet result = stm.executeQuery(consulta);
		
		while(result.next()){
			Aluno a = new Aluno();
			a.setNome(result.getString("nome"));
			a.setMatricula(result.getString("matricula"));
			a.setDataNasc(result.getDate("data_nascimento"));
			a.setDataMatricula(result.getDate("data_matricula"));
			
			alunos.add(a);
		}
		
		return alunos;	
	}
	
	public List<Aluno> BuscaAlunoPorNome(String nome){
		return null;
	}
}
