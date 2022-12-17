package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class InstrucoesPainel extends JPanel implements ActionListener {
	JButton voltar;
	JLabel tituloDicas, dica1, dica2, dica3, dica4;

	public InstrucoesPainel() {
		super();
		this.setLayout(null);
		this.setBackground(new Color(246, 255, 145));
		
		voltar = new JButton();
		voltar.setBounds(150,670, 110, 100);
		voltar.setText("Voltar");
		voltar.setVisible(true);
		voltar.setFont(new Font("Arial", Font.BOLD, 18));
		add(voltar);
		voltar.addActionListener(this);
		
		tituloDicas = new JLabel("Como usar o sistema");
		tituloDicas.setBounds(575,60,500,50);
		tituloDicas.setForeground(Color.black);
		tituloDicas.setFont(new Font("Arial", Font.BOLD, 48));
		tituloDicas.setVisible(true);
		this.add(tituloDicas);
		
		dica1 = new JLabel("1 - Um produto deve estar necessariamente vinculado à uma fornecedora.");
		dica1.setBounds(400,160,1000,50);
		dica1.setForeground(Color.black);
		dica1.setFont(new Font("Arial", Font.PLAIN, 24));
		dica1.setVisible(true);
		this.add(dica1);
		
		dica2 = new JLabel("2 - Analogamente, um recibo deve estar necessariamente vinculado à um produto.");
		dica2.setBounds(400,260,1000,50);
		dica2.setForeground(Color.black);
		dica2.setFont(new Font("Arial", Font.PLAIN, 24));
		dica2.setVisible(true);
		this.add(dica2);
		
		dica3 = new JLabel("3 - Dando dois cliques na tabela 'Pesquisar' você pode ver todas as informações.");
		dica3.setBounds(400,360,1000,50);
		dica3.setForeground(Color.black);
		dica3.setFont(new Font("Arial", Font.PLAIN, 24));
		dica3.setVisible(true);
		this.add(dica3);
		
		dica4 = new JLabel("4 - Você não pode remover uma fornecedora ou produto que tenha recibo ativo.");
		dica4.setBounds(400,460,1000,50);
		dica4.setForeground(Color.black);
		dica4.setFont(new Font("Arial", Font.PLAIN, 24));
		dica4.setVisible(true);
		this.add(dica4);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(voltar)) {
			Janela.getInstance().InstrucoesPainel.setVisible(false);
			Janela.getInstance().PainelPrincipal.setVisible(true);
		}
		
	}
}
