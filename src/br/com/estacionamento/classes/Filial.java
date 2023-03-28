package br.com.estacionamento.classes;

public class Filial {
	private Endereco endereco;
	private String compus;
	
	public Filial() {

	}

	public Filial(Endereco endereco, String compus) {
		this.endereco = endereco;
		this.compus = compus;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCompus() {
		return compus;
	}

	public void setCompus(String compus) {
		this.compus = compus;
	}
	
	
}
