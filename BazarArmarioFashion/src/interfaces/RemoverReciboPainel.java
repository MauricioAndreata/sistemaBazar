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

import dataBase.ReciboDAO;

@SuppressWarnings("serial")
public class RemoverReciboPainel extends JPanel implements ActionListener{
	JTextField textId;
	JButton btnRemover;
	JLabel lblId;
	
	public RemoverReciboPainel() {
		super();
		setLayout(null);
		setBackground(Color.white);
		
		lblId = new JLabel("ID do Recibo:");
		lblId.setFont(new Font("Arial", Font.PLAIN, 24));
		lblId.setBounds(0, 350, 200, 25);
		lblId.setVisible(true);
		add(lblId);

		textId = new JTextField();
		textId.setBounds(170, 350, 300, 30);
		textId.setFont(new Font("Arial", Font.PLAIN, 18));
		add(textId);
		textId.setColumns(10);
		
		btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Arial", Font.BOLD, 18));
		btnRemover.setBounds(120, 400, 200, 60);
		add(btnRemover);
		btnRemover.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(btnRemover)) {
			if(textId.getText().isEmpty()) {
				JOptionPane.showMessageDialog(Janela.getInstance(), "ERRO\nDigite o ID do Recibo");
			}else {
				ReciboDAO cadRecibo = new ReciboDAO();
				
				String id = textId.getText();
				
				try {
					cadRecibo.removerId(id);
				}catch(Exception error) {
					JOptionPane.showMessageDialog(Janela.getInstance(), "ERRO\nNão foi possível remover recibo");
				}
				
				Janela.getInstance().RemoverReciboPainel.setVisible(false);
				Janela.getInstance().ReciboPainel.setVisible(false);
				Janela.getInstance().PainelPrincipal.setVisible(true);
			}
		}
	}

}
