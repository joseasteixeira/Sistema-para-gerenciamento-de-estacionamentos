package br.com.estacionamento.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoDB{
	public static Connection getConexao() {
		try {
			Properties prop=getProperties();
			final String url=prop.getProperty("banco.url");
			final String usuario=prop.getProperty("banco.usuario");
			final String senha=prop.getProperty("banco.senha");
			
			return DriverManager.getConnection(url, usuario, senha);
		}catch(SQLException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static Properties getProperties() throws IOException{
		Properties prop=new Properties();
		String caminho="/conexaoTxt.properties";
		prop.load(ConexaoDB.class.getResourceAsStream(caminho));
		return prop;
	}
}
