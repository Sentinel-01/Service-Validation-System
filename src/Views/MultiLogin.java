package Views;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import database.DBConnection;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class MultiLogin extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private static String message="";
	/**
	 * Launch the application.
	 */
	public static void main (String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultiLogin window = new MultiLogin();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void successLogin(String msg)
	{
		message = msg;
		return;
	}
	private JPanel contentPane2;
	MultiLogin() {
		setBounds(100, 100, 500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane2 = new JPanel();
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane2);
		contentPane2.setLayout(null);
		
		JLabel lblLoginSystem = new JLabel("Login System");
		lblLoginSystem.setBounds(200, 20, 122, 16);
		contentPane2.add(lblLoginSystem);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(20, 72, 89, 16);
		contentPane2.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(20, 115, 61, 16);
		contentPane2.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(121, 72, 289, 26);
		contentPane2.add(textField);
		textField.setColumns(10);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(121, 110, 291, 26);
		contentPane2.add(passwordField);

		JLabel lblUsertype = new JLabel("User Type");
		lblUsertype.setBounds(20, 154, 89, 16);
		contentPane2.add(lblUsertype);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Administrator", "Executor", "Process Owner", "Approver"}));
		comboBox.setEditable(true);
		comboBox.setBackground(new Color(238, 238, 238));
		comboBox.setBounds(121, 148, 168, 27);
		contentPane2.add(comboBox);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String password = passwordField.getText();
			String username = textField.getText();
			String usertype=comboBox.getSelectedItem().toString();
			DBConnection DB = new DBConnection();
			if((!password.isEmpty())||(!username.isEmpty()))
			{
			try {
				ResultSet rs = DB.getConnection(username,password,usertype);
				if(rs.next()==false)
				{
					JFrame frmMultiLogin = new JFrame("Error");
					JOptionPane.showMessageDialog(frmMultiLogin,  "Login failed. Please confirm username, password or usertype", "Login Systems",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				switch(usertype)
				{
				case "Administrator": 
				{
					java.awt.EventQueue.invokeLater(new Runnable() {

				        public void run() {
				        	new AdminViews().setVisible(true);
				        }
				    });
					break;
				}
				case "Process Owner":
				{
					java.awt.EventQueue.invokeLater(new Runnable() {

				        public void run() {
				        	new ProcessOwnView().setVisible(true);
				        }
				    });
					break;
				}
				case "Executor":
				{
					java.awt.EventQueue.invokeLater(new Runnable() {

				        public void run() {
				        	new ExecutorView().setVisible(true);
				        }
				    });
					break;
				
				}
				case "Approver":
				{
					java.awt.EventQueue.invokeLater(new Runnable() {

				        public void run() {
				        	new ApproverView().setVisible(true);
				        }
				    });
					break;
				}
				default: System.out.println("Login failed! Please confirm username, password or usertype");
				}
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
			else 
			{

				JFrame frmMultiLogin = new JFrame("Invalid");
				JOptionPane.showMessageDialog(frmMultiLogin,  "Enter valid username or password", "Login Systems",JOptionPane.OK_OPTION);
			}
			}
			
		});
		btnLogin.setBounds(32, 222, 117, 29);
		contentPane2.add(btnLogin);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent args) {
				textField.setText(null);
				passwordField.setText(null);	
			}
		});
		btnNewButton.setBounds(182, 222, 117, 29);
		contentPane2.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(17, 192, 438, 12);
		contentPane2.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(17, 48, 438, 12);
		contentPane2.add(separator_1);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmMultiLogin = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmMultiLogin,  "Confirm if you want to exit", "Login Systems",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(318, 222, 117, 29);
		contentPane2.add(btnExit);
		
	}
}

