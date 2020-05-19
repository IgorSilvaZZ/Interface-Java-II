package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.bean.Cliente;
import model.bean.Fabricante;
import model.bean.Funcionario;
import model.bean.Medicamento;
import model.bean.Venda;
import model.dao.ClienteDAO;
import model.dao.FabricanteDAO;
import model.dao.FuncionarioDAO;
import model.dao.MedicamentoDAO;
import model.dao.VendaDAO;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class telaVenda extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox SelectMed;
	private JComboBox SelectFun;
	private JComboBox SelectCli;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JScrollPane barraRolagem;
	private JTable tabela;
	private DefaultTableModel modelo = new DefaultTableModel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaVenda frame = new telaVenda();
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
	public telaVenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,680, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(162, 155, 254));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabela = new JTable(modelo);
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(15, 380, 600, 150);
		contentPane.add(barraRolagem);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		modelo.addColumn("ID");
	    modelo.addColumn("Medicamento");
	    modelo.addColumn("Cliente");
	    modelo.addColumn("Funcionario");
	    modelo.addColumn("Total");
	    readJTable();
		
		JButton btnNewButton = new JButton("Realizar Venda\r\n");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnNewButton.setBounds(232, 332, 205, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblVenda = new JLabel("Venda");
		lblVenda.setForeground(Color.WHITE);
		lblVenda.setFont(new Font("Verdana", Font.PLAIN, 31));
		lblVenda.setBounds(194, 11, 263, 52);
		contentPane.add(lblVenda);
		
		JLabel lblNewLabel = new JLabel("Valor:");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel.setBounds(194, 74, 64, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade de Itens:");
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(330, 75, 154, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Codigo do Funcionario:\r\n");
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(153, 146, 150, 17);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_4 = new JLabel("SubTotal:");
		lblNewLabel_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(10, 254, 134, 20);
		contentPane.add(lblNewLabel_4);
		
		textField_1 = new JTextField();//Quantidade de Itens
		textField_1.setBounds(330, 105, 91, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();//Valor do Medicamento
		textField_2.setBounds(180, 105, 118, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEditable(false);
		
		SelectFun = new JComboBox();//Codigo do Funcionario
		SelectFun.setBounds(153, 174, 100, 30);
		SelectFun.addItem("Funcionario:");
		contentPane.add(SelectFun);
		
		 FuncionarioDAO fundao = new FuncionarioDAO();
	    	for(Funcionario fun:fundao.Listar()) {
	    		SelectFun.addItem(fun);
	    }
	    SelectFun.setSelectedIndex(-1);
		
		textField_4 = new JTextField();//SubTotal
		textField_4.setBounds(10, 294, 147, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setEditable(false);
		
		SelectMed = new JComboBox();//Codigo Medicamento
		SelectMed.setBounds(10, 104, 100, 30);
		SelectMed.addItem("Medicamento:");
		contentPane.add(SelectMed);
		
		MedicamentoDAO vedao = new MedicamentoDAO();
		java.util.List<Medicamento> medicamentosCombo = vedao.Listar();
    	for(Medicamento medicamento: medicamentosCombo) {
    		SelectMed.addItem(medicamento);
    	}
		
		SelectCli = new JComboBox();//Codigo Cliente
		SelectCli.setBounds(20, 174, 100, 30);
		SelectCli.addItem("Cliente:");
		contentPane.add(SelectCli);
		
		ClienteDAO cdao = new ClienteDAO();
    	for(Cliente c:cdao.Listar()) {
    		SelectCli.addItem(c);
    	}
    	SelectCli.setSelectedIndex(-1);
		
		JLabel lblNewLabel_5 = new JLabel("Medicamento");
		lblNewLabel_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(10, 75, 157, 18);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblCdigoDaVenda = new JLabel("Cliente:");
		lblCdigoDaVenda.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblCdigoDaVenda.setBounds(10, 144, 131, 20);
		contentPane.add(lblCdigoDaVenda);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int codmed = SelectMed.getSelectedIndex();
				int codfun = SelectFun.getSelectedIndex();
				int codclie = SelectCli.getSelectedIndex();
				Venda ven = new Venda();
				VendaDAO vendao = new VendaDAO();
				ven.setCodMedicamento(codmed);
				ven.setCodFuncionario(codfun);
				ven.setCodCliente(codclie);
				ven.setTotalVenda(textField_4.getText());
				vendao.Create(ven);
				readJTable();
			}
		});
		
		SelectMed.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String valor = medicamentosCombo.get(SelectMed.getSelectedIndex()-1).getPrecoMedicamento();
				textField_2.setText(valor);
				recalcularTotal();
			}
		});
		textField_1.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) { }
			@Override
			public void keyPressed(KeyEvent arg0) { }
			@Override
			public void keyReleased(KeyEvent arg0) {
				recalcularTotal();
			}
		});
	
	}
	
	public void recalcularTotal() {
		int quantidade;
		double valor;
		try {
			quantidade = Integer.parseInt(textField_1.getText());
		} catch(NumberFormatException ex) {
			quantidade = 0;
		}
		try {
			valor = Double.parseDouble(textField_2.getText());
		} catch(NumberFormatException ex) {
			valor = 0;
		}
		double total = quantidade*valor;
		textField_4.setText(""+total);
	}
	
	public void readJTable() {
		modelo.setNumRows(0);
    	VendaDAO vendao = new VendaDAO();
    	for(Venda ve:vendao.Listar()) {
    		modelo.addRow(new Object[] {
    			ve.getCodVenda(),
    			ve.getNomeMed(),
    			ve.getNomeCli(),
    			ve.getNomeFun(),
    			ve.getTotalVenda()
    			
    		});
    	}
    }

}
