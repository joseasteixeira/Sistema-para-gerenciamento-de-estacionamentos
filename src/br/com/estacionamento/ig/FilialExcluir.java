package br.com.estacionamento.ig;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.estacionamento.db.ConexaoFilial;

public class FilialExcluir {
	private String campus;

	public FilialExcluir() throws SQLException{
		campus=JOptionPane.showInputDialog("informe o codigo da filial: ");
		
		ConexaoFilial cf=new ConexaoFilial();
		cf.excluir(campus);
	}
}
