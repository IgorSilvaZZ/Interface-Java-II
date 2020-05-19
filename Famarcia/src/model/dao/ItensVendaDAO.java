package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.Conector;
import model.bean.ItensVenda;

public class ItensVendaDAO {
	
	public String sql;
	
	public void Create(ItensVenda it) {
		
		Connection con = Conector.getConnection();
		PreparedStatement stn = null;
		try {
			sql = "insert into tbItensVenda (qtdItensVenda, subTotalItensVenda, codMedicamento, codVenda)"  + "values (?,?,?,?)";
			stn = con.prepareStatement(sql);
			stn.setInt(1, it.getQtdItensVenda());
			stn.setInt(2, it.getSubTotalItensVenda());
			stn.setInt(3, it.getCodMedicamento());
			stn.setInt(4, it.getCodVenda());
			stn.execute();
			JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar");
		}finally {
			Conector.closeConnection();
		}
		
	}

}
