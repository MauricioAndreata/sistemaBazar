package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import dataBase.FornecedorasDAO;
import classes.Fornecedora;

@SuppressWarnings("serial")
public class AddFornecedoraPainel extends JPanel implements ActionListener{
	JTextField textNome;
	JFormattedTextField textCPF;
	JFormattedTextField textDataNascimento;
	JTextField textEndereco;
	JFormattedTextField textCep;
	JFormattedTextField textNumeroTelefone;
	JTextField textNumero;
	JTextField textEmail;
	JTextField textSigla;
	JButton btnConfirmar;
	JLabel lblAdicionarCliente, lblNome, lblCPF, lblDataDeNascimento, lblEndereco, lblNumero, lblCep, lblEmail, lblNumeroTelefone, lblSigla;

	MaskFormatter mascData = createFormatter1("##/##/####");
	MaskFormatter createFormatter1(String format) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(format);
            formatter.setPlaceholderCharacter('_');
            formatter.setAllowsInvalid(false); 
            formatter.setOverwriteMode(true); 
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
        }
        return formatter;
    }
	
	MaskFormatter mascCPF = createFormatter2("###.###.###-##");
	MaskFormatter createFormatter2(String format) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(format);
            formatter.setPlaceholderCharacter('_');
            formatter.setAllowsInvalid(false); 
            formatter.setOverwriteMode(true); 
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
        }
        return formatter;
    }
	
	MaskFormatter mascTelefone = createFormatter3("(##) ####-####");
	MaskFormatter createFormatter3(String format) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(format);
            formatter.setPlaceholderCharacter('_');
            formatter.setAllowsInvalid(false); 
            formatter.setOverwriteMode(true); 
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
        }
        return formatter;
    }
	
	MaskFormatter mascCEP = createFormatter4("#####-###");
	MaskFormatter createFormatter4(String format) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(format);
            formatter.setPlaceholderCharacter('_');
            formatter.setAllowsInvalid(false); 
            formatter.setOverwriteMode(true); 
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
        }
        return formatter;
    }
	
	public AddFornecedoraPainel() {
		super();
		this.setLayout(null);
		this.setBackground(Color.white);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Arial", Font.BOLD, 18));
		btnConfirmar.setBounds(150, 600, 145, 60);
		add(btnConfirmar);
		btnConfirmar.addActionListener(this);
		
		lblNome = new JLabel("Nome Completo:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNome.setBounds(0, 150, 200, 25);
		lblNome.setVisible(true);
		add(lblNome);
		
		lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Arial", Font.PLAIN, 24));
		lblCPF.setBounds(0, 200, 100, 25);
		add(lblCPF);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Arial", Font.PLAIN, 24));
		lblDataDeNascimento.setBounds(0, 250, 250, 25);
		add(lblDataDeNascimento);
		
		lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 24));
		lblEndereco.setBounds(0, 300, 120, 25);
		add(lblEndereco);
		
		lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNumero.setBounds(0, 350, 100, 25);
		add(lblNumero);
		
		lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Arial", Font.PLAIN, 24));
		lblCep.setBounds(0, 400, 100, 25);
		add(lblCep);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 24));
		lblEmail.setBounds(0, 450, 133, 25);
		add(lblEmail);
		
		lblNumeroTelefone = new JLabel("N\u00FAmero de Telefone:");
		lblNumeroTelefone.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNumeroTelefone.setBounds(0, 500, 230, 25);
		add(lblNumeroTelefone);
		
		lblSigla = new JLabel("Sigla:");
		lblSigla.setFont(new Font("Arial", Font.PLAIN, 24));
		lblSigla.setBounds(0, 550, 174, 30);
		add(lblSigla);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Arial", Font.PLAIN, 18));
		textNome.setBounds(210, 150, 300, 30);
		add(textNome);
		textNome.setColumns(10);
		
		textCPF = new JFormattedTextField(mascCPF);
		textCPF.setFont(new Font("Arial", Font.PLAIN, 18));
		textCPF.setColumns(10);
		textCPF.setBounds(70, 200, 245, 30);
		add(textCPF);
		
		textDataNascimento = new JFormattedTextField(mascData);
		textDataNascimento.setFont(new Font("Arial", Font.PLAIN, 18));
		textDataNascimento.setColumns(10);
		textDataNascimento.setBounds(240, 250, 155, 30);
		add(textDataNascimento);
		
		textEndereco = new JTextField();
		textEndereco.setFont(new Font("Arial", Font.PLAIN, 18));
		textEndereco.setColumns(10);
		textEndereco.setBounds(120, 300, 215, 30);
		add(textEndereco);
		
		textNumero = new JTextField();
		textNumero.setFont(new Font("Arial", Font.PLAIN, 18));
		textNumero.setColumns(10);
		textNumero.setBounds(100, 350, 215, 30);
		add(textNumero);
		
		textCep = new JFormattedTextField(mascCEP);
		textCep.setFont(new Font("Arial", Font.PLAIN, 18));
		textCep.setColumns(10);
		textCep.setBounds(70, 400, 235, 30);
		add(textCep);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Arial", Font.PLAIN, 18));
		textEmail.setColumns(10);
		textEmail.setBounds(80, 450, 250, 30);
		add(textEmail);
		
		textNumeroTelefone = new JFormattedTextField(mascTelefone);
		textNumeroTelefone.setFont(new Font("Arial", Font.PLAIN, 18));
		textNumeroTelefone.setColumns(10);
		textNumeroTelefone.setBounds(230, 500, 145, 30);
		add(textNumeroTelefone);
				
		textSigla = new JTextField();
		textSigla.setFont(new Font("Arial", Font.PLAIN, 18));
		textSigla.setColumns(10);
		textSigla.setBounds(70, 550, 175, 30);
		add(textSigla);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(btnConfirmar)) {
			if(textNome.getText().isEmpty() || textSigla.getText().isEmpty()) {
				JOptionPane.showMessageDialog(Janela.getInstance(), "ERRO\nFornecedor sem nome e/ou sigla");
			}else {
				String sigla = textSigla.getText();
				FornecedorasDAO cadFornecedora = new FornecedorasDAO();
				ArrayList<Fornecedora> listaFornecedora;
				
				listaFornecedora = cadFornecedora.pesquisarSigla(sigla);
				
				if(listaFornecedora.size() == 1) {
					int verifica = JOptionPane.showConfirmDialog(Janela.getInstance(), "A Fornecedora já existe\nDeseja atualizar os dados?");
					
					if(verifica == JOptionPane.YES_OPTION) {
						FornecedorasDAO cadCliente = new FornecedorasDAO();
						
						Fornecedora fornecedora = new Fornecedora();
						
						fornecedora.setNome(textNome.getText());
						fornecedora.setCpf(textCPF.getText());
						fornecedora.setEndereco(textEndereco.getText());
						fornecedora.setCep(textCep.getText());
						fornecedora.setNumero(textNumero.getText());
						fornecedora.setEmail(textEmail.getText());
						fornecedora.setNumeroTelefone(textNumeroTelefone.getText());
						fornecedora.setSigla(textSigla.getText());
						
						SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						try {
							java.sql.Date data = new java.sql.Date(format.parse(textDataNascimento.getText()).getTime());
							fornecedora.setData_nasc(data);
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						
						cadCliente.update(fornecedora);
						
						Janela.getInstance().AddFornecedoraPainel.setVisible(false);
						Janela.getInstance().FornecedorasPainel.setVisible(false);
						Janela.getInstance().PainelPrincipal.setVisible(true);
						
						textNome.setText(null);
						textCPF.setText(null);
						textDataNascimento.setText(null);
						textEndereco.setText(null);
						textCep.setText(null);
						textNumero.setText(null);
						textEmail.setText(null);
						textNumeroTelefone.setText(null);
						textSigla.setText(null);
					}
				}else {
					FornecedorasDAO cadCliente = new FornecedorasDAO();
					
					Fornecedora fornecedora = new Fornecedora();
					
					fornecedora.setNome(textNome.getText());
					fornecedora.setCpf(textCPF.getText());
					fornecedora.setEndereco(textEndereco.getText());
					fornecedora.setCep(textCep.getText());
					fornecedora.setNumero(textNumero.getText());
					fornecedora.setEmail(textEmail.getText());
					fornecedora.setNumeroTelefone(textNumeroTelefone.getText());
					fornecedora.setSigla(textSigla.getText());
					
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					try {
						java.sql.Date data = new java.sql.Date(format.parse(textDataNascimento.getText()).getTime());
						fornecedora.setData_nasc(data);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					cadCliente.add(fornecedora);
					
					Janela.getInstance().AddFornecedoraPainel.setVisible(false);
					Janela.getInstance().FornecedorasPainel.setVisible(false);
					Janela.getInstance().PainelPrincipal.setVisible(true);
					
					textNome.setText(null);
					textCPF.setText(null);
					textDataNascimento.setText(null);
					textEndereco.setText(null);
					textCep.setText(null);
					textNumero.setText(null);
					textEmail.setText(null);
					textNumeroTelefone.setText(null);
					textSigla.setText(null);
				}
			}
		}
	}
	
}
