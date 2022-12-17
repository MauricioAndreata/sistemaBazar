package interfaces;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Janela extends JFrame {

	public static Janela instance;
	public InstrucoesPainel InstrucoesPainel;
	public LoginPainel LoginPainel;
	public PainelPrincipal PainelPrincipal;
	public PadraoPainel PadraoPainel;
	
	public FornecedorasPainel FornecedorasPainel;
	public AddFornecedoraPainel AddFornecedoraPainel;
	public PesquisarFornecedoraPainel PesquisarFornecedoraPainel;
	public RemoverFornecedoraPainel RemoverFornecedoraPainel;
	
	public ProdutoPainel FuncionariosPainel;
	public AddProdutoPainel AddProdutoPainel;
	public PesquisarProdutoPainel PesquisarProdutoPainel;
	public RemoverProdutoPainel RemoverProdutoPainel;
	
	public ReciboPainel ReciboPainel;
	public AddReciboPainel AddReciboPainel;
	public PesquisarReciboPainel PesquisarReciboPainel;
	public RemoverReciboPainel RemoverReciboPainel;
	
	public Janela() {
		super ("Bazar Armário Fashion");
		this.setSize(1600,900);
		this.setVisible(true);
		this.setLayout(null);	 
		this.setLocationRelativeTo(null);
		this.alterarIcone();     	
		this.desenharJanela();
		this.repaint();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
		private void alterarIcone() {
			try {
				Image iconeTitulo = ImageIO.read(getClass().getResource("manequimSuper.png"));
				setIconImage(iconeTitulo);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void desenharJanela() {
			LoginPainel = new LoginPainel();
			LoginPainel.setBounds(0,0,1600,900);
			LoginPainel.setVisible(true);
			this.getContentPane().add(LoginPainel);
			
			PainelPrincipal = new PainelPrincipal();
			PainelPrincipal.setBounds(0,0,1600,900);
			PainelPrincipal.setVisible(false);
			this.getContentPane().add(PainelPrincipal);	
			
			InstrucoesPainel = new InstrucoesPainel();
			InstrucoesPainel.setBounds(0,0,1600,900);
			InstrucoesPainel.setVisible(false);
			this.getContentPane().add(InstrucoesPainel);
			
			PadraoPainel = new PadraoPainel();
			PadraoPainel.setBounds(550,0,1050,900);
			PadraoPainel.setVisible(false);
			this.getContentPane().add(PadraoPainel);
			
			ReciboPainel = new ReciboPainel();
			ReciboPainel.setBounds(0,0,550,900);
			ReciboPainel.setVisible(false);
			this.getContentPane().add(ReciboPainel);
			
			AddReciboPainel = new AddReciboPainel();
			AddReciboPainel.setBounds(550,0,1050,900);
			AddReciboPainel.setVisible(false);
			this.getContentPane().add(AddReciboPainel);
			
			PesquisarReciboPainel = new PesquisarReciboPainel();
			PesquisarReciboPainel.setBounds(550,0,1050,900);
			PesquisarReciboPainel.setVisible(false);
			this.getContentPane().add(PesquisarReciboPainel);
			
			RemoverReciboPainel = new RemoverReciboPainel();
			RemoverReciboPainel.setBounds(550,0,1050,900);
			RemoverReciboPainel.setVisible(false);
			this.getContentPane().add(RemoverReciboPainel);
			
			FornecedorasPainel = new FornecedorasPainel();
			FornecedorasPainel.setBounds(0,0,550,900);
			FornecedorasPainel.setVisible(false);
			this.getContentPane().add(FornecedorasPainel);
			
			AddFornecedoraPainel = new AddFornecedoraPainel();
			AddFornecedoraPainel.setBounds(550,0,1050,900);
			AddFornecedoraPainel.setVisible(false);
			this.getContentPane().add(AddFornecedoraPainel);
			
			PesquisarFornecedoraPainel = new PesquisarFornecedoraPainel();
			PesquisarFornecedoraPainel.setBounds(550,0,1050,900);
			PesquisarFornecedoraPainel.setVisible(false);
			this.getContentPane().add(PesquisarFornecedoraPainel);
			
			RemoverFornecedoraPainel = new RemoverFornecedoraPainel();
			RemoverFornecedoraPainel.setBounds(550,0,1050,900);
			RemoverFornecedoraPainel.setVisible(false);
			this.getContentPane().add(RemoverFornecedoraPainel);
			
			FuncionariosPainel = new ProdutoPainel();
			FuncionariosPainel.setBounds(0,0,550,900);
			FuncionariosPainel.setVisible(false);
			this.getContentPane().add(FuncionariosPainel);
			
			AddProdutoPainel = new AddProdutoPainel();
			AddProdutoPainel.setBounds(550,0,1050,900);
			AddProdutoPainel.setVisible(false);
			this.getContentPane().add(AddProdutoPainel);
			
			PesquisarProdutoPainel = new PesquisarProdutoPainel();
			PesquisarProdutoPainel.setBounds(550,0,1050,900);
			PesquisarProdutoPainel.setVisible(false);
			this.getContentPane().add(PesquisarProdutoPainel);
			
			RemoverProdutoPainel = new RemoverProdutoPainel();
			RemoverProdutoPainel.setBounds(550,0,1050,900);
			RemoverProdutoPainel.setVisible(false);
			this.getContentPane().add(RemoverProdutoPainel);

		}
		
		public static Janela getInstance() {
			// TODO Auto-generated method stub
			if (instance == null) {
				instance = new Janela();
				return instance;
			}
			else {
				return instance;
			}
		}


		
		
}
