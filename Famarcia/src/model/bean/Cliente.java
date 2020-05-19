package model.bean;

public class Cliente {
	private int codCliente;
	private String nomeCliente;
	private String cpfCliente;
	private String rgCliente;
	private String bairroCliente;
	private String cepCliente;
	private String enderecoCliente;
	private String numeroCliente;
	private String ufCliente;
	private String cidadeCliente;
	
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	public String getRgCliente() {
		return rgCliente;
	}
	public void setRgCliente(String rgCliente) {
		this.rgCliente = rgCliente;
	}
	public String getBairroCliente() {
		return bairroCliente;
	}
	public void setBairroCliente(String bairroCliente) {
		this.bairroCliente = bairroCliente;
	}
	public String getCepCliente() {
		return cepCliente;
	}
	public void setCepCliente(String cepCliente) {
		this.cepCliente = cepCliente;
	}
	public String getEnderecoCliente() {
		return enderecoCliente;
	}
	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}
	public String getNumeroCliente() {
		return numeroCliente;
	}
	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
	public String getUfCliente() {
		return ufCliente;
	}
	public void setUfCliente(String ufCliente) {
		this.ufCliente = ufCliente;
	}
	
	public String getCidadeCliente() {
		return cidadeCliente;
	}
	
	public void setCidadeCliente(String cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNomeCliente();
	}
	
}
