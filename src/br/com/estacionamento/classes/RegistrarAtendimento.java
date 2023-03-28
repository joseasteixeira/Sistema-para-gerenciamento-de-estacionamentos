package br.com.estacionamento.classes;

import java.util.Date;

public class RegistrarAtendimento {
	private Veiculo veiculo;
	private Usuario atendente;
	private Date dataEntrada;
	private Date dataSaida;
	private int tempoTotal;
	private float valor;
	
	public RegistrarAtendimento() {
		
	}

	public RegistrarAtendimento(Veiculo veiculo, Usuario atendente, Date dataEntrada, Date dataSaida, int tempoTotal,
			float valor) {
		super();
		this.veiculo = veiculo;
		this.atendente = atendente;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.tempoTotal = tempoTotal;
		this.valor = valor;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Usuario getAtendente() {
		return atendente;
	}

	public void setAtendente(Usuario atendente) {
		this.atendente = atendente;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public int getTempoTotal() {
		return tempoTotal;
	}

	public void setTempoTotal(int tempoTotal) {
		this.tempoTotal = tempoTotal;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
}
