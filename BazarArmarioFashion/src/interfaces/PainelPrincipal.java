package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PainelPrincipal extends JPanel implements ActionListener{
	ImageIcon imagem = new ImageIcon(getClass().getResource("manequim.png"));
	JLabel Manequim = new JLabel(imagem);
	
	public JLabel centro;
	public JButton Instrucoes;
	public JButton Fornecedoras;
	public JButton Produtos;
	public JButton Recibos;
	public JButton Sair;
	
	public PainelPrincipal() {
		super();
		this.setLayout(null);
		this.setBackground(Color.white);
		
		Manequim.setBounds(600,175,0,0);
		Manequim.setForeground(Color.black);
		Manequim.setVisible(true);
		Manequim.setSize(400,400);
		this.add(Manequim);
		
		centro = new JLabel("BAZAR ARMÁRIO FASHION");
		centro.setBounds(500,530,700,50);
		centro.setForeground(Color.black);
		centro.setFont(new Font("Arial", Font.BOLD, 48));
		centro.setVisible(true);
		this.add(centro);
		
		Instrucoes = new JButton();
		Instrucoes.setBounds(150,670, 160, 100);
		Instrucoes.setVisible(true);
		Instrucoes.setText("Como Usar");
		Instrucoes.setFont(new Font("Arial", Font.BOLD, 18));
		add(Instrucoes);
		Instrucoes.addActionListener(this);
		
		Fornecedoras = new JButton();
		Fornecedoras.setBounds(300,60, 160, 100);
		Fornecedoras.setVisible(true);
		Fornecedoras.setText("Fornecedoras");
		Fornecedoras.setFont(new Font("Arial", Font.BOLD, 18));
		add(Fornecedoras);
		Fornecedoras.addActionListener(this);
		
		Produtos = new JButton();
		Produtos.setBounds(720,60,160,100);
		Produtos.setVisible(true);
		Produtos.setText("Produtos");
		Produtos.setFont(new Font("Arial", Font.BOLD, 18));
		add(Produtos);
		Produtos.addActionListener(this);
		
		Recibos = new JButton();
		Recibos.setBounds(1140,60,160,100);
		Recibos.setVisible(true);
		Recibos.setText("Recibos");
		Recibos.setFont(new Font("Arial", Font.BOLD, 18));
		add(Recibos);
		Recibos.addActionListener(this);
		
		Sair = new JButton();
		Sair.setBounds(1370,670,110,100);
		Sair.setVisible(true);
		Sair.setText("Sair");
		Sair.setFont(new Font("Arial", Font.BOLD, 18));
		add(Sair);
		Sair.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(Sair)) {
			Janela.getInstance().LoginPainel.setVisible(true);
			Janela.getInstance().PainelPrincipal.setVisible(false);
		}
		if(e.getSource().equals(Fornecedoras)) {
			Janela.getInstance().PainelPrincipal.setVisible(false);
			Janela.getInstance().FornecedorasPainel.setVisible(true);
			Janela.getInstance().PadraoPainel.setVisible(true);
		}
		
		if(e.getSource().equals(Produtos)) {
			Janela.getInstance().PainelPrincipal.setVisible(false);
			Janela.getInstance().FuncionariosPainel.setVisible(true);
			Janela.getInstance().PadraoPainel.setVisible(true);
		}
		
		if(e.getSource().equals(Instrucoes)) {
			Janela.getInstance().PainelPrincipal.setVisible(false);
			Janela.getInstance().InstrucoesPainel.setVisible(true);
			Janela.getInstance().PadraoPainel.setVisible(true);
		}
		
		if(e.getSource().equals(Recibos)) {
			Janela.getInstance().PainelPrincipal.setVisible(false);
			Janela.getInstance().ReciboPainel.setVisible(true);
			Janela.getInstance().PadraoPainel.setVisible(true);
		}
	}
}
