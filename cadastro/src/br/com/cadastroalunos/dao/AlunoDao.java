package br.com.cadastroalunos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.cadastroalunos.connection.ConnectionFactory;
import br.com.cadastroalunos.model.Aluno;
import br.com.cadastroalunos.utils.AlunoUtil;

public class AlunoDao {
	
	Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet resultSet = null;
	
	public void create(Aluno aluno) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
		String insert = "INSERT INTO aluno(nome, dataNascimento, endereco, email, telefone) VALUES (?,?,?,?,?)";
		try {
			stmt = connectionFactory.getConnection().prepareStatement(insert);
			stmt.setString(1, aluno.getNome());
			stmt.setDate(2, AlunoUtil.convert(aluno.getDataNascimento())); //ESTA CONVERTENDO O DATE DO JAVA PARA DATE DO MYSQL
			stmt.setString(3, aluno.getEndereco());
			stmt.setString(4, aluno.getEmail());
			stmt.setString(5, aluno.getTelefone());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) {
				stmt.close();
			}
		}
	}
	
	public void update(Aluno aluno) {
		 ConnectionFactory connectionFactory = new ConnectionFactory();
		String update = "Update aluno set nome = ?, dataNascimento = ?, endereco = ?, email = ?, telefone = ? WHERE nome = ?";
		
		try {
			stmt = connectionFactory.getConnection().prepareStatement(update);
			stmt.setString(1, aluno.getNome());
			stmt.setDate(2, AlunoUtil.convert(aluno.getDataNascimento())); 
			stmt.setString(3, aluno.getEndereco());
			stmt.setString(4, aluno.getEmail());
			stmt.setString(5, aluno.getTelefone());
			stmt.setString(6, aluno.getNome());//BUSCANDO ATRAVES DO NOME EM OUTRO CAMPO
			stmt.execute();
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	}
	
	public void delete(Aluno aluno) {
		 ConnectionFactory connectionFactory = new ConnectionFactory();
		String delete = "DELETE FROM aluno WHERE nome = ?";
		
		try {
			stmt = connectionFactory.getConnection().prepareStatement(delete);
			stmt.setString(1, aluno.getNome());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Aluno> findByName(String nome) {
		 ConnectionFactory connectionFactory = new ConnectionFactory();
		List<Aluno> listaAluno = new ArrayList();
		
		String select = "Select nome, dataNascimento, endereco, email, telefone FROM aluno WHERE nome = ?";
		
		try {
			stmt = connectionFactory.getConnection().prepareStatement(select);
			stmt.setString(1, nome);//
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()) {
				Aluno aluno = new Aluno();
				
				aluno.setNome(resultSet.getString("nome"));
				aluno.setDataNascimento(resultSet.getDate("dataNascimento")); //TIPO DATE
				aluno.setEndereco(resultSet.getString("endereco"));
				aluno.setEmail(resultSet.getString("email"));
				aluno.setTelefone(resultSet.getString("telefone"));
				listaAluno.add(aluno);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAluno;
	}	
    
	public Aluno nomeEmail(String nome, String email) {
		 ConnectionFactory connectionFactory = new ConnectionFactory();
		 Aluno aluno = new Aluno();
		
		String select = "Select nome, dataNascimento, endereco, email, telefone FROM aluno WHERE nome = ? and email = ?";
		
		try {
			stmt = connectionFactory.getConnection().prepareStatement(select);
			stmt.setString(1, nome);
			stmt.setString(2, email);
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()) {
				
				
				aluno.setNome(resultSet.getString("nome"));
				aluno.setDataNascimento(resultSet.getDate("dataNascimento")); //TIPO DATE
				aluno.setEndereco(resultSet.getString("endereco"));
				aluno.setEmail(resultSet.getString("email"));
				aluno.setTelefone(resultSet.getString("telefone"));
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aluno;
	}	
    

}
