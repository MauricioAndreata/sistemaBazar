package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.Fornecedora;
import classes.Produto;
import classes.Recibo;
import dataBase.FornecedorasDAO;
import dataBase.ProdutoDAO;
import dataBase.ReciboDAO;

@SuppressWarnings("serial")
public class AddReciboPainel extends JPanel implements ActionListener{
	JButton btnConfirmar;
	JTextField textFornecedor;
	JTextField textCodigo;
	JTextField textDesconto;
	JLabel lblFornecedor, lblCodigo, lblDesconto;

	public AddReciboPainel() {
		super();
		setLayout(null);
		setBackground(Color.white);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Arial", Font.BOLD, 18));
		btnConfirmar.setBounds(150, 500, 145, 60);
		add(btnConfirmar);
		btnConfirmar.addActionListener(this);
		
		lblFornecedor = new JLabel("Sigla do Fornecedor:");
		lblFornecedor.setFont(new Font("Arial", Font.PLAIN, 24));
		lblFornecedor.setBounds(0, 290, 250, 25);
		add(lblFornecedor);
		
		lblCodigo = new JLabel("Código do Produto:");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 24));
		lblCodigo.setBounds(0, 360, 250, 25);
		add(lblCodigo);
		
		lblDesconto = new JLabel("Desconto (Se houver):");
		lblDesconto.setFont(new Font("Arial", Font.PLAIN, 24));
		lblDesconto.setBounds(0, 430, 250, 25);
		add(lblDesconto);
		
		textFornecedor = new JTextField();
		textFornecedor.setFont(new Font("Arial", Font.PLAIN, 18));
		textFornecedor.setColumns(10);
		textFornecedor.setBounds(230, 290, 215, 30);
		add(textFornecedor);
		
		textCodigo = new JTextField();
		textCodigo.setFont(new Font("Arial", Font.PLAIN, 18));
		textCodigo.setColumns(10);
		textCodigo.setBounds(220, 360, 235, 30);
		add(textCodigo);
		
		textDesconto = new JTextField();
		textDesconto.setFont(new Font("Arial", Font.PLAIN, 18));
		textDesconto.setColumns(10);
		textDesconto.setBounds(250, 430, 250, 30);
		add(textDesconto);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(btnConfirmar)) {
			if(textFornecedor.getText().isEmpty() || textCodigo.getText().isEmpty()) {
				JOptionPane.showMessageDialog(Janela.getInstance(), "ERRO\nRecibo sem fornecedor e/ou código");
			}else {
				String nome = textFornecedor.getText();
        		
	        	FornecedorasDAO cadFornecedora = new FornecedorasDAO();
				ArrayList<Fornecedora> listaFornecedora;
				
				listaFornecedora = cadFornecedora.pesquisarSigla(nome);
				
				String codigo = textCodigo.getText();
        		
	        	ProdutoDAO cadProduto = new ProdutoDAO();
				ArrayList<Produto> listaProduto;
				
				listaProduto = cadProduto.pesquisar(nome, codigo);
				
				if(listaFornecedora.size() != 0) {
					if(listaProduto.size() != 0) {
						ReciboDAO cadRecibo = new ReciboDAO();
						
						Recibo recibo = new Recibo();
						
						recibo.setFornecedor(textFornecedor.getText());
						recibo.setCodigo(textCodigo.getText());
						if(textDesconto.getText().isEmpty())
							recibo.setDesconto(0.00);
						else
							recibo.setDesconto(Double.parseDouble(textDesconto.getText()));
						
						try {
							cadRecibo.add(recibo);
						}catch(Exception error) {
							JOptionPane.showMessageDialog(Janela.getInstance(), "ERRO\nNão foi possível adicionar recibo");
						}
						
						Janela.getInstance().AddReciboPainel.setVisible(false);
						Janela.getInstance().ReciboPainel.setVisible(false);
						Janela.getInstance().PainelPrincipal.setVisible(true);
						
						textFornecedor.setText(null);
						textCodigo.setText(null);
						textDesconto.setText(null);
					}else {
						JOptionPane.showMessageDialog(Janela.getInstance(), "ERRO\nProduto não encontrado no sistema!");
					}
				}else {
					JOptionPane.showMessageDialog(Janela.getInstance(), "ERRO\nFornecedora não encontrada no sistema!");
				}
			}
		}
	}

}
