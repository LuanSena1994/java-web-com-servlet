package br.com.cadastroalunos.dao;

import java.sql.SQLException;
import java.util.Date;

import br.com.cadastroalunos.model.Aluno;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Aluno aluno = new Aluno("luan", new Date(),"1212121" , "12121", "1212121212");
		
		AlunoDao dao = new AlunoDao();
		try {
			dao.create(aluno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
