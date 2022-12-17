package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import dataBase.ProdutoDAO;

@SuppressWarnings("serial")
public class RemoverProdutoPainel extends JPanel implements ActionListener{
	JTextField textSiglaFornecedor, textCodigo;
	JLabel lblSiglaFornecedor, lblCodigo, lblE;
	JButton btnRemover;

	public RemoverProdutoPainel() {
		super();
		this.setLayout(null);
		this.setBackground(Color.white);
		
		lblSiglaFornecedor = new JLabel("Sigla Fornecedora:");
		lblSiglaFornecedor.setFont(new Font("Arial", Font.PLAIN, 24));
		lblSiglaFornecedor.setBounds(0, 300, 250, 30);
		lblSiglaFornecedor.setVisible(true);
		add(lblSiglaFornecedor);

		textSiglaFornecedor = new JTextField();
		textSiglaFornecedor.setBounds(210, 300, 300, 30);
		textSiglaFornecedor.setFont(new Font("Arial", Font.PLAIN, 18));
		add(textSiglaFornecedor);
		textSiglaFornecedor.setColumns(10);
		
		lblE = new JLabel("E");
		lblE.setFont(new Font("Arial", Font.PLAIN, 24));
		lblE.setBounds(150, 350, 100, 30);
		lblE.setVisible(true);
		add(lblE);
		
		lblCodigo = new JLabel("Código:");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 24));
		lblCodigo.setBounds(120, 400, 174, 30);
		lblCodigo.setVisible(true);
		add(lblCodigo);

		textCodigo = new JTextField();
		textCodigo.setBounds(210, 400, 300, 30);
		textCodigo.setFont(new Font("Arial", Font.PLAIN, 18));
		add(textCodigo);
		textCodigo.setColumns(10);
		
		btnRemover = new JButton("Remover");
		btnRemover.setBounds(120, 450, 200, 60);
		btnRemover.setFont(new Font("Arial", Font.BOLD, 18));
		add(btnRemover);
		btnRemover.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnRemover)) {
			if(!textSiglaFornecedor.getText().isBlank() && !textCodigo.getText().isEmpty()) {
				ProdutoDAO cadProduto = new ProdutoDAO();
				
				String siglaFornecedorProduto = textSiglaFornecedor.getText();
				String codigoProduto = textCodigo.getText();
				
				cadProduto.removerProduto(siglaFornecedorProduto, codigoProduto);
				
				Janela.getInstance().RemoverProdutoPainel.setVisible(false);
				Janela.getInstance().FuncionariosPainel.setVisible(false);
				Janela.getInstance().PainelPrincipal.setVisible(true);
				
				textSiglaFornecedor.setText(null);
				textCodigo.setText(null);
			}else
				JOptionPane.showMessageDialog(Janela.getInstance(), "Ambos os campos devem ser preenchidos");
		}
	}
}