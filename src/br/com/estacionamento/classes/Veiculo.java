package br.com.estacionamento.classes;

public class Veiculo{
	private String placa;
	private String nomeProprietario;
	
	public Veiculo() {
		
	}

	public Veiculo(String placa, String nomeProprietario) {
		this.placa = placa;
		this.nomeProprietario = nomeProprietario;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}
	
	
}
