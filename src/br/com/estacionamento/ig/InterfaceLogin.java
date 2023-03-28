package br.com.estacionamento.ig;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.estacionamento.classes.Login;
import br.com.estacionamento.classes.Usuario;
import br.com.estacionamento.db.ConexaoFilial;

public class InterfaceLogin extends JFrame{

	JLabel labelMatricula, labelSenha;
	JTextField txtMatricula;
	JPasswordField txtSenha;
	JPanel janela;
	JButton btnEntrar;
	
	public InterfaceLogin() {
		
		setTitle("Login do Usuário");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		labelMatricula=new JLabel("Matricula");
		labelMatricula.setBounds(40, 60, 180, 20);
		
		txtMatricula=new JTextField();
		txtMatricula.setBounds(100, 60, 180, 20);
		
		labelSenha=new JLabel("Senha:");
		labelSenha.setBounds(40, 90, 180, 20);
		
		txtSenha=new JPasswordField();
		txtSenha.setBounds(100, 90, 180, 20);
		
		btnEntrar=new JButton();
		btnEntrar.setBounds(180, 150, 100, 20);
		btnEntrar.setText("Entrar");
		
		janela=new JPanel();
		janela.setLayout(null);
		
		janela.add(labelMatricula);
		janela.add(txtMatricula);
		janela.add(labelSenha);
		janela.add(txtSenha);
		janela.add(btnEntrar);
		
		
		add(janela);
		setSize(400, 300);
		setVisible(true);
		
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String matricula=txtMatricula.getText();
				String senha=txtSenha.getText();
				
				Login login=new Login();
				if(login.verificarUsuario(matricula, senha)) {
					if(login.getTCargo()) {
						MenuGerente mg=new MenuGerente(matricula, senha);
					}else {
						//menu usuario
					}
				}else {
					JOptionPane.showMessageDialog(null,"Usuario nao encontrado!");
				}
				
				
//				try {
//					ConexaoFilial endereco=new ConexaoFilial();
//					endereco.editarEndereco(campus, estado, cidade, bairro, rua, cep, numero);
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
				
				limparCampus();
				
			}

			
		});
	}
	
//	public static void main(String[] args) {
//		Login login=new Login();
//	}
	
	private void limparCampus() {
		txtMatricula.setText("");
		txtSenha.setText("");
	}
	
}
