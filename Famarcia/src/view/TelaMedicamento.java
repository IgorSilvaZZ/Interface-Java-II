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
import model.bean.Medicamento;
import model.dao.FabricanteDAO;
import model.dao.MedicamentoDAO;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class TelaMedicamento extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JScrollPane barraRolagem;
	private JComboBox FabSelect;
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
					TelaMedicamento frame = new TelaMedicamento();
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
	public TelaMedicamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 410);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(162, 155, 254));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabela = new JTable(modelo);
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(15, 210, 300, 150);
		contentPane.add(barraRolagem);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		modelo.addColumn("ID");
	    modelo.addColumn("Nome");
	    modelo.addColumn("Valor");
	    modelo.addColumn("Fabricante");
	    readJTable();
	   
	    
	    FabSelect = new JComboBox();
	    FabSelect.setBounds(390, 110, 150, 26);
	    FabSelect.addItem("Selecione um Fabricante");
        contentPane.add(FabSelect);
        
        FabricanteDAO fbdao = new FabricanteDAO();
    	for(Fabricante fa:fbdao.Listar()) {
    		FabSelect.addItem(fa);
    	}
    	
		
		JLabel lblNewLabel = new JLabel("Cadastro de Medicamentos");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 23));
		lblNewLabel.setBounds(66, 11, 379, 38);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(17, 113, 97, 26);
		contentPane.add(label);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblValor.setBounds(236, 85, 46, 14);
		contentPane.add(lblValor);
		
		textField_2 = new JTextField();
		textField_2.setBounds(236, 110, 141, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCdigoDoFabricante = new JLabel("Fabricante:");
		lblCdigoDoFabricante.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblCdigoDoFabricante.setBounds(390, 85, 100, 14);
		contentPane.add(lblCdigoDoFabricante);
		
		textField_3 = new JTextField();
		textField_3.setBounds(17, 110, 179, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNome.setBounds(22, 88, 46, 14);
		contentPane.add(lblNome);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnCadastrar.setBounds(350, 260, 134, 38);
		contentPane.add(btnCadastrar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnVoltar.setBounds(350, 310, 134, 38);
		contentPane.add(btnVoltar);
		
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = FabSelect.getSelectedIndex();
				Medicamento med = new Medicamento();
				MedicamentoDAO medao = new MedicamentoDAO();
				med.setDescMedicamento(textField_3.getText());
				med.setPrecoMedicamento(textField_2.getText());
				med.setCodFabricante(index);
				medao.Create(med);
				readJTable();
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
		
	}
	
	public void readJTable() {
		modelo.setNumRows(0);
    	MedicamentoDAO medao = new MedicamentoDAO();
    	for(Medicamento me:medao.Listar()) {
    		modelo.addRow(new Object[] {
    			me.getCodMedicamento(),
    			me.getDescMedicamento(),
    			me.getPrecoMedicamento(),
    			me.getNomeFabricante()
    		});
    	}
    }
	
}
