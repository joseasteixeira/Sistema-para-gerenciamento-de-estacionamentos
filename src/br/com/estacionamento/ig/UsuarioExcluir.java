package br.com.estacionamento.ig;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.estacionamento.db.ConexaoUsuario;

public class UsuarioExcluir {
	private String matricula;

	public UsuarioExcluir() throws SQLException{
		matricula=JOptionPane.showInputDialog("informe amatricula do usuario: ");
		
		ConexaoUsuario cu=new ConexaoUsuario();
		cu.excluir(matricula);
	}
}
