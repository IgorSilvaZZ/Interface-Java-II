package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.Conector;
import model.bean.Fabricante;
import model.bean.Funcionario;

public class FabricanteDAO {
	
	public String sql;
	
	public void Create(Fabricante fa) {
		
		Connection con = Conector.getConnection();
		PreparedStatement stn = null;
		try {
			sql = "insert into tbFabricante (nomeFabricante, cnpjFabricante, ufFabricante, cidadeFabricante, cepFabricante, telefoneFabricante, complementoFabricante)" + " values (?,?,?,?,?,?,?)" ;
			stn = con.prepareStatement(sql);
			stn.setString(1, fa.getNomeFabricante());
			stn.setString(2, fa.getCnpjFabricante());
			stn.setString(3, fa.getUfFabricante());
			stn.setString(4, fa.getCidadeFabricante());
			stn.setString(5, fa.getCepFabricante());
			stn.setString(6, fa.getTelefoneFabricante());
			stn.setString(7, fa.getComplementoFabricante());
			stn.execute();
			JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar");
		}finally {
			Conector.closeConnection();
		}
		
		
	}
	
	public void Update(Fabricante fa) {
		
		Connection con = Conector.getConnection();
		PreparedStatement stn = null;
		try {
			sql = "update tbFabricante set nomeFabricante = ?,cnpjFabricante = ?,ufFabricante = ?,cidadeFabricante = ?,cepFabricante = ?,telefoneFabricante = ?,complementoFabricante = ?  where codFabricante = ?";
			stn = con.prepareStatement(sql);
			stn.setString(1, fa.getNomeFabricante());
			stn.setString(2, fa.getCnpjFabricante());
			stn.setString(3, fa.getUfFabricante());
			stn.setString(4, fa.getCidadeFabricante());
			stn.setString(5, fa.getCepFabricante());
			stn.setString(6, fa.getTelefoneFabricante());
			stn.setString(7, fa.getComplementoFabricante());
			stn.setInt(8, fa.getCodFabricante());
			stn.executeUpdate();
			JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Atualizar");
			System.out.println(e.getMessage());
		}finally {
			Conector.closeConnection();
		}
		
	}
	
	public void Delete(Fabricante fa) {
		
		Connection con = Conector.getConnection();
		PreparedStatement stn = null;
		try {
			sql = "delete from tbFabricante where codFabricante = ?";
			stn = con.prepareStatement(sql);
			stn.setInt(1, fa.getCodFabricante());
			stn.executeUpdate();
			JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Excluir");
			System.out.println(e.getMessage());
		}finally {
			Conector.closeConnection();
		}
		
	}

	
		public List<Fabricante> Listar(){
		
		Connection con = Conector.getConnection();
		PreparedStatement stn = null;
		ResultSet result = null;
		List<Fabricante> fabricantes = new ArrayList<>();
		try {
			sql = "select * from tbFabricante";
			stn = con.prepareStatement(sql);
			result = stn.executeQuery();
			while(result.next()) {
				Fabricante fb =  new Fabricante();
				fb.setCodFabricante(result.getInt("codFabricante"));
				fb.setNomeFabricante(result.getString("nomeFabricante"));
				fb.setCnpjFabricante(result.getString("cnpjFabricante"));
				fb.setUfFabricante(result.getString("ufFabricante"));
				fb.setCidadeFabricante(result.getString("cidadeFabricante"));
				fb.setCepFabricante(result.getString("cepFabricante"));
				fb.setTelefoneFabricante(result.getString("telefoneFabricante"));
				fb.setComplementoFabricante(result.getString("complementoFabricante"));
				fabricantes.add(fb);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar");
		}finally {
			Conector.closeConnection();
		}
		return fabricantes;
		
	}

}
