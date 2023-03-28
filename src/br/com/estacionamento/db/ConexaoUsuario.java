package br.com.estacionamento.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import br.com.estacionamento.classes.Endereco;
import br.com.estacionamento.classes.Filial;
import br.com.estacionamento.classes.Usuario;

public class ConexaoUsuario {
	
	public static void inserirUsuario(String nome, String matricula, String campusFilial, String cargo, String senha) throws SQLException{

		Connection conexao=ConexaoDB.getConexao();
		String sql="insert into usuario(nome, matricula, campusFilial, cargo, senha) "
				+ "values(?, ?, ?, ?, ?)";
		PreparedStatement stmt=conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.setString(2, matricula);
		stmt.setString(3, campusFilial);
		stmt.setString(4, cargo);
		stmt.setString(5, senha);
		
		try {
			stmt.execute();
			JOptionPane.showMessageDialog(null, "Usuario incluida com sucesso!");
		}catch(SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Usuario já existe!"
					+ "\n Altere a matricula e tente novamente.");
		}
	}
	
public List<Usuario> listar(){
        
        List<Usuario> listado=new ArrayList<>();
        
        try {
            Connection conexao=ConexaoDB.getConexao();
            String sql="select * from usuario";
            Statement statement=conexao.createStatement();
            ResultSet resultado=statement.executeQuery(sql);
            
            while(resultado.next()){
            	Usuario usuario=new Usuario();
            	usuario.setNome(resultado.getString("nome"));
            	usuario.setMatricula(resultado.getString("matricula"));
            	usuario.setCargo(resultado.getString("cargo"));
            	usuario.setFilial(resultado.getString("campusFilial"));
            	usuario.setSenha(resultado.getString("senha"));
                
                listado.add(usuario);
                //System.out.println(listado.get(0).getMatricula());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ConexaoUsuario.class.getName()).log(null);
        }
    	//System.out.println(listado.get(0).getMatricula());

        return listado;
    }
	
	public void excluir(String matricula) throws SQLException{
		Connection conexao=ConexaoDB.getConexao();
		String sql="delete from usuario where matricula=?";
		PreparedStatement stmt=conexao.prepareStatement(sql);
		stmt.setString(1, matricula);
		
		try {
			stmt.execute();
			JOptionPane.showMessageDialog(null, "Pessoa excluida com sucesso!");
		}catch(SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Opcao nao execultada.");
		}
	}
	
	public static void editarUsuario(String nome, String matricula, String cargo, String campusFilial, String senha) throws SQLException{

		Connection conexao=ConexaoDB.getConexao();
		String sql="update usuario set nome=?, cargo=?, campusFilial=?, senha=? where matricula=?";
		PreparedStatement stmt=conexao.prepareStatement(sql);
		
		stmt.setString(1, nome);
		stmt.setString(2, cargo);
		stmt.setString(3, campusFilial);
		stmt.setString(4, senha);
		stmt.setString(5, matricula);
		
		try {
			stmt.execute();
			JOptionPane.showMessageDialog(null, "Pessoa alterada com sucesso!");
		}catch(SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Opcao invalida!");
		}
	}
	
	public Usuario editar(String matricula) {
		
		List<Usuario> listado=new ArrayList<>();
		Usuario usuario=new Usuario();
		
		listado=listar();
		
		for(Usuario u: listado) {
			if(u.getMatricula().equals(matricula)) {
				usuario=u;
				return usuario;
			}
		}
		JOptionPane.showMessageDialog(null, "Usuario nao encontrada!");
		return null;
	}
				
				

}
