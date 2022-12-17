package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import classes.Fornecedora;
import classes.Produto;
import dataBase.FornecedorasDAO;
import dataBase.ProdutoDAO;

@SuppressWarnings("serial")
public class PesquisarProdutoPainel extends JPanel implements ActionListener{
	JTextField textSiglaFornecedor, textCodigo;
	JLabel lblSiglaFornecedor, lblCodigo;
	JButton btnPesquisar;
	JTable tabela;

	public PesquisarProdutoPainel() {
		super();
		this.setLayout(null);
		this.setBackground(Color.white);
		
		lblSiglaFornecedor = new JLabel("Sigla do Fornecedor:");
		lblSiglaFornecedor.setFont(new Font("Arial", Font.PLAIN, 24));
		lblSiglaFornecedor.setBounds(50, 100, 240, 25);
		lblSiglaFornecedor.setVisible(true);
		add(lblSiglaFornecedor);

		textSiglaFornecedor = new JTextField();
		textSiglaFornecedor.setBounds(290, 100, 300, 30);
		textSiglaFornecedor.setFont(new Font("Arial", Font.PLAIN, 18));
		add(textSiglaFornecedor);
		textSiglaFornecedor.setColumns(10);
		
		lblCodigo = new JLabel("Código:");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 24));
		lblCodigo.setBounds(190, 150, 174, 30);
		lblCodigo.setVisible(true);
		add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(290, 150, 300, 30);
		textCodigo.setFont(new Font("Arial", Font.PLAIN, 18));
		add(textCodigo);
		textCodigo.setColumns(10);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Arial", Font.BOLD, 18));
		btnPesquisar.setBounds(190, 200, 200, 60);
		add(btnPesquisar);
		btnPesquisar.addActionListener(this);
		
		tabela = new JTable(20,6);
		tabela.setVisible(true);
		tabela.setEnabled(true);
		tabela.setBounds(10,280,800,600);
		tabela.setFont(new Font("Arial", Font.PLAIN, 18));
		tabela.setRowHeight(25);
		tabela.setColumnSelectionAllowed(false);
		tabela.setRowSelectionAllowed(true);
		tabela.setDefaultEditor(Object.class, null);
		add(tabela);
		
		tabela.setValueAt("Fornecedor", 0, 0);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
		tabela.setValueAt("Código", 0, 1);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(30);
		tabela.setValueAt("Nome", 0, 2);
		tabela.setValueAt("Preço Loja", 0, 3);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(40);
		tabela.setValueAt("Valor Fornecedora", 0, 4);
		tabela.setValueAt("Lucro Esperado", 0, 5);
		
		tabela.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int linhaSelecionada = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != 0) {
		        	if(tabela.getValueAt(linhaSelecionada, 1) != null){
		        		String nome = tabela.getValueAt(linhaSelecionada, 0).toString();
		        		String codigo = tabela.getValueAt(linhaSelecionada, 1).toString();
		        		
			        	FornecedorasDAO cadFornecedora = new FornecedorasDAO();
						ArrayList<Fornecedora> listaFornecedora;
						
						listaFornecedora = cadFornecedora.pesquisarSigla(nome);
						
						String texto = "";
						
						for (Fornecedora fornecedora : listaFornecedora) {
							texto += ("<html>Sigla: "+ fornecedora.getSigla()+
									"<br><br>Fornecedora: "+ fornecedora.getNome()+
									"<br><br>CPF: "+ fornecedora.getCpf());
						}
						ProdutoDAO cadProduto = new ProdutoDAO();
						ArrayList<Produto> listaProduto;
						
						listaProduto = cadProduto.pesquisar(nome, codigo);
						
						for (Produto produto : listaProduto) {
							
							texto += ("<br><br>Código: "+ produto.getCodigo()+
									"<br><br>Nome: "+ produto.getNome()+
									"<br><br>Preço Loja: R$ "+ String.format("%.2f", produto.getPrecoLoja())+
									"<br><br>Valor para Fornecedora: R$"+ String.format("%.2f", produto.getPrecoFornecedor())+
									"<br><br>Descrição: "+ produto.getDescricao()+"<br><br></html>");
						}
						
						JLabel sigla = new JLabel(texto);
						sigla.setFont(new Font("Arial", Font.PLAIN, 18));
						JOptionPane.showMessageDialog(Janela.getInstance(), sigla);
					}
		        }
		    }
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnPesquisar)) {
			try {
				for(int j = 1; j < tabela.getRowCount(); j++) {
					tabela.setValueAt(null, j, 0);
					tabela.setValueAt(null, j, 1);
					tabela.setValueAt(null, j, 2);
					tabela.setValueAt(null, j, 3);
					tabela.setValueAt(null, j, 4);
					tabela.setValueAt(null, j, 5);
				}
					
				ProdutoDAO cadProduto = new ProdutoDAO();
				ArrayList<Produto> listaProduto;
					
				listaProduto = cadProduto.pesquisar(textSiglaFornecedor.getText(), textCodigo.getText());
					
				if(listaProduto.size() == 0) {
					JOptionPane.showMessageDialog(Janela.getInstance(), "Não foram encontrados dados para 'Produtos'");
				}else {
					int i = 1;
						
					for (Produto produto : listaProduto) {
							
						tabela.setValueAt(produto.getFornecedor(), i, 0);
						tabela.setValueAt(produto.getCodigo(), i, 1);
						tabela.setValueAt(produto.getNome(), i, 2);
						tabela.setValueAt("R$ " + String.format("%.2f",produto.getPrecoLoja()), i, 3);
						tabela.setValueAt("R$ " + String.format("%.2f", produto.getPrecoFornecedor()), i, 4);
						tabela.setValueAt("R$ " + String.format("%.2f", (produto.getPrecoLoja() - produto.getPrecoFornecedor())), i, 5);
							
						i++;
					}
				}
			}catch(Exception error) {
				JOptionPane.showMessageDialog(Janela.getInstance(), "Não foram encontrados dados para 'Produtos'");
			}
		}
	}
}
