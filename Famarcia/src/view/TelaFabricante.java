package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.bean.Fabricante;
import model.bean.Funcionario;
import model.dao.FabricanteDAO;
import model.dao.FuncionarioDAO;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TelaFabricante extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JScrollPane barraRolagem;
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
					TelaFabricante frame = new TelaFabricante();
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
	public TelaFabricante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 204));
		contentPane.setBackground(new Color(162, 155, 254));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabela = new JTable(modelo);
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(5, 380, 640, 150);
		contentPane.add(barraRolagem);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		modelo.addColumn("ID");
	    modelo.addColumn("Nome");
	    modelo.addColumn("Cpnj");
	    modelo.addColumn("Uf");
	    modelo.addColumn("Cidade");
	    modelo.addColumn("Cep");
	    modelo.addColumn("Telefone");
	    modelo.addColumn("Complemento");
	    readJTable();
		
		textField = new JTextField();
		textField.setBounds(20, 108, 234, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNomeDoFabricante = new JLabel("Nome do Fabricante:\r\n");
		lblNomeDoFabricante.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNomeDoFabricante.setForeground(Color.BLACK);
		lblNomeDoFabricante.setBackground(new Color(230, 230, 250));
		lblNomeDoFabricante.setBounds(20, 80, 135, 29);
		contentPane.add(lblNomeDoFabricante);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCadastrar.setBounds(140, 300, 117, 29);
		contentPane.add(btnCadastrar);
		
		btnAtualizar= new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnAtualizar.setBounds(260, 300, 117, 29);
		contentPane.add(btnAtualizar);
		
		btnExcluir= new JButton("Excluir");
		btnExcluir.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnExcluir.setBounds(380, 300, 117, 29);
		contentPane.add(btnExcluir);
		
		btnVoltar= new JButton("Voltar");
		btnVoltar.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnVoltar.setBounds(500, 300, 117, 29);
		contentPane.add(btnVoltar);
		
		
		JLabel lblCadastroDeFabricante = new JLabel("Cadastro de Fabricante");
		lblCadastroDeFabricante.setBackground(new Color(255, 255, 204));
		lblCadastroDeFabricante.setForeground(Color.WHITE);
		lblCadastroDeFabricante.setFont(new Font("Verdana", Font.PLAIN, 23));
		lblCadastroDeFabricante.setBounds(81, 0, 308, 45);
		contentPane.add(lblCadastroDeFabricante);
		
		textField_1 = new JTextField();
		textField_1.setBounds(277, 108, 146, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblCnpj.setBounds(277, 87, 46, 14);
		contentPane.add(lblCnpj);
		
		JLabel lblNewLabel = new JLabel("UF:\r\n");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel.setBounds(434, 148, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cidade:");
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(170, 148, 60, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CEP:\r\n");
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(20, 147, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone:");
		lblNewLabel_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(20, 213, 73, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(423, 173, 57, 29);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(20, 172, 135, 29);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(170, 172, 129, 29);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(20, 238, 135, 29);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(309, 172, 104, 29);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblComplemento.setBounds(309, 148, 99, 14);
		contentPane.add(lblComplemento);
		
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Fabricante fab = new Fabricante();
				FabricanteDAO fbdao = new FabricanteDAO();
				fab.setNomeFabricante(textField.getText());
				fab.setCnpjFabricante(textField_1.getText());
				fab.setUfFabricante(textField_2.getText());
				fab.setCepFabricante(textField_3.getText());
				fab.setCidadeFabricante(textField_4.getText());
				fab.setTelefoneFabricante(textField_5.getText());
				fab.setComplementoFabricante(textField_6.getText());
				fbdao.Create(fab);
				readJTable();
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				
			}
		});
		
		btnAtualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int indice = tabela.getSelectedRow();
				Fabricante fab = new Fabricante();
				FabricanteDAO fbdao = new FabricanteDAO();
				fab.setNomeFabricante(textField.getText());
				fab.setCnpjFabricante(textField_1.getText());
				fab.setUfFabricante(textField_2.getText());
				fab.setCepFabricante(textField_3.getText());
				fab.setCidadeFabricante(textField_4.getText());
				fab.setTelefoneFabricante(textField_5.getText());
				fab.setComplementoFabricante(textField_6.getText());
				fab.setCodFabricante((int)tabela.getValueAt(indice,0));
				fbdao.Update(fab);
				readJTable();
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				
			}
		});
		
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int indice = tabela.getSelectedRow();
				Fabricante fab = new Fabricante();
				FabricanteDAO fbdao = new FabricanteDAO();
				fab.setCodFabricante((int)tabela.getValueAt(indice,0));
				fbdao.Delete(fab);
				readJTable();
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				
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
				textField_2.setText(tabela.getValueAt(indice, 3).toString());
				textField_1.setText(tabela.getValueAt(indice, 2).toString());
				textField_3.setText(tabela.getValueAt(indice, 5).toString());
				textField_4.setText(tabela.getValueAt(indice, 4).toString());
				textField_5.setText(tabela.getValueAt(indice, 6).toString());
				textField_6.setText(tabela.getValueAt(indice, 7).toString());
				
			}
		});
		
		
	}
	
	public void readJTable() {
		modelo.setNumRows(0);
    	FabricanteDAO fbdao = new FabricanteDAO();
    	for(Fabricante fb:fbdao.Listar()) {
    		modelo.addRow(new Object[] {
    			fb.getCodFabricante(),
    			fb.getNomeFabricante(),
    			fb.getCnpjFabricante(),
    			fb.getUfFabricante(),
    			fb.getCidadeFabricante(),
    			fb.getCepFabricante(),
    			fb.getTelefoneFabricante(),
    			fb.getComplementoFabricante()
    				
    		});
    	}
    		
    }
	
}
