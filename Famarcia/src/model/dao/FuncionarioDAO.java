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


public class FuncionarioDAO {
	
	public String sql;
	
	public void Create(Funcionario f) {
		
		Connection con = Conector.getConnection();
		PreparedStatement stn = null;
		try {
			sql = "insert into tbFuncionario (nomeFuncionario,cargoFuncionario,rgFuncionario,cpfFuncionario,nomeUsuario,senhaUsuario)" + " values (?,?,?,?,?,?)";
			stn = con.prepareStatement(sql);
			stn.setString(1, f.getNomeFuncionario());
			stn.setString(2, f.getCargoFuncionario());
			stn.setString(3, f.getRgFuncionario());
			stn.setString(4, f.getCpfFuncionario());
			stn.setString(5, f.getNomeUsuario());
			stn.setString(6, f.getSenhaUsuario());
			stn.execute();
			JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar");
			System.out.println(e.getMessage());
		}finally {
			Conector.closeConnection();
		}
		
	}
	
	public void Update(Funcionario f) {
		
		Connection con = Conector.getConnection();
		PreparedStatement stn = null;
		try {
			sql = "update tbFuncionario set nomeFuncionario = ?,cargoFuncionario = ?,rgFuncionario = ?,cpfFuncionario = ?,nomeUsuario = ?,senhaUsuario = ? where codFuncionario = ?";
			stn = con.prepareStatement(sql);
			stn.setString(1, f.getNomeFuncionario());
			stn.setString(2, f.getCargoFuncionario());
			stn.setString(3, f.getRgFuncionario());
			stn.setString(4, f.getCpfFuncionario());
			stn.setString(5, f.getNomeUsuario());
			stn.setString(6, f.getSenhaUsuario());
			stn.setInt(7, f.getCodFuncionario());
			stn.executeUpdate();
			JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Atualizar");
			System.out.println(e.getMessage());
		}finally {
			Conector.closeConnection();
		}
		
	}
	
	public void Delete(Funcionario f) {
		
		Connection con = Conector.getConnection();
		PreparedStatement stn = null;
		try {
			sql = "delete from tbFuncionario where codFuncionario = ?";
			stn = con.prepareStatement(sql);
			stn.setInt(1, f.getCodFuncionario());
			stn.executeUpdate();
			JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Excluir");
			System.out.println(e.getMessage());
		}finally {
			Conector.closeConnection();
		}
		
	}

	public boolean checkLogin(String nome,String senha) {
		
		Connection con = Conector.getConnection();
		PreparedStatement stn = null;
		ResultSet rs = null;
		boolean check = false;
		
		try {
			sql = "select * from tbFuncionario where nomeUsuario = ? and senhaUsuario = ?";
			stn = con.prepareStatement(sql);
			stn.setString(1, nome);
			stn.setString(2, senha);
			rs = stn.executeQuery();
			if(rs.next()) {
				check = true;
				JOptionPane.showMessageDialog(null, "Logado");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}finally {
			Conector.closeConnection();
		}
		return check;
		
	}
	
	public List<Funcionario> Listar(){
		
		Connection con = Conector.getConnection();
		PreparedStatement stn = null;
		ResultSet result = null;
		List<Funcionario> funcionarios = new ArrayList<>();
		try {
			sql = "select * from tbFuncionario";
			stn = con.prepareStatement(sql);
			result = stn.executeQuery();
			while(result.next()) {
				Funcionario f =  new Funcionario();
				f.setCodFuncionario(result.getInt("codFuncionario"));
				f.setNomeFuncionario(result.getString("nomeFuncionario"));
				f.setCargoFuncionario(result.getString("cargoFuncionario"));
				f.setRgFuncionario(result.getString("rgFuncionario"));
				f.setCpfFuncionario(result.getString("cpfFuncionario"));
				f.setNomeUsuario(result.getString("nomeUsuario"));
				f.setSenhaUsuario(result.getString("senhaUsuario"));
				funcionarios.add(f);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar");
		}finally {
			Conector.closeConnection();
		}
		return funcionarios;
		
	}

}
