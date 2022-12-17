package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dataBase.FornecedorasDAO;
import dataBase.ProdutoDAO;
import classes.Fornecedora;
import classes.Produto;

@SuppressWarnings("serial")
public class AddProdutoPainel extends JPanel implements ActionListener{
	JTextField textNome;
	JTextField textFornecedor;
	JTextField textCodigo;
	JTextField textPrecoLoja;
	JTextField textPrecoFornecedor;
	JTextArea textDescricao;
	JButton btnConfirmar;
	JLabel lblAdicionarCliente, lblNome, lblFornecedor, lblCodigo, lblPrecoLoja, lblPrecoFornecedor, lblDescricao;

	public AddProdutoPainel() {
		super();
		this.setLayout(null);
		this.setBackground(Color.white);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Arial", Font.BOLD, 18));
		btnConfirmar.setBounds(150, 600, 145, 60);
		add(btnConfirmar);
		btnConfirmar.addActionListener(this);
		
		lblNome = new JLabel("Nome do Produto:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNome.setBounds(0, 150, 200, 25);
		lblNome.setVisible(true);
		add(lblNome);
		
		lblFornecedor = new JLabel("Sigla do Fornecedor:");
		lblFornecedor.setFont(new Font("Arial", Font.PLAIN, 24));
		lblFornecedor.setBounds(0, 220, 250, 25);
		add(lblFornecedor);
		
		lblCodigo = new JLabel("Código do Produto:");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 24));
		lblCodigo.setBounds(0, 290, 250, 25);
		add(lblCodigo);
		
		lblPrecoLoja = new JLabel("Preço na Loja:");
		lblPrecoLoja.setFont(new Font("Arial", Font.PLAIN, 24));
		lblPrecoLoja.setBounds(0, 360, 250, 25);
		add(lblPrecoLoja);
		
		lblPrecoFornecedor = new JLabel("Preço ao Fornecedor:");
		lblPrecoFornecedor.setFont(new Font("Arial", Font.PLAIN, 24));
		lblPrecoFornecedor.setBounds(0, 430, 250, 25);
		add(lblPrecoFornecedor);
		
		lblDescricao = new JLabel("Descrição:");
		lblDescricao.setFont(new Font("Arial", Font.PLAIN, 24));
		lblDescricao.setBounds(0, 500, 170, 30);
		add(lblDescricao);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Arial", Font.PLAIN, 18));
		textNome.setBounds(210, 150, 300, 30);
		add(textNome);
		textNome.setColumns(10);
		
		textFornecedor = new JTextField();
		textFornecedor.setFont(new Font("Arial", Font.PLAIN, 18));
		textFornecedor.setColumns(10);
		textFornecedor.setBounds(240, 220, 245, 30);
		add(textFornecedor);
		
		textCodigo = new JTextField();
		textCodigo.setFont(new Font("Arial", Font.PLAIN, 18));
		textCodigo.setColumns(10);
		textCodigo.setBounds(220, 290, 215, 30);
		add(textCodigo);
		
		textPrecoLoja = new JTextField();
		textPrecoLoja.setFont(new Font("Arial", Font.PLAIN, 18));
		textPrecoLoja.setColumns(10);
		textPrecoLoja.setBounds(180, 360, 235, 30);
		add(textPrecoLoja);
		
		textPrecoFornecedor = new JTextField();
		textPrecoFornecedor.setFont(new Font("Arial", Font.PLAIN, 18));
		textPrecoFornecedor.setColumns(10);
		textPrecoFornecedor.setBounds(250, 430, 250, 30);
		add(textPrecoFornecedor);
				
		textDescricao = new JTextArea();
		textDescricao.setFont(new Font("Arial", Font.PLAIN, 18));
		textDescricao.setLineWrap(true);
		textDescricao.setWrapStyleWord(true);
		textDescricao.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
		textDescricao.setBounds(130, 500, 350, 80);
		add(textDescricao);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(btnConfirmar)) {
			if(textNome.getText().isEmpty() || textFornecedor.getText().isEmpty() || textCodigo.getText().isEmpty()) {
				JOptionPane.showMessageDialog(Janela.getInstance(), "ERRO\nProduto sem nome, fornecedor e/ou código");
			}else {
				String nome = textFornecedor.getText();
        		
	        	FornecedorasDAO cadFornecedora = new FornecedorasDAO();
				ArrayList<Fornecedora> listaFornecedora;
				
				listaFornecedora = cadFornecedora.pesquisarSigla(nome);
				
				if(listaFornecedora.size() != 0) {
					ProdutoDAO cadProduto = new ProdutoDAO();
					
					Produto produto = new Produto();
					
					produto.setNome(textNome.getText());
					produto.setFornecedor(textFornecedor.getText());
					produto.setCodigo(textCodigo.getText());
					produto.setPrecoLoja(Double.parseDouble(textPrecoLoja.getText()));
					produto.setPrecoFornecedor(Double.parseDouble(textPrecoFornecedor.getText()));
					produto.setDescricao(textDescricao.getText());
					
					cadProduto.add(produto);
					
					Janela.getInstance().AddProdutoPainel.setVisible(false);
					Janela.getInstance().FuncionariosPainel.setVisible(false);
					Janela.getInstance().PainelPrincipal.setVisible(true);
					
					textNome.setText(null);
					textFornecedor.setText(null);
					textCodigo.setText(null);
					textPrecoLoja.setText(null);
					textPrecoFornecedor.setText(null);
					textDescricao.setText(null);
				}else {
					JOptionPane.showMessageDialog(Janela.getInstance(), "ERRO\nFornecedora não encontrada no sistema!");
				}
				
			}
		}
	}
	
}
