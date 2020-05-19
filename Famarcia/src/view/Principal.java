package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame{
	
	//Fazendo as telas
	private JFrame janela;
	private JPanel painel;
	private JPanel painel2;
	private JPanel painel3;
	
	//Componentes das Telas Principais
	private ImageIcon imgP;	
	private ImageIcon AddCli;
	private ImageIcon AddFun;
	private ImageIcon AddMed;
	private ImageIcon AddVenda;
	private ImageIcon AddItens;
	private JLabel Princ;
	private JButton imgCli;
	private JButton imgFun;
	private JButton imgMed;
	private JButton imgVenda;
	private JButton imgItens;
	
	public Principal() {
		
		janela = new JFrame("Famarcia Plus");
	    janela.setSize(500, 500);
	    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    janela.setResizable(true);
	    janela.setLocationRelativeTo(null);
	    
	    painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(new Color(85, 239, 196));
        painel.setSize(350, 350);
        painel.setPreferredSize(new Dimension(0,500));
        janela.add(painel);
        janela.setVisible(true);
	    
	    painel2 = new JPanel();
	    painel2.setSize(110, 500);
	    painel2.setLayout(null);
	    painel2.setBackground(new Color(162, 155, 254));
	    painel.add(painel2);
	    
	    painel3 = new JPanel();
        painel3.setLayout(null);
        painel3.setBackground(new Color(108, 92, 231));
        painel3.setSize(350, 350);
        painel3.setPreferredSize(new Dimension(0,500));
        
	    
	    Princ = new JLabel();
	    Princ.setSize(500, 500);
	    Princ.setLocation(0, 0);
	    painel.add(Princ);
	    
	    imgP = new ImageIcon("src/giphy.gif");
	    imgP.setImage(imgP.getImage().getScaledInstance(Princ.getWidth(), Princ.getHeight(), 1));
	    Princ.setIcon(imgP);
	    
	    imgCli = new JButton();
	    imgCli.setBorder(null);
	    imgCli.setOpaque(false);
	    imgCli.setContentAreaFilled(false);
	    imgCli.setBorderPainted(false);
	    imgCli.setSize(80,80);
	    imgCli.setLocation(15, 50);
	    painel2.add(imgCli);
	    
	    AddCli = new ImageIcon("src/login.png");
	    AddCli.setImage(AddCli.getImage().getScaledInstance(imgCli.getWidth(), imgCli.getHeight(), 1));
	    imgCli.setIcon(AddCli);
	    
	    imgFun = new JButton();
	    imgFun.setBorder(null);
	    imgFun.setOpaque(false);
	    imgFun.setContentAreaFilled(false);
	    imgFun.setBorderPainted(false);
	    imgFun.setSize(80,80);
	    imgFun.setLocation(15, 150);
	    painel2.add(imgFun);
	    
	    AddFun = new ImageIcon("src/funcionario.png");
	    AddFun.setImage(AddFun.getImage().getScaledInstance(imgFun.getWidth(), imgFun.getHeight(), 1));
	    imgFun.setIcon(AddFun);
	    
	    imgMed = new JButton();
	    imgMed.setBorder(null);
	    imgMed.setOpaque(false);
	    imgMed.setContentAreaFilled(false);
	    imgMed.setBorderPainted(false);
	    imgMed.setSize(80,80);
	    imgMed.setLocation(15, 250);
	    painel2.add(imgMed);
	    
	    AddMed = new ImageIcon("src/medicamento.png");
	    AddMed.setImage(AddMed.getImage().getScaledInstance(imgMed.getWidth(), imgMed.getHeight(), 1));
	    imgMed.setIcon(AddMed);
	    
	    imgVenda = new JButton();
	    imgVenda.setBorder(null);
	    imgVenda.setOpaque(false);
	    imgVenda.setContentAreaFilled(false);
	    imgVenda.setBorderPainted(false);
	    imgVenda.setSize(80,80);
	    imgVenda.setLocation(15, 350);
	    painel2.add(imgVenda);
	    
	    AddVenda = new ImageIcon("src/venda.png");
	    AddVenda.setImage(AddVenda.getImage().getScaledInstance(imgVenda.getWidth(), imgVenda.getHeight(), 1));
	    imgVenda.setIcon(AddVenda);
	    
	    imgFun.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaFuncionario next = new TelaFuncionario();
				janela.dispose();
				next.setVisible(true);
				
			}
		});
	    
	    imgCli.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CadCliente next = new CadCliente();
				janela.dispose();
				next.setVisible(true);
				
			}
		});
	    
	    imgMed.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaMedicamento next = new TelaMedicamento();
				janela.dispose();
				next.setVisible(true);
				
			}
		});
	    
	    imgVenda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				telaVenda next = new telaVenda();
				janela.dispose();
				next.setVisible(true);
				
			}
		});
		
	}

	public static void main(String[] args) {
		Principal p1 = new Principal();

	}

}
