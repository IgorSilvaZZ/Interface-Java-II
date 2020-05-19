package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.Conector;
import model.bean.Cliente;
import model.bean.Fabricante;

public class ClienteDAO {
	
	public String sql;
	
	public void Create(Cliente c) {
		
		Connection con = Conector.getConnection();
		PreparedStatement stn = null;
		try {
			sql = "insert into tbCliente (nomeCliente,cpfCliente,rgCliente,bairroCliente,cepCliente,enderecoCliente,numeroCliente,ufCliente,cidadeCliente) " + " values (?,?,?,?,?,?,?,?,?)";
			stn = con.prepareStatement(sql);
			stn.setString(1, c.getNomeCliente());
			stn.setString(2, c.getCpfCliente());
			stn.setString(3, c.getRgCliente());
			stn.setString(4, c.getBairroCliente());
			stn.setString(5, c.getCepCliente());
			stn.setString(6, c.getEnderecoCliente());
			stn.setString(7, c.getNumeroCliente());
			stn.setString(8, c.getUfCliente());
			stn.setString(9, c.getCidadeCliente());
			stn.execute();
			JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar");
		}finally {
			Conector.closeConnection();
		}
		
	}
	
	public void Update(Cliente c) {
		
		Connection con = Conector.getConnection();
		PreparedStatement stn = null;
		try {
			sql = "update tbCliente set nomeCliente = ?, cpfCliente = ?, rgCliente = ?, bairroCliente = ?, cepCliente = ?, enderecoCliente = ?, numeroCliente = ?, ufCliente = ?, cidadeCliente = ?  where codCliente = ?";
			stn = con.prepareStatement(sql);
			stn = con.prepareStatement(sql);
			stn.setString(1, c.getNomeCliente());
			stn.setString(2, c.getCpfCliente());
			stn.setString(3, c.getRgCliente());
			stn.setString(4, c.getBairroCliente());
			stn.setString(5, c.getCepCliente());
			stn.setString(6, c.getEnderecoCliente());
			stn.setString(7, c.getNumeroCliente());
			stn.setString(8, c.getUfCliente());
			stn.setString(9, c.getCidadeCliente());
			stn.setInt(10, c.getCodCliente());
			stn.executeUpdate();
			JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Atualizar");
			System.out.println(e.getMessage());
		}finally {
			Conector.closeConnection();
		}
		
	}
	
	public void Delete(Cliente c) {
		
		Connection con = Conector.getConnection();
		PreparedStatement stn = null;
		try {
			sql = "delete from tbCliente where codCliente = ?";
			stn = con.prepareStatement(sql);
			stn.setInt(1, c.getCodCliente());
			stn.executeUpdate();
			JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Excluir");
			System.out.println(e.getMessage());
		}finally {
			Conector.closeConnection();
		}
		
	}

	
	public List<Cliente> Listar(){
		
		Connection con = Conector.getConnection();
		PreparedStatement stn = null;
		ResultSet result = null;
		List<Cliente> clientes = new ArrayList<>();
		try {
			sql = "select * from tbCliente";
			stn = con.prepareStatement(sql);
			result = stn.executeQuery();
			while(result.next()) {
				Cliente c =  new Cliente();
				c.setCodCliente(result.getInt("codCliente"));
				c.setNomeCliente(result.getString("nomeCliente"));
				c.setCpfCliente(result.getString("cpfCliente"));
				c.setRgCliente(result.getString("rgCliente"));
				c.setBairroCliente(result.getString("bairroCliente"));
				c.setCepCliente(result.getString("cepCliente"));
				c.setEnderecoCliente(result.getString("enderecoCliente"));
				c.setNumeroCliente(result.getString("numeroCliente"));
				c.setUfCliente(result.getString("ufCliente"));
				c.setCidadeCliente(result.getString("cidadeCliente"));
				c.setNumeroCliente(result.getString("numeroCliente"));
				clientes.add(c);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar");
		}finally {
			Conector.closeConnection();
		}
		return clientes;
	}

}
