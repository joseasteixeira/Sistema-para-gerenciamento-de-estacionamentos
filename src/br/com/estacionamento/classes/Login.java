package br.com.estacionamento.classes;

import java.util.List;

import br.com.estacionamento.db.ConexaoUsuario;
import br.com.estacionamento.ig.MenuGerente;

public class Login {
	private boolean teste, tCargo=false;

	public boolean getTeste() {
		return teste;
	}

	public void setTeste(boolean teste) {
		this.teste = teste;
	}
	
	public boolean getTCargo() {
		return tCargo;
	}

	public void setTCargo(boolean tCargo) {
		this.tCargo = tCargo;
	}

	public boolean verificarUsuario(String matricula, String senha) {
		teste=false;
		ConexaoUsuario cu=new ConexaoUsuario();
		List<Usuario> usuario=cu.listar();
		
		for(Usuario user:usuario) {
			if(user.getMatricula().equals(matricula)
					&&user.getSenha().equals(senha)) {
				if(user.getCargo().equals("Gerente")) {
					setTCargo(true);
				}
				teste=true;
			}
		}
		//System.out.println(u.getNome());
		return teste;
	}
}
