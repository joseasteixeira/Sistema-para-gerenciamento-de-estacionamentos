package br.com.estacionamento.classes;

public class Usuario {
	private String nome;
	private String matricula;
	private String cargo;
	private String campusFilial;
	private String senha;
	
	public Usuario() {
		
	}

	public Usuario(String nome, String matricula, String cargo, String campusFilial, String senha) {
		this.nome = nome;
		this.matricula = matricula;
		this.cargo = cargo;
		this.campusFilial = campusFilial;
		this.senha=senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getFilial() {
		return campusFilial;
	}

	public void setFilial(String campusFilial) {
		this.campusFilial = campusFilial;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
