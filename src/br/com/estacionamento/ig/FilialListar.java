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
import br.com.estacionamento.db.ConexaoFilial;

public class FilialListar extends JFrame{
	String[] dadosLista;
	List<Filial> filiais=new ArrayList();

	FilialListar() throws SQLException{
		setTitle("Lista Filiais");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(200, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		
		ConexaoFilial cf=new ConexaoFilial();
		filiais=cf.listar();
		
		dadosLista=new String[filiais.size()];
		//System.out.println(filiais.size());
		for(int i=0;i<filiais.size();i++) {
			dadosLista[i]=filiais.get(i).getCompus();
			//System.out.println(filiais.get(i).getCompus());
		}
		JList lista=new JList(dadosLista);
		add(BorderLayout.WEST, lista);
		
		//System.out.println(filiais.get(0).getCompus());
	}
	
}
