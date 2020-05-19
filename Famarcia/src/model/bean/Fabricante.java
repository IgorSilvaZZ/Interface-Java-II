package model.bean;

public class Fabricante {
	
	private int codFabricante;
	private String nomeFabricante;
	private String cnpjFabricante;
	private String ufFabricante;
	private String cidadeFabricante;
	private String cepFabricante;
	private String telefoneFabricante;
	private String complementoFabricante;
	
	public int getCodFabricante() {
		return codFabricante;
	}
	public void setCodFabricante(int codFabricante) {
		this.codFabricante = codFabricante;
	}
	public String getNomeFabricante() {
		return nomeFabricante;
	}
	public void setNomeFabricante(String nomeFabricante) {
		this.nomeFabricante = nomeFabricante;
	}
	
	public String getCnpjFabricante() {
		return this.cnpjFabricante;
	}
	
	public void setCnpjFabricante(String cnpjFabricante) {
		this.cnpjFabricante = cnpjFabricante;
	}
	
	public String getUfFabricante() {
		return this.ufFabricante;
	}
	
	public void setUfFabricante(String ufFabricante) {
		this.ufFabricante = ufFabricante;
	}
	
	public String getCidadeFabricante() {
		return this.cidadeFabricante;
	}
	
	public void setCidadeFabricante(String cidadeFabricante) {
		this.cidadeFabricante = cidadeFabricante;
	}
	
	public String getCepFabricante() {
		return this.cepFabricante;
	}
	
	public void setCepFabricante(String cepFabricante) {
		this.cepFabricante = cepFabricante;
	}
	
	public String getTelefoneFabricante() {
		return this.telefoneFabricante;
	}
	
	public void setTelefoneFabricante(String telefoneFabricante) {
		this.telefoneFabricante = telefoneFabricante;
	}
	
	public String getComplementoFabricante() {
		return this.complementoFabricante;
	}
	
	public void setComplementoFabricante(String complementoFabricante) {
		this.complementoFabricante = complementoFabricante;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNomeFabricante();
	}
	

}
