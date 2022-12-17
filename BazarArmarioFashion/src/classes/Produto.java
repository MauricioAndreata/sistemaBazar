package classes;

public class Produto {
	
	private int id;
	private String nome;
	private String fornecedor;
	private String codigo;
	private Double precoLoja;
	private Double precoFornecedor;
	private String descricao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Double getPrecoLoja() {
		return precoLoja;
	}
	public void setPrecoLoja(Double precoLoja) {
		this.precoLoja = precoLoja;
	}
	public Double getPrecoFornecedor() {
		return precoFornecedor;
	}
	public void setPrecoFornecedor(Double precoFornecedor) {
		this.precoFornecedor = precoFornecedor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}