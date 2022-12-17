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
import javax.swing.JTable;
import javax.swing.JTextField;

import classes.Produto;
import classes.Recibo;
import dataBase.ProdutoDAO;
import dataBase.ReciboDAO;

@SuppressWarnings("serial")
public class PesquisarReciboPainel extends JPanel implements ActionListener{
	JTextField textId;
	JLabel lblId;
	JButton btnPesquisar;
	JTable tabela;
	
	public PesquisarReciboPainel() {
		super();
		setLayout(null);
		setBackground(Color.white);
		
		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Arial", Font.PLAIN, 24));
		lblId.setBounds(50, 100, 174, 25);
		lblId.setVisible(true);
		add(lblId);

		textId = new JTextField();
		textId.setBounds(150, 100, 300, 30);
		textId.setFont(new Font("Arial", Font.PLAIN, 18));
		add(textId);
		textId.setColumns(10);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Arial", Font.BOLD, 18));
		btnPesquisar.setBounds(150, 150, 200, 60);
		add(btnPesquisar);
		btnPesquisar.addActionListener(this);
		
		tabela = new JTable(20,6);
		tabela.setVisible(true);
		tabela.setEnabled(true);
		tabela.setBounds(10,250,800,600);
		tabela.setFont(new Font("Arial", Font.PLAIN, 18));
		tabela.setRowHeight(25);
		tabela.setColumnSelectionAllowed(false);
		tabela.setRowSelectionAllowed(true);
		tabela.setDefaultEditor(Object.class, null);
		add(tabela);
		
		tabela.setValueAt("ID", 0, 0);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.setValueAt("Fornecedora", 0, 1);
		tabela.setValueAt("Código", 0, 2);
		tabela.setValueAt("Preço", 0, 3);
		tabela.setValueAt("Desconto", 0, 4);
		tabela.setValueAt("Receita Líquida", 0, 5);
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
					
				ReciboDAO cadRecibo = new ReciboDAO();
				ArrayList<Recibo> listaRecibo;
				
				listaRecibo = cadRecibo.pesquisar(textId.getText());
					
				int i = 1;
					
				for (Recibo recibo : listaRecibo) {
						
					ProdutoDAO cadProduto = new ProdutoDAO();
					ArrayList<Produto> listaProduto;
					
					listaProduto = cadProduto.pesquisar(recibo.getFornecedor(), recibo.getCodigo());
					
					tabela.setValueAt(recibo.getId(), i, 0);
					tabela.setValueAt(recibo.getFornecedor(), i, 1);
					tabela.setValueAt(recibo.getCodigo(), i, 2);
					tabela.setValueAt("R$ "+ String.format("%.2f",listaProduto.get(0).getPrecoLoja()), i, 3);
					tabela.setValueAt("R$ " + String.format("%.2f",recibo.getDesconto()), i, 4);
					tabela.setValueAt("R$ "+String.format("%.2f",(listaProduto.get(0).getPrecoLoja() - recibo.getDesconto())), i, 5);
						
					i++;
				}
			}catch(Exception error) {
				JOptionPane.showMessageDialog(Janela.getInstance(), "Não foram encontrados dados em 'Recibos'");
			}
		}
	}

}
