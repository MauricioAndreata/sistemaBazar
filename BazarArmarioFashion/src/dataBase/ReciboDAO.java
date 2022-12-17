package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import classes.Recibo;
import interfaces.Janela;

public class ReciboDAO {
	
	public Connection conexao;
	
	public ReciboDAO() {
		this.conexao = new ConnectionFactory().getConnection();
		System.out.println("Conectado");
	}
	
	public void add(Recibo recibo) {
		
		String sql;
		PreparedStatement ps;
		try {
			sql = "create table if not exists recibos (\r\n" + 
					"  id int(11) NOT NULL auto_increment primary key,\r\n" + 
					"  siglaFornecedor varchar(255) DEFAULT NULL,\r\n" + 
					"  codigo varchar(255) DEFAULT NULL,\r\n" + 
					"  desconto double DEFAULT NULL\r\n" + 
					"  ) ENGINE=InnoDB DEFAULT CHARSET=latin1" ;
			
			ps = conexao.prepareStatement(sql);
			ps.execute();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro!");
		}
		
		sql = "insert into recibos (siglaFornecedor, codigo, desconto)" + "values(?,?,?)";
		
		try {
			
			ps = conexao.prepareStatement(sql);
			
			ps.setString(1, recibo.getFornecedor());
			ps.setString(2, recibo.getCodigo());
			ps.setDouble(3, recibo.getDesconto());
			
			ps.execute();
			ps.close();
			
			JOptionPane.showMessageDialog(Janela.getInstance(), "Cadastro Concluido!");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(Janela.getInstance(), "Deu algum erro!");
		}
	}
	
	public ArrayList<Recibo> pesquisar (String idRecibo){
		
		this.conexao = new ConnectionFactory().getConnection();
		
		String sql = "Select * from recibos where id like ?";
		
		ArrayList<Recibo> listaRecibo = new ArrayList<Recibo>();
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, idRecibo+"%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Recibo recibo = new Recibo();
				
				recibo.setId(rs.getInt("id"));
				recibo.setFornecedor(rs.getString("siglaFornecedor"));
				recibo.setCodigo(rs.getString("codigo"));
				recibo.setDesconto(rs.getDouble("desconto"));
				
				listaRecibo.add(recibo);

			}
			rs.close();
			ps.close();
			
			this.conexao.close();
			return listaRecibo;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public void removerId(String idRecibo) {
		String sql = "Delete from recibos where id = ? ";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, idRecibo);
			
			int aux = ps.executeUpdate();
			if(aux == 0)
				JOptionPane.showMessageDialog(Janela.getInstance(), "Recibo não encontrado!");
			else
				JOptionPane.showMessageDialog(Janela.getInstance(), "Recibo Removido Com Sucesso!");
			ps.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Deu errado");
		}
	}
}