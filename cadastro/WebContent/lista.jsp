<%@page import="br.com.cadastroalunos.model.Aluno"%>
<%@page import="java.util.List"%>
<%@page import="br.com.cadastroalunos.dao.AlunoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
	text-align: left;
}
</style>
</head>
<body>

	<a href="Update.jsp">update</a>

	<h2>Cell tfindByNamehat spans two columns</h2>
	<p>To make a cell span more than one column, use the colspan
		attribute.</p>
	<form action="lista.jsp" method="get">
		<label>Digite um nome</label> <input name="Pesquisa" type="text">
	</form>
<%String nomeTabela = request.getParameter("nome");  
String email = request.getParameter("email");%>
	<table style="width: 100%">
		<tr>
			<th>nome</th>
			<th>Endereço</th>
			<th>E-mail</th>
			<th>Telefone</th>
			<th>Data de Nascimento</th>
		</tr>
		<%
			AlunoDao dao = new AlunoDao();
			String nome = request.getParameter("Pesquisa");
			List<Aluno> listaAlunos = dao.findByName(nome);
			for (Aluno aluno : listaAlunos) {
		%>
		<tr>
			<td><%=aluno.getNome()%></td>
			<td><%=aluno.getEndereco()%></td>
			<td><%=aluno.getEmail()%></td>
			<td><%=aluno.getTelefone()%></td>
			<td><%=aluno.getDataNascimento()%></td>
			<td><a href="editar.jsp?nome=<%=aluno.getNome()%>&email=<%=aluno.getEmail()%>">update</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>
