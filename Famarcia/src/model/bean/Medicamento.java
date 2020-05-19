package model.bean;

public class Medicamento {
	
	private int codMedicamento;
	private String descMedicamento;
	private String precoMedicamento;
	private int codFabricante;
	private String nomeFabricante;
	
	public int getCodMedicamento() {
		return codMedicamento;
	}
	public void setCodMedicamento(int codMedicamento) {
		this.codMedicamento = codMedicamento;
	}
	public String getDescMedicamento() {
		return descMedicamento;
	}
	public void setDescMedicamento(String descMedicamento) {
		this.descMedicamento = descMedicamento;
	}
	public String getPrecoMedicamento() {
		return precoMedicamento;
	}
	public void setPrecoMedicamento(String precoMedicamento) {
		this.precoMedicamento = precoMedicamento;
	}
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getDescMedicamento();
	}
	

}
