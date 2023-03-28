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

public class ConexaoFilial {
	
	public static void inserirEndereco(String campus, String estado, String cidade, String bairro, String rua, 
			String cep, String numero) throws SQLException{

		Connection conexao=ConexaoDB.getConexao();
		String sql="insert into filial(campus, estado, cidade, bairro, rua, cep, numero) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt=conexao.prepareStatement(sql);
		stmt.setString(1, campus);
		stmt.setString(2, estado);
		stmt.setString(3, cidade);
		stmt.setString(4, bairro);
		stmt.setString(5, rua);
		stmt.setString(6, cep);
		stmt.setString(7, numero);
		
		try {
			stmt.execute();
			JOptionPane.showMessageDialog(null, "Filial incluida com sucesso!");
		}catch(SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Filial já existe!"
					+ "\n Altere o campus e tente novamente.");
		}
	}
	
public List<Filial> listar(){
        
        List<Filial> listado=new ArrayList<>();
        
        try {
            Connection conexao=ConexaoDB.getConexao();
            String sql="SELECT * FROM `filial`";
            Statement statement=conexao.createStatement();
            ResultSet resultado=statement.executeQuery(sql);
            
            while(resultado.next()){
                Filial filial=new Filial();
                filial.setCompus(resultado.getString("campus"));
                Endereco endereco=new Endereco();
                endereco.setEstado(resultado.getString("estado"));
                endereco.setCidade(resultado.getString("cidade"));
                endereco.setBairro(resultado.getString("bairro"));
                endereco.setRua(resultado.getString("rua"));
                endereco.setCep(resultado.getString("cep"));
                endereco.setNumero(resultado.getString("numero"));
                
                filial.setEndereco(endereco);
                
                listado.add(filial);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ConexaoFilial.class.getName()).log(null);
        }
        
        return listado;
    }
	
	public void excluir(String campus) throws SQLException{
		Connection conexao=ConexaoDB.getConexao();
		String sql="delete from filial where campus=?";
		PreparedStatement stmt=conexao.prepareStatement(sql);
		stmt.setString(1, campus);
		
		try {
			stmt.execute();
			JOptionPane.showMessageDialog(null, "Pessoa excluida com sucesso!");
		}catch(SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Filial já existe!"
					+ "\n Altere o campus e tente novamente.");
		}
	}
	
	public static void editarEndereco(String campus, String estado, String cidade, String bairro, String rua, 
			String cep, String numero) throws SQLException{

		Connection conexao=ConexaoDB.getConexao();
		String sql="update filial set estado=?, cidade=?, bairro=?, rua=?, cep=?, numero=? where campus=?";
		PreparedStatement stmt=conexao.prepareStatement(sql);
		
		stmt.setString(1, estado);
		stmt.setString(2, cidade);
		stmt.setString(3, bairro);
		stmt.setString(4, rua);
		stmt.setString(5, cep);
		stmt.setString(6, numero);
		stmt.setString(7, campus);
		
		try {
			stmt.execute();
			JOptionPane.showMessageDialog(null, "Pessoa alterada com sucesso!");
		}catch(SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Ocao invalida!");
		}
	}
	
	public Filial editar(String campus) {
		
		List<Filial> listado=new ArrayList<>();
		Filial filial=new Filial();
		
		listado=listar();
		
		for(Filial f: listado) {
			if(f.getCompus().equals(campus)) {
				filial=f;
				return filial;
			}
		}
		JOptionPane.showMessageDialog(null, "Filial nao encontrada!");
		return null;
	}
				
				

}
