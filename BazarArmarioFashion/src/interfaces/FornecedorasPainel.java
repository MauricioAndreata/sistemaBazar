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
public class FornecedorasPainel extends JPanel implements ActionListener {
	ImageIcon linha = new ImageIcon(getClass().getResource("linha.png"));
	JLabel Linha = new JLabel(linha);
	JButton adicionar, pesquisar, remover, voltar;

	public FornecedorasPainel() {
		
		super();
		this.setLayout(null);
		this.setBackground(Color.white);
		
		Linha.setBounds(280,225,0,0);
		Linha.setForeground(Color.black);
		Linha.setVisible(true);
		Linha.setSize(300,350);
		this.add(Linha);
		
		adicionar = new JButton();
		adicionar.setBounds(250,180, 130, 100);
		adicionar.setVisible(true);
		adicionar.setText("Adicionar");
		adicionar.setFont(new Font("Arial", Font.BOLD, 18));
		add(adicionar);
		adicionar.addActionListener(this);
		
		pesquisar = new JButton();
		pesquisar.setBounds(250,300, 130, 100);
		pesquisar.setVisible(true);
		pesquisar.setText("Pesquisar");
		pesquisar.setFont(new Font("Arial", Font.BOLD, 18));
		add(pesquisar);
		pesquisar.addActionListener(this);
		
		remover = new JButton();
		remover.setBounds(250,420, 130, 100);
		remover.setText("Remover");
		remover.setFont(new Font("Arial", Font.BOLD, 18));
		remover.setVisible(true);
		add(remover);
		remover.addActionListener(this);
		
		voltar = new JButton();
		voltar.setBounds(250,540, 130, 100);
		voltar.setText("Voltar");
		voltar.setFont(new Font("Arial", Font.BOLD, 18));
		voltar.setVisible(true);
		add(voltar);
		voltar.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(voltar)) {
			Janela.getInstance().AddFornecedoraPainel.setVisible(false);
			Janela.getInstance().PadraoPainel.setVisible(false);
			Janela.getInstance().PesquisarFornecedoraPainel.setVisible(false);
			Janela.getInstance().RemoverFornecedoraPainel.setVisible(false);
			Janela.getInstance().FornecedorasPainel.setVisible(false);
			Janela.getInstance().PainelPrincipal.setVisible(true);
		}
		
		if(e.getSource().equals(adicionar)) {
			Janela.getInstance().PadraoPainel.setVisible(false);
			Janela.getInstance().AddFornecedoraPainel.setVisible(true);
			Janela.getInstance().RemoverFornecedoraPainel.setVisible(false);
			Janela.getInstance().PesquisarFornecedoraPainel.setVisible(false);
		}
		
		if(e.getSource().equals(remover)) {
			Janela.getInstance().PadraoPainel.setVisible(false);
			Janela.getInstance().RemoverFornecedoraPainel.setVisible(true);
			Janela.getInstance().AddFornecedoraPainel.setVisible(false);
			Janela.getInstance().PesquisarFornecedoraPainel.setVisible(false);
		}
		
		if(e.getSource().equals(pesquisar)) {
			Janela.getInstance().PadraoPainel.setVisible(false);
			Janela.getInstance().PesquisarFornecedoraPainel.setVisible(true);
			Janela.getInstance().RemoverFornecedoraPainel.setVisible(false);
			Janela.getInstance().AddFornecedoraPainel.setVisible(false);
		}
	}
}
