package br.com.cadastroalunos.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AlunoUtil {
	
	public static java.sql.Date convert(Date data) {
		return new java.sql.Date(data.getTime());
		
	}

	public static Date convertToStringToDate(String data) {
		Date dataFormatada = null;
		
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			dataFormatada = formato.parse(data);
		} catch (Exception e) {
		}
		return dataFormatada;
	}
	
	public static Date convertToStringToDateView(String data) {
		Date dataFormatada = null;
		
		try {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
			dataFormatada = formato.parse(data);
		} catch (Exception e) {
		}
		return dataFormatada;
	}

}
