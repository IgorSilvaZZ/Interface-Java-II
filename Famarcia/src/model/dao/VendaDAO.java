package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.Conector;
import model.bean.Medicamento;
import model.bean.Venda;

public class VendaDAO {
	
	public String sql;
	
	public void Create(Venda ve) {
		
		Connection con = Conector.getConnection();
		PreparedStatement stn = null;
		try {
			sql = "insert into tbVenda (totalVenda, codCliente, codFuncionario, codMedicamento)" + "values (?,?,?,?)";
			stn = con.prepareStatement(sql);
			stn.setString(1, ve.getTotalVenda());
			stn.setInt(2, ve.getCodCliente());
			stn.setInt(3, ve.getCodFuncionario());
			stn.setInt(4, ve.getCodMedicamento());
			stn.execute();
			JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar");
			System.out.println(e.getMessage());
		}finally {
			Conector.closeConnection();
		}
		
	}
	
	public List<Venda> Listar(){
		
		Connection con = Conector.getConnection();
		PreparedStatement stn = null;
		ResultSet result = null;
		List<Venda> vendas = new ArrayList<>();
		try {
			sql = "select totalVenda, tbVenda.codCliente, tbVenda.codFuncionario, tbVenda.codMedicamento, tbVenda.codVenda, nomeFuncionario, descMedicamento, nomeCliente from tbVenda inner join tbCliente on tbVenda.codCliente = tbCliente.codCliente inner join tbFuncionario on tbVenda.codFuncionario = tbFuncionario.codFuncionario inner join tbMedicamento on tbVenda.codMedicamento = tbMedicamento.codMedicamento";
			stn = con.prepareStatement(sql);
			result = stn.executeQuery();
			while(result.next()) {
				Venda vend =  new Venda();
				vend.setCodVenda(result.getInt("codVenda"));
				vend.setCodCliente(result.getInt("codCliente"));
				vend.setCodMedicamento(result.getInt("codMedicamento"));
				vend.setCodFuncionario(result.getInt("codFuncionario"));
				vend.setTotalVenda(result.getString("totalVenda"));
				vend.setNomeFun(result.getString("nomeFuncionario"));
				vend.setNomeMed(result.getString("descMedicamento"));
				vend.setNomeCli(result.getString("nomeCliente"));
				vendas.add(vend);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar");
			System.out.println(e.getMessage());
			
		}finally {
			Conector.closeConnection();
		}
		return vendas;
		
	}

}
