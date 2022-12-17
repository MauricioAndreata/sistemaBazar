package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LoginPainel extends JPanel implements ActionListener {
	
	
	
	ImageIcon inicio = new ImageIcon(getClass().getResource("manequimLogin.png"));
	JLabel logo = new JLabel(inicio);
	
	public static LoginPainel instance;
	public JTextField cx1;
	public JLabel User,Senha;
	public JButton Entrar,Esqueci;
	public PainelPrincipal PainelPrincipal;
	public LoginPainel LoginPainel;
	private JPasswordField cx2;
	
	public LoginPainel() {
		super();
		this.setLayout(null);
		this.setBackground(Color.white);
		
		logo.setBounds(575,105,0,0);
		logo.setForeground(Color.black);
		logo.setVisible(true);
		logo.setSize(400,300);
		this.add(logo);
		
		cx1 = new JTextField();
		cx1.setBounds(690,430,290,30);
		cx1.setFont(new Font("Arial", Font.PLAIN, 24));
		add(cx1);
		
		cx2 = new JPasswordField();
		cx2.setBounds(680,480,300,30);
		cx2.setFont(new Font("Arial", Font.PLAIN, 24));
		add(cx2);
		
		User = new JLabel("Usuário:");
		User.setBounds(600,270,0,0);
		User.setForeground(Color.black);
		User.setFont(new Font("Arial", Font.PLAIN, 24));
		User.setVisible(true);
		User.setSize(300,350);
		this.add(User);
		
		Senha = new JLabel("Senha:");
		Senha.setBounds(600,320,0,0);
		Senha.setForeground(Color.black);
		Senha.setFont(new Font("Arial", Font.PLAIN, 24));
		Senha.setVisible(true);
		Senha.setSize(300,350);
		this.add(Senha);
		
		Entrar = new JButton();
		Entrar.setBounds(880,550, 100, 50);
		Entrar.setVisible(true);
		Entrar.setText("Entrar");
		Entrar.setFont(new Font("Arial", Font.BOLD, 18));
		add(Entrar);
		Entrar.addActionListener(this);
		
		Esqueci = new JButton();
		Esqueci.setBounds(590,550, 210, 50);
		Esqueci.setVisible(true);
		Esqueci.setText("Perdi minha senha");
		Esqueci.setFont(new Font("Arial", Font.BOLD, 18));
		add(Esqueci);
		Esqueci.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(Entrar))
		{
			Janela.getInstance().LoginPainel.setVisible(false);
			Janela.getInstance().PainelPrincipal.setVisible(true);
			
		}
		
		if (e.getSource().equals(Esqueci)) {
			String email = JOptionPane.showInputDialog(Janela.getInstance(),"Digite seu e-mail de recuperação de senha");
			try{
				if(!email.isEmpty())
					JOptionPane.showMessageDialog(Janela.getInstance(),"E-mail enviado","Envio e-mail", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(Janela.getInstance(), "Digite um e-mail para recuperação!");
			}catch(Exception error) {
				JOptionPane.showMessageDialog(Janela.getInstance(), "Digite um e-mail para recuperação!");
			}
		}
	}
	
	
}

