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
import br.com.estacionamento.db.ConexaoFilial;
import br.com.estacionamento.db.ConexaoUsuario;

@SuppressWarnings("serial")
public class UsuarioAdicionar extends JFrame implements ActionListener{
	
	JLabel labelNome, labelMatricula, labelCampusFilial, labelCargo, labelSenha;
	JTextField txtNome, txtMatricula, txtCampusFilial, txtCargo, txtSenha;
	JButton btnRegistrar;
	JPanel janela;
	JComboBox<String> cargoCB;
	
	UsuarioAdicionar() {
		setTitle("Cadastro Usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		labelNome=new JLabel("Nome");
		labelNome.setBounds(40, 30, 180, 20);
		
		txtNome=new JTextField();
		txtNome.setBounds(100, 30, 180, 20);
		
		labelMatricula=new JLabel("Matricula");
		labelMatricula.setBounds(40, 60, 180, 20);
		
		txtMatricula=new JTextField();
		txtMatricula.setBounds(100, 60, 180, 20);
		
		labelCampusFilial=new JLabel("Campus");
		labelCampusFilial.setBounds(40, 90, 180, 20);
		
		txtCampusFilial=new JTextField();
		txtCampusFilial.setBounds(100, 90, 180, 20);
		
		labelCargo=new JLabel("Cargo");
		labelCargo.setBounds(40, 120, 180, 20);
		
		txtCargo=new JTextField();
		//txtCargo.setBounds(100, 120, 180, 20);
		//
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
		
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int testeCargo=0;
				int testeFilial=0;
				
				String nome=txtNome.getText();
				String matricula=txtMatricula.getText();
				String campusFilial=txtCampusFilial.getText();
				String cargo=(String)cargoCB.getSelectedItem();
				String senha=txtSenha.getText();
				
				/*do {
					testeCargo=1;
					if((!cargo.equals("Gerante"))&&(!cargo.equals("Atendente"))) {
						testeCargo=0;
						cargo=JOptionPane.showInputDialog("Cargo Invalido!"
								+ "\nTente 'Gerente' ou 'Atendente'");
					}
					
				}while(testeCargo==0);*/
				
				ConexaoFilial cf=new ConexaoFilial();
				List<Filial> lf=new ArrayList<>();
				lf=cf.listar();
				for(Filial f:lf) {
					if(f.getCompus().equals(campusFilial)){
						testeFilial=1;
					}
				}
				while(testeFilial==0) {
					campusFilial=JOptionPane.showInputDialog("Filial nao existe!"
							+ "\nDigite outra para tentar novamente.");
					for(Filial f:lf) {
						if(f.getCompus().equals(campusFilial)){
							testeFilial=1;
						}
					}
				}
				
				
				try {
					ConexaoUsuario endereco=new ConexaoUsuario();
					endereco.inserirUsuario(nome, matricula, campusFilial, cargo, senha);
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
	
}
