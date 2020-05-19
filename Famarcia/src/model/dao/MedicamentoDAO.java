package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.Conector;
import model.bean.Funcionario;
import model.bean.Medicamento;

public class MedicamentoDAO {
	
	public String sql;
	
	public void Create(Medicamento me) {
		
		Connection con = Conector.getConnection();
		PreparedStatement stn = null;
		try {
			sql = "insert into tbMedicamento (descMedicamento, precoMedicamento, codFabricante) " + "values(?,?,?)";
			stn = con.prepareStatement(sql);
			stn.setString(1, me.getDescMedicamento());
			stn.setString(2, me.getPrecoMedicamento());
			stn.setInt(3, me.getCodFabricante());
			stn.execute();
			JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar");
			System.out.println(e.getMessage());
		}finally {
			Conector.closeConnection();
		}
		
	}
	
	public List<Medicamento> Listar(){
		
		Connection con = Conector.getConnection();
		PreparedStatement stn = null;
		ResultSet result = null;
		List<Medicamento> medicamentos = new ArrayList<>();
		try {
			sql = "select descMedicamento, precoMedicamento, tbMedicamento.codFabricante, tbMedicamento.codMedicamento,nomeFabricante from tbMedicamento inner join tbFabricante on tbMedicamento.codFabricante = tbFabricante.codFabricante";
			stn = con.prepareStatement(sql);
			result = stn.executeQuery();
			while(result.next()) {
				Medicamento med =  new Medicamento();
				med.setCodMedicamento(result.getInt("codMedicamento"));
				med.setDescMedicamento(result.getString("descMedicamento"));
				med.setPrecoMedicamento(result.getString("precoMedicamento"));
				med.setCodFabricante(result.getInt("codFabricante"));
				med.setNomeFabricante(result.getString("nomeFabricante"));
				medicamentos.add(med);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar");
			System.out.println(e.getMessage());
			
		}finally {
			Conector.closeConnection();
		}
		return medicamentos;
		
	}
	
	public void ListarPreco(Medicamento me){
		
		Connection con = Conector.getConnection();
		PreparedStatement stn = null;
		ResultSet result = null;
		try {
			sql = "select precoMedicamento from tbMedicamento where codMedicamento = ?";
			stn = con.prepareStatement(sql);
			result = stn.executeQuery();
			stn.setString(0, me.getPrecoMedicamento());
			stn.setInt(1, me.getCodMedicamento());
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar");
			System.out.println(e.getMessage());
			
		}finally {
			Conector.closeConnection();
		}
	}

}
