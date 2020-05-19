package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.Conector;
import model.bean.Telefone;

public class TelefoneDAO {
	
	public String sql;
	
	public void Create(Telefone t) {
		
		Connection con = Conector.getConnection();
		PreparedStatement stn = null;
		try {
			sql = "insert into Telefone (numTelefone,codCliente)" + "values (?,?)";
			stn = con.prepareStatement(sql);
			stn.setString(1, t.getNumTelefone());
			stn.setInt(2, t.getCodCliente());
			stn.execute();
			JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar");
		}finally {
			Conector.closeConnection();
		}
		
	}

}
