package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.bean.Cliente;
import model.dao.ClienteDAO;


public class CadCliente extends JFrame{
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField txtEnd;
	private JTextField txtNumero;
	private JScrollPane barraRolagem;
	private JButton btnVoltar;
	private JButton btnAtualizar;
	private JButton btnExcluir;
	private JTable tabela;
	private DefaultTableModel modelo = new DefaultTableModel();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadCliente frame = new CadCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CadCliente() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 204));
		contentPane.setBackground(new Color(162, 155, 254));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabela = new JTable(modelo);
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(5, 380, 740, 150);
		contentPane.add(barraRolagem);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		modelo.addColumn("ID");
	    modelo.addColumn("Nome");
	    modelo.addColumn("Cpf");
	    modelo.addColumn("RG");
	    modelo.addColumn("Endereço");
	    modelo.addColumn("UF");
	    modelo.addColumn("Cidade");
	    modelo.addColumn("Cep");
	    modelo.addColumn("Bairro");
	    modelo.addColumn("Numero");
	    readJTable();
		
		textField = new JTextField();//Nome Cliente
		textField.setBounds(20, 108, 234, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNomeDoFabricante = new JLabel("Nome");
		lblNomeDoFabricante.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNomeDoFabricante.setForeground(Color.BLACK);
		lblNomeDoFabricante.setBackground(new Color(230, 230, 250));
		lblNomeDoFabricante.setBounds(20, 80, 135, 29);
		contentPane.add(lblNomeDoFabricante);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCadastrar.setBounds(40, 300, 117, 29);
		contentPane.add(btnCadastrar);
		
		btnAtualizar= new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnAtualizar.setBounds(160, 300, 117, 29);
		contentPane.add(btnAtualizar);
		
		btnExcluir= new JButton("Excluir");
		btnExcluir.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnExcluir.setBounds(280, 300, 117, 29);
		contentPane.add(btnExcluir);
		
		btnVoltar= new JButton("Voltar");
		btnVoltar.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnVoltar.setBounds(400, 300, 117, 29);
		contentPane.add(btnVoltar);
		
		
		JLabel lblCadastroDeFabricante = new JLabel("Cadastro de Clientes");
		lblCadastroDeFabricante.setBackground(new Color(255, 255, 204));
		lblCadastroDeFabricante.setForeground(Color.WHITE);
		lblCadastroDeFabricante.setFont(new Font("Verdana", Font.PLAIN, 23));
		lblCadastroDeFabricante.setBounds(81, 0, 308, 45);
		contentPane.add(lblCadastroDeFabricante);
		
		textField_1 = new JTextField();//Cpf Cliente
		textField_1.setBounds(277, 108, 146, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		txtEnd = new JTextField();//Rg Cliente
		txtEnd.setBounds(450, 108, 146, 29);
		contentPane.add(txtEnd);
		txtEnd.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CPF:");
		lblCnpj.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblCnpj.setBounds(277, 87, 46, 14);
		contentPane.add(lblCnpj);
		
		JLabel lblRG = new JLabel("RG:");
		lblRG.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblRG.setBounds(450, 87, 100, 14);
		contentPane.add(lblRG);
		
		JLabel lblNewLabel = new JLabel("UF:\r\n");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel.setBounds(434, 148, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cidade:");
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(170, 148, 60, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Endereço:\r\n");
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(20, 147, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Bairro:");
		lblNewLabel_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(500, 148, 73, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Numero:");
		lblNewLabel_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(600, 148, 100, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();//UF Cliente
		textField_2.setBounds(423, 173, 57, 29);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();//Endereco Cliente
		textField_3.setBounds(20, 172, 135, 29);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();//Cidade Cliente
		textField_4.setBounds(170, 172, 129, 29);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();//Bairro Cliente
		textField_5.setBounds(500, 172, 90, 29);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		txtNumero = new JTextField();//Numero Cliente
		txtNumero.setBounds(600, 172, 70, 29);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		textField_6 = new JTextField();//Cep Cliente
		textField_6.setBounds(309, 172, 104, 29);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblComplemento = new JLabel("CEP:");
		lblComplemento.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblComplemento.setBounds(309, 148, 99, 14);
		contentPane.add(lblComplemento);
		
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Cliente c = new Cliente();
				ClienteDAO cdao = new ClienteDAO();
				c.setNomeCliente(textField.getText());
				c.setCpfCliente(textField_1.getText());
				c.setRgCliente(txtEnd.getText());
				c.setBairroCliente(textField_5.getText());
				c.setCepCliente(textField_6.getText());
				c.setEnderecoCliente(textField_3.getText());
				c.setNumeroCliente(txtNumero.getText());
				c.setUfCliente(textField_2.getText());
				c.setCidadeCliente(textField_4.getText());
				cdao.Create(c);
				readJTable();
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				txtEnd.setText("");
				txtNumero.setText("");
				
			}
		});
		
		btnAtualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int indice = tabela.getSelectedRow();
				Cliente c = new Cliente();
				ClienteDAO cdao = new ClienteDAO();
				c.setNomeCliente(textField.getText());
				c.setCpfCliente(textField_1.getText());
				c.setRgCliente(txtEnd.getText());
				c.setBairroCliente(textField_5.getText());
				c.setCepCliente(textField_6.getText());
				c.setEnderecoCliente(textField_3.getText());
				c.setNumeroCliente(txtNumero.getText());
				c.setUfCliente(textField_2.getText());
				c.setCidadeCliente(textField_4.getText());
				c.setCodCliente((int)tabela.getValueAt(indice,0));
				cdao.Update(c);
				readJTable();
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				txtEnd.setText("");
				txtNumero.setText("");
				
			}
		});
		
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int indice = tabela.getSelectedRow();
				Cliente c = new Cliente();
				ClienteDAO cdao = new ClienteDAO();
				c.setCodCliente((int)tabela.getValueAt(indice,0));
				cdao.Delete(c);
				readJTable();
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				txtEnd.setText("");
				txtNumero.setText("");
				
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
				textField_1.setText(tabela.getValueAt(indice, 2).toString());
				txtEnd.setText(tabela.getValueAt(indice, 3).toString());
				textField_3.setText(tabela.getValueAt(indice, 4).toString());
				textField_4.setText(tabela.getValueAt(indice, 5).toString());
				textField_6.setText(tabela.getValueAt(indice, 6).toString());
				textField_2.setText(tabela.getValueAt(indice, 7).toString());
				textField_5.setText(tabela.getValueAt(indice, 8).toString());
				txtNumero.setText(tabela.getValueAt(indice, 9).toString());
				
			}
		});
		
		
	}
	
	public void readJTable() {
		modelo.setNumRows(0);
		ClienteDAO cdao = new ClienteDAO();
		for(Cliente c:cdao.Listar()) {
			modelo.addRow(new Object[] {	
			c.getCodCliente(),
			c.getNomeCliente(),
			c.getCpfCliente(),
			c.getRgCliente(),
			c.getEnderecoCliente(),
			c.getCidadeCliente(),
			c.getCepCliente(),
			c.getUfCliente(),
			c.getBairroCliente(),
			c.getNumeroCliente(),
    		
			});
		}
    		
    }
	
		
}
