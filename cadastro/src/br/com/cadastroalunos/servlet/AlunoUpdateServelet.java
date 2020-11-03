package br.com.cadastroalunos.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastroalunos.dao.AlunoDao;
import br.com.cadastroalunos.model.Aluno;
import br.com.cadastroalunos.utils.AlunoUtil;

/**
 * Servlet implementation class AlunoUpdateServelet
 */
@WebServlet("/alunoupdateservelet")
public class AlunoUpdateServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlunoUpdateServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubre
		
		doGet(request, response);
		Aluno aluno = new Aluno();
		aluno.setNome(request.getParameter("nome"));
		aluno.setEmail(request.getParameter("email"));
		aluno.setDataNascimento(AlunoUtil.convertToStringToDateView(request.getParameter("dataNascimento")));
		aluno.setEndereco(request.getParameter("endereco"));
		aluno.setTelefone(request.getParameter("telefone"));
		AlunoDao dao = new AlunoDao();
		dao.update(aluno);
		response.sendRedirect("lista.jsp");


		
	}

}
