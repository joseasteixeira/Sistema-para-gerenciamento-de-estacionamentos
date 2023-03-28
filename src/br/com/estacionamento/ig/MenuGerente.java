package br.com.estacionamento.ig;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.com.estacionamento.classes.Login;
import br.com.estacionamento.classes.Usuario;
import br.com.estacionamento.db.ConexaoUsuario;

public class MenuGerente extends JFrame{

	Usuario usuario;

	JMenuBar barra=new JMenuBar();
	
	JMenu menuFiliais=new JMenu("Filiais");
	JMenu menuSair=new JMenu("Sair");
	JMenu menuUsuario=new JMenu("Usuário");
	
	JMenuItem itemSair1=new JMenuItem("Exit");
	JMenuItem itemFilialAdicionar=new JMenuItem("Adicionar");
	JMenuItem itemFilialListar=new JMenuItem("Listar");
	JMenuItem itemFilialEditar=new JMenuItem("Editar");
	JMenuItem itemFilialExcluir=new JMenuItem("Excluir");
	JMenuItem itemUsuarioAdicionar=new JMenuItem("Adicionar");
	JMenuItem itemUsuarioListar=new JMenuItem("Listar");
	JMenuItem itemUsuarioEditar=new JMenuItem("Editar");
	JMenuItem itemUsuarioExcluir=new JMenuItem("Excluir");
	
	public MenuGerente(String matricula, String senha){

		setJMenuBar(barra);
		barra.add(menuFiliais);
		barra.add(menuUsuario);
		barra.add(menuSair);
		
		itensFilial();
		itensSair();
		itensUsuario();
		
		usuario=buscarUsuario(matricula, senha);
		
		setTitle("Menu - "+usuario.getNome());
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}
	
	private void itensUsuario() {
		menuUsuario.add(itemUsuarioAdicionar);
		itemUsuarioAdicionar.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				UsuarioAdicionar ua=new UsuarioAdicionar();
			}
		});
		
		menuUsuario.add(itemUsuarioListar);
		itemUsuarioListar.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				try {
					UsuarioListar ul=new UsuarioListar();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		menuUsuario.add(itemUsuarioEditar);
		itemUsuarioEditar.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				try {
					UsuarioEditar ue=new UsuarioEditar();
				} catch (NullPointerException npe) {
//					efe.printStackTrace();
				}
			}
		});
		
		menuUsuario.add(itemUsuarioExcluir);
		itemUsuarioExcluir.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				try {
					UsuarioExcluir ue=new UsuarioExcluir();
				}catch(SQLException efe) {
					efe.printStackTrace();
				}
				
			}
		});
		
	}

	private void itensSair() {
		menuSair.add(itemSair1);
		itemSair1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		});
		
	}

	public void itensFilial() {
		menuFiliais.add(itemFilialAdicionar);
		itemFilialAdicionar.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				FilialAdicionar ff=new FilialAdicionar();
			}
		});
		
		menuFiliais.add(itemFilialListar);
		itemFilialListar.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				try {
					FilialListar fl=new FilialListar();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		menuFiliais.add(itemFilialEditar);
		itemFilialEditar.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				try {
					FilialEditar fe=new FilialEditar();
				} catch (NullPointerException efe) {
//					efe.printStackTrace();

				}
			}
		});
		
		menuFiliais.add(itemFilialExcluir);
		itemFilialExcluir.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				try {
					FilialExcluir fe=new FilialExcluir();
				}catch(SQLException efe) {
					efe.printStackTrace();
				}
				
			}
		});
	}
	
	public Usuario buscarUsuario(String matricula, String senha) {
		Usuario u=null;
		ConexaoUsuario cu=new ConexaoUsuario();
		List<Usuario> usuario=cu.listar();
		
		for(Usuario user:usuario) {
			if(user.getMatricula().equals(matricula)
					&&user.getSenha().equals(senha)) {
				u=user;
			}
		}
		return u;
	}
}
