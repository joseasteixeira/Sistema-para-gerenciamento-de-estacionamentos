package br.com.estacionamento.ig;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;

import br.com.estacionamento.classes.Endereco;
import br.com.estacionamento.classes.Filial;
import br.com.estacionamento.classes.Usuario;
import br.com.estacionamento.db.ConexaoFilial;
import br.com.estacionamento.db.ConexaoUsuario;

public class UsuarioListar extends JFrame{
	String[] dadosLista;
	List<Usuario> usuarios=new ArrayList();

	UsuarioListar() throws SQLException{
		setTitle("Lista Filiais");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(200, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		
		ConexaoUsuario cu=new ConexaoUsuario();
		usuarios=cu.listar();
		//System.out.println(usuarios.get(0).getMatricula());
		
		dadosLista=new String[usuarios.size()];
		//System.out.println(filiais.size());
		for(int i=0;i<usuarios.size();i++) {
			dadosLista[i]=usuarios.get(i).getMatricula();
			//System.out.println(usuarios.get(i).getMatricula());
		}
		JList lista=new JList(dadosLista);
		add(BorderLayout.WEST, lista);
		
		//System.out.println(filiais.get(0).getCompus());
	}
	
}
