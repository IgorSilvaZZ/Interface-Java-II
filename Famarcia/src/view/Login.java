package view;

import javax.swing.*;

import model.dao.FuncionarioDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
	
	private JFrame janela;
	private JPanel painel;
	private JPanel painel2;
	private JLabel imgLogin;
	private ImageIcon Login;
	private ImageIcon Saude;
	private JLabel imgSaude;
	private JLabel lbUsuario;
	private JLabel lbSenha;
	private JTextField txtSenha;
	private JTextField txtUsuario;
	private JButton btLogar;
	private JButton btCancelar;
	private final static String quebra = "\n";
	
	public Login() {
		
		janela = new JFrame("Login");
	    janela.setSize(350, 350);
	    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    janela.setResizable(true);
	    janela.setLocationRelativeTo(null);
	    
	    painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(new Color(108, 92, 231));
        painel.setSize(350, 350);
        painel.setPreferredSize(new Dimension(0,500));
        janela.add(painel);
        janela.setVisible(true);
	    
	    painel2 = new JPanel();
	    painel2.setSize(100, 350);
	    painel2.setLayout(null);
	    painel2.setBackground(new Color(162, 155, 254));
	    painel.add(painel2);
	    
	    imgLogin = new JLabel();
	    imgLogin.setSize(80,80);
	    imgLogin.setLocation(15, 95);
	    painel2.add(imgLogin);
	    
	    Login = new ImageIcon("src/login.png");
	    Login.setImage(Login.getImage().getScaledInstance(imgLogin.getWidth(), imgLogin.getHeight(), 1));
	    imgLogin.setIcon(Login);
	   
	    lbUsuario = new JLabel("Usuario:");
	    lbUsuario.setBounds(130, 100, 100, 50);
	    painel.add(lbUsuario);
	    
	    lbSenha = new JLabel("Senha:");
	    lbSenha.setBounds(130, 150, 100, 50);
	    painel.add(lbSenha);
	    
	    txtUsuario = new JTextField();
	    txtUsuario.setBounds(200, 115, 90, 25);
	    painel.add(txtUsuario);
	    
	    txtSenha = new JTextField();
	    txtSenha.setBounds(200, 165, 90, 25);
	    painel.add(txtSenha);
	    
	    btLogar = new JButton("Logar");
	    btLogar.setBounds(130, 220, 90, 25);
	    painel.add(btLogar);
	    
	    btCancelar = new JButton("Sair");
	    btCancelar.setBounds(230, 220, 90, 25);
	    painel.add(btCancelar);
	    
	    imgSaude = new JLabel();
	    imgSaude.setSize(80,80);
	    imgSaude.setLocation(180, 20);
	    painel.add(imgSaude);
	    
	    Saude = new ImageIcon("src/saude.png");
	    Saude.setImage(Saude.getImage().getScaledInstance(imgSaude.getWidth(), imgSaude.getHeight(), 1));
	    imgSaude.setIcon(Saude);
	    
	    btLogar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FuncionarioDAO f = new FuncionarioDAO();
				if(f.checkLogin(txtUsuario.getText(), txtSenha.getText())) {
					janela.dispose();
					Principal next =  new Principal();
					next.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Não Cadastrado");
				}
				
				
			}
		});
	    
	    btCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				janela.dispose();
				
			}
		});
		
	}

	public static void main(String[] args) {
		
		Login l1 = new Login();

	}

}
