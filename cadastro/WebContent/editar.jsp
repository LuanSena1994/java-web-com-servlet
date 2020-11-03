<%@page import="br.com.cadastroalunos.utils.AlunoUtil"%>
<%@page import="br.com.cadastroalunos.model.Aluno"%>
<%@page import="java.util.List"%>
<%@page import="br.com.cadastroalunos.dao.AlunoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="pt-br">

<head>

<meta charset="UTF-8" />
<title>Editar dados Pessoais</title>
<link rel="stylesheet" type="text/css" href="_css/estilo.css" />
<link rel="stylesheet" type="text/css" href="_css/form.css" />

</head>

<body>
	<%
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		System.out.print("nome =" + nome + " email = " + email);
	%>
	<div id="interface">

		<header id="cabecalho">

			<hgroup>

				<h1>Cadastro de Alunos</h1>
				<h2>Editar Dados Pessoais</h2>

			</hgroup>

		</header>

		<section id="corpo-full">

			<article id="noticia-principal">

				<header id="cabecalho-artigo">

					<hgroup>
						<h1>Editar Dados Pessoais</h1>
						<h3 class="direita">Atualizado em 01/Novembro/2020</h3>
					</hgroup>

				</header>

			</article>

		</section>

		<form method="post" id="fCOntato" action="alunoupdateservelet">

			<fieldset id="usuario">
				<legend>Editar Dados Pessoais</legend>
				<%
					AlunoDao dao = new AlunoDao();
					Aluno pesquisaAluno = dao.nomeEmail(nome, email);
				%>
				<p>
					<label for="cNome">Nome:</label> <input
						value=<%=pesquisaAluno.getNome()%> id="cNome" name="nome"
						type="text" size="20" maxlength="30" placeholder="Editar Nome" />
				</p>

				<p>
					<label for="cNome">Endereço:</label> <input
						value=<%=pesquisaAluno.getEndereco()%> id="cNome"
						name="endereco" type="text" size="20" maxlength="30"
						placeholder="Editar Endereço" />
				</p>

				<p>
					<label for="cNome">E-mail:</label> <input
						value=<%=pesquisaAluno.getEmail()%> id="cNome" name="email"
						type="text" size="20" maxlength="30" placeholder="Editar E-mail" />
				</p>

				<p>
					<label for="cNome">Telefone:</label> <input
						value=<%=pesquisaAluno.getTelefone()%> id="cNome"
						name="telefone" type="text" size="20" maxlength="30"
						placeholder="Editar Telefone" />
				</p>

				<p>
					Data de Nascimento:<input
						value=<%=pesquisaAluno.getDataNascimento()%> id="cNasc"
						name="dataNascimento" type="date" />
				</p>



			</fieldset>

			<!--<input id="" name="tEnviar" type="image" src="_imagens/botao-enviar.png"/> -->
			<!--<input id="" name="tEnviar" type="image" src="_imagens/botao-enviar.png"/> -->

			<button>Salvar</button>

		</form>


		<footer id="rodape">


			<p>
				Copyright 2020 - by Werike Santos<br />
				<!-- <a href="http://werike.epizy.com/?i=1" target="_blank">Site</a> | -->
				<a href="https://github.com/werikesantos/CRUD-Web_Projeto"
					target="_blank">GitHub</a>
			</p>

		</footer>