package br.com.estacionamento.ig;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.estacionamento.classes.Filial;
import br.com.estacionamento.db.ConexaoFilial;

@SuppressWarnings("serial")
public class FilialEditar extends JFrame implements ActionListener{
	private String campus;
	JLabel dadosEndereco, labelCampus, labelEstado, labelCidade, labelBairro, labelRua, labelNumero, labelCep, txtCampus;
	JTextField txtEstado, txtCidade, txtBairro, txtRua, txtNumero, txtCep;
	JButton btnRegistrar;
	JPanel janela;

	FilialEditar(){
		campus=JOptionPane.showInputDialog("Informe o campus a editar:");
		ConexaoFilial cf=new ConexaoFilial();
		
		Filial filial=new Filial();
		filial=cf.editar(campus);
		if(filial.equals(null)) {
			return;
		}
		
		
		setTitle("Editar Filial");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		labelCampus=new JLabel("Campus");
		labelCampus.setBounds(40, 30, 180, 20);
		
		txtCampus=new JLabel();
		txtCampus.setBounds(100, 30, 180, 20);
		
		dadosEndereco=new JLabel("Dados do endereco");
		dadosEndereco.setBounds(100, 75, 200, 20);
		
		labelEstado=new JLabel("Estado");
		labelEstado.setBounds(40, 110, 180, 20);
		
		txtEstado=new JTextField();
		txtEstado.setBounds(100, 110, 180, 20);
		
		labelCidade=new JLabel("Cidade");
		labelCidade.setBounds(40, 140, 180, 20);
		
		txtCidade=new JTextField();
		txtCidade.setBounds(100, 140, 180, 20);
		
		labelBairro=new JLabel("Bairro");
		labelBairro.setBounds(40, 170, 180, 20);
		
		txtBairro=new JTextField();
		txtBairro.setBounds(100, 170, 180, 20);
		
		labelRua=new JLabel("Rua");
		labelRua.setBounds(40, 200, 180, 20);
		
		txtRua=new JTextField();
		txtRua.setBounds(100, 200, 180, 20);
		
		labelNumero=new JLabel("Numero");
		labelNumero.setBounds(40, 260, 180, 20);
		
		txtNumero=new JTextField();
		txtNumero.setBounds(100, 260, 180, 20);
		
		labelCep=new JLabel("Cep");
		labelCep.setBounds(40, 230, 180, 20);
		
		txtCep=new JTextField();
		txtCep.setBounds(100, 230, 180, 20);
		
		
		btnRegistrar=new JButton();
		btnRegistrar.setBounds(200, 300, 100, 20);
		btnRegistrar.setText("Salvar");
		
		janela=new JPanel();
		janela.setLayout(null);
		
		
		janela.add(labelCampus);
		janela.add(txtCampus);
		janela.add(dadosEndereco);
		janela.add(labelEstado);
		janela.add(txtEstado);
		janela.add(labelCidade);
		janela.add(txtCidade);
		janela.add(labelBairro);
		janela.add(txtBairro);
		janela.add(labelRua);
		janela.add(txtRua);
		janela.add(labelNumero);
		janela.add(txtNumero);
		janela.add(labelCep);
		janela.add(txtCep);
		janela.add(btnRegistrar);
		
		
		add(janela);
		setSize(400, 400);
		setVisible(true);
		
		setTexto(filial);
		
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String campus=txtCampus.getText();
				String estado=txtEstado.getText();
				String cidade=txtCidade.getText();
				String bairro=txtBairro.getText();
				String rua=txtRua.getText();
				String numero=txtNumero.getText();
				String cep=txtCep.getText();
				
				
				
				try {
					ConexaoFilial endereco=new ConexaoFilial();
					endereco.editarEndereco(campus, estado, cidade, bairro, rua, cep, numero);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				limparCampus();
				
			}
		});

	}

	private void setTexto(Filial filial) {
		txtCampus.setText(filial.getCompus());
		txtEstado.setText(filial.getEndereco().getEstado());
		txtCidade.setText(filial.getEndereco().getCidade());
		txtBairro.setText(filial.getEndereco().getBairro());
		txtRua.setText(filial.getEndereco().getRua());
		txtNumero.setText(filial.getEndereco().getCep());
		txtCep.setText(filial.getEndereco().getNumero());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void limparCampus() {
		txtCampus.setText("");
		txtEstado.setText("");
		txtCidade.setText("");
		txtBairro.setText("");
		txtRua.setText("");
		txtNumero.setText("");
		txtCep.setText("");
	}
}
