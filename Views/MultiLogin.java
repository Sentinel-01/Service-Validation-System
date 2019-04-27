package Views;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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

public class MultiLogin {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private static String message="";
	/**
	 * Launch the application.
	 */
	public static void main (String[] args) throws Exception{
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultiLogin window = new MultiLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MultiLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void successLogin(String msg)
	{
		message = msg;
		return;
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLoginSystem = new JLabel("Login System");
		lblLoginSystem.setBounds(200, 20, 122, 16);
		frame.getContentPane().add(lblLoginSystem);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(20, 72, 89, 16);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(20, 115, 61, 16);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(121, 72, 289, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(121, 110, 291, 26);
		frame.getContentPane().add(passwordField);

		JLabel lblUsertype = new JLabel("User Type");
		lblUsertype.setBounds(20, 154, 89, 16);
		frame.getContentPane().add(lblUsertype);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Administrator", "Executor", "Process Owner", "Approver"}));
		comboBox.setEditable(true);
		comboBox.setBackground(new Color(238, 238, 238));
		comboBox.setBounds(121, 148, 168, 27);
		frame.getContentPane().add(comboBox);
		
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
				        	new ProcessOwn().setVisible(true);
				        }
				    });
					break;
				}
				case "Executor":
				{
					java.awt.EventQueue.invokeLater(new Runnable() {

				        public void run() {
				        	new Executor().setVisible(true);
				        }
				    });
					break;
				
				}
				case "Approver":
				{
					java.awt.EventQueue.invokeLater(new Runnable() {

				        public void run() {
				        	new Approver().setVisible(true);
				        }
				    });
					break;
				}
				default: System.out.println("Login failed! Please confirm username, password or usertype");
				}
				frame.setVisible(false); //you can't see me!
				frame.dispose(); //Destroy the JFrame object
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
		frame.getContentPane().add(btnLogin);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent args) {
				textField.setText(null);
				passwordField.setText(null);	
			}
		});
		btnNewButton.setBounds(182, 222, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(17, 192, 438, 12);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(17, 48, 438, 12);
		frame.getContentPane().add(separator_1);
		
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
		frame.getContentPane().add(btnExit);
		
	}
}

