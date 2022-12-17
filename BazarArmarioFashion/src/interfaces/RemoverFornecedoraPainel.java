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
import dataBase.FornecedorasDAO;


@SuppressWarnings("serial")
public class RemoverFornecedoraPainel extends JPanel implements ActionListener{
	JTextField textNome, textSigla;
	JLabel lblNome, lblSigla;
	JButton btnNome, btnSigla;

	public RemoverFornecedoraPainel() {
		super();
		this.setLayout(null);
		this.setBackground(Color.white);
		
		lblNome = new JLabel("Nome Completo:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNome.setBounds(0, 200, 200, 25);
		lblNome.setVisible(true);
		add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(210, 200, 300, 30);
		textNome.setFont(new Font("Arial", Font.PLAIN, 18));
		add(textNome);
		textNome.setColumns(10);
		
		btnNome = new JButton("Remover por Nome");
		btnNome.setFont(new Font("Arial", Font.BOLD, 18));
		btnNome.setBounds(150, 250, 220, 60);
		add(btnNome);
		btnNome.addActionListener(this);
		
		lblSigla = new JLabel("Sigla:");
		lblSigla.setFont(new Font("Arial", Font.PLAIN, 24));
		lblSigla.setBounds(120, 500, 174, 25);
		lblSigla.setVisible(true);
		add(lblSigla);

		textSigla = new JTextField();
		textSigla.setBounds(210, 500, 300, 30);
		textSigla.setFont(new Font("Arial", Font.PLAIN, 18));
		add(textSigla);
		textSigla.setColumns(10);
		
		btnSigla = new JButton("Remover por Sigla");
		btnSigla.setFont(new Font("Arial", Font.BOLD, 18));
		btnSigla.setBounds(170, 550, 200, 60);
		add(btnSigla);
		btnSigla.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnNome)) {
			if(!textNome.getText().isEmpty()) {
				FornecedorasDAO cadFornecedora = new FornecedorasDAO();
				
				String nomeFornecedora = textNome.getText();
				
				cadFornecedora.removerNome(nomeFornecedora);
				
				Janela.getInstance().RemoverFornecedoraPainel.setVisible(false);
				Janela.getInstance().FornecedorasPainel.setVisible(false);
				Janela.getInstance().PainelPrincipal.setVisible(true);
				
				textNome.setText(null);
				textSigla.setText(null);
			}else {
				JOptionPane.showMessageDialog(Janela.getInstance(), "O campo 'Nome' deve ser preenchido");
			}
		}
		
		if(e.getSource().equals(btnSigla)) {
			if(!textSigla.getText().isEmpty()) {
				FornecedorasDAO cadFornecedora = new FornecedorasDAO();
				
				String siglaFornecedora = textSigla.getText();
				
				cadFornecedora.removerSigla(siglaFornecedora);
				
				Janela.getInstance().RemoverFornecedoraPainel.setVisible(false);
				Janela.getInstance().FornecedorasPainel.setVisible(false);
				Janela.getInstance().PainelPrincipal.setVisible(true);
				
				textNome.setText(null);
				textSigla.setText(null);
			}else
				JOptionPane.showMessageDialog(Janela.getInstance(), "O campo 'Sigla' deve ser preenchido");
		}
	}
}