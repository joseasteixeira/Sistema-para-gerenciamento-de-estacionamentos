package br.com.estacionamento.ig;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterfaceAtendimento extends JFrame{
	
	JPanel janela;
	JLabel dadosVeiculo, LabelPlaca, LabelPrprietario;
	JTextField txtPlaca, txtProprietario;
	JLabel atendente, nomeAtendente;
	JLabel dataEntrada, dE, dataSaida, dS;
	JLabel tempoTotal, tempo, valorTotal, valor;
	

	public InterfaceAtendimento() {
		
		setTitle("Login do Usuário");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		janela=new JPanel();
		janela.setLayout(null);
		
		add(janela);
		setSize(400, 300);
		setVisible(true);
	}
}
