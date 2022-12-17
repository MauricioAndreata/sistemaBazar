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
import dataBase.FornecedorasDAO;

@SuppressWarnings("serial")
public class PesquisarFornecedoraPainel extends JPanel implements ActionListener{
	JTextField textNome;
	JLabel lblNome;
	JButton btnNome;
	JTable tabela;

	public PesquisarFornecedoraPainel() {
		super();
		this.setLayout(null);
		this.setBackground(Color.white);
		
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNome.setBounds(50, 100, 174, 25);
		lblNome.setVisible(true);
		add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(150, 100, 300, 30);
		textNome.setFont(new Font("Arial", Font.PLAIN, 18));
		add(textNome);
		textNome.setColumns(10);
		
		btnNome = new JButton("Pesquisar");
		btnNome.setFont(new Font("Arial", Font.BOLD, 18));
		btnNome.setBounds(150, 150, 200, 60);
		add(btnNome);
		btnNome.addActionListener(this);
		
		tabela = new JTable(20,3);
		tabela.setVisible(true);
		tabela.setEnabled(true);
		tabela.setFont(new Font("Arial", Font.PLAIN, 18));
		tabela.setRowHeight(25);
		tabela.setBounds(10,250,800,600);
		tabela.setColumnSelectionAllowed(false);
		tabela.setRowSelectionAllowed(true);
		tabela.setDefaultEditor(Object.class, null);
		add(tabela);
		
		tabela.setValueAt("Sigla", 0, 0);
		tabela.setValueAt("Nome", 0, 1);
		tabela.setValueAt("CPF", 0, 2);
		
		tabela.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int linhaSelecionada = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != 0) {
		        	if(tabela.getValueAt(linhaSelecionada, 1) != null){
		        		String nome = tabela.getValueAt(linhaSelecionada, 1).toString();
		        	
			        	FornecedorasDAO cadFornecedora = new FornecedorasDAO();
						ArrayList<Fornecedora> listaFornecedora;
						
						listaFornecedora = cadFornecedora.pesquisar(nome);
						
						for (Fornecedora fornecedora : listaFornecedora) {
							
							String texto = ("<html>Sigla: "+ fornecedora.getSigla()+
									"<br><br>Nome Completo: "+ fornecedora.getNome()+
									"<br><br>CPF: "+ fornecedora.getCpf()+
									"<br><br>Data de Nascimento: "+ fornecedora.getData_nasc()+
									"<br><br>Endereço: "+ fornecedora.getEndereco()+
									"<br><br>Número: "+ fornecedora.getNumero()+
									"<br><br>CEP: "+ fornecedora.getCep()+
									"<br><br>Email: "+ fornecedora.getEmail()+
									"<br><br>Telefone: "+ fornecedora.getNumeroTelefone()+ "<br><br></html>");
							
							JLabel sigla = new JLabel(texto);
							sigla.setFont(new Font("Arial", Font.PLAIN, 18));
							JOptionPane.showMessageDialog(Janela.getInstance(), sigla);
						}	
					}
		        }
		    }
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnNome)) {
			try {
				for(int j = 1; j < tabela.getRowCount(); j++) {
					tabela.setValueAt(null, j, 0);
					tabela.setValueAt(null, j, 1);
					tabela.setValueAt(null, j, 2);
				}
					
				FornecedorasDAO cadFornecedora = new FornecedorasDAO();
				ArrayList<Fornecedora> listaFornecedora;
					
				listaFornecedora = cadFornecedora.pesquisar(textNome.getText());
					
				int i = 1;
					
				for (Fornecedora fornecedora : listaFornecedora) {
						
					tabela.setValueAt(fornecedora.getSigla(), i, 0);
					tabela.setValueAt(fornecedora.getNome(), i, 1);
					tabela.setValueAt(fornecedora.getCpf(), i, 2);
						
					i++;
				}
			}catch(Exception error)	{
				JOptionPane.showMessageDialog(Janela.getInstance(), "Não foram encontrados dados em 'Fornecedoras'");
			}
		}
	}
}
