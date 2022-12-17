package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import classes.Produto;
import interfaces.Janela;

public class ProdutoDAO {
	
	public Connection conexao;
	
	public ProdutoDAO() {
		this.conexao = new ConnectionFactory().getConnection();
		System.out.println("Conectado");
	}
	
	public void add(Produto produto) {
		String sql;
		PreparedStatement ps;
		try {
			sql = "create table if not exists produtos (\r\n" + 
					"  id int(11) NOT NULL auto_increment primary key,\r\n" + 
					"  nome varchar(255) DEFAULT NULL,\r\n" + 
					"  siglaFornecedor varchar(255) DEFAULT NULL,\r\n" + 
					"  codigo varchar(255) DEFAULT NULL,\r\n" + 
					"  precoLoja double DEFAULT NULL,\r\n" + 
					"  precoFornecedor double DEFAULT NULL,\r\n" + 
					"  descricao varchar(255) DEFAULT NULL\r\n" + 
					") ENGINE=InnoDB DEFAULT CHARSET=latin1 ";
			
			ps = conexao.prepareStatement(sql);
			ps.execute();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		sql = "insert into produtos (nome,siglaFornecedor,codigo,precoLoja,precoFornecedor,descricao)" + "values(?,?,?,?,?,?)";
		
		try {
			
			 ps = conexao.prepareStatement(sql);
			
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getFornecedor());
			ps.setString(3, produto.getCodigo());
			ps.setDouble(4, produto.getPrecoLoja());
			ps.setDouble(5, produto.getPrecoFornecedor());
			ps.setString(6, produto.getDescricao());
			
			ps.execute();
			ps.close();
			
			JOptionPane.showMessageDialog(null, "Cadastro Concluido!");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Deu algum erro!");
		}
	}
	
	public ArrayList<Produto> pesquisar (String fornecedor, String codigo){
		
		this.conexao = new ConnectionFactory().getConnection();
		
		String sql = "Select * from produtos where siglaFornecedor like ? and codigo like ?";
		
		ArrayList<Produto> listaProduto = new ArrayList<Produto>();
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, fornecedor+"%");
			ps.setString(2, codigo+"%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Produto produto = new Produto();
				
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setFornecedor(rs.getString("siglaFornecedor"));
				produto.setCodigo(rs.getString("codigo"));
				produto.setPrecoLoja(rs.getDouble("precoLoja"));
				produto.setPrecoFornecedor(rs.getDouble("precoFornecedor"));
				produto.setDescricao(rs.getString("descricao"));
				
				listaProduto.add(produto);

			}
			rs.close();
			ps.close();
			
			this.conexao.close();
			return listaProduto;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public void removerProduto(String siglaFornecedorProduto, String codigoProduto) {
		String sql = "Delete from produtos where siglaFornecedor = ? and codigo = ?";
		
		try {
			if(siglaFornecedorProduto.equals("")) {
				JOptionPane.showMessageDialog(Janela.getInstance(), "Fornecedor 'Vazio' não encontrado."+siglaFornecedorProduto);
			}else if(codigoProduto.equals("")) {
				JOptionPane.showMessageDialog(Janela.getInstance(), "Código 'Vazio' não encontrado."+codigoProduto);
			}else {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, siglaFornecedorProduto);
			ps.setString(2, codigoProduto);
			
			int aux = ps.executeUpdate();
			if(aux == 0)
				JOptionPane.showMessageDialog(Janela.getInstance(), "Produto não encontrado!");
			else
				JOptionPane.showMessageDialog(Janela.getInstance(), "Produto Removido Com Sucesso!");
			ps.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Deu errado");
		}
	}

}