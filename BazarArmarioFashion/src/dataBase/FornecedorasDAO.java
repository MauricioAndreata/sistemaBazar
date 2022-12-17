package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TimeZone;

import javax.swing.JOptionPane;

import classes.Fornecedora;
import interfaces.Janela;

public class FornecedorasDAO {
	
	public Connection conexao;
	
	public FornecedorasDAO() {
		this.conexao = new ConnectionFactory().getConnection();
		System.out.println("Conectado");
	}
	
	public void add(Fornecedora fornecedora) {
		String sql;
		PreparedStatement ps;
		
		try {
			sql = "create table if not exists fornecedoras (\r\n" + 
					"  id int(11) NOT NULL auto_increment primary key,\r\n" + 
					"  nome varchar(255) DEFAULT NULL,\r\n" + 
					"  cpf varchar(255) DEFAULT NULL,\r\n" + 
					"  data_nasc date DEFAULT NULL,\r\n" + 
					"  endereco varchar(255) DEFAULT NULL,\r\n" + 
					"  cep varchar(255) DEFAULT NULL,\r\n" + 
					"  numero varchar(255) DEFAULT NULL,\r\n" + 
					"  email varchar(255) DEFAULT NULL,\r\n" + 
					"  numeroTelefone varchar(255) DEFAULT NULL,\r\n" + 
					"  sigla varchar(255) DEFAULT NULL\r\n" + 
					") ENGINE=InnoDB DEFAULT CHARSET=latin1 ";
			ps = conexao.prepareStatement(sql);
			ps.execute();
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
				
		sql = "insert into fornecedoras (nome,cpf,data_nasc,endereco,cep,numero,email,numeroTelefone, sigla)" + "values(?,?,?,?,?,?,?,?,?)";
		
		try {
			
			ps = conexao.prepareStatement(sql);
			
			ps.setString(1, fornecedora.getNome());
			ps.setString(2, fornecedora.getCpf());
			ps.setDate(3, fornecedora.getData_nasc());
			ps.setString(4, fornecedora.getEndereco());
			ps.setString(5, fornecedora.getCep());
			ps.setString(6, fornecedora.getNumero());
			ps.setString(7, fornecedora.getEmail());
			ps.setString(8, fornecedora.getNumeroTelefone());
			ps.setString(9, fornecedora.getSigla());
			
			ps.execute();
			ps.close();
			
			JOptionPane.showMessageDialog(Janela.getInstance(), "Cadastro Concluido!");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(Janela.getInstance(), "Deu algum erro!");
		}
	}
	
	public void update(Fornecedora fornecedora) {
		String sql = "UPDATE fornecedoras SET nome = ?, cpf = ?, data_nasc = ?, endereco = ?, cep = ?, numero = ?, email = ?, numeroTelefone = ? \r\n" +
					 "WHERE sigla = ?";
		
		try {
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, fornecedora.getNome());
			ps.setString(2, fornecedora.getCpf());
			ps.setDate(3, fornecedora.getData_nasc());
			ps.setString(4, fornecedora.getEndereco());
			ps.setString(5, fornecedora.getCep());
			ps.setString(6, fornecedora.getNumero());
			ps.setString(7, fornecedora.getEmail());
			ps.setString(8, fornecedora.getNumeroTelefone());
			ps.setString(9, fornecedora.getSigla());
			
			int aux = ps.executeUpdate();
			if(aux == 0)
				JOptionPane.showMessageDialog(Janela.getInstance(), "Fornecedora não encontrada!");
			else
				JOptionPane.showMessageDialog(Janela.getInstance(), "Fornecedora Atualizada Com Sucesso!");
			ps.close();
			
		}catch(Exception e) {
			System.out.println("Deu errado");
		}
	}
	
	public ArrayList<Fornecedora> pesquisar (String nomePessoa){
		
		this.conexao = new ConnectionFactory().getConnection();
		
		String sql = "Select * from fornecedoras where nome like ?";
		
		ArrayList<Fornecedora> listaFornecedora = new ArrayList<Fornecedora>();
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, nomePessoa+"%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Fornecedora fornecedora = new Fornecedora();
				
				TimeZone timeZone;
				timeZone = TimeZone.getTimeZone("GMT+0:00");
				TimeZone.setDefault(timeZone);
				
				fornecedora.setId(rs.getInt("id"));
				fornecedora.setNome(rs.getString("nome"));
				fornecedora.setCpf(rs.getString("cpf"));
				fornecedora.setData_nasc(rs.getDate("data_nasc"));
				fornecedora.setEndereco(rs.getString("endereco"));
				fornecedora.setNumero(rs.getString("numero"));
				fornecedora.setCep(rs.getString("cep"));
				fornecedora.setEmail(rs.getString("email"));
				fornecedora.setNumeroTelefone(rs.getString("numeroTelefone"));
				fornecedora.setSigla(rs.getString("sigla"));
				
				listaFornecedora.add(fornecedora);

			}
			rs.close();
			ps.close();
			
			this.conexao.close();
			return listaFornecedora;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
public ArrayList<Fornecedora> pesquisarSigla (String siglaFornecedor){
		
		this.conexao = new ConnectionFactory().getConnection();
		
		String sql = "Select * from fornecedoras where sigla like ?";
		
		ArrayList<Fornecedora> listaFornecedora = new ArrayList<Fornecedora>();
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, siglaFornecedor+"%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Fornecedora fornecedora = new Fornecedora();
				
				TimeZone timeZone;
				timeZone = TimeZone.getTimeZone("GMT+0:00");
				TimeZone.setDefault(timeZone);
				
				fornecedora.setId(rs.getInt("id"));
				fornecedora.setNome(rs.getString("nome"));
				fornecedora.setCpf(rs.getString("cpf"));
				fornecedora.setData_nasc(rs.getDate("data_nasc"));
				fornecedora.setEndereco(rs.getString("endereco"));
				fornecedora.setNumero(rs.getString("numero"));
				fornecedora.setCep(rs.getString("cep"));
				fornecedora.setEmail(rs.getString("email"));
				fornecedora.setNumeroTelefone(rs.getString("numeroTelefone"));
				fornecedora.setSigla(rs.getString("sigla"));
				
				listaFornecedora.add(fornecedora);

			}
			rs.close();
			ps.close();
			
			this.conexao.close();
			return listaFornecedora;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public void removerNome(String nomeFornecedora) {
		String sql = "Delete from fornecedoras where nome = ? ";
		
		try {
			if(nomeFornecedora.equals("")) {
				JOptionPane.showMessageDialog(Janela.getInstance(), "Nome 'Vazio' não encontrado."+nomeFornecedora);

			}else {
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setString(1, nomeFornecedora);
				
				int aux = ps.executeUpdate();
				if(aux == 0)
					JOptionPane.showMessageDialog(Janela.getInstance(), "Fornecedora não encontrada!");
				else
					JOptionPane.showMessageDialog(Janela.getInstance(), "Fornecedora Removida Com Sucesso!");
				ps.close();
			}	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Deu errado");
		}
		
	}
	
	public void removerSigla(String siglaFornecedora) {
		String sql = "Delete from fornecedoras where sigla = ? ";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, siglaFornecedora);
			
			int aux = ps.executeUpdate();
			if(aux == 0)
				JOptionPane.showMessageDialog(Janela.getInstance(), "Fornecedora não encontrada!");
			else
				JOptionPane.showMessageDialog(Janela.getInstance(), "Fornecedora Removida Com Sucesso!");
			ps.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Deu errado");
		}
	}
}