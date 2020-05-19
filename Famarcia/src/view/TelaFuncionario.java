package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.bean.Funcionario;
import model.dao.FuncionarioDAO;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class TelaFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JScrollPane barraRolagem;
	private JComboBox PaisesSelect;
	private JButton btnVoltar;
	private JButton btnAtualizar;
	private JButton btnExcluir;
	private JTable tabela;
	private DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionario frame = new TelaFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */       
	
	public TelaFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(162, 155, 254));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabela = new JTable(modelo);
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(15, 430, 580, 150);
		contentPane.setLayout(null);
		contentPane.add(barraRolagem);
		setContentPane(contentPane);
		
		modelo.addColumn("ID");
	    modelo.addColumn("Nome");
	    modelo.addColumn("Cargo");
	    modelo.addColumn("Rg");
	    modelo.addColumn("Cpf");
	    modelo.addColumn("Usuario");
	    modelo.addColumn("Senha");
	    readJTable();
	    
	    /*PaisesSelect = new JComboBox();
        PaisesSelect.setBounds(90, 130, 110, 30);
        contentPane.add(PaisesSelect);
        
        FuncionarioDAO fdao = new FuncionarioDAO();
    	for(Funcionario fun:fdao.Listar()) {
    		
    		PaisesSelect.addItem(fun);
    	}*/
    		
    	//Metodo para pegar os valores da ComboBox(Funcionario)
    	//Funcionario funcionarios = (Funcionario) PaisesSelect.getSelectedItem();
    	//JOptionPane.showMessageDialog(null, "Nome: "+funcionarios.getNomeFuncionario+ "Cargo: "+funcionario.getCargoFuncionario());

		JLabel lblCadastroDeFuncionrios = new JLabel("Cadastro de Funcion\u00E1rios");
		lblCadastroDeFuncionrios.setForeground(Color.WHITE);
		lblCadastroDeFuncionrios.setFont(new Font("Verdana", Font.PLAIN, 24));
		lblCadastroDeFuncionrios.setBounds(111, 11, 348, 27);
		contentPane.add(lblCadastroDeFuncionrios);
		
		JLabel lblNewLabel = new JLabel(" Nome do Funcion\u00E1rio:");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel.setBounds(24, 73, 183, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("RG:");
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(24, 150, 106, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(240, 150, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nome Usuario:");
		lblNewLabel_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(24, 235, 123, 41);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cargo:");
		lblNewLabel_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(324, 73, 106, 26);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Senha:\r\n");
		lblNewLabel_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(24, 303, 66, 27);
		contentPane.add(lblNewLabel_5);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnCadastrar.setBounds(302, 300, 134, 29);
		contentPane.add(btnCadastrar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnAtualizar.setBounds(302, 330, 134, 29);
		contentPane.add(btnAtualizar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnExcluir.setBounds(302, 360, 134, 29);
		contentPane.add(btnExcluir);
		
		textField = new JTextField();
		textField.setBounds(24, 105, 273, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(24, 169, 183, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(324, 105, 123, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(239, 169, 166, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(24, 275, 183, 27);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(24, 331, 183, 27);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnVoltar.setBounds(302, 390, 134, 29);
		contentPane.add(btnVoltar);
		
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Funcionario fn = new Funcionario();
				FuncionarioDAO f = new FuncionarioDAO();
				fn.setNomeFuncionario(textField.getText());
				fn.setCargoFuncionario(textField_2.getText());
				fn.setRgFuncionario(textField_1.getText());
				fn.setCpfFuncionario(textField_3.getText());
				fn.setNomeUsuario(textField_4.getText());
				fn.setSenhaUsuario(textField_5.getText());
				f.Create(fn);
				readJTable();
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				
			}
		});
		
		btnAtualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int indice = tabela.getSelectedRow();
				Funcionario fn = new Funcionario();
				FuncionarioDAO f = new FuncionarioDAO();
				fn.setNomeFuncionario(textField.getText());
				fn.setCargoFuncionario(textField_2.getText());
				fn.setRgFuncionario(textField_1.getText());
				fn.setCpfFuncionario(textField_3.getText());
				fn.setNomeUsuario(textField_4.getText());
				fn.setSenhaUsuario(textField_5.getText());
				fn.setCodFuncionario((int)tabela.getValueAt(indice,0));
				f.Update(fn);
				readJTable();
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				
			}
		});
		
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int indice = tabela.getSelectedRow();
				Funcionario fn = new Funcionario();
				FuncionarioDAO f = new FuncionarioDAO();
				fn.setCodFuncionario((int)tabela.getValueAt(indice,0));
				f.Delete(fn);
				readJTable();
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Principal p1 = new Principal();
				dispose();
				contentPane.setVisible(false);
				p1.setVisible(true);
				
			}
		});
		
		tabela.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int indice = tabela.getSelectedRow();
				textField.setText(tabela.getValueAt(indice, 1).toString());
				textField_2.setText(tabela.getValueAt(indice, 2).toString());
				textField_1.setText(tabela.getValueAt(indice, 3).toString());
				textField_3.setText(tabela.getValueAt(indice, 4).toString());
				textField_4.setText(tabela.getValueAt(indice, 5).toString());
				textField_5.setText(tabela.getValueAt(indice, 6).toString());
				
				
			}
		});
		
		
	}
	
	
	public void readJTable() {
		modelo.setNumRows(0);
    	FuncionarioDAO fdao = new FuncionarioDAO();
    	for(Funcionario fun:fdao.Listar()) {
    		modelo.addRow(new Object[] {
    				fun.getCodFuncionario(),
    				fun.getNomeFuncionario(),
    				fun.getCargoFuncionario(),
    				fun.getRgFuncionario(),
    				fun.getCpfFuncionario(),
    				fun.getNomeUsuario(),
    				fun.getSenhaUsuario()
    				
    		});
    	}
    		
    }
}
