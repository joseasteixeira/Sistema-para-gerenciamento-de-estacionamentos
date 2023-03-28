package br.com.estacionamento.ig;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.estacionamento.classes.Filial;
import br.com.estacionamento.classes.Usuario;
import br.com.estacionamento.db.ConexaoFilial;
import br.com.estacionamento.db.ConexaoUsuario;

@SuppressWarnings("serial")
public class UsuarioEditar extends JFrame implements ActionListener{
	private String matricula;
	JLabel txtMatricula, labelNome, labelMatricula, labelCampusFilial, labelCargo, labelSenha;
	JTextField txtNome, txtCampusFilial, txtCargo, txtSenha;
	JButton btnRegistrar;
	JPanel janela;
	JComboBox<String> cargoCB;
	
	UsuarioEditar() {
		matricula=JOptionPane.showInputDialog("Informe o campus a editar:");
		ConexaoUsuario cu=new ConexaoUsuario();
		
		Usuario usuario=new Usuario();
		usuario=cu.editar(matricula);
		if(usuario.equals(null)) {
			return;
		}
		
		setTitle("Cadastro Usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		labelNome=new JLabel("Nome");
		labelNome.setBounds(40, 30, 180, 20);
		
		txtNome=new JTextField();
		txtNome.setBounds(100, 30, 180, 20);
		
		labelMatricula=new JLabel("Matricula");
		labelMatricula.setBounds(40, 60, 180, 20);
		
		txtMatricula=new JLabel();
		txtMatricula.setBounds(100, 60, 180, 20);
		//txtMatricula.setText(usuario.getMatricula());
		
		labelCampusFilial=new JLabel("Campus");
		labelCampusFilial.setBounds(40, 90, 180, 20);
		
		txtCampusFilial=new JTextField();
		txtCampusFilial.setBounds(100, 90, 180, 20);
		
		labelCargo=new JLabel("Cargo");
		labelCargo.setBounds(40, 120, 180, 20);
		
		txtCargo=new JTextField();
		//txtCargo.setBounds(100, 120, 180, 20);
		
		cargoCB=new JComboBox();
		cargoCB.setBounds(100, 120, 180, 20);
		
		labelSenha=new JLabel("Senha");
		labelSenha.setBounds(40, 150, 180, 20);
		
		txtSenha=new JTextField();
		txtSenha.setBounds(100, 150, 180, 20);
		
		
		btnRegistrar=new JButton();
		btnRegistrar.setBounds(200, 200, 100, 20);
		btnRegistrar.setText("Registrar");
		
		janela=new JPanel();
		janela.setLayout(null);
		
		
		janela.add(labelMatricula);
		janela.add(txtMatricula);
		janela.add(labelNome);
		janela.add(txtNome);
		janela.add(labelCampusFilial);
		janela.add(txtCampusFilial);
		janela.add(labelCargo);
		janela.add(cargoCB);
		//janela.add(txtCargo);
		janela.add(labelSenha);
		janela.add(txtSenha);
		janela.add(btnRegistrar);
		
		
		add(janela);
		setSize(400, 300);
		setVisible(true);
		vewComboBox();
		
		setTexto(usuario);
		
		
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int testeCargo=0;
				int testeUsuario=0;
				
				String nome=txtNome.getText();
				String matricula=txtMatricula.getText();
				String campusFilial=txtCampusFilial.getText();
				String cargo=(String)cargoCB.getSelectedItem();
				String senha=txtSenha.getText();
				
				try {
					ConexaoUsuario cu=new ConexaoUsuario();
					cu.editarUsuario(nome, matricula, campusFilial, cargo, senha);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				limparCampus();
				
			}
		});
		
	}

	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void limparCampus() {
		txtNome.setText("");
		txtMatricula.setText("");
		txtCampusFilial.setText("");
		//txtCargo.setText("");
		txtSenha.setText("");
	}
	
	public void vewComboBox() {
		cargoCB.addItem("Gerente");
		cargoCB.addItem("Atendente");
	}
	
	private void setTexto(Usuario usuario) {
		txtNome.setText(usuario.getNome());
		txtMatricula.setText(usuario.getMatricula());
		txtCargo.setText(usuario.getCargo());
		txtCampusFilial.setText(usuario.getFilial());
		txtSenha.setText(usuario.getSenha());
		
	}
	
}
